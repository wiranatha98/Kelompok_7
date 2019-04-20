package com.example.edulib;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMateri_Ips extends AppCompatActivity {

    Toolbar mToolbar;
    android.support.v7.widget.RecyclerView mRecyclerView_Ips;
    List<MateriData_Ips> mMateriList_Ips;
    MateriData_Ips mMateriData_Ips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_recycler_view_materi_ips);
=======
        setContentView(R.layout.activity_recycler_view_materi);
>>>>>>> 2deb8366b9afd687b354539ec5fcf6ba3e0dc7cd
        ActionBar ab = getSupportActionBar();
        ab.hide();
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.pilihpelajaran));
        mRecyclerView_Ips = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(RecyclerViewMateri_Ips.this, 2);
        mRecyclerView_Ips.setLayoutManager(mGridLayoutManager);

        mMateriList_Ips = new ArrayList<>();
<<<<<<< HEAD
        mMateriData_Ips = new MateriData_Ips("Ekonomi", getString(R.string.ekonomi) ,R.drawable.ekonomi1);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Matematika", getString(R.string.matematikaIps) ,R.drawable.mtkIps);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Bahasa Inggris", getString(R.string.inggrisIps) ,R.drawable.english1);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Bahasa Indonesia", getString(R.string.indonesiaIps) ,R.drawable.indo1);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Sosiologi", getString(R.string.sosiologi) ,R.drawable.sosiologi1);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Antropologi", getString(R.string.antropologi) ,R.drawable.antropologi1);
=======
        mMateriData_Ips = new MateriData_Ips("Ekonomi", getString(R.string.biologi) ,R.drawable.biologi3);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Matematika", getString(R.string.matematika) ,R.drawable.itb);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Bahasa Inggris", getString(R.string.inggris) ,R.drawable.its);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Bahasa Indonesia", getString(R.string.indonesia) ,R.drawable.unpad);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Kimia", getString(R.string.kimia) ,R.drawable.unpad);
        mMateriList_Ips.add(mMateriData_Ips);
        mMateriData_Ips = new MateriData_Ips("Fisika", getString(R.string.fisika) ,R.drawable.unpad);
>>>>>>> 2deb8366b9afd687b354539ec5fcf6ba3e0dc7cd
        mMateriList_Ips.add(mMateriData_Ips);

        MateriAdapter_Ips myAdapter = new MateriAdapter_Ips(RecyclerViewMateri_Ips.this, mMateriList_Ips);
        mRecyclerView_Ips.setAdapter(myAdapter);
    }
}
