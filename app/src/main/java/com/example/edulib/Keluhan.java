package com.example.edulib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Keluhan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluhan);
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

    public void kirimKeluhan(View view) {
        EditText perihal = findViewById(R.id.editText);
        EditText keluhan =findViewById(R.id.editText2);

        if (!perihal.getText().toString().equals("")&& !keluhan.getText().toString().equals("")){
            Intent intent = new Intent(getApplicationContext(), keluhanTerkirim.class);
            startActivity(intent);
        }
        else if (perihal.getText().toString().equals("")){
            perihal.setError("Harap isi bidang ini");
        }
        else if (keluhan.getText().toString().equals("")){
            keluhan.setError("Harap isi bidang ini");
        }
    }
    }

