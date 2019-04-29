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

<<<<<<< Updated upstream
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), DashboardAdmin.class);
        startActivity(intent);
=======
//        if (!username.getText().toString().equals("admin")){
//            Toast.makeText(this, "Access Denied", Toast.LENGTH_SHORT).show();
//            return;
//        }
        if (username.getText().toString().equals("")){
            username.setError("Isi Username");
            username.requestFocus();
            return;
        }
        if (password.getText().toString().equals("")){
            password.setError("Isi Password");
            password.requestFocus();
            return;
        }
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(username.getText().toString()+"@admin.com",password.getText().toString()).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginAdmin.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginAdmin.this,DashboardAdmin.class));
                            finish();
                        }
                        else {
                            Toast.makeText(LoginAdmin.this,"Login Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
>>>>>>> Stashed changes
    }
}
