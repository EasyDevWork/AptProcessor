package com.easy.app;

import com.alibaba.android.arouter.launcher.ARouter;
import com.easy.apt.lib.JsonConverterFactory;
import com.easy.apt.lib.SharePreference;
import com.easy.framework.base.BaseApplication;

public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.init(this);

        SharePreference.setConverterFactory(new JsonConverterFactory());
    }
}
