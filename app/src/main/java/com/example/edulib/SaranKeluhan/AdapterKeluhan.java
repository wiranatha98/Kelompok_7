package com.example.edulib.SaranKeluhan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edulib.R;

import java.util.ArrayList;

public class AdapterKeluhan extends RecyclerView.Adapter<AdapterKeluhan.ViewHolder> {
    ArrayList<SaranKeluhan> daftarSaranKeluhan;
    Context mContext;

    public AdapterKeluhan(ArrayList<SaranKeluhan> daftarSaranKeluhan, Context mContext) {
        this.daftarSaranKeluhan = daftarSaranKeluhan;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SaranKeluhan saranKeluhan = daftarSaranKeluhan.get(i);
        viewHolder.bindTo(saranKeluhan);
    }

    @Override
    public int getItemCount() {
        return daftarSaranKeluhan.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView judul, user;
        String isi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.txJudulCard);
            user = itemView.findViewById(R.id.txUserCard);
            itemView.setOnClickListener(this);
        }

        void bindTo(SaranKeluhan saranKeluhan){
            judul.setText(saranKeluhan.perihal);
            user.setText(saranKeluhan.getNamaUser());
            isi = saranKeluhan.getKeluhan();
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, isi, Toast.LENGTH_SHORT).show();
        }
    }
}
