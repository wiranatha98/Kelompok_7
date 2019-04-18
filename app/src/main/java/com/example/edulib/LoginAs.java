package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginAs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }

    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(),LoginAdmin.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
}
