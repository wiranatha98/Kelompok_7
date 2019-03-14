package com.example.edulib;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        TextView tv_signup = findViewById(R.id.tv_signup);

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        EditText username = findViewById(R.id.username_login);
        EditText password = findViewById(R.id.password_login);

        if (!username.getText().toString().equals("")&& !password.getText().toString().equals("")){
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
        else if (username.getText().toString().equals("")){
            username.setError("Harap Isi Username");
        }
        else if (password.getText().toString().equals("")){
            password.setError("Harap Isi Password");
        }
    }
}
