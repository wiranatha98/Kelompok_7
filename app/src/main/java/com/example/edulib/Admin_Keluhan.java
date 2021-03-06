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

public class Admin_Keluhan extends AppCompatActivity {
    ArrayList<List> saran, keluhan;
    RecyclerView rvSaran, rvKeluhan;
    ListAdapter lSaran, lKeluhan;
    TextView admin;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_keluhan);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        saran = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();
        keluhan = new ArrayList<>();
        lSaran = new ListAdapter(saran, Admin_Keluhan.this);
        lKeluhan = new ListAdapter(keluhan, Admin_Keluhan.this);
        //rvSaran = findViewById(R.id.rvSaran);
        rvKeluhan = findViewById(R.id.rvKeluhan);
        //Saran.setLayoutManager(new LinearLayoutManager(this));
        rvKeluhan.setLayoutManager(new LinearLayoutManager(this));
        //rvSaran.setAdapter(lSaran);
        rvKeluhan.setAdapter(lKeluhan);
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
                                startActivity(new Intent(v.getContext(), Login.class));
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
        ref.child("Keluhan").addValueEventListener(new ValueEventListener() {
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
        });
    }

    public void saranClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Admin_Saran.class);
        startActivity(intent);
    }

    public void berandaClick(View view) {

        Intent intent = new Intent(getApplicationContext(), DashboardAdmin.class);
        startActivity(intent);
    }
}
