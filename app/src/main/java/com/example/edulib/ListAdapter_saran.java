package com.example.edulib;

import android.content.Context;
import android.content.Intent;
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView pertanyaan,saran;
        String nama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pertanyaan = itemView.findViewById(R.id.pertanyaan);
            saran = itemView.findViewById(R.id.saran);
//            super(itemView);

            itemView.setOnClickListener(this);
        }

        void bindTo(List_saran list){
            nama = list.getNama();
           pertanyaan.setText(list.pertanyaan);
            saran.setText(list.saran);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, DetailSaran.class);
            intent.putExtra("judul",pertanyaan.getText().toString());
            intent.putExtra("isi",saran.getText().toString());
            intent.putExtra("nama",nama);
            mContext.startActivity(intent);
        }
    }
}
