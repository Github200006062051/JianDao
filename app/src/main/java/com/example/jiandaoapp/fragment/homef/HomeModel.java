package com.example.jiandaoapp.fragment.homef;

import android.util.Log;

import com.example.jiandaoapp.Base.BaseModel;
import com.example.jiandaoapp.home.contract.HomeContract;
import com.example.jiandaoapp.home.contract.RecommendContract;
import com.example.jiandaoapp.net.INetCallBack;
import com.example.jiandaoapp.net.NetWorkFactory;
import com.example.jiandaoapp.net.ParamsUtils;
import com.example.jiandaoapp.net.api.URLConstants;

import java.util.HashMap;

public class HomeModel extends BaseModel implements RecommendContract.IRecommendMode {

    @Override
    public <T> void getRecommendList(String id, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("id",id);
        commonParams.put("start","0");
        commonParams.put("number ","0");
        commonParams.put("point_time","0");
        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.RECOMMEND_LIST,commonParams,iNetCallBack);
    }

    @Override
    public <T> void getColumList(INetCallBack<T> iNetCallBack) {

        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
//        commonParams.put("token","");

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }

        NetWorkFactory.getInstance().getNetWork().get(URLConstants.COLUM_LIST,commonParams,iNetCallBack);
    }
}
