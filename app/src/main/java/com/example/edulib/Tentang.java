package com.example.edulib;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Tentang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran_keluhan);
        final ImageView saran = findViewById(R.id.imageView13);
        final ImageView keluhan= findViewById(R.id.imageView17);
        ActionBar ab = getSupportActionBar();
        ab.hide();

        saran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Saran.class);
                startActivity(intent);
            }
        });

        keluhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Keluhan.class);
                startActivity(intent);
            }
        });
    }
    public void berandaClick(View view) {
        Intent intent= new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
    }

    public void materiClick(View view) {
        Intent intent= new Intent(getApplicationContext(), Materi.class);
        startActivity(intent);
    }

    public void diskusiClick(View view) {
        Intent intent= new Intent(getApplicationContext(), Diskusi.class);
        startActivity(intent);
    }

    public void saran(View view){
        startActivity(new Intent(Tentang.this,Saran.class));

    }

    public void keluhan(View view){
        startActivity(new Intent(Tentang.this,Keluhan.class));

    }
}
