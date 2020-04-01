package com.easy.app;

import com.easy.framework.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    public MainPresenter() {
    }

    public String getTest() {
        return "tset";
    }
}
