package com.example.jiandaoapp.fragment.homef.homeadapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.jiandaoapp.bean.ColunmBean;
import com.example.jiandaoapp.fragment.homef.NewsFragment;

import java.util.List;

public class NewsFragmentAdapter extends FragmentPagerAdapter {
    List<NewsFragment> fragments;
    public NewsFragmentAdapter(@NonNull FragmentManager fm,List<NewsFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
