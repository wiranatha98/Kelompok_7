package com.example.edulib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

public class ChatAdapter extends BaseAdapter {
    private List<Chat>daftarChat;
    private Context mContext;
    LayoutInflater inflater;

    @Override
    public int getCount() {
        return daftarChat.size();
    }

    public ChatAdapter(List<Chat> daftarChat, Context mContext) {
        this.daftarChat = daftarChat;//tes
        this.mContext = mContext;
        inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int position) {
        return daftarChat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null){
            if (daftarChat.get(position).isMe()){
                view = inflater.inflate(R.layout.chat_box_me,null);
            }else{
                view = inflater.inflate(R.layout.chat_box,null);
            }
        }
        BubbleTextView msg = view.findViewById(R.id.txPesan);
        msg.setText(daftarChat.get(position).getPesan());
        TextView who = view.findViewById(R.id.txPersonName);
        who.setText(daftarChat.get(position).getName());

        return view;
    }
}
