package com.eniserkaya.dersiki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ilkBtn;
    private Button ikinciBtn;
    private TextView  bilgiTv;

    private int sayac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ilkBtn = (Button)findViewById(R.id.button_bir);
        ikinciBtn = (Button)findViewById(R.id.button_renkli);
        bilgiTv = (TextView)findViewById(R.id.text_bilgi);

        ikinciBtn.setOnClickListener(this);
        ilkBtn.setOnClickListener(this);

        /*ilkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    sayac++;
                    bilgiTv.setText(sayac+"");

                    if(sayac == 33)
                        sayac = 0;

                //Toast.makeText(MainActivity.this, "Basma Sayısı : "+sayac, Toast.LENGTH_SHORT).show();
            }
        });*/



       // Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
            if(view == ilkBtn){// ilk Butona tıklanırsa olacaklar bu if blgunda calısır.
                sayac++;
                bilgiTv.setText(sayac+"");

                if(sayac == 33)
                    sayac = 0;
            }
            else if(view.getId() == R.id.button_renkli){ // renklı butona basınca calısacaklar burada .
                bilgiTv.setText("Renkli butona bastın kardeş.");
            }
            else{}
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }*/
}
