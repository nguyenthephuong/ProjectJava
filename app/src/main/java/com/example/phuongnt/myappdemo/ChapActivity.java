package com.example.phuongnt.myappdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ChapActivity extends AppCompatActivity {
    public String[] listNovels;
    public ListView lstView;
    public ArrayAdapter<String> adapter;
    public Toolbar toolbar;
    public MaterialSearchView searchView;
    public String currentNovel;
    public List<String> chapFound;

    public static final int REQUEST_ID_READ_PERMISSION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap);

        Intent intent = this.getIntent();

        this.listNovels = intent.getStringArrayExtra("listNovels");
        this.currentNovel = intent.getStringExtra("currentNovel");

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchView = (MaterialSearchView)findViewById(R.id.search_view);

        chapFound = askPermissionAndReadFile(currentNovel);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chapFound);

        lstView = (ListView)findViewById(R.id.lstChapers);
        lstView.setAdapter(adapter);

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                lstView = (ListView)findViewById(R.id.lstChapers);
                ArrayAdapter adapter = new ArrayAdapter(ChapActivity.this, android.R.layout.simple_list_item_1, chapFound);
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
                    for (String item:chapFound) {
                        if (item.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault())))
                            lstFound.add(item);
                    }

                    ArrayAdapter adapterFound = new ArrayAdapter(ChapActivity.this, android.R.layout.simple_list_item_1, lstFound);
                    lstView.setAdapter(adapterFound);

                    lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String currentChap = lstFound.get(position);
                            Intent intent = new Intent(ChapActivity.this, TextActivity.class);
                            intent.putExtra("currentNovel", currentNovel);
                            intent.putExtra("currentChap", currentChap);

                            ChapActivity.this.startActivity(intent);
                        }
                    });
                }
                else {
                    ArrayAdapter adapterNotFound = new ArrayAdapter(ChapActivity.this, android.R.layout.simple_list_item_1, chapFound);
                    lstView.setAdapter(adapterNotFound);
                }
                return true;
            }
        });

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currentChap = adapter.getItem(position);
                Intent intent = new Intent(ChapActivity.this, TextActivity.class);
                intent.putExtra("currentNovel", currentNovel);
                intent.putExtra("currentChap", currentChap);

                ChapActivity.this.startActivity(intent);
            }
        });

    }

    public List<String> askPermissionAndReadFile(String currentNovel) {
        boolean canRead = this.askPermission(REQUEST_ID_READ_PERMISSION,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if (canRead) {
            File extStore = Environment.getExternalStorageDirectory();
            String path = extStore.getAbsolutePath() + "/KimDungNovels/" + currentNovel;
            File novel = new File(path);
            File[] chapers = novel.listFiles();
            List<String> chapFound = new ArrayList<>();
            for (File chaper:chapers) {
//                String chapName = chaper.getName();
                chapFound.add(chaper.getName());
            }

            return chapFound;
        }
        return null;
    }

    public boolean askPermission(int requestId, String permissionName) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            // Kiểm tra quyền
            int permission = ActivityCompat.checkSelfPermission(this, permissionName);

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // Nếu không có quyền, cần nhắc người dùng cho phép.
                this.requestPermissions(
                        new String[]{permissionName},
                        requestId
                );
                return false;
            }
        }
        return true;
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
