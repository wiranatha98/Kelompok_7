package com.example.edulib;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DaftarUser extends AppCompatActivity {
ArrayList<Pengguna>daftarPengguna;
AdapterPengguna adapterPengguna;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_user);
        recyclerView = findViewById(R.id.rvUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        daftarPengguna = new ArrayList<>();
        adapterPengguna = new AdapterPengguna(daftarPengguna,this);
        recyclerView.setAdapter(adapterPengguna);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    daftarPengguna.clear();
                    for (DataSnapshot e : dataSnapshot.getChildren()){
                        daftarPengguna.add(new Pengguna(e.child("FirstName").getValue().toString(),e.child("LastName").getValue().toString()));
                    }
                    adapterPengguna.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
