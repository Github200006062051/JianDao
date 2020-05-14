package com.example.jiandaoapp.fragment.my.presenter;


import com.example.jiandaoapp.Base.BasePresenter;
import com.example.jiandaoapp.fragment.my.contract.AffirmContract;
import com.example.jiandaoapp.fragment.my.model.AffirmRegisterModel;

public class AffirmRegisterPresenter extends BasePresenter<AffirmContract.IAffirmView> implements AffirmContract.IAffirmPresenter {

    private AffirmContract.IAffirmMode iAffirmMode;
    public AffirmRegisterPresenter() {

        iAffirmMode = new AffirmRegisterModel();

    }

    @Override
    public void register(String phoneNum, String password, String affirm_password) {

    }
}
