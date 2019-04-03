package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Materi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }

    public void berandaClick(View view) {
    }

    public void diskusiClick(View view) {
    }

    public void materiClick(View view) {
    }

    public void showImageBahasa(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_bahasa.class);
        startActivity(intent);
    }

    public void showImageIps(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ips.class);
        startActivity(intent);
    }

    public void showImageIpa(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ipa.class);
        startActivity(intent);
    }
}
