package com.org.pbn.sdk.plugin.common;

import android.util.Log;

import com.org.pbn.sdk.SDKManager;
import com.org.pbn.sdk.plugin.PluginManager;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Format;

import dalvik.system.DexClassLoader;

public class PluginLoader {
    private static String AD_FACTORY_CLS = "com.org.pbn.sdk.plugin.AdFactoryImpl";
    private DexClassLoader classLoader;
    private static PluginLoader sInstance = null;
    private boolean isInit;

    public static PluginLoader getInstance() {
        if (null == sInstance) {
            synchronized (PluginLoader.class) {
                if (null == sInstance) {
                    sInstance = new PluginLoader();
                }
            }
        }
        return sInstance;
    }

    private PluginLoader() {
    }

    public void init(){
        if(!isInit){
            String path = SDKManager.getContext().getDir("plugin", 0).getAbsolutePath();
            Log.e("PluginLoader", "loader:"+SDKManager.getContext().getClassLoader().getClass().getSimpleName());
            classLoader = new DexClassLoader(PluginManager.getTargetPath(), path, null, SDKManager.getContext().getClassLoader());
            isInit = true;
        }
    }

    public AdFactory getAdFactory(){
        try {
            if(null == classLoader){
                Log.e("PluginLoader", "init plugin error");
                return null;
            }
            Class cls = classLoader.loadClass(AD_FACTORY_CLS);
            Method getInstance = cls.getDeclaredMethod("getInstance");
            AdFactory factory = AdFactory.class.cast(getInstance.invoke(null));
            return factory;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}