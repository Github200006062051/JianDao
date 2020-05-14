package com.example.jiandaoapp.fragment.my.model;

import android.util.Log;


import com.example.jiandaoapp.fragment.my.contract.PassWordLoginContract;
import com.example.jiandaoapp.net.INetCallBack;
import com.example.jiandaoapp.net.NetWorkFactory;
import com.example.jiandaoapp.net.ParamsUtils;
import com.example.jiandaoapp.net.api.URLConstants;

import java.util.HashMap;

public class PassWordLoginModel implements PassWordLoginContract.IPassWordLoginMode {
    @Override
    public <T> void passWordLogin(String userName, String password, INetCallBack<T> iNetCallBack) {



        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("username",userName);
        commonParams.put("password",password);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.PHONEPAWORD_LOGIN,commonParams,iNetCallBack);



    }
}
