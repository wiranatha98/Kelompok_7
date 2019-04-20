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
public class MateriAdapter_Ips extends RecyclerView.Adapter<MateriViewHolder> {

    private Context mContext;
    private List<MateriData_Ips> mMateriList_Ips;

    MateriAdapter_Ips(Context mContext, List<MateriData_Ips> mMateriList_Ips) {
        this.mContext = mContext;
        this.mMateriList_Ips = mMateriList_Ips;
    }

    @Override
    public MateriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_materi_ips, parent, false);
        return new MateriViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final MateriViewHolder holder, int position) {
        holder.mImage.setImageResource(mMateriList_Ips.get(position).getUnivImage());
        holder.mTitle.setText(mMateriList_Ips.get(position).getUnivName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailMateri.class);
                mIntent.putExtra("Title", mMateriList_Ips.get(holder.getAdapterPosition()).getUnivName());
                mIntent.putExtra("Description", mMateriList_Ips.get(holder.getAdapterPosition()).getUnivDescription());
                mIntent.putExtra("Image", mMateriList_Ips.get(holder.getAdapterPosition()).getUnivImage());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMateriList_Ips.size();
    }
}

class MateriViewHolder_Ips extends RecyclerView.ViewHolder {
    private Context mContext;
    ImageView mImage;
    TextView mTitle;
    CardView mCardView;
    Button button_info;

    MateriViewHolder_Ips(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
        button_info = itemView.findViewById(R.id.button);
    }
}
