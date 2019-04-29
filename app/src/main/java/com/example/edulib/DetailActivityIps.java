package com.example.edulib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivityIps extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView mFlower;
    TextView mDescription,tvTitle;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ips);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        SharedPref pref = new SharedPref(this);
        mToolbar = findViewById(R.id.toolbar);
        mFlower = findViewById(R.id.ivImage);
        mDescription = findViewById(R.id.tvDescription);
        tvTitle = findViewById(R.id.tvTitle);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle(mBundle.getString("Title"));
            //tvTitle.setText(mBundle.getString("Title"));
            mFlower.setImageResource(mBundle.getInt("Image"));
            mDescription.setText(mBundle.getString("Description"));
        }
        if(pref.loadFont()) {
            mDescription.setTextSize(getResources().getDimension(R.dimen.big));
        } else {
            mDescription.setTextSize(getResources().getDimension(R.dimen.small));
        }
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

