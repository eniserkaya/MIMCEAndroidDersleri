package com.eniserkaya.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listeView;
    private List<Contact> contactList;
    private ContactAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        verileriOlustur();

        listeView = findViewById(R.id.list_view);
        adapter = new ContactAdapter(this,R.layout.list_item,contactList);
        listeView.setAdapter(adapter);

    }

    private void verileriOlustur() {
        contactList = new ArrayList<>();
        for(int i = 0 ; i < 20; i++){
            if(i % 2 == 0){
                contactList.add(new Contact(true,"Ahmed Enis","0554 415 79 7"+i));
            }
            else{
                contactList.add(new Contact(false,"Ayşe","0554 415 79 7"+i));
            }
        }
    }
}
