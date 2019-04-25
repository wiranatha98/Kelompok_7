package com.example.edulib;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 *
 */
public class MateriAdapter_Bahasa extends RecyclerView.Adapter<MateriViewHolder_Ips> {

    private Context mContext;
    private List<MateriData_Bahasa> mMateriList_Bahasa;

    MateriAdapter_Bahasa(Context mContext, List<MateriData_Bahasa> mMateriList_Bahasa) {
        this.mContext = mContext;
        this.mMateriList_Bahasa = mMateriList_Bahasa;
    }

    @Override
    public MateriViewHolder_Ips onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_materi, parent, false);
        return new MateriViewHolder_Ips(mView);
    }

    @Override
    public void onBindViewHolder(final MateriViewHolder_Ips holder, int position) {
        holder.mImage.setImageResource(mMateriList_Bahasa.get(position).getUnivImage());
        holder.mTitle.setText(mMateriList_Bahasa.get(position).getUnivName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailMateri.class);
                mIntent.putExtra("Title", mMateriList_Bahasa.get(holder.getAdapterPosition()).getUnivName());
                mIntent.putExtra("Description", mMateriList_Bahasa.get(holder.getAdapterPosition()).getUnivDescription());
                mIntent.putExtra("Image", mMateriList_Bahasa.get(holder.getAdapterPosition()).getUnivImage());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMateriList_Bahasa.size();
    }
}

class MateriViewHolder_Bahasa extends RecyclerView.ViewHolder {
    private Context mContext;
    ImageView mImage;
    TextView mTitle;
    CardView mCardView;
    Button button_info;

    MateriViewHolder_Bahasa(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
        button_info = itemView.findViewById(R.id.back);
    }
}
