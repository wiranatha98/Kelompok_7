package com.example.edulib;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SoalActivity extends AppCompatActivity {

    private RecyclerView rvSoal;
    private List<SoalModel> sList = new ArrayList<>();
    private String jurusan;

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseDatabase.getInstance().getReference("soal").child("IPA")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        sList.clear();

                        for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            SoalModel sm = postSnapshot.getValue(SoalModel.class);
                            sList.add(sm);
                        }
                        rvSoal.setAdapter(new SoalAdapter(
                                rvSoal,
                                SoalActivity.this,
                                sList));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

        jurusan = new Intent().getStringExtra("jurusan");

        NoHorizontalScrollLLM nhllm = new NoHorizontalScrollLLM(this,LinearLayoutManager.HORIZONTAL, false);
        nhllm.canScrollHorizontally();
        nhllm.canScrollVertically();

        rvSoal = findViewById(R.id.rvSoal);
        rvSoal.setHasFixedSize(true);
        rvSoal.setLayoutFrozen(true);
        rvSoal.setLayoutManager(nhllm);
    }
}
