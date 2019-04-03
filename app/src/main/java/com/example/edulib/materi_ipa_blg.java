package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class materi_ipa_blg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_ipa_blg);
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }

    public void diskusiClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Diskusi.class);
        startActivity(intent);
    }

    public void materiClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Materi.class);
        startActivity(intent);
    }

    public void berandaClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);

    }
}
