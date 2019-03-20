package com.example.edulib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Saran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran);
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

    public void kirimSaran(View view) {
        EditText saran = findViewById(R.id.editText3);
        EditText pertanyaan=findViewById(R.id.editText4);

        if (!saran.getText().toString().equals("")&& !pertanyaan.getText().toString().equals("")){
            Intent intent = new Intent(getApplicationContext(), saranTerkirim.class);
            startActivity(intent);
        }
        else if (saran.getText().toString().equals("")){
            saran.setError("Harap isi bidang ini");
        }
        else if (pertanyaan.getText().toString().equals("")){
            pertanyaan.setError("Harap isi bidang ini");
        }
    }
}
