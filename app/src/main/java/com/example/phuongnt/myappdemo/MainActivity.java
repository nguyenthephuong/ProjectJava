package com.example.phuongnt.myappdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public ListView lstView;
    public ArrayAdapter<String> adapter;
    public Toolbar toolbar;
    public MaterialSearchView searchView;
    public String[] listNovels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchView = (MaterialSearchView)findViewById(R.id.search_view);

        listNovels = MainActivity.this.getResources().getStringArray(R.array.kimdung_novels);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNovels);

        lstView = (ListView)findViewById(R.id.lstNovels);
        lstView.setAdapter(adapter);

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                lstView = (ListView)findViewById(R.id.lstNovels);
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listNovels);
                lstView.setAdapter(adapter);
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && !newText.isEmpty()) {
                    final List<String> lstFound = new ArrayList<String>();
                    for (String item:listNovels) {
                        if (item.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault())))
                            lstFound.add(item);
                    }

                    ArrayAdapter adapterFound = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, lstFound);
                    lstView.setAdapter(adapterFound);

                    lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String currentNovel = lstFound.get(position);
                            Intent intent = new Intent(MainActivity.this, ChapActivity.class);
                            intent.putExtra("listNovels", listNovels);
                            intent.putExtra("currentNovel", currentNovel);

                            startActivity(intent);
                        }
                    });
                }
                else {
                    ArrayAdapter adapterNotFound = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listNovels);
                    lstView.setAdapter(adapterNotFound);
                }
                return true;
            }
        });

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currentNovel = adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, ChapActivity.class);
                intent.putExtra("listNovels", listNovels);
                intent.putExtra("currentNovel", currentNovel);

                startActivity(intent);
            }
        });

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
