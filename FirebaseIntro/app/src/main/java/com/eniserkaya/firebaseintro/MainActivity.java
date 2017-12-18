package com.eniserkaya.firebaseintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    EditText editText;
    DatabaseReference myRef;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        editText = findViewById(R.id.editText);
        btn.setOnClickListener(this);
        tv = findViewById(R.id.tv);

        myRef = database.getReference("KullaniciMesajlari/");

        mesajOku();

    }

    private void mesajOku() {
        // Read from the database


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Message value = dataSnapshot.getValue(Message.class);
                tv.append(value.getKisi()+ ": "+value.getMesaj()+"\n");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                for (DataSnapshot gelenler: dataSnapshot.getChildren()) {
                    Message value = gelenler.getValue(Message.class);
                    tv.append(value.getKisi()+ ": "+value.getMesaj()+"\n");
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
*/
    }

    @Override
    public void onClick(View view) {


        // Write a message to the database

        Message msj = new Message(editText.getText().toString().trim(),"Enis");

        //myRef.push().setValue(editText.getText().toString().trim());
        myRef.push().setValue(msj);

        //myRef.setValue();
    }
}
