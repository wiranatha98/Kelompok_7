package com.example.edulib;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewBahasa extends AppCompatActivity {

    Toolbar mToolbar;
    android.support.v7.widget.RecyclerView mRecyclerView;
    List<bahasaData> mBahasaList;
    bahasaData mBahasaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_ipa);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        //mToolbar = findViewById(R.id.toolbar);
        //mToolbar.setTitle(getResources().getString(R.string.toolbarString));
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(RecyclerViewBahasa.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);


        mBahasaList = new ArrayList<>();
        mBahasaData = new bahasaData("Bahasa Indonesia", getString(R.string.indonesiaBahasa) ,R.drawable.indonesia);
        mBahasaList.add(mBahasaData);
        mBahasaData = new bahasaData("Bahasa Inggris", getString(R.string.inggris) ,R.drawable.inggris);
        mBahasaList.add(mBahasaData);
        mBahasaData = new bahasaData("Bahasa Jepang", getString(R.string.jepang) ,R.drawable.jepang);
        mBahasaList.add(mBahasaData);
        mBahasaData = new bahasaData("Bahasa Mandarin", getString(R.string.mandarin) ,R.drawable.mandarin);
        mBahasaList.add(mBahasaData);
        mBahasaData = new bahasaData("Matematika",  getString(R.string.matematika) ,R.drawable.matematika);
        mBahasaList.add(mBahasaData);
        mBahasaData = new bahasaData("Sejarah", getString(R.string.sejarah) ,R.drawable.biologi);
        mBahasaList.add(mBahasaData);

        MyAdapterBahasa myAdapter = new MyAdapterBahasa(RecyclerViewBahasa.this, mBahasaList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
