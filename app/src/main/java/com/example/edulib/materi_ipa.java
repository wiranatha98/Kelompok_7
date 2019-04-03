package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class materi_ipa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_ipa);
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }

    public void show_blg(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ipa_blg.class);
        startActivity(intent);
    }

    public void show_kma(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ipa_kma.class);
        startActivity(intent);
    }

    public void show_fsk(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ipa_fsk.class);
        startActivity(intent);
    }

    public void show_mtk(View view) {
        Intent intent = new Intent(getApplicationContext(), materi_ipa_mtk.class);
        startActivity(intent);
    }
}
