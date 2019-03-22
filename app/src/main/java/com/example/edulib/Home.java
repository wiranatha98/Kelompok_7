package com.example.edulib;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.net.Inet4Address;

public class Home extends AppCompatActivity  implements GoogleApiClient.OnConnectionFailedListener {

    private FirebaseAuth mAuth;
    private TextView namaUser;

    private GoogleSignInOptions gso;
    private GoogleApiClient mGoogleApiClient;
    private static final String TAG = "HomeActivity";
    private static final int RC_SIGN_IN = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         final ImageView materi = findViewById(R.id.materi);
         final ImageView latihan_soal = findViewById(R.id.latihan_soal);
         final ImageView pengingat = findViewById(R.id.pengingat);
         final ImageView info = findViewById(R.id.info);
         final ImageView diskusi = findViewById(R.id.diskusi);
         final ImageView tentang = findViewById(R.id.tentang);
         final TextView tv_materi = findViewById(R.id.textView_materi);
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


        mAuth = FirebaseAuth.getInstance();
            namaUser = findViewById(R.id.txHello);
            if (mAuth.getCurrentUser()!=null){
                namaUser.setText("Hai, " + mAuth.getCurrentUser().getDisplayName());
            }else{
                startActivity(new Intent(Home.this,Login.class));
                finish();
            }

            //TODO(namaUser Listener) : Sementara untuk test logout
            namaUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Auth.GoogleSignInApi.signOut(mGoogleApiClient).addStatusListener(new PendingResult.StatusListener() {
                        @Override
                        public void onComplete(Status status) {
//                            Toast.makeText(Home.this, status.getStatus().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    mAuth.signOut();
                    startActivity(new Intent(Home.this,Login.class));
                    finish();
                }
            });


            materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Materi.class);
                startActivity(intent);
            }
        });

            latihan_soal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), LatihanSoal.class);
                    startActivity(intent);
                }
            });

        pengingat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pengingat.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Info.class);
                startActivity(intent);
            }
        });

        diskusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Diskusi.class);
                startActivity(intent);
            }
        });

        diskusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Diskusi.class);
                startActivity(intent);
            }
        });

        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Tentang.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
