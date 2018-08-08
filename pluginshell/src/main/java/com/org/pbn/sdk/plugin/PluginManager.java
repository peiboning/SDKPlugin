package com.org.pbn.sdk.plugin;

import android.content.res.AssetManager;
import android.os.Environment;

import com.org.pbn.sdk.SDKManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class PluginManager {

    public static void loadPlugin(){
        AssetManager assetManager = SDKManager.getContext().getAssets();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open("test_plugin.dex");
            out = new FileOutputStream(getTargetPath());
            int len = -1;
            byte[] buff = new byte[1024];
            while ((len = in.read(buff)) != -1){
                out.write(buff, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(null != out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getTargetPath(){
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "patch_dex.jar";
    }
}
