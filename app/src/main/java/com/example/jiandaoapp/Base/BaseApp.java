package com.example.jiandaoapp.Base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.leakcanary.LeakCanary;

public class BaseApp extends Application {
    public static BaseApp baseApp;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
        initLeakCanary();
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
            LeakCanary.install(this);
    }

    ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
            AppManager.getInstance().addActivity(activity);
        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {

        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {

        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {
            AppManager.getInstance().removeActivity(activity);
        }
    };
}
