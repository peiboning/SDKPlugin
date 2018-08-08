package com.org.pbn.sdk;

import android.content.Context;

import com.org.pbn.sdk.plugin.common.PluginLoader;

public class SDKManager {

    public static Context context;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        SDKManager.context = context;
    }

    public static void init(Context ctx){
        context = ctx;
        PluginLoader.getInstance().init();

    }
}
