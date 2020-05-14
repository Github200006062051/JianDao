package com.example.jiandaoapp.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jiandaoapp.R;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView{
    public P mPresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getlayoutId(),container,false);
        initView(root);
        mPresenter=initPresenter();
        if(mPresenter!=null){
            mPresenter.AttachView(this);
        }
        initData();
        initListener();
        return root;
    }

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initView(View root);

    protected abstract int getlayoutId();

}
