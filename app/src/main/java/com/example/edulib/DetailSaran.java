package com.example.edulib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailSaran extends AppCompatActivity {

    TextView judul, isi, nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_saran);

        judul = findViewById(R.id.txJudulDetail);
        isi = findViewById(R.id.txIsiDetail);
        nama = findViewById(R.id.txUser);

        judul.setText(getIntent().getStringExtra("judul"));
        isi.setText(getIntent().getStringExtra("isi"));
        if (!getIntent().getStringExtra("nama").equals("")) {
            nama.setText(getIntent().getStringExtra("nama"));
        }
    }
}
