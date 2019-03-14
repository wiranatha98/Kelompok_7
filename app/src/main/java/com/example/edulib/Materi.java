package com.example.edulib;

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
        ab.setTitle("Materi");
    }

    public void berandaClick(View view) {
    }

    public void diskusiClick(View view) {
    }

    public void materiClick(View view) {
    }
}
