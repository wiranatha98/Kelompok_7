package com.example.edulib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
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
    private TextView userProfile;
    private TextView namaUser;
    private EditText firstName,lastName,username;
            FirebaseUser user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        frAuth = FirebaseAuth.getInstance();
        user = frAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

        userProfile = findViewById(R.id.txUser);
        firstName = findViewById(R.id.f_nameEdit);
        lastName = findViewById(R.id.l_nameEdit);
        username = findViewById(R.id.usernameEdit);

        namaUser = findViewById(R.id.textView20);
        namaUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu menu = new PopupMenu(v.getContext(), namaUser);
                menu.getMenuInflater()
                        .inflate(R.menu.menu_user, menu.getMenu());
                menu.getMenu().findItem(R.id.editUser).setVisible(false);
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
