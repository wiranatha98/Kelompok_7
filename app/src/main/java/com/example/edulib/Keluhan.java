package com.example.edulib;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBar;

public class Keluhan extends AppCompatActivity {
    private FirebaseAuth mAuth;
    //    private Button submit;
    private EditText perihal, keluhan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluhan);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        perihal = findViewById(R.id.edPerihalKeluhan);
        keluhan = findViewById(R.id.edKeluhanKeluhan);
        mAuth = FirebaseAuth.getInstance();

    }

    public void submit(View view) {
        if (perihal.getText().toString().equals("")) {
            Toast.makeText(this, "Isi Perihalnya", Toast.LENGTH_SHORT).show();
            perihal.requestFocus();
            return;
        }
        if (keluhan.getText().toString().equals("")) {
            Toast.makeText(this, "Isi keluhanmu", Toast.LENGTH_SHORT).show();
            keluhan.requestFocus();
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy:HHmmss");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Keluhan").child(sdf.format(new Date()));
        ref.child("Perihal").setValue(perihal.getText().toString());
        ref.child("keluhan").setValue(keluhan.getText().toString());
        startActivity(new Intent(Keluhan.this, NotifKeluhan.class));
        finish();
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

