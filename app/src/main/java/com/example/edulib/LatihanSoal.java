package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LatihanSoal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_soal);
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }
    public void berandaClick(View view){
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

    public void pilihBahasa(View view) {
    }

    public void pilihIPA(View view) {
        Intent i = new Intent(LatihanSoal.this,SoalActivity.class);
        i.putExtra("jurusan","IPA");
        startActivity(i);
    }

    public void pilihIPS(View view) {
    }
}
