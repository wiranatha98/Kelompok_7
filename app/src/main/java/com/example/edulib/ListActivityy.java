package com.example.edulib;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class ListActivityy extends AppCompatActivity {

    RecyclerView rvlist;
    SQLite sql;
    ArrayList<Pengingatmodel> data = new ArrayList<>();
    ListAdapterr adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listt);

        sql = new SQLite(ListActivityy.this);

        rvlist = findViewById(R.id.rvlist);
        rvlist.setHasFixedSize(true);
        rvlist.setLayoutManager(new LinearLayoutManager(ListActivityy.this));
        rvlist.setAdapter(new ListAdapterr(ListActivityy.this,sql.pilihSemuaArtikel()));
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                data.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(rvlist);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            rvlist.setLayoutManager(new GridLayoutManager(this, 2));
        }else if (newConfig.orientation== Configuration.ORIENTATION_PORTRAIT){
            rvlist.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}
