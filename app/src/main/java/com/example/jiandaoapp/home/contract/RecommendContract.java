package com.example.jiandaoapp.home.contract;

import com.example.jiandaoapp.Base.BaseView;
import com.example.jiandaoapp.bean.ColunmBean;
import com.example.jiandaoapp.bean.NewsBean;
import com.example.jiandaoapp.net.INetCallBack;

public class RecommendContract {
    public interface IRecommendView extends BaseView {
        void  setRecommendList(NewsBean string);
        void setColumList(ColunmBean columList);
    }
    public interface IRecommendMode{
        <T> void getRecommendList(String id, INetCallBack<T> iNetCallBack);
        <T> void getColumList(INetCallBack<T> iNetCallBack);
    }


    public interface IRecommendPresenter {

        void getColumList();
        void getRecommendList(String id);

    }
}
