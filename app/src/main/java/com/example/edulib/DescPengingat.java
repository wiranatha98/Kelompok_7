package com.example.edulib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DescPengingat extends AppCompatActivity {
    SQLite sql;
    TextView judul, prioritas, waktu, tanggal,desk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_pengingat);
        judul = findViewById(R.id.judulKegiatan);
        prioritas = findViewById(R.id.prirotasKegiatan);
        waktu = findViewById(R.id.jamKegiatan);
        tanggal = findViewById(R.id.tanggalKegiatan);
        desk = findViewById(R.id.deskKegiatan);
        sql = new SQLite(this);
        Intent i = getIntent();
        Pengingatmodel art = sql.pilihSatuArtikel(i.getStringExtra("id"));

        judul.setText(art.getTitle());
        prioritas.setText(art.getPriority());
        waktu.setText(art.getJam());
        tanggal.setText(art.getTanggal());
        desk.setText(art.getDesc());
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }
    public void berandaClick(View view) {
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

    public void back(View view) {
        Intent intent= new Intent(getApplicationContext(), DashboardPengingat.class);
        startActivity(intent);
    }
}
