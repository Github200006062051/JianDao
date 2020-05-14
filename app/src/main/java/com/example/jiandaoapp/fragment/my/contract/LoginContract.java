package com.example.jiandaoapp.fragment.my.contract;

import com.example.jiandaoapp.Base.BaseView;
import com.example.jiandaoapp.fragment.my.bean.AffirmRegisterBean;
import com.example.jiandaoapp.fragment.my.bean.VerfiedBean;
import com.example.jiandaoapp.net.INetCallBack;

public class LoginContract {
    public interface ILoginView extends BaseView {

        //            逻辑判断在P层判断--为了简单一点，扔道Acitivty
        void getVerified(VerfiedBean s);

        void  getLoginResult(AffirmRegisterBean string);

        void checkSmsCodeResult(VerfiedBean verfiedBean);

    }
    public interface ILoginMode{
        <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);

        <T> void login(String mobile,String smsCode,INetCallBack<T> iNetCallBack);
        <T> void checkSmsCode(String phoneNum,String smsCode,String type,INetCallBack<T> iNetCallBack);
    }
    public interface ILoginPresenter{
        void getVerified(String string,String type);
        void login(String mobile,String smsCode);
        void checkSmsCode(String phoneNum,String smsCode,String type);
    }
}
