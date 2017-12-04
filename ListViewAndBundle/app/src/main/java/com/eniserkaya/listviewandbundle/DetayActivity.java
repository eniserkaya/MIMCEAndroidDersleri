package com.eniserkaya.listviewandbundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        tv = (TextView)findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String mesaj = bundle.getString("mesaj");
            String tarih = bundle.getString("tarih");
            Log.d("mesajVeTarih","Mesaj: "+ mesaj+ " Tarih: " +tarih);
            tv.setText("Mesaj: "+ mesaj+ " Tarih: " +tarih);


        }


    }
}
