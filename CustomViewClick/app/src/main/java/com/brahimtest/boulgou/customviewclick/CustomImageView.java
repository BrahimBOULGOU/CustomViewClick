package com.brahimtest.boulgou.customviewclick;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Brahim BOULGOU on 3/3/18.
 */

public class CustomImageView extends AppCompatImageView {
    private Context mContext;
    private boolean selected;

    public CustomImageView(Context context) {
        super(context);
        this.mContext = context;
        manageWithTouchListener();
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        manageWithTouchListener();
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        manageWithTouchListener();
    }
    private void manageWithTouchListener() {
        this.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN) {
                    changeColorImage(true);
                } else if (action == MotionEvent.ACTION_UP) {
                    changeColorImage(false);
                }
                return false;
            }
        });
    }
    private void changeColorImage(boolean state) {
        Drawable d = this.getDrawable();
        if (d != null) {
            if (state) {
                d.setColorFilter(mContext.getResources().getColor(R.color.cmjnorange), PorterDuff.Mode.SRC_ATOP);
            } else {
                d.setColorFilter(null);
            }
        }
    }
    public void setSelected(boolean state) {
        this.selected = state;
        this.setOnTouchListener(null);
        changeColorImage(state);
    }

    public boolean getSelected(){
        return selected;
    }
}
