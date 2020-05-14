package com.example.jiandaoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;

import com.example.jiandaoapp.Base.AppManager;
import com.example.jiandaoapp.Base.BaseActivity;
import com.example.jiandaoapp.fragment.homef.HomeFragment;
import com.example.jiandaoapp.fragment.my.MyFragment;
import com.example.jiandaoapp.fragment.my.view.LoginActivity;
import com.example.jiandaoapp.fragment.special.SpecialFragment;
import com.example.jiandaoapp.fragment.video.VideoFragement;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity<MianPresenter> implements MainContract.IMainView {
    private FrameLayout mFragment;
    private LinearLayout mContent;
    private NavigationView mNavigationHeaderContainer;
    private DrawerLayout mDrawer;
    private HomeFragment homeFragment;
    private VideoFragement videoFragement;
    private SpecialFragment specialFragment;
    private MyFragment myFragment;
    private TabLayout tabLayout;
    /**
     * 双击退出    时间分发    onTouchEvent、  disPatchTouch、onInterc。。。
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        菜单、home、返回键 点击了返回键
//        点击屏幕的时候，   按下，抬起， 移动  判断时间为两秒
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
//            获取当前点击返回键的时间   --   两个时间
            long currentTime = System.currentTimeMillis();
            if (currentTime - fristKeyBackTime > 2000) {
//                表示不能退出
                fristKeyBackTime = currentTime;
                Toast.makeText(this, "在点击一次返回键，退出当前应用", Toast.LENGTH_SHORT).show();
            } else {
//                成立   应用关闭掉
                AppManager.getInstance().appExit();
            }
        }
//        get(a);
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected MianPresenter initPresenter() {
        return new MianPresenter();
    }

    @Override
    protected int getLayoutId() {
        Log.e("TAG", "布局加载");
        return R.layout.activity_main;
    }

    @Override
    protected void initLinstenter() {


    }

    @Override
    protected void initData() {
        Toast.makeText(this, "调用P层网络请求", Toast.LENGTH_SHORT).show();
        mPresenter.getRecommendList();
    }

    @Override
    protected void initView() {
        mContent = (LinearLayout) findViewById(R.id.content);
        mNavigationHeaderContainer = (NavigationView) findViewById(R.id.navigation_header_container);
        tabLayout = findViewById(R.id.table);
        homeFragment = new HomeFragment();
        videoFragement = new VideoFragement();
        specialFragment = new SpecialFragment();
        myFragment = new MyFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content,homeFragment).add(R.id.content,videoFragement).add(R.id.content,specialFragment).add(R.id.content,myFragment).commit();
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.getTabAt(0).setCustomView(select("推荐",R.drawable.homeselect));
        tabLayout.getTabAt(1).setCustomView(select("视频",R.drawable.videolayout));
        tabLayout.getTabAt(2).setCustomView(select("专栏",R.drawable.selector));
        tabLayout.getTabAt(3).setCustomView(select("我的",R.drawable.myselect));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0){
                    getSupportFragmentManager().beginTransaction().show(homeFragment).hide(videoFragement).hide(specialFragment).hide(myFragment).commit();
                }
                if (position == 1){
                    getSupportFragmentManager().beginTransaction().show(videoFragement).hide(homeFragment).hide(specialFragment).hide(myFragment).commit();
                }
                if (position == 2){
                    getSupportFragmentManager().beginTransaction().show(specialFragment).hide(videoFragement).hide(homeFragment).hide(myFragment).commit();
                }
                if (position == 3){
                    getSupportFragmentManager().beginTransaction().show(myFragment).hide(videoFragement).hide(specialFragment).hide(homeFragment).commit();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private long fristKeyBackTime = 0;
    int a = 100;
    public View select(String title,int res){
        View root= LayoutInflater.from(this).inflate(R.layout.selectlayout,null);
       TextView textView= root.findViewById(R.id.title);
        ImageView imageView = root.findViewById(R.id.image);
        textView.setText(title);
        imageView.setImageResource(res);
        return root;
    }

/*
    public void  get(int b){
        b = 200;
    }
*/
}
