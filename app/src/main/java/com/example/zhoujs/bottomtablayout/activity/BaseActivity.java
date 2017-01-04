package com.example.zhoujs.bottomtablayout.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.zhoujs.bottomtablayout.R;
import com.github.chenglei1986.statusbar.StatusBarColorManager;


public class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBarColor();
    }

    protected void setStatusBarColor() {
        StatusBarColorManager statusBarColorManager = new StatusBarColorManager(this);
        statusBarColorManager.setStatusBarColor(ContextCompat.getColor(this, R.color.white), false, false);
    }
}
