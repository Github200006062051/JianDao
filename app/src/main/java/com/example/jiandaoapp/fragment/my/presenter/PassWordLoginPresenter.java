package com.example.jiandaoapp.fragment.my.presenter;


import com.example.jiandaoapp.Base.BasePresenter;
import com.example.jiandaoapp.fragment.my.bean.AffirmRegisterBean;
import com.example.jiandaoapp.fragment.my.contract.PassWordLoginContract;
import com.example.jiandaoapp.fragment.my.model.PassWordLoginModel;
import com.example.jiandaoapp.net.INetCallBack;

public class PassWordLoginPresenter extends BasePresenter<PassWordLoginContract.IPassWordLoginView> implements PassWordLoginContract.IPassWordLoginPresenter {

    private PassWordLoginContract.IPassWordLoginMode iPassWordLoginMode;

    public PassWordLoginPresenter() {
        iPassWordLoginMode = new PassWordLoginModel();
    }

    @Override
    public void passWordLogin(String username, String password) {

        iPassWordLoginMode.passWordLogin(username, password, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean affirmRegisterBean) {

                mView.getPWLoginResult(affirmRegisterBean);

            }
            @Override
            public void onError(Throwable throwable) {

//                这里去通知V层刷新失败得结果


            }
        });

    }
}
