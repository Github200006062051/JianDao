package com.example.jiandaoapp.fragment.homef;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.jiandaoapp.Base.BaseFragment;
import com.example.jiandaoapp.R;
import com.example.jiandaoapp.bean.ColunmBean;
import com.example.jiandaoapp.bean.NewsBean;
import com.example.jiandaoapp.fragment.homef.homeadapter.NewsFragmentAdapter;
import com.example.jiandaoapp.home.contract.RecommendContract;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenter> implements RecommendContract.IRecommendView {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<NewsFragment> fragments = new ArrayList<>();

    private NewsFragmentAdapter newsFragmentAdapter;
    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getColumList();
    }
    private void initTab(final ColunmBean columList){
        newsFragmentAdapter = new NewsFragmentAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(newsFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0; i < columList.getData().getList().size(); i++) {
                    TextView tabAt = (TextView) tabLayout.getTabAt(i).getCustomView();
                    tabAt.setBackgroundResource(R.color.color_WHITE);
                }
                GradientDrawable drawable = new GradientDrawable();
                drawable.setCornerRadius(50);

                TextView customView = (TextView) tab.getCustomView();
                drawable.setStroke(1, Color.parseColor("#ff00ff"));
                drawable.setColor(Color.parseColor("#" + columList.getData().getList().get(tab.getPosition()).getBack_color()));
                customView.setBackground(drawable);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
            @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View root) {
        tabLayout = root.findViewById(R.id.mytablayout);
        viewPager = root.findViewById(R.id.myviewpage);
    }

    @Override
    protected int getlayoutId() {
        return R.layout.recommend_fragment;
    }


    @Override
    public void setRecommendList(NewsBean string) {
        Log.e("TAG", "对应栏目新闻请求i成功：" + string.toString());
    }

    @Override
    public void setColumList(ColunmBean columList) {
        Log.e("TAG", "当前TabLayout的栏目数据：" + columList.toString());
//        栏目请求成功了
        if (columList.getCode() == 1) {
            for (int i = 0; i < columList.getData().getList().size(); i++) {
//                创建咱们得Fragment
                NewsFragment newsFragment = new NewsFragment(columList.getData().getList().get(i).getId());
                fragments.add(newsFragment);
            }

            initTab(columList);

            for (int i = 0; i < columList.getData().getList().size(); i++) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.recommend_tab_item, null);
                textView.setGravity(Gravity.CENTER);
                textView.setText(columList.getData().getList().get(i).getName());
                tabLayout.addTab(tabLayout.newTab().setCustomView(textView), i);
            }
        }
    }
}
