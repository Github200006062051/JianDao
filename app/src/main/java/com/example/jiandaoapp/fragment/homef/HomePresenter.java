package com.example.jiandaoapp.fragment.homef;

import com.example.jiandaoapp.Base.BasePresenter;
import com.example.jiandaoapp.bean.ColunmBean;
import com.example.jiandaoapp.bean.NewsBean;
import com.example.jiandaoapp.home.contract.HomeContract;
import com.example.jiandaoapp.home.contract.RecommendContract;
import com.example.jiandaoapp.net.INetCallBack;

public class HomePresenter extends BasePresenter<RecommendContract.IRecommendView> implements RecommendContract.IRecommendPresenter {
    RecommendContract.IRecommendMode iRecommendMode;

    public HomePresenter() {
        iRecommendMode = new HomeModel();
    }

    @Override
    public void getColumList() {
        iRecommendMode.getColumList(new INetCallBack<ColunmBean>() {
            @Override
            public void onSuccess(ColunmBean colunmBean) {
                mView.setColumList(colunmBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getRecommendList(String id) {
        iRecommendMode.getRecommendList(id, new INetCallBack<NewsBean>() {
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
