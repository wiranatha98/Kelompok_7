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
public class MyAdapterBahasa extends RecyclerView.Adapter<BahasaViewHolder> {

    private Context mContext;
    private List<bahasaData> mBahasaList;

    MyAdapterBahasa(Context mContext, List<bahasaData> mBahasaList) {
        this.mContext = mContext;
        this.mBahasaList = mBahasaList;
    }

    @Override
    public BahasaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item_bahasa, parent, false);
        return new BahasaViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final BahasaViewHolder holder, int position) {
        holder.mImage.setImageResource(mBahasaList.get(position).getbahasaImage());
        holder.mTitle.setText(mBahasaList.get(position).getbahasaName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivityBahasa.class);
                mIntent.putExtra("Title", mBahasaList.get(holder.getAdapterPosition()).getbahasaName());
                mIntent.putExtra("Description", mBahasaList.get(holder.getAdapterPosition()).getbahasaDescription());
                mIntent.putExtra("Image", mBahasaList.get(holder.getAdapterPosition()).getbahasaImage());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBahasaList.size();
    }
}

class BahasaViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    ImageView mImage;
    TextView mTitle;
    CardView mCardView;
    Button button_info;

    BahasaViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
        button_info = itemView.findViewById(R.id.back);
    }
}
