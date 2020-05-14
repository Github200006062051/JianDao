package com.example.jiandaoapp.fragment.my.contract;

import com.example.jiandaoapp.Base.BaseView;
import com.example.jiandaoapp.fragment.my.bean.AffirmRegisterBean;
import com.example.jiandaoapp.net.INetCallBack;

public class AffirmContract {
    public interface IAffirmView extends BaseView {

        //            逻辑判断在P层判断--为了简单一点，扔道Acitivty
        void registerResult(AffirmRegisterBean registerBean);
    }
    public interface IAffirmMode{
        <T> void register(String phoneNum,String password,String affirm_password, INetCallBack<T> iNetCallBack);
    }
    public interface IAffirmPresenter{
        void register(String phoneNum,String password,String affirm_password);

    }
}
