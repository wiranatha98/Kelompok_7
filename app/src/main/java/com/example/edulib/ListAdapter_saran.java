package com.example.edulib;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter_saran extends RecyclerView.Adapter<ListAdapter_saran.ViewHolder> {
    ArrayList<List_saran> daftarList;
    Context mContext;

    public ListAdapter_saran(ArrayList<List_saran> daftarList, Context mContext) {
        this.daftarList = daftarList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_saran, viewGroup, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        List_saran list = daftarList.get(i);
        viewHolder.bindTo(list);

    }

    @Override
    public int getItemCount() {
        return daftarList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView pertanyaan,saran;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pertanyaan = itemView.findViewById(R.id.pertanyaan);
            saran = itemView.findViewById(R.id.saran);
//            super(itemView);
        }

        void bindTo(List_saran list){
           pertanyaan.setText(list.pertanyaan);
            saran.setText(list.saran);
        }
    }
}
