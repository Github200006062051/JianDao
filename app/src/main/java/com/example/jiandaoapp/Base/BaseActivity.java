package com.example.jiandaoapp.Base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = initPresenter();
        mPresenter.AttachView(this);
        initView();
        initData();
        initLinstenter();


    }

  /*  @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }*/

    protected abstract P initPresenter();

    protected abstract int getLayoutId();

    protected abstract void initLinstenter();

    protected abstract void initData();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.disAttachView();
    }
}
