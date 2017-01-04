package com.example.zhoujs.bottomtablayout.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhoujs.bottomtablayout.R;
import com.example.zhoujs.bottomtablayout.fragment.BaseFragment;
import com.example.zhoujs.bottomtablayout.utils.DoubleClickExitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;

    DoubleClickExitHelper doubleClick = new DoubleClickExitHelper(this);
    List<BaseFragment> mFragments;
    FragmentAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }


    private void initViews() {
        mFragments = initFragments();
        mAdapter = new FragmentAdapter(mFragments, getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(mAdapter.getTabView(i));
            }
        }
    }

    private List<BaseFragment> initFragments() {
        List<BaseFragment> fragments = new ArrayList<BaseFragment>();

        BaseFragment productFragment = new BaseFragment();
        productFragment.setTitle("产品");
        productFragment.setIconId(R.drawable.maintab_product);
        fragments.add(productFragment);

        BaseFragment discoverFragment = new BaseFragment();
        discoverFragment.setTitle("发现");
        discoverFragment.setIconId(R.drawable.maintab_discover);
        fragments.add(discoverFragment);


        BaseFragment notificationFragment = new BaseFragment();
        notificationFragment.setTitle("通知");
        notificationFragment.setIconId(R.drawable.maintab_notification);
        fragments.add(notificationFragment);

        BaseFragment moreFragment = new BaseFragment();
        moreFragment.setTitle("我的");
        moreFragment.setIconId(R.drawable.maintab_more);
        fragments.add(moreFragment);

        return fragments;
    }

    class FragmentAdapter extends FragmentPagerAdapter {

        private List<BaseFragment> mFragments;

        public FragmentAdapter(List<BaseFragment> fragments, FragmentManager fm) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public View getTabView(int position) {
            View tabView = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_tab, null, false);
            TextView tv = (TextView) tabView.findViewById(R.id.custom_tab_text);
            tv.setText(mFragments.get(position).getTitle());
            ImageView img = (ImageView) tabView.findViewById(R.id.custom_tab_icon);
            img.setImageResource(mFragments.get(position).getIconId());
            return tabView;
        }
        
    }


    /**
     * 双击返回键，退出应用
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return doubleClick.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
}
