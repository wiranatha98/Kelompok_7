package com.example.edulib;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewIps extends AppCompatActivity {

    Toolbar mToolbar;
    android.support.v7.widget.RecyclerView mRecyclerView;
    List<ipsData> mIpsList;
    ipsData mIpsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_ips);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("MATERI IPS");
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(RecyclerViewIps.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);


        mIpsList = new ArrayList<>();
        mIpsData = new ipsData("Ekonomi", getString(R.string.ekonomi) ,R.drawable.ekonomi);
        mIpsList.add(mIpsData);
        mIpsData = new ipsData("Bahasa Indonesia", getString(R.string.indonesia) ,R.drawable.indonesia);
        mIpsList.add(mIpsData);
        mIpsData = new ipsData("Bahasa Inggris", getString(R.string.inggris) ,R.drawable.inggris);
        mIpsList.add(mIpsData);
        mIpsData = new ipsData("Antropologi", getString(R.string.antropologi) ,R.drawable.antropologi);
        mIpsList.add(mIpsData);
        mIpsData = new ipsData("Sosiologi",  getString(R.string.sosiologi) ,R.drawable.sosiologi);
        mIpsList.add(mIpsData);
        mIpsData = new ipsData("Matematika", getString(R.string.matematika) ,R.drawable.matematika);
        mIpsList.add(mIpsData);

        MyAdapterIps myAdapter = new MyAdapterIps(RecyclerViewIps.this, mIpsList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
