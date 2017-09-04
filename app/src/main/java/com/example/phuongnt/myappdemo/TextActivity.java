package com.example.phuongnt.myappdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.phuongnt.myappdemo.Spell.Language;
import com.example.phuongnt.myappdemo.Spell.SpellChecker;
import com.example.phuongnt.myappdemo.TextUltility.Reader;
import com.example.phuongnt.myappdemo.TextUltility.Seacher;
import com.example.phuongnt.myappdemo.TextUltility.Text;
import com.example.phuongnt.myappdemo.TextUltility.TextWord;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TextActivity extends AppCompatActivity {

    public Toolbar toolbar;
    public MaterialSearchView searchView;
    public String currentNovel, currentChap;
    public TextView textView;
    public Button btnCheck, btnBack, btnNext;
    public Text text;
    public SpellChecker checker;
    public ArrayList<TextWord> listChange, listFind;
    public ScrollView scrollView;
    public Spannable wordtoSpan;
    public int countError;

    public static final int REQUEST_ID_READ_PERMISSION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        Intent intent = this.getIntent();

        this.currentNovel = intent.getStringExtra("currentNovel");
        this.currentChap = intent.getStringExtra("currentChap");

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchView = (MaterialSearchView)findViewById(R.id.search_view);

        scrollView = (ScrollView)findViewById(R.id.scrollView);

        textView = (TextView)findViewById(R.id.textView);


        btnCheck = (Button)findViewById(R.id.btnCheck);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnNext = (Button)findViewById(R.id.btnNext);

        File extStore = Environment.getExternalStorageDirectory();
        String path = extStore.getAbsolutePath() + "/KimDungNovels/" + currentNovel + "/" + currentChap;

        listChange = new ArrayList<TextWord>();
        listFind = new ArrayList<TextWord>();

        try {
            text = Reader.get_instance().read(path);
            Seacher.get_instance().split_words(text);
            textView.setText(text.content);
            wordtoSpan = new SpannableString(text.content);

            btnCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listChange.size() > 0) listChange.clear();
                    checker = new SpellChecker(Language.VIETNAMESE);
                    wordtoSpan = new SpannableString(text.content);
                    countError = -1;
                    for(TextWord i : text.word_list){
                        String w = i.getString();
                        if(!checker.check(w)){
                            Log.d("===>>>  word error: ", w);
                            wordtoSpan.setSpan(new ForegroundColorSpan(Color.RED), i.begin, i.end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                            listChange.add(i);
                        }

                    }
                    textView.setText(wordtoSpan);
                }
            });

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countError++;
                    if (countError <= listChange.size() -1 ) {
                        int line = textView.getLayout().getLineForOffset(listChange.get(countError).begin);
                        int y = textView.getLayout().getLineTop(line);
                        scrollView.scrollTo(0, y);
                    }
                    else {
                        countError--;
                    }
                }
            });

            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countError--;
                    if (countError >= 0) {
                        int line = textView.getLayout().getLineForOffset(listChange.get(countError).begin);
                        int y = textView.getLayout().getLineTop(line);
                        scrollView.scrollTo(0, y);
                    }
                    else {
                        countError++;
                    }
                }
            });

            searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
                @Override
                public void onSearchViewShown() {

                }

                @Override
                public void onSearchViewClosed() {
                    textView.setText(text.content);
                }
            });

            searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    wordtoSpan = new SpannableString(text.content);
                    if (listFind.size() > 0) listFind.clear();
                    ArrayList<Integer> rs = Seacher.get_instance().search(text, query);
                    for( int i : rs){
//                        wordtoSpan.setSpan(new ForegroundColorSpan(Color.YELLOW), text.word_list.get(i).begin, text.word_list.get(i).end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        listFind.add(text.word_list.get(i));
                    }
                    if (rs.size() > 0) {
                        wordtoSpan.setSpan(new BackgroundColorSpan(Color.YELLOW), text.word_list.get(rs.get(0)).begin, text.word_list.get(rs.get(rs.size()-1)).end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        int line = textView.getLayout().getLineForOffset(text.word_list.get(rs.get(0)).begin);
                        int y = textView.getLayout().getLineTop(line);
                        scrollView.scrollTo(0, y);
                        textView.setText(wordtoSpan);
                    }

                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    return false;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

}
