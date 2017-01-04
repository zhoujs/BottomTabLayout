package com.example.zhoujs.bottomtablayout.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import com.example.zhoujs.bottomtablayout.R;

/**
 * 自定义toolbar
 */
public class NavigationBar extends Toolbar {

    private TextView titleTextView;

    public NavigationBar(Context context) {
        super(context);
        init(context);
    }

    public NavigationBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NavigationBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        titleTextView = new TextView(context);
        titleTextView.setTextSize(getResources().getDimension(R.dimen.w_24px));
        titleTextView.setSingleLine();
        titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        titleTextView.setTextColor(Color.WHITE);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        titleTextView.setLayoutParams(layoutParams);
        addView(titleTextView);
    }

    @Override
    public void setTitle(int resId) {
        titleTextView.setText(getResources().getString(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        titleTextView.setText(title);
    }

    @Override
    public void setTitleTextColor(int color) {
        titleTextView.setTextColor(color);
    }

    public void setTitleTextSize(float size) {
        titleTextView.setTextSize(size);
    }
}
