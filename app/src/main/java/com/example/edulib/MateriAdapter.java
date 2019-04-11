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
 * Created by abdalla on 1/12/18.
 */
public class MateriAdapter extends RecyclerView.Adapter<MateriViewHolder_Ips> {

    private Context mContext;
    private List<MateriData> mMateriList;

    MateriAdapter(Context mContext, List<MateriData> mMateriList) {
        this.mContext = mContext;
        this.mMateriList = mMateriList;
    }

    @Override
    public MateriViewHolder_Ips onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_materi, parent, false);
        return new MateriViewHolder_Ips(mView);
    }

    @Override
    public void onBindViewHolder(final MateriViewHolder_Ips holder, int position) {
        holder.mImage.setImageResource(mMateriList.get(position).getUnivImage());
        holder.mTitle.setText(mMateriList.get(position).getUnivName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailMateri.class);
                mIntent.putExtra("Title", mMateriList.get(holder.getAdapterPosition()).getUnivName());
                mIntent.putExtra("Description", mMateriList.get(holder.getAdapterPosition()).getUnivDescription());
                mIntent.putExtra("Image", mMateriList.get(holder.getAdapterPosition()).getUnivImage());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMateriList.size();
    }
}

class MateriViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    ImageView mImage;
    TextView mTitle;
    CardView mCardView;
    Button button_info;

    MateriViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
        button_info = itemView.findViewById(R.id.button);
    }
}
