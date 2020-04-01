package com.easy.app;


import androidx.annotation.Keep;

import com.easy.app.annotation.sp.Clear;
import com.easy.app.annotation.sp.Default;
import com.easy.app.annotation.sp.Expired;
import com.easy.app.annotation.sp.Preferences;
import com.easy.app.annotation.sp.Remove;

@Preferences(name = "defaultSp")
@Keep//keep 避免混淆
public interface AppSharePreferences {

    @Default("true")
    @Expired(value = 5, unit = Expired.UNIT_SECONDS)
    boolean isGoGuide();

    void setGoGuide(boolean go);

    @Clear
    void clear();

    @Remove
    void removeUsername();
}
