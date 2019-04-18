package com.example.edulib;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
ArrayList<List> daftarList;
Context mContext;

    public ListAdapter(ArrayList<List> daftarList, Context mContext) {
        this.daftarList = daftarList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        List list = daftarList.get(i);
        viewHolder.bindTo(list);

    }

    @Override
    public int getItemCount() {
        return daftarList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView perihal,keluhan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            perihal = itemView.findViewById(R.id.perihal);
            keluhan = itemView.findViewById(R.id.keluhan);
//            super(itemView);
        }

        void bindTo(List list){
            perihal.setText(list.perihal);
            keluhan.setText(list.keluhan);
        }
    }
}
