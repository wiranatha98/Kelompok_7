package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class materi_bahasa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_bahasa);
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }

    public void show_bahasa_indo(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_bahasa_indo.class);
        startActivity(intent);
    }

    public void show_bahasa_inggris(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_bahasa_inggris.class);
        startActivity(intent);
    }

    public void show_bahasa_antropologi(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_bahasa_antropologi.class);
        startActivity(intent);
    }

    public void show_bahasa_mtk(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_bahasa_mtk.class);
        startActivity(intent);
    }
}
