package com.example.edulib;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SkorActivity extends AppCompatActivity {

    private TextView tvSkor;
    private ArrayList<String> jList = new ArrayList<>();
    public static final String KJ = "kunci_jawaban";
    private int skor = 0;

    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);

        tvSkor = findViewById(R.id.tvSkor);
        TextView tvSkorAnda = findViewById(R.id.tvSkorAnda);

        Intent in = getIntent();

        FirebaseDatabase.getInstance().getReference("skor")
                .child(in.getStringExtra("jurusan"))
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            jList.add((String) postSnapshot.getValue());


                        }

                        for(int i=0 ; i<jList.size(); i++) {
                            skor += Integer.parseInt(jList.get(i)) * 10;
                            Log.e("SIZE",String.valueOf(jList.size()));
                            Log.e("Jawaban",String.valueOf(i) + " - " + String.valueOf(skor));
                        }

                        tvSkor.setText(String.valueOf(skor));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }
    public void berandaClick(View view) {
        Intent intent= new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
        finish();
    }

    public void materiClick(View view) {
        Intent intent= new Intent(getApplicationContext(), Materi.class);
        startActivity(intent);
        finish();
    }

    public void diskusiClick(View view) {
        Intent intent= new Intent(getApplicationContext(), Diskusi.class);
        startActivity(intent);
        finish();
    }
}
