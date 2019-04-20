package com.example.edulib;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMateri_Bahasa extends AppCompatActivity {

    Toolbar mToolbar;
    android.support.v7.widget.RecyclerView mRecyclerView_Bahasa;
    List<MateriData_Bahasa> mMateriList_Bahasa;
    MateriData_Bahasa mMateriData_Bahasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_materi_bahasa);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.pilihpelajaran));
        mRecyclerView_Bahasa = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(RecyclerViewMateri_Bahasa.this, 2);
        mRecyclerView_Bahasa.setLayoutManager(mGridLayoutManager);

        mMateriList_Bahasa = new ArrayList<MateriData_Bahasa>();
        mMateriData_Bahasa = new MateriData_Bahasa("Bahasa dan Sastra Indonesia", getString(R.string.indonesiaBahasa) ,R.drawable.indo1);
        mMateriList_Bahasa.add(mMateriData_Bahasa);
        mMateriData_Bahasa = new MateriData_Bahasa("Matematika", getString(R.string.matematikaBahasa) ,R.drawable.matematika1);
        mMateriList_Bahasa.add(mMateriData_Bahasa);
        mMateriData_Bahasa= new MateriData_Bahasa("Bahasa dan Sastra Inggris", getString(R.string.inggrisBahasa) ,R.drawable.english1);
        mMateriList_Bahasa.add(mMateriData_Bahasa);
        mMateriData_Bahasa = new MateriData_Bahasa("Bahasa dan Sastra Jepang", getString(R.string.jepang) ,R.drawable.jepang1);
        mMateriList_Bahasa.add(mMateriData_Bahasa);
        mMateriData_Bahasa = new MateriData_Bahasa("Bahasa dan Sastra Mandarin", getString(R.string.mandarin) ,R.drawable.mandarin);
        mMateriList_Bahasa.add(mMateriData_Bahasa);
        mMateriData_Bahasa = new MateriData_Bahasa("Sejarah", getString(R.string.sejarah) ,R.drawable.sejarah);
        mMateriList_Bahasa.add(mMateriData_Bahasa);

        MateriAdapter_Bahasa myAdapter = new MateriAdapter_Bahasa(RecyclerViewMateri_Bahasa.this, mMateriList_Bahasa);
        mRecyclerView_Bahasa.setAdapter(myAdapter);
    }
}
