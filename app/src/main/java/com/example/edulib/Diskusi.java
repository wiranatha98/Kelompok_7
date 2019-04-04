package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Diskusi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diskusi);
        final Button ipa = findViewById(R.id.ipa_btn);
        final Button sosial = findViewById(R.id.sosial_btn);
        final Button bahasa = findViewById(R.id.bahasa_btn);


        ActionBar ab = getSupportActionBar();
        ab.hide();

    }

    public void diskusi_ipa(View view){
        Intent intent = new Intent(getApplicationContext(), ChatRoom.class);
        intent.putExtra("room-name","IPA");
        startActivity(intent);
    }
    public void diskusi_sosial(View view){
        Intent intent = new Intent(getApplicationContext(), ChatRoom.class);
        intent.putExtra("room-name","Sosial");
        startActivity(intent);
    }
    public void diskusi_bahasa(View view){
        Intent intent = new Intent(getApplicationContext(), ChatRoom.class);
        intent.putExtra("room-name","Bahasa");
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


}
