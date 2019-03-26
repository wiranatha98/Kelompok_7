package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tentang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Tentang");
    }

    public void saran(View view){
        startActivity(new Intent(Tentang.this,Saran.class));

    }

    public void keluhan(View view){
        startActivity(new Intent(Tentang.this,Keluhan.class));

    }
}
