package com.example.jiandaoapp.home.contract;

import com.example.jiandaoapp.Base.BaseView;
import com.example.jiandaoapp.bean.NewsBean;
import com.example.jiandaoapp.net.INetCallBack;

public class NewsFragmentContract {
    public interface INewsView extends BaseView {
        void  setRecommendList(NewsBean newsBean);
    }
    public interface INewsMode{
        <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack);
    }
    public interface INewsPresenter{
        void getRecommend(String string);
    }
}
