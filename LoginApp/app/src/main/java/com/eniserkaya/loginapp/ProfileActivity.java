package com.eniserkaya.loginapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    int age;
    String name;

    private TextView ageTv,nameTv;
    private ListView ulkelerLv;

    private String[] ulkeler;

    /*private String[] ulkeler =
            {"Türkiye", "Bosna", "Katar","Avusturya",
                    "Pakistan", "Yunanistan", "Rusya", "Suriye", "İran", "Irak",
                    "Şili", "Brezilya", "Japonya", "Portekiz", "İspanya",
                    "Makedonya", "Ukrayna", "İsviçre"};*/


    private ArrayAdapter<String> veriAdaptoru;
    //private ArrayList<String> ulkelerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

       /* if(getIntent().getExtras() != null){

        }*/
       ageTv = (TextView)findViewById(R.id.yas_tv);
       nameTv = (TextView)findViewById(R.id.user_name_tv);
       ulkelerLv = (ListView)findViewById(R.id.ulkeler_lv_id);

       ulkeler = getResources().getStringArray(R.array.ulkeArray);

       //ulkelerList = new ArrayList<>();
       //ulkelerList.add("Türkiye");
        veriAdaptoru = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);
        ulkelerLv.setAdapter(veriAdaptoru);

       Bundle bundle = getIntent().getExtras();
       age = bundle.getInt("age");
       name = bundle.getString("kullaniciAdi");
        nameTv.setText("Hoşgeldin "+ name + ". Bu bir iç içe layout örneğidir.");
        ageTv.setText("Yaşını bilmiyorsan ben söyleyeyim: "+ age);


        ulkelerLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dialogGoster(ulkeler[i]);
            }
        });



    }

    private void dialogGoster(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ÜLKE");
        builder.setMessage(s);
        /*builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {

                //İptal butonuna basılınca yapılacaklar.Sadece kapanması isteniyorsa boş bırakılacak

            }
        });

*/
        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //Tamam butonuna basılınca yapılacaklar

            }
        });


        builder.show();
    }
}
