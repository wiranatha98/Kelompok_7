package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }

    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), DashboardAdmin.class);
        startActivity(intent);
    }
}
