package com.eniserkaya.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText userNameEt;
    private EditText pwEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        init();
    }

    private void init() {

        Log.d("INITEGELCEKMI","geliyor");

        loginBtn = (Button)findViewById(R.id.giris_yap_id);
        userNameEt =(EditText)findViewById(R.id.username_id);
        pwEt = (EditText)findViewById(R.id.pw_id);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("INITEGELCEKMI","onclick");

                String userName = userNameEt.getText().toString().trim();
                String pw = pwEt.getText().toString().trim();

                if(userName.isEmpty() ||
                        pw.isEmpty() ||
                        pw.length() < 5 ||
                        userName.length() < 3){

                    Toast toast = Toast.makeText(MainActivity.this, "BİLGİLERİNİ KONTROL ET !", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
                else{
                    doLogin(userName,pw);
                }
            }
        });

    }

    private void doLogin(String userName, String pw) {

        // bir tane şifre değişkeni tanımla
        // bir tane userName değişkeni tanımla
        // equalIgnoreCase methodunu kullanarak if else ile karşışatır.
        // giriş yaparsa OKEY tostunu yaz, yapmazsa hata tostunu yazdır..
    }
}
