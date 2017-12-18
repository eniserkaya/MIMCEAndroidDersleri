package com.eniserkaya.broadcastreceiverexample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IzinKontrolEt();
        ObservableObject.getInstance().addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        Toast.makeText(this, String.valueOf("activity observer " + o), Toast.LENGTH_SHORT).show();

    }

    public void IzinKontrolEt() {
        String[] izinler = {
                Manifest.permission.RECEIVE_SMS,

        };
        int izinKodu = 6;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED) {
               //Zaten izin verilmiş
            } else {
                //-- Almak istediğimiz izinler daha öncesinde kullanıcı tarafından onaylanmamış ise bu kod bloğu harekete geçecektir.
                //-- Burada requestPermissions() metodu ile kullanıcıdan ilgili Manifest izinlerini onaylamasını istiyoruz.
                requestPermissions(izinler, izinKodu);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 6: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //-- Eğer kullanıcı istemiş olduğunuz izni onaylarsa bu kod bloğu çalışacaktır.

                } else {
                    //İzin vermezse
                }
                return;
            }
            //-- Farklı 'case' blokları ekleyerek diğer izin işlemlerinizin sonuçlarını da kontrol edebilirsiniz.. Biz burada sadece değerini 67 olarak tanımladığımız izin işlemini kontrol ettik.
        }
    }

}
