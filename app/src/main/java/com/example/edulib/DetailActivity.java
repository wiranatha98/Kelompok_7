package com.example.edulib;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView mFlower;
    TextView mDescription,tvTitle;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ActionBar ab = getSupportActionBar();
        ab.hide();

        mToolbar = findViewById(R.id.toolbar);
        mFlower = findViewById(R.id.ivImage);
        mDescription = findViewById(R.id.tvDescription);
        tvTitle = findViewById(R.id.tvTitle);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            //mToolbar.setTitle(mBundle.getString("Title"));
            tvTitle.setText(mBundle.getString("Title"));
            mFlower.setImageResource(mBundle.getInt("Image"));
            mDescription.setText(mBundle.getString("Description"));
        }
    }
}
