package com.example.jiandaoapp.fragment.my.model;

import android.util.Log;


import com.example.jiandaoapp.fragment.my.contract.AffirmPassWordContract;
import com.example.jiandaoapp.net.INetCallBack;
import com.example.jiandaoapp.net.NetWorkFactory;
import com.example.jiandaoapp.net.ParamsUtils;
import com.example.jiandaoapp.net.api.URLConstants;

import java.util.HashMap;

public class AffirmPaswMode implements AffirmPassWordContract.IAffirmPaswMode {
    @Override
    public <T> void forgetPasw(String mobile, String sms_code, String password, INetCallBack<T> iNetCallBack) {


        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",mobile);
        commonParams.put("password",password);
        commonParams.put("sms_code",sms_code);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.FORGET_PW,commonParams,iNetCallBack);




    }
}
