package com.eniserkaya.exercise01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lv;
    private Button btnEkle;
    private EditText etEklenecekText;
    private ArrayList<String> liste;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        lv = findViewById(R.id.list_view_id);
        btnEkle = findViewById(R.id.ekle_btn_id);
        btnEkle.setOnClickListener(this);
        etEklenecekText = findViewById(R.id.editText);
        liste = new ArrayList<>();
        liste.add("Bu birinci eklenen");
        liste.add("Bu ikinci eklenen");

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, liste);

        lv.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if(view == btnEkle){
            String eklenecekStr = etEklenecekText.getText().toString().trim();
            liste.add(eklenecekStr);
            adapter.notifyDataSetChanged();
        }
    }
}
