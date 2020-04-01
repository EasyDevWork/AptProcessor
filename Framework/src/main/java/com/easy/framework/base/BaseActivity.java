package com.easy.framework.base;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.easy.apt.lib.InjectActivity;

import javax.inject.Inject;

public abstract class BaseActivity<P extends BasePresenter, V extends ViewDataBinding> extends AppCompatActivity implements BaseView {

    public V viewBind;
    @Inject
    public P presenter;
    public Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        viewBind = DataBindingUtil.setContentView(this, getLayoutId());
        InjectActivity.inject(this);
        if (presenter != null) {
            presenter.attachView(this, context);
        }
        initView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    public abstract int getLayoutId();

    public abstract void initView();
}
