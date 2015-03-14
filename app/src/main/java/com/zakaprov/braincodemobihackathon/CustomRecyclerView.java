package com.zakaprov.braincodemobihackathon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by kulak on 14/03/15.
 */
public class CustomRecyclerView extends RecyclerView {
    public CustomRecyclerView(Context context) {
        super(context);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public int getVerticalOffset() {
        return super.computeVerticalScrollOffset();
    }
}
