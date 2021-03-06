package com.example.jiandaoapp.fragment.my.contract;


import com.example.jiandaoapp.Base.BaseView;
import com.example.jiandaoapp.fragment.my.bean.VerfiedBean;
import com.example.jiandaoapp.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class ForgetPWContract {

        public interface IForgetPWView extends BaseView {

//            逻辑判断在P层判断--为了简单一点，扔道Acitivty
            void getVerified(VerfiedBean s);

            void checkSmsCodeResult(VerfiedBean verfiedBean);

        }
        public interface IForgetPWMode{
           <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);

            <T> void checkSmsCode(String phoneNum, String smsCode, String type, INetCallBack<T> iNetCallBack);
        }
        public interface IForgetPWPresenter{
            void getVerified(String string, String type);
            void checkSmsCode(String phoneNum, String smsCode, String type);
        }
}
