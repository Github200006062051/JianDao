package com.example.jiandaoapp;

import android.util.Log;


import com.example.jiandaoapp.Base.BaseModel;
import com.example.jiandaoapp.net.INetCallBack;
import com.example.jiandaoapp.net.NetWorkFactory;
import com.example.jiandaoapp.net.ParamsUtils;
import com.example.jiandaoapp.net.api.URLConstants;

import java.util.HashMap;

public class MianModel extends BaseModel implements MainContract.IMainMode{
    public MianModel(){

    }
    @Override
    public <T> void getRecommendList(INetCallBack<T> netCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("start","0");
        commonParams.put("number","0");
        commonParams.put("point_time","0");
        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.VEDIO_LIST,commonParams ,netCallBack);
    }
}
