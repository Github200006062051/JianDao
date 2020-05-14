package com.example.jiandaoapp;


import com.example.jiandaoapp.Base.BaseView;
import com.example.jiandaoapp.net.INetCallBack;

public class MainContract {
    public interface IMainView extends BaseView {

    }

    public interface IMainMode{
        <T>  void getRecommendList(INetCallBack<T> netCallBack);
    }

    public interface IMainPresenter{

        void getRecommendList();

//            它两交互时候，需要什么操作
    }
}
