package com.example.jiandaoapp.fragment.homef;

import com.example.jiandaoapp.Base.BasePresenter;
import com.example.jiandaoapp.bean.ColunmBean;
import com.example.jiandaoapp.bean.NewsBean;
import com.example.jiandaoapp.home.contract.NewsFragmentContract;
import com.example.jiandaoapp.home.contract.RecommendContract;
import com.example.jiandaoapp.net.INetCallBack;

public class NewsPresenter extends BasePresenter<NewsFragmentContract.INewsView> implements RecommendContract.IRecommendPresenter {
     NewsFragmentContract.INewsMode iNewsMode;

    public NewsPresenter(){
        iNewsMode = new NewsModel();
    }
    @Override
    public void getColumList() {

    }

    @Override
    public void getRecommendList(String id) {
        iNewsMode.getRecommendList(id, new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                mView.setRecommendList(newsBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
