package com.example.jiandaoapp.fragment.my.model;


import com.example.jiandaoapp.fragment.my.contract.AffirmContract;
import com.example.jiandaoapp.net.INetCallBack;

public class AffirmRegisterModel implements AffirmContract.IAffirmMode {
    @Override
    public <T> void register(String phoneNum, String password, String affirm_password, INetCallBack<T> iNetCallBack) {

    }
}
