package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);
        ActionBar ab = getSupportActionBar();
        ab.hide();
    }

    public void saran(View view){
        startActivity(new Intent(DashboardAdmin.this, DaftarSaran.class));
    }

    public void keluhan(View view){
        startActivity(new Intent(DashboardAdmin.this, DaftarKeluhan.class));
    }
}
