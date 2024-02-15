package com.example.farepaymentsysapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class Register extends AppCompatActivity {
    EditText edtuName, edtphone, edtpasswd, edtconfPasswd;
    Button btnRegister;
    User user;
    FirebaseDatabase db;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       edtuName = findViewById(R.id.uName);
       edtphone = findViewById(R.id.phone);
       edtpasswd = findViewById(R.id.pass);
       edtconfPasswd = findViewById(R.id.confpass);
       btnRegister = findViewById(R.id.register);

        // Write a message to the database
        db = FirebaseDatabase.getInstance();
        myRef = db.getReference("user info");
        user = new User();

        btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String uName = edtuName.getText().toString();
               String phone = edtphone.getText().toString();
               String passwd = edtpasswd.getText().toString();
               String confPasswd = edtconfPasswd.getText().toString();

               if (uName.isEmpty() || phone.isEmpty() || passwd.isEmpty() ||
               confPasswd.isEmpty()){
                   Toast.makeText(getApplicationContext(), "please fill all the fields!",
                           Toast.LENGTH_SHORT).show();

               }else if (passwd.equals(confPasswd)){
                   addNewUser(uName, phone, passwd, confPasswd);
                   Intent intent = new Intent(getApplicationContext(), Login.class);
                   startActivity(intent);
               }
               else {
                   Toast.makeText(getApplicationContext(), "Password do not match!",
                           Toast.LENGTH_SHORT).show();
               }
           }

       });
    }
    public void addNewUser(String uName, String phone, String passwd, String confPasswd){
        user.setuName(uName);
        user.setPhone(phone);
        user.setPasswd(passwd);
        user.setConfPasswd(confPasswd);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myRef.child(phone).setValue(user);
                Toast.makeText(getApplicationContext(), "User registered successfully",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Error! user registration failed.",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}