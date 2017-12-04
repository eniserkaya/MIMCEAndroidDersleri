package com.eniserkaya.listviewandbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {

    private ListView listView;
    private EditText mesajEt;
    private Button gonderBtn;

    private ArrayList<String> dataList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        listView = (ListView)findViewById(R.id.list_view);
        listView.setOnItemClickListener(this);
        mesajEt = (EditText)findViewById(R.id.msg_et);
        gonderBtn =(Button)findViewById(R.id.send_btn);
        gonderBtn.setOnClickListener(this);
        dataList = new ArrayList<>();

        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, dataList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

        String mesaj = mesajEt.getText().toString().trim();
        dataList.add(mesaj);
        adapter.notifyDataSetChanged();
        listView.smoothScrollToPosition(dataList.size()-1);
        mesajEt.setText("");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(MainActivity.this,DetayActivity.class);
        //intent.putExtra("yas",10);
        Bundle  bundle = new Bundle();
        bundle.putString("mesaj",dataList.get(i));
        bundle.putString("tarih",new Date().toString());

        intent.putExtras(bundle);

        startActivity(intent);

    }
}
