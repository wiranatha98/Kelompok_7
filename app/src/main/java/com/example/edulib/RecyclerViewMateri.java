package com.example.edulib;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMateri extends AppCompatActivity {

    Toolbar mToolbar;
    android.support.v7.widget.RecyclerView mRecyclerView;
    List<MateriData> mMateriList;
    MateriData mMateriData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_materi);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.toolbarString));
        mRecyclerView = findViewById(R.id.recyclerview_materi);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(RecyclerViewMateri.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mMateriList = new ArrayList<>();
        mMateriData = new MateriData("Biologi", getString(R.string.biologi), R.drawable.biologi3);
        mMateriList.add(mMateriData);
        mMateriData = new MateriData("Matematika", getString(R.string.matematika), R.drawable.matematika1);
        mMateriList.add(mMateriData);
        mMateriData = new MateriData("Bahasa Inggris", getString(R.string.inggris), R.drawable.english1);
        mMateriList.add(mMateriData);
        mMateriData = new MateriData("Bahasa Indonesia", getString(R.string.indonesia), R.drawable.indo1);
        mMateriList.add(mMateriData);
        mMateriData = new MateriData("Kimia", getString(R.string.kimia), R.drawable.kimia1);
        mMateriList.add(mMateriData);
        mMateriData = new MateriData("Fisika", getString(R.string.fisika), R.drawable.fisika1);
        mMateriList.add(mMateriData);

        MateriAdapter myAdapter = new MateriAdapter(RecyclerViewMateri.this, mMateriList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
