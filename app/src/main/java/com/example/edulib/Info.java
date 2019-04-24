package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ActionBar ab = getSupportActionBar();
        ab.hide();

        Button infoUniv_btn = findViewById(R.id.infoUniv_btn);
        infoUniv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),RecyclerViewUniv.class);
                startActivity(intent);
            }
        });

    }

    public void infoUN(View view) {
        Intent intent = new Intent(this,Info_Un.class);
        startActivity(intent);
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


    public void infoUniv(View view) {
    }
}
