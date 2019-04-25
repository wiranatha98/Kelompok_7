package com.example.edulib;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapterr extends RecyclerView.Adapter<ListAdapterr.ListViewHolder> {

    List<Pengingatmodel> artlist;
    Context context;
    Pengingatmodel art;

    public ListAdapterr(Context context, List<Pengingatmodel> artlist) {
        this.context = context;
        this.artlist = artlist;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_cardvieww,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        art = artlist.get(i);
        listViewHolder.judul.setText(art.getTitle());
        listViewHolder.prioritas.setText(art.getPriority());
        listViewHolder.desc.setText(art.getDesc());

    }

    @Override
    public int getItemCount() {
        return artlist.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView judul, prioritas, desc;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            judul =  itemView.findViewById(R.id.judul_card);
            prioritas = itemView.findViewById(R.id.prioritas_card);
            desc = itemView.findViewById(R.id.desc_card);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    art = artlist.get(getAdapterPosition());
                    Intent i = new Intent(context,DescPengingat.class);
                    i.putExtra("id",art.getId());
                    context.startActivity(i);
                }
            });
        }
    }
}
