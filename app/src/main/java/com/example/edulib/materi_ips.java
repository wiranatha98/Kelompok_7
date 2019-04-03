package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class materi_ips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_ips);
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }


    public void show_ips_inggris(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ips_inggris.class);
        startActivity(intent);
    }

    public void show_ips_ekonomi(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ips_ekonomi.class);
        startActivity(intent);
    }

    public void show_ips_sosiologi(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ips_sosiologi.class);
        startActivity(intent);
    }

    public void show_ips_indo(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ips_indo.class);
        startActivity(intent);
    }
}
