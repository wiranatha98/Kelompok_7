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
        setContentView(R.layout.activity_recycler_view_materi_ips);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.pilihpelajaran));
        mRecyclerView_Ips = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(RecyclerViewMateri_Ips.this, 2);
        mRecyclerView_Ips.setLayoutManager(mGridLayoutManager);

        mMateriList_Ips = new ArrayList<>();
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
        mMateriList_Ips.add(mMateriData_Ips);

        MateriAdapter_Ips myAdapter = new MateriAdapter_Ips(RecyclerViewMateri_Ips.this, mMateriList_Ips);
        mRecyclerView_Ips.setAdapter(myAdapter);
    }
}
