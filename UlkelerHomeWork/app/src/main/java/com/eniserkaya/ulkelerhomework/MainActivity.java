package com.eniserkaya.ulkelerhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listeView;
    private List<Ulke> ulkeList;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        listeView = findViewById(R.id.listView);
        ulkeList = new ArrayList<>();

        ulkeList.add(new Ulke("Türkiye",1923,"Türkiye Cumhuriyeti",R.drawable.turkiye));
        ulkeList.add(new Ulke("Filistin",1923,"Filistin",R.drawable.filistin));
        ulkeList.add(new Ulke("Pakistan",1923,"Pakistan",R.drawable.pakistan));

        adapter = new Adapter(this,R.layout.item_layout,ulkeList);

        listeView.setAdapter(adapter);
    }
}
