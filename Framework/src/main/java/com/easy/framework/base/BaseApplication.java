package com.easy.framework.base;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.easy.framework.component.Appcomponent;
import com.easy.framework.component.DaggerAppcomponent;
import com.easy.framework.module.AppModule;

public abstract class BaseApplication extends Application {

    public static BaseApplication application;
    private Appcomponent appcomponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //Dagger初始化--用于注入对象
        appcomponent = DaggerAppcomponent.builder().appModule(new AppModule(this)).build();
        appcomponent.inject(this);
    }

    public static BaseApplication getInst() {
        return application;
    }

    public Appcomponent getAppComponent() {
        return appcomponent;
    }
}
