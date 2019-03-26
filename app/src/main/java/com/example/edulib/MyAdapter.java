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
public class MyAdapter extends RecyclerView.Adapter<UnivViewHolder> {

    private Context mContext;
    private List<UnivData> mUnivList;

    MyAdapter(Context mContext, List<UnivData> mUnivList) {
        this.mContext = mContext;
        this.mUnivList = mUnivList;
    }

    @Override
    public UnivViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item, parent, false);
        return new UnivViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final UnivViewHolder holder, int position) {
        holder.mImage.setImageResource(mUnivList.get(position).getUnivImage());
        holder.mTitle.setText(mUnivList.get(position).getUnivName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("Title", mUnivList.get(holder.getAdapterPosition()).getUnivName());
                mIntent.putExtra("Image", mUnivList.get(holder.getAdapterPosition()).getUnivImage());
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUnivList.size();
    }
}

class UnivViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    ImageView mImage;
    TextView mTitle;
    CardView mCardView;
    Button button_info;

    UnivViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
        button_info = itemView.findViewById(R.id.button);
    }
}
