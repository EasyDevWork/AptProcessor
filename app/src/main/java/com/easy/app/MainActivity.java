package com.easy.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.easy.apt.lib.SharePreference;

@Route(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goHome(View view) {
        ARouter.getInstance().build("/app/HomeActivity").navigation();
    }

    public void testSp(View view) {
        AppSharePreferences appSp = SharePreference.get(MainActivity.this, AppSharePreferences.class);
        appSp.setGoGuide(false);
        Toast.makeText(MainActivity.this, appSp.isGoGuide() + "", Toast.LENGTH_SHORT).show();
    }
}
