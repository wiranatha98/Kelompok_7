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
public class MyAdapterIpa extends RecyclerView.Adapter<IpaViewHolder> {

    private Context mContext;
    private List<ipaData> mIpaList;

    MyAdapterIpa(Context mContext, List<ipaData> mIpaList) {
        this.mContext = mContext;
        this.mIpaList = mIpaList;
    }

    @Override
    public IpaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item_ipa, parent, false);
        return new IpaViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final IpaViewHolder holder, int position) {
        holder.mImage.setImageResource(mIpaList.get(position).getipaImage());
        holder.mTitle.setText(mIpaList.get(position).getipaName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivityIpa.class);
                mIntent.putExtra("Title", mIpaList.get(holder.getAdapterPosition()).getipaName());
                mIntent.putExtra("Description", mIpaList.get(holder.getAdapterPosition()).getipaDescription());
                mIntent.putExtra("Image", mIpaList.get(holder.getAdapterPosition()).getipaImage());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mIpaList.size();
    }
}

class IpaViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    ImageView mImage;
    TextView mTitle;
    CardView mCardView;
    Button button_info;

    IpaViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
        button_info = itemView.findViewById(R.id.back);
    }
}
