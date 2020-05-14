package com.example.jiandaoapp;

import android.util.Log;
import android.widget.Toast;

import com.example.jiandaoapp.Base.BasePresenter;
import com.example.jiandaoapp.net.INetCallBack;


public class MianPresenter extends BasePresenter<MainActivity> implements  MainContract.IMainPresenter {
   public MainContract.IMainMode mode;
    public MianPresenter(){
        mode = new MianModel();
    }
    @Override
    public void getRecommendList() {
        mode.getRecommendList(new INetCallBack<RemBean>() {
            @Override
            public void onSuccess(RemBean remBean) {
                Log.e("TAG","打印网络请求返回实体类:"+remBean.toString());
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
