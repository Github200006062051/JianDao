package com.example.jiandaoapp.Base;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import java.util.Stack;

public class AppManager {
    //    初始化  Actiivyt和Fragment 管理栈
    private static Stack<Activity> activities = new Stack<>();
    private static Stack<Fragment> fragments = new Stack<>();
    private static volatile AppManager appManager;
    private AppManager(){

    }
    public static AppManager getInstance(){
        if (appManager == null){
            synchronized (AppManager.class){
                if (appManager == null){
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }
    /**
     * 获取所有Acitvity
     * @return
     */
    public static Stack<Activity> getActivityStack(){
        return activities;
    }

    /**
     * 获取所有Fragment
     * @return
     */
    public static Stack<Fragment> getFragmentStack(){
        return fragments;
    }
    //添加Activity
    public void addActivity(Activity activity){
        if (activities == null){
            activities = new Stack<Activity>();
        }
        activities.add(activity);
    }
    //移除activity
    public void removeActivity(Activity activity){
        if (activities != null){
            activity.finish();
            activities.remove(activity);
        }
    }
    /**
     *删除当前Activity
     */
    public void deleteActivity(){
        Activity activity = activities.lastElement();
        if(activity!= null){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
    /**
     * 当应用退出以后，需要结束掉所有Acitviy
     */
    public void appExit(){
        for (int i = 0; i < activities.size(); i++) {
            if (null != activities.get(i)){
                activities.get(i).finish();
            }
        }
        activities.clear();
        System.exit(0);
//        双击退出
//        1、点击返回键
//                2、判断返回键 时间间隔
//                3、满足appExit
    }
}
