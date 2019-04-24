package com.example.edulib;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditPassword extends AppCompatActivity {

    private FirebaseAuth frAuth;
    private DatabaseReference databaseReference;
    private TextView userProfile;
    private EditText passwordBaru,confirmBaru,passwordLama,confirmLama,username;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        frAuth = FirebaseAuth.getInstance();
        user = frAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

        userProfile = findViewById(R.id.txUser);
        passwordLama = findViewById(R.id.password_lama);
        passwordBaru = findViewById(R.id.password);
        confirmBaru = findViewById(R.id.confirm_pass);
        username = findViewById(R.id.usernameEdit);


        userProfile= findViewById(R.id.txUser);
        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu menu = new PopupMenu(v.getContext(), userProfile);
                menu.getMenuInflater()
                        .inflate(R.menu.menu_user, menu.getMenu());
                menu.getMenu().findItem(R.id.editPass).setVisible(false);
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.logout:
                                frAuth.signOut();
                                startActivity(new Intent(v.getContext(), Login.class));
                                ((Activity) getApplicationContext()).finish();
                                break;

                            case R.id.editUser :
                                startActivity(new Intent(v.getContext(),EditProfile.class));
                                break;

                            case R.id.editPass :
                                startActivity(new Intent(v.getContext(),EditPassword.class));
                                break;
                        }
                        return true;
                    }
                });
                menu.show();
            }
        });
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
    public void resetPassword(View view){
        if (!passwordBaru.getText().toString().equals(confirmBaru.getText().toString())){
            Toast.makeText(this, "Password baru tidak sama", Toast.LENGTH_SHORT).show();
            return;
        }
        if (passwordLama.getText().toString().equals(passwordBaru.getText().toString())){
            Toast.makeText(this, "Password baru harus berbeda !", Toast.LENGTH_SHORT).show();
            return;
        }
        AuthCredential credential = EmailAuthProvider.getCredential(frAuth.getCurrentUser().getEmail(),passwordLama.getText().toString());
        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            user.updatePassword(passwordBaru.getText().toString())
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                          if (task.isSuccessful()){
                                              Toast.makeText(EditPassword.this, "Password updated!", Toast.LENGTH_SHORT).show();
                                          }else{
                                              Toast.makeText(EditPassword.this, "Error password" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();                                          }
                                        }
                                    });
                        }
                    }
                });
    }
}

