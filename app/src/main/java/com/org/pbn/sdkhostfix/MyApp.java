package com.org.pbn.sdkhostfix;

import android.app.Application;
import android.content.Context;

import com.org.pbn.sdk.SDKManager;

public class MyApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        SDKManager.init(this);
    }
}
