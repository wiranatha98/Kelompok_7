package com.example.edulib;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Admin_Saran extends AppCompatActivity {
    ArrayList<List_saran> pertanyaan, saran;
    RecyclerView rvSaran, rvPertanyaan;
    ListAdapter_saran lSaran, lPertanyaan;
    TextView admin;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_saran);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        saran = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();
        pertanyaan = new ArrayList<>();
        lSaran = new ListAdapter_saran(saran, Admin_Saran.this);
        lPertanyaan = new ListAdapter_saran(pertanyaan, Admin_Saran.this);
        rvSaran = findViewById(R.id.rvSaran);
        //rvKeluhan = findViewById(R.id.rvKeluhan);
        rvSaran.setLayoutManager(new LinearLayoutManager(this));
        //rvKeluhan.setLayoutManager(new LinearLayoutManager(this));
        rvSaran.setAdapter(lSaran);
        //rvKeluhan.setAdapter(lKeluhan);
        admin = findViewById(R.id.txAdmin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu menu = new PopupMenu(v.getContext(), admin);
                menu.getMenuInflater()
                        .inflate(R.menu.admin, menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.logout:
                                mAuth.signOut();
                                startActivity(new Intent(v.getContext(), LoginAs.class));
                                ((Activity) getApplicationContext()).finish();
                                break;

                        }
                        return true;
                    }
                });
                menu.show();
            }
        });


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Saran").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    Log.d("TAG", x.getValue().toString());
                    saran.add(new List_saran(x.child("Pertanyan").getValue().toString(), x.child("saran").getValue().toString()));
                    lSaran.notifyDataSetChanged();
                    //keluhan.add(new List(x.child("Perihal").getValue().toString(), x.child("keluhan").getValue().toString()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*ref.child("Keluhan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    keluhan.add(new List(x.child("Perihal").getValue().toString(), x.child("keluhan").getValue().toString()));
                    lKeluhan.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }

    public void keluhanClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Admin_Keluhan.class);
        startActivity(intent);
    }
    public void berandaClick(View view) {

        Intent intent = new Intent(getApplicationContext(), DashboardAdmin.class);
        startActivity(intent);
    }
}
