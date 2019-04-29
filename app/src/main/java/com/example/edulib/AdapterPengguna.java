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

public class AdapterPengguna  extends RecyclerView.Adapter<AdapterPengguna.ViewHolder> {
    ArrayList<Pengguna> daftarUser;
    Context mContext;

    public AdapterPengguna(ArrayList<Pengguna> daftarUser, Context mContext) {
        this.daftarUser = daftarUser;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_user, viewGroup, false);
        return new AdapterPengguna.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPengguna.ViewHolder viewHolder, int i) {
        Pengguna pengguna = daftarUser.get(i);
        viewHolder.bindTo(pengguna);
    }


    @Override
    public int getItemCount() {
        return daftarUser.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nama;
//        String nama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.txUser);
//            pertanyaan = itemView.findViewById(R.id.pertanyaan);
//            saran = itemView.findViewById(R.id.saran);
//            super(itemView);

//            itemView.setOnClickListener(this);
        }

        void bindTo(Pengguna list){
            nama.setText(list.getName());
//            nama = list.getNama();
//            pertanyaan.setText(list.pertanyaan);
//            saran.setText(list.saran);
        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(mContext, DetailSaran.class);
//            intent.putExtra("judul",pertanyaan.getText().toString());
//            intent.putExtra("isi",saran.getText().toString());
//            intent.putExtra("nama",nama);
//            mContext.startActivity(intent);
        }
    }
}
