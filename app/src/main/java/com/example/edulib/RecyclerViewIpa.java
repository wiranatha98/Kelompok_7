package com.example.edulib;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewIpa extends AppCompatActivity {

    Toolbar mToolbar;
    android.support.v7.widget.RecyclerView mRecyclerView;
    List<ipaData> mIpaList;
    ipaData mIpaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_ipa);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        //mToolbar = findViewById(R.id.toolbar);
        //mToolbar.setTitle(getResources().getString(R.string.toolbarString));
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(RecyclerViewIpa.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);


        mIpaList = new ArrayList<>();
        mIpaData = new ipaData("Biologi", getString(R.string.biologi) ,R.drawable.biologi);
        mIpaList.add(mIpaData);
        mIpaData = new ipaData("Bahasa Indonesia", getString(R.string.indonesia) ,R.drawable.indonesia);
        mIpaList.add(mIpaData);
        mIpaData = new ipaData("Bahasa Inggris", getString(R.string.inggris) ,R.drawable.inggris);
        mIpaList.add(mIpaData);
        mIpaData = new ipaData("Kimia", getString(R.string.kimia) ,R.drawable.kimia);
        mIpaList.add(mIpaData);
        mIpaData = new ipaData("Fisika",  getString(R.string.fisika) ,R.drawable.fisika);
        mIpaList.add(mIpaData);
        mIpaData = new ipaData("Matematika", getString(R.string.matematika) ,R.drawable.matematika);
        mIpaList.add(mIpaData);

        MyAdapterIpa myAdapter = new MyAdapterIpa(RecyclerViewIpa.this, mIpaList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
