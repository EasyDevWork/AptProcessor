package com.easy.app;

import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.easy.app.databinding.ActivityMainBinding;
import com.easy.apt.annotation.ActivityInject;
import com.easy.apt.annotation.SingleClick;
import com.easy.apt.lib.SharePreference;
import com.easy.framework.base.BaseActivity;

@ActivityInject
@Route(path = "/app/MainActivity")
public class MainActivity extends BaseActivity<MainPresenter, ActivityMainBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        Toast.makeText(MainActivity.this, presenter.getTest(), Toast.LENGTH_SHORT).show();
    }

    public void goHome(View view) {
        ARouter.getInstance().build("/app/HomeActivity").navigation();
    }

    public void testSp(View view) {
        AppSharePreferences appSp = SharePreference.get(MainActivity.this, AppSharePreferences.class);
        appSp.setGoGuide(false);
        Toast.makeText(MainActivity.this, appSp.isGoGuide() + "", Toast.LENGTH_SHORT).show();
    }

    @SingleClick
    public void setAccount(View view) {
        AppSharePreferences appSp = SharePreference.get(MainActivity.this, AppSharePreferences.class);
        Accounts accounts = new Accounts();
        accounts.setAge(222);
        accounts.setName("ddd");
        appSp.setUserInfo(accounts);
    }

    public void getAccount(View view) {
        AppSharePreferences appSp = SharePreference.get(MainActivity.this, AppSharePreferences.class);
        Toast.makeText(MainActivity.this, appSp.getUserInfo().toString(), Toast.LENGTH_SHORT).show();
    }
}
