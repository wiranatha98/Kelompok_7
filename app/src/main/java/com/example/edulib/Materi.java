package com.example.edulib;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Materi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        ActionBar ab = getSupportActionBar();
        ab.hide();

        //Button showIpa = findViewById(R.id.showIpa);
        ImageView materiipa = findViewById(R.id.materiIpa);
        materiipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecyclerViewMateri.class);
                startActivity(intent);
            }
        });

    }

    public void berandaClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
    }

    public void materiClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Materi.class);
        startActivity(intent);
    }

    public void diskusiClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Diskusi.class);
        startActivity(intent);
    }

    public void showImageIpa(View view) {
        Intent intent = new Intent(getApplicationContext(), RecyclerViewMateri.class);
        startActivity(intent);
    }

<<<<<<< HEAD
    public void showImageBahasa(View view) {
    }

    public void showImageIps(View view) {
    }

    public void onClick(View view) {
    }
=======
>>>>>>> 2deb8366b9afd687b354539ec5fcf6ba3e0dc7cd
}


