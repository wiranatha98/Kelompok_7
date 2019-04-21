package com.example.edulib;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AsAdmin extends AppCompatActivity {
EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_admin);
        username = findViewById(R.id.username_login);
        password = findViewById(R.id.password_login);
    }

    public void login(View view){
//        if (!username.getText().toString().equals("admin")){
//            Toast.makeText(this, "Access Denied", Toast.LENGTH_SHORT).show();
//            return;
//        }
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(username.getText().toString()+"@admin.com",password.getText().toString()).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(AsAdmin.this, "login berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AsAdmin.this, Admin_Saran.class));
                            finish();
                        }
                    }
                }
        );
    }
}
