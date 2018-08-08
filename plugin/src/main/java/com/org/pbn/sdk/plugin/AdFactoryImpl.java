package com.org.pbn.sdk.plugin;

import android.content.Context;

import com.org.pbn.sdk.SDKManager;
import com.org.pbn.sdk.common.fuc.ISender;
import com.org.pbn.sdk.plugin.common.AdFactory;
import com.org.pbn.sdk.plugin.sender.BrocastSender;

public class AdFactoryImpl implements AdFactory{
    private static AdFactoryImpl sInstance = null;

    public static AdFactoryImpl getInstance() {
        if (null == sInstance) {
            synchronized (AdFactoryImpl.class) {
                if (null == sInstance) {
                    sInstance = new AdFactoryImpl();
                }
            }
        }
        return sInstance;
    }

    private AdFactoryImpl() {
        SDKManager.getContext();
    }

    @Override
    public ISender createSender(Context context, String msg) {
        return new BrocastSender();
    }
}