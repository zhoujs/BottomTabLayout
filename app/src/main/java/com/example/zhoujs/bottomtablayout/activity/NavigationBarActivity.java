package com.example.zhoujs.bottomtablayout.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.zhoujs.bottomtablayout.R;
import com.example.zhoujs.bottomtablayout.widget.NavigationBar;


/**
 * 功能导航栏
 */
public class NavigationBarActivity extends BaseActivity {

    private NavigationBar mNavigationBar;
    private LinearLayout mContentParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.navigation_layout);
        mNavigationBar = (NavigationBar) findViewById(R.id.mToolBar);
        mContentParent = (LinearLayout) findViewById(R.id.content_layout);
        setSupportActionBar(mNavigationBar);
    }

    @Override
    public void setContentView(int layoutResID) {
        mContentParent.removeAllViews();
        View view = getLayoutInflater().inflate(layoutResID, mContentParent, false);
        if (view != null) {
            mContentParent.addView(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        }
    }

    @Override
    public void setContentView(View view) {
        mContentParent.removeAllViews();
        if (view != null) {
            mContentParent.addView(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mContentParent.removeAllViews();
        if (view != null) {
            mContentParent.addView(view, params);
        }
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        if (view != null) {
            mContentParent.addView(view, params);
        }
    }
}
