package com.example.jiandaoapp.home.contract;


import com.example.jiandaoapp.Base.BaseView;
import com.example.jiandaoapp.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class HomeContract {
    public interface IHomeView extends BaseView {
        void setBannView(String string);
        //            定义V层操作接口集合    更新页面操作，接口定义好
//            toast    set数据setText，get页面数据getText
//            获取数据
        void setTabList();
    }
    public interface IHomeModel {
        <T>void getHomeBannview(INetCallBack<T> callBack);
        //            一个网络请求，登录    ，   首页，4-N接口    getData
//            网络请求，数据库   sp    文件File
        <T> void getHomeTabList(INetCallBack<T> iNetCallBack);
    }
    public interface IHomePresenter{
        void callHomeBannview(String string);
        void getBannerView();
        //            它两交互时候，需要什么操作
        void getHomeTabList();
    }
}
