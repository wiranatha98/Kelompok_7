package com.example.edulib;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Set;

public class Setting extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    Switch switchnight, switchfont;
    Button savebutton;
    private FirebaseAuth mAuth;
    private GoogleSignInOptions gso;
    private GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        //Google Sign In
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getResources().getString(R.string.webClientId))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        final SharedPref pref = new SharedPref(this);


        switchfont = findViewById(R.id.switch2);
        switchfont.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchfont.isChecked()) {
                    pref.setFont(true);
                } else {
                    pref.setFont(false);
                }
            }
        });

        if (pref.loadFont()) {
            switchfont.setChecked(true);
        } else {
            switchfont.setChecked(false);
        }

        savebutton = findViewById(R.id.savebutton);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Setting.this, Home.class));
                finish();
            }
        });
    }

    public void keluar(View view) {
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(Setting.this, LoginAs.class));
            finish();
        } else {
            startActivity(new Intent(Setting.this, LoginAs.class));
            finish();
        }
    }

    public void editPassword(View view) {
        Intent intent = new Intent(getApplicationContext(), EditPassword.class);
        startActivity(intent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(Setting.this, "Error Connection", Toast.LENGTH_SHORT).show();
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



