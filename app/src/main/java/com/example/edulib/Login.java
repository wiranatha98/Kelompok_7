package com.example.edulib;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //firebase init()
        mAuth = FirebaseAuth.getInstance();

        ActionBar ab = getSupportActionBar();
        ab.hide();
        TextView tv_signup = findViewById(R.id.tv_signup);

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
//                finish();
            }
        });
    }

    public void onClick(View view) {
        EditText username = findViewById(R.id.username_login);
        EditText password = findViewById(R.id.password_login);//Firebase Login

        if (!username.getText().toString().equals("") && !password.getText().toString().equals("")) {
            mAuth.signInWithEmailAndPassword(username.getText().toString()+"@"+R.string.emailDummy, password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), Home.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        } else if (username.getText().toString().equals("")) {
            username.setError("Harap Isi Username");
        } else if (password.getText().toString().equals("")) {
            password.setError("Harap Isi Password");
        }
    }
}
