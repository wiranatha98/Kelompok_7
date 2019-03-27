package com.example.edulib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NotifKeluhan extends AppCompatActivity {
    private Button submit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluhanterkirim);
        submit = findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    public void diskusiClick(View view) {
    }

    public void materiClick(View view) {
    }

    public void berandaClick(View view) {
    }

//    public void submitX(View view){
//        finish();
//    }
}
