package com.example.jiandaoapp.fragment.my.presenter;


import com.example.jiandaoapp.Base.BasePresenter;
import com.example.jiandaoapp.fragment.my.bean.VerfiedBean;
import com.example.jiandaoapp.fragment.my.contract.AffirmPassWordContract;
import com.example.jiandaoapp.fragment.my.model.AffirmPaswMode;
import com.example.jiandaoapp.net.INetCallBack;

public class AffirmPaswPresenter extends BasePresenter<AffirmPassWordContract.IAffirmPaswView> implements AffirmPassWordContract.IAffirmPaswPresenter {

    private AffirmPassWordContract.IAffirmPaswMode iAffirmPaswMode;

    public AffirmPaswPresenter() {

        iAffirmPaswMode = new AffirmPaswMode();

    }

    @Override
    public void forgetPasw(String phoneNum, String sms, String password) {

        iAffirmPaswMode.forgetPasw(phoneNum, sms, password, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean bean) {

                mView.registerResult(bean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }
}
