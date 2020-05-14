package com.example.jiandaoapp.fragment.homef.homeadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.jiandaoapp.bean.ColunmBean;

import java.util.List;

public class HomeFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<ColunmBean>colunmBeans;
    public HomeFragmentAdapter(@NonNull FragmentManager fm,List<Fragment> fragments, List<ColunmBean>colunmBeans) {
        super(fm);
        this.fragments = fragments;
        this.colunmBeans=colunmBeans;
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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return colunmBeans.get(position).getData().getList().get(position).getName();
    }
}
