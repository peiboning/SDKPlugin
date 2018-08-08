package com.org.pbn.sdk.sender;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.org.pbn.sdk.common.fuc.ISender;
import com.org.pbn.sdk.plugin.common.PluginLoader;

public class Sender {
    ISender sender ;
    public Sender(){
        sender = PluginLoader.getInstance().getAdFactory().createSender(null, "");
    }

    public void send(Context context, String msg){
        sender.sendMsg(context, msg);
    }

    public void showView(ViewGroup viewGroup){
        viewGroup.addView(sender.getView(viewGroup.getContext()));
    }

}
