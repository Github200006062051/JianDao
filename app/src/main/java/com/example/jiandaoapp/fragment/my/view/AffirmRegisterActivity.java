package com.example.jiandaoapp.fragment.my.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

;import com.example.jiandaoapp.Base.BaseActivity;
import com.example.jiandaoapp.R;
import com.example.jiandaoapp.fragment.homef.HomeFragment;
import com.example.jiandaoapp.fragment.my.bean.AffirmRegisterBean;
import com.example.jiandaoapp.fragment.my.contract.AffirmContract;
import com.example.jiandaoapp.fragment.my.presenter.AffirmRegisterPresenter;
import com.tencent.mmkv.MMKV;

/**
 * 确认注册
 */
public class AffirmRegisterActivity extends BaseActivity<AffirmRegisterPresenter> implements AffirmContract.IAffirmView {

    private EditText affreg_passward;
    private EditText affreg_affirmpassword;
    private Button arrirm_regbug;
    private String phoneNum;

    @Override
    protected AffirmRegisterPresenter initPresenter() {
        return new AffirmRegisterPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_affirm_register;
    }

    @Override
    protected void initLinstenter() {

    }

    @Override
    public void initView() {

          affreg_passward = findViewById(R.id.affreg_passward);
          affreg_affirmpassword = findViewById(R.id.affreg_affirmpassword);
          arrirm_regbug  = findViewById(R.id.arrirm_regbug);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        phoneNum = intent.getStringExtra("phoneNum");

    }

    @Override
    public void registerResult(AffirmRegisterBean registerBean) {
        Log.e("TAG","注册成功返回值="+registerBean.toString());


        if(registerBean.getCode().equals("1")){

            Toast.makeText(this, "注册成功返回数据，且code等于1", Toast.LENGTH_SHORT).show();

            if(null !=registerBean.getData().getToken().getValue() &&registerBean.getData().getToken().getValue()!="" ){

//                SP

                MMKV mmkv = MMKV.defaultMMKV();

//                用户信息 直接展示， 在本地存储了

                mmkv.encode("token",registerBean.getData().getToken().getValue());
                mmkv.encode("expire_time",registerBean.getData().getToken().getExpire_time());
                mmkv.encode("head_url",registerBean.getData().getUser_info().getHead_url());
                mmkv.encode("nickname",registerBean.getData().getUser_info().getNickname());
                mmkv.encode("mobile",registerBean.getData().getUser_info().getMobile());






                Intent it = new Intent(AffirmRegisterActivity.this, HomeFragment.class);
                startActivity(it);
            }

        }else {
            Toast.makeText(this, registerBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
