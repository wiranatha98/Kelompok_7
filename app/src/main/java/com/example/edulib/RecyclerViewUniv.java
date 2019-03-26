package com.example.edulib;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewUniv extends AppCompatActivity {

    Toolbar mToolbar;
    android.support.v7.widget.RecyclerView mRecyclerView;
    List<UnivData> mUnivList;
    UnivData mUnivData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.toolbarString));
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(RecyclerViewUniv.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mUnivList = new ArrayList<>();
        mUnivData = new UnivData("Universitas Gadjah Mada", R.drawable.ugm);
        mUnivList.add(mUnivData);
        mUnivData = new UnivData("Institut Teknologi Bandung", R.drawable.itb);
        mUnivList.add(mUnivData);
        mUnivData = new UnivData("Institut Teknologi Sepuluh November", R.drawable.its);
        mUnivList.add(mUnivData);
        mUnivData = new UnivData("Universitas Padjajaran", R.drawable.unpad);
        mUnivList.add(mUnivData);
        mUnivData = new UnivData("Universitas Telkom",  R.drawable.telu);
        mUnivList.add(mUnivData);
        mUnivData = new UnivData("Universitas Udayana", R.drawable.unud);
        mUnivList.add(mUnivData);
        mUnivData = new UnivData("Universitas Dipenogoro", R.drawable.undip);
        mUnivList.add(mUnivData);
        mUnivData = new UnivData("Universitas Brawijaya",R.drawable.unibraw);
        mUnivList.add(mUnivData);
        mUnivData = new UnivData("Universitas Airlangga", R.drawable.unair);
        mUnivList.add(mUnivData);
        mUnivData = new UnivData("Universitas Indonesia", R.drawable.ui);
        mUnivList.add(mUnivData);

        MyAdapter myAdapter = new MyAdapter(RecyclerViewUniv.this, mUnivList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
