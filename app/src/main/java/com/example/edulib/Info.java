package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ActionBar ab = getSupportActionBar();
        ab.hide();

    }

    public void infoUN(View view) {
        Intent intent = new Intent(this,Info_Un.class);
        startActivity(intent);
    }
}
