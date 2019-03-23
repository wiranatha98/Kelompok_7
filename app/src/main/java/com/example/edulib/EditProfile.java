package com.example.edulib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditProfile extends AppCompatActivity {

    private FirebaseAuth frAuth;
    private DatabaseReference databaseReference;
    private EditText firstName,lastName,username;
            FirebaseUser user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        frAuth = FirebaseAuth.getInstance();
        user = frAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

        firstName = findViewById(R.id.f_nameEdit);
        lastName = findViewById(R.id.l_nameEdit);
        username = findViewById(R.id.usernameEdit);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                firstName.setText(dataSnapshot.child("FirstName").getValue().toString());
                lastName.setText(dataSnapshot.child("LastName").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        String sementera = user.getEmail().split("@")[0];
        username.setText(sementera);




    }
}
