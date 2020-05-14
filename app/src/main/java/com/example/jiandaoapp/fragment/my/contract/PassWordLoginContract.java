package com.example.jiandaoapp.fragment.my.contract;


import com.example.jiandaoapp.Base.BaseView;
import com.example.jiandaoapp.fragment.my.bean.AffirmRegisterBean;
import com.example.jiandaoapp.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class PassWordLoginContract {

        public interface IPassWordLoginView extends BaseView {
            void  getPWLoginResult(AffirmRegisterBean string);
        }
        public interface IPassWordLoginMode{
            <T> void passWordLogin(String username, String password, INetCallBack<T> iNetCallBack);
        }
        public interface IPassWordLoginPresenter{
            void passWordLogin(String username, String password);
        }
}
