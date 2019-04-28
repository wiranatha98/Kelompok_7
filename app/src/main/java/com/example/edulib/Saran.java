package com.example.edulib;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Saran extends AppCompatActivity {
    private FirebaseAuth mAuth;
//    private Button submit;
    private EditText perihal, keluhan,saran,pertanyaan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran);

        //perihal = findViewById(R.id.edSaran);
        //keluhan = findViewById(R.id.edPertanyaan);
        saran = findViewById(R.id.edSaran);
        pertanyaan = findViewById(R.id.edPertanyaan);
        mAuth = FirebaseAuth.getInstance();
        ActionBar ab = getSupportActionBar();
        ab.hide();

    }

    public void submit(View view) {
        if (saran.getText().toString().equals("")) {

            Toast.makeText(this, "Isi Pertanyaan", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Isi Saran", Toast.LENGTH_SHORT).show();
            saran.requestFocus();
            return;
        }
        if (pertanyaan.getText().toString().equals("")) {

            Toast.makeText(this, "Isi keluhanmu", Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "Isi Pertanyaan", Toast.LENGTH_SHORT).show();

            pertanyaan.requestFocus();
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy:HHmmss");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Saran").child(sdf.format(new Date()));
        ref.child("Pertanyan").setValue(pertanyaan.getText().toString());
        ref.child("saran").setValue(saran.getText().toString());
        startActivity(new Intent(Saran.this, NotifSaran.class));
        finish();

//        startActivity(new Intent());


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
}
//        startActivity(new Intent());
