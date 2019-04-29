package com.example.edulib;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

public class NoHorizontalScrollLLM extends LinearLayoutManager {


    public NoHorizontalScrollLLM(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public boolean canScrollHorizontally() {
        return false;
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}
