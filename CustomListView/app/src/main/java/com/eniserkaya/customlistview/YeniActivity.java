package com.eniserkaya.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class YeniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){

            Log.d("telefonVeisim ", bundle.getString("tel")+
                    "isim: " +bundle.getString("ad"));

        }
    }
}
