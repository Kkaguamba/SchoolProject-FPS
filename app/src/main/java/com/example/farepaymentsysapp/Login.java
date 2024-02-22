package com.example.farepaymentsysapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button submit;
    EditText phone_no,passwd;
    FirebaseDatabase db;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        submit = findViewById(R.id.submit);
        phone_no = findViewById(R.id.phone);
        passwd = findViewById(R.id.pass);

        db = FirebaseDatabase.getInstance();
        myRef = db.getReference("user info");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String Phone = phone_no.getText().toString().trim();
              String Password = passwd.getText().toString().trim();
               if (Phone.isEmpty() || Password.isEmpty()){
                   Toast.makeText(Login.this, "Please fill in all the fields.",
                           Toast.LENGTH_SHORT).show();
               }else {
                   // Read from the database
                   myRef.addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(DataSnapshot dataSnapshot) {
                           // This method is called once with the initial value and again
                           // whenever data at this location is updated.
                           if (dataSnapshot.hasChild(Phone)){
                               String pass = dataSnapshot.child(Phone).child("passwd").getValue(String.class);
                               if (Password.equals(pass)){
                                   Intent i = new Intent(getApplicationContext(), Scanner.class);
                                   startActivity(i);
                               }else {
                                   Toast.makeText(Login.this, "Invalid phone number and password!",
                                           Toast.LENGTH_SHORT).show();
                               }

                           }else {
                               Toast.makeText(Login.this, "Invalid input!",
                                       Toast.LENGTH_SHORT).show();
                           }

                       }

                       @Override
                       public void onCancelled(DatabaseError error) {
                       }
                   });
               }

            }
        });


    }
}