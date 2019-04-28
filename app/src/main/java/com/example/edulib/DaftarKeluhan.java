package com.example.edulib;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.edulib.SaranKeluhan.AdapterKeluhan;
import com.example.edulib.SaranKeluhan.SaranKeluhan;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DaftarKeluhan extends AppCompatActivity {
    ArrayList<SaranKeluhan> arKeluhan;
    RecyclerView rvKeluhan;
    AdapterKeluhan adapKeluhan;
    //    ListAdapter lKeluhan;
    TextView admin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_keluhan);

        mAuth = FirebaseAuth.getInstance();
//        keluhan = new ArrayList<>();
//        arSaran = new ArrayList<>();
        arKeluhan = new ArrayList<>();
//        adapSaran = new AdapterKeluhan(arSaran,this);
        adapKeluhan = new AdapterKeluhan(arKeluhan, this);
//        lSaran = new ListAdapter(saran, Admin.this);
//        lKeluhan = new ListAdapter(keluhan, Admin.this);
//        rvSaran = findViewById(R.id.rvKeluhan);
        rvKeluhan = findViewById(R.id.rvKeluhan);
//        rvSaran.setLayoutManager(new LinearLayoutManager(this));
        rvKeluhan.setLayoutManager(new LinearLayoutManager(this));
//        rvSaran.setAdapter(adapSaran);
        rvKeluhan.setAdapter(adapKeluhan);
        admin = findViewById(R.id.txAdmin3);
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
                                finish();
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
                if (dataSnapshot.exists()) {
                    arKeluhan.clear();
                    for (DataSnapshot x : dataSnapshot.getChildren()) {
//                    keluhan.add(new List(x.child("Perihal").getValue().toString(), x.child("keluhan").getValue().toString()));
//                    lKeluhan.notifyDataSetChanged();
                        if (dataSnapshot.child("nama").exists()) {
                            arKeluhan.add(new SaranKeluhan(x.child("Perihal").getValue().toString(), x.child("keluhan").getValue().toString(), x.child("nama").getValue().toString()));
                        }else{
                            arKeluhan.add(new SaranKeluhan(x.child("Perihal").getValue().toString(), x.child("keluhan").getValue().toString()));
                        }
                    }
                    adapKeluhan.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
