package com.example.edulib;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


public class Splashscreen  extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static int SPLASH_TIME_OUT = 4000;
    private Intent next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            if (mAuth.getCurrentUser().getEmail().contains("admin.com")){
                next = new Intent(Splashscreen.this, Admin.class);
            }else {
                next = new Intent(Splashscreen.this, Home.class);
            }
        }else{
            next = new Intent(Splashscreen.this, LoginAs.class);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent =
                startActivity(next);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}


