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
public class MyAdapterIps extends RecyclerView.Adapter<IpsViewHolder> {

    private Context mContext;
    private List<ipsData> mIpsList;

    MyAdapterIps(Context mContext, List<ipsData> mIpsList) {
        this.mContext = mContext;
        this.mIpsList = mIpsList;
    }

    @Override
    public IpsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item_ips, parent, false);
        return new IpsViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final IpsViewHolder holder, int position) {
        holder.mImage.setImageResource(mIpsList.get(position).getipsImage());
        holder.mTitle.setText(mIpsList.get(position).getipsName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivityIpa.class);
                mIntent.putExtra("Title", mIpsList.get(holder.getAdapterPosition()).getipsName());
                mIntent.putExtra("Description", mIpsList.get(holder.getAdapterPosition()).getipsDescription());
                mIntent.putExtra("Image", mIpsList.get(holder.getAdapterPosition()).getipsImage());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mIpsList.size();
    }
}

class IpsViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    ImageView mImage;
    TextView mTitle;
    CardView mCardView;
    Button button_info;

    IpsViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
        button_info = itemView.findViewById(R.id.back);
    }
}
