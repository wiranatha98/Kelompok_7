package com.example.edulib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailKeluhan extends AppCompatActivity {

    TextView judul, isi, nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_keluhan);
        judul = findViewById(R.id.txJudulDetail);
        isi = findViewById(R.id.txIsiDetail);
        nama = findViewById(R.id.txUserDetail);

        judul.setText(getIntent().getStringExtra("judul"));
        isi.setText(getIntent().getStringExtra("isi"));
        nama.setText(getIntent().getStringExtra("nama"));
    }
}
