package com.example.jiandaoapp.fragment.my.presenter;


import com.example.jiandaoapp.Base.BasePresenter;
import com.example.jiandaoapp.fragment.my.bean.VerfiedBean;
import com.example.jiandaoapp.fragment.my.contract.RegisterMSMContract;
import com.example.jiandaoapp.fragment.my.model.RegisterMSMModel;
import com.example.jiandaoapp.net.INetCallBack;

public class RegisterMSMPresenter extends BasePresenter<RegisterMSMContract.IRegisterMSMView> implements RegisterMSMContract.IRegisterMSMPresenter {

    private RegisterMSMContract.IRegisterMSMMode iRegisterMSMMode;

    public RegisterMSMPresenter() {
        iRegisterMSMMode = new RegisterMSMModel();
    }

    @Override
    public void getVerified(String string, String type) {

        iRegisterMSMMode.getVerified(string, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mView.getVerified(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {

        iRegisterMSMMode.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {

                mView.checkSmsCodeResult(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });



    }
}
