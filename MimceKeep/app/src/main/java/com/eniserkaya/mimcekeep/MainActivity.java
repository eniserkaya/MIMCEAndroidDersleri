package com.eniserkaya.mimcekeep;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Toolbar toolBar;
    Button kameraBtn,galeriBtn;
    ImageView img;

    public static final int galeryRequest = 1002;
    public static final int takePhotoRequest = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar = findViewById(R.id.toolbar_include);
        setSupportActionBar(toolBar);


        init();

    }

    private void init() {

        kameraBtn = findViewById(R.id.foto_cek_btn_id);
        galeriBtn = findViewById(R.id.galeri_sec_btn_id);
        img = findViewById(R.id.imageView);
        kameraBtn.setOnClickListener(this);
        galeriBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view == galeriBtn){

            Intent galeriIntent = new Intent();
            galeriIntent.setType("image/*");
            galeriIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(galeriIntent,
                    "Foto seçcek uygulamayı seç!"),galeryRequest);


        }
        else if(view == kameraBtn){
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent,1001);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1001){
            if(resultCode == RESULT_OK){
                Uri uri =data.getData();
                Log.d("gelenUri",uri+"");
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                img.setImageBitmap(bitmap);

            }
            else if(resultCode == RESULT_CANCELED){

            }
        }
        else if( requestCode == galeryRequest){
            if(resultCode == RESULT_OK){
                Uri uri = data.getData();
                Log.d("gelenUri",uri+"");
                try {
                    InputStream imageStream = getContentResolver().openInputStream(uri);
                    Bitmap fotoBitmap = BitmapFactory.decodeStream(imageStream);
                    img.setImageBitmap(fotoBitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if(resultCode == RESULT_CANCELED){

            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
