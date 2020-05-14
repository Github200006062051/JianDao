package com.example.jiandaoapp.fragment.my.presenter;

import android.util.Log;


import com.example.jiandaoapp.Base.BasePresenter;
import com.example.jiandaoapp.fragment.my.bean.VerfiedBean;
import com.example.jiandaoapp.fragment.my.contract.LoginContract;
import com.example.jiandaoapp.fragment.my.model.LoginModel;
import com.example.jiandaoapp.net.INetCallBack;

import java.io.IOException;

import okhttp3.ResponseBody;

public class LoginPresenter extends BasePresenter<LoginContract.ILoginView> implements LoginContract.ILoginPresenter {

    LoginContract.ILoginMode iLoginMode;

    public LoginPresenter() {
        iLoginMode = new LoginModel();
    }

    @Override
    public void getVerified(String phoneNum,String type) {


        iLoginMode.getVerified(phoneNum, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean s) {


                mView.getVerified(s);

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }

    @Override
    public void login(String mobile, String smsCode) {
        iLoginMode.login(mobile, smsCode, new INetCallBack<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody responseBody) {

                try {//4
                    Log.e("TAG","登录成功返回值："+responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }


    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {

        Log.e("TAG",phoneNum+"验证p层码值："+smsCode);

        iLoginMode.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
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
