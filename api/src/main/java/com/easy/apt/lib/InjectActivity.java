package com.easy.apt.lib;

import android.util.ArrayMap;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Method;

public class InjectActivity {
    private static final ArrayMap<String, Object> injectMap = new ArrayMap<>();

    public static void inject(AppCompatActivity activity) {
        String className = activity.getClass().getName();
        try {
            Object inject = injectMap.get(className);
            if (inject == null) {
                Class<?> aClass = Class.forName(className + "$$InjectActivity");
                inject = aClass.newInstance();
                injectMap.put(className, inject);
            }
            Method m1 = inject.getClass().getDeclaredMethod("inject", activity.getClass());
            m1.invoke(inject, activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
