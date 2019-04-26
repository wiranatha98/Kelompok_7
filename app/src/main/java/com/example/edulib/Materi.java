package com.example.edulib;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Materi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        ActionBar ab = getSupportActionBar();
        ab.hide();

            }

    public void berandaClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
    }

    public void materiClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Materi.class);
        startActivity(intent);
    }

    public void diskusiClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Diskusi.class);
        startActivity(intent);
    }


    public void ipa(View view) {
        Intent intent = new Intent(getApplicationContext(), RecyclerViewIpa.class);
        startActivity(intent);
    }

    public void ips(View view) {
        Intent intent = new Intent(getApplicationContext(), RecyclerViewIps.class);
        startActivity(intent);
    }

    public void bahasa(View view) {
        Intent intent = new Intent(getApplicationContext(), RecyclerViewBahasa.class);
        startActivity(intent);
    }
}


