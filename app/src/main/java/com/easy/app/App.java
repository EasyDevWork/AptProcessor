package com.easy.app;

import com.alibaba.android.arouter.launcher.ARouter;
import com.easy.framework.base.BaseApplication;

public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
