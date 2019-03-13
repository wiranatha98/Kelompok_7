package com.example.edulib;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.Inet4Address;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         final ImageView materi = findViewById(R.id.materi);
         final ImageView latihan_soal = findViewById(R.id.latihan_soal);
         final ImageView pengingat = findViewById(R.id.pengingat);
         final ImageView info = findViewById(R.id.info);
         final ImageView diskusi = findViewById(R.id.diskusi);
         final ImageView tentang = findViewById(R.id.tentang);
         final TextView tv_materi = findViewById(R.id.textView_materi);
         ActionBar ab = getSupportActionBar();
         ab.hide();



            materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Materi.class);
                startActivity(intent);
            }
        });

            latihan_soal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), LatihanSoal.class);
                    startActivity(intent);
                }
            });

        pengingat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pengingat.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Info.class);
                startActivity(intent);
            }
        });

        diskusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Diskusi.class);
                startActivity(intent);
            }
        });

        diskusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Diskusi.class);
                startActivity(intent);
            }
        });

        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Tentang.class);
                startActivity(intent);
            }
        });
    }
}
