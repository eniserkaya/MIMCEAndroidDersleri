package com.eniserkaya.tesbihuygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button allahuEkberBtn,subhanallahBtn,elhamdulillahBtn;
    TextView tesbihBirTv,tesbihIkiTv,tesbihUcTv,turBirTv,turIkiTv,turUcTv;
    int sayacAllahuEkber;
    int sayacSubhanallah;
    int sayacElhamdulillah;
    int turSayaciAllahuEkber;
    int turSayaciSubhanallah;
    int turSayaciElhamdulillah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        allahuEkberBtn =(Button)findViewById(R.id.tesbih_bir_id);
        subhanallahBtn = findViewById(R.id.tesbih_iki_id);
        elhamdulillahBtn = (Button)findViewById(R.id.tesbih_uc_id);

        allahuEkberBtn.setOnClickListener(this);
        subhanallahBtn.setOnClickListener(this);
        elhamdulillahBtn.setOnClickListener(this);

        tesbihBirTv = (TextView)findViewById(R.id.tesbih_bir_sayac_id);
        tesbihIkiTv = (TextView)findViewById(R.id.tesbih_iki_sayac_id);
        tesbihUcTv = (TextView)findViewById(R.id.tesbih_uc_sayac_id);
        turBirTv = (TextView)findViewById(R.id.tesbih_bir_tur_id);
        turIkiTv = (TextView)findViewById(R.id.tesbih_iki_tur_id);
        turUcTv = (TextView)findViewById(R.id.tesbih_uc_tur_id);


    }

    @Override
    public void onClick(View view) {
        /*if(view == subhanallahBtn){}
        else if(view == elhamdulillahBtn){}
        else if(view == allahuEkberBtn){}
        else{}
        */
        switch (view.getId()){
            case R.id.tesbih_bir_id: // Allahu Ekber Butonu

                sayacAllahuEkber++;

                if(sayacAllahuEkber == 33) { // if(sayacAllahuEkber == 33) if( sayacAllahuEkber % 33 == 0)
                    sayacAllahuEkber = 0;
                    turSayaciAllahuEkber ++;
                    turBirTv.setText("33 x" + turSayaciAllahuEkber); // String.valueOf(sayacAllahuEkber);
                }

                if(sayacAllahuEkber == 0)
                    tesbihBirTv.setText("Allahu Ekber: "); // String.valueOf(sayacAllahuEkber);
                else
                    tesbihBirTv.setText("Allahu Ekber:" + sayacAllahuEkber); // String.valueOf(sayacAllahuEkber);



                break;
            case R.id.tesbih_iki_id: // Subhanallah Butonu
                Toast.makeText(this, "SUBHANALLAH", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tesbih_uc_id: // Elhamdülillah Butonu
                Toast.makeText(this, "ELHAMDULILLAH", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
