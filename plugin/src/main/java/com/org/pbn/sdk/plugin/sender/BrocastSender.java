package com.org.pbn.sdk.plugin.sender;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.org.pbn.sdk.common.fuc.ISender;
import com.org.pbn.sdk.plugin.utils.InstanceTest;
import com.org.pbn.sdk.plugin.utils.Utils;

public class BrocastSender implements ISender {
    @Override
    public void sendMsg(Context context, String msg) {
        Intent intent = new Intent();
        intent.setAction("com.pbn.test.sender");
        intent.putExtra("ttt", msg);
        Utils.Test();
        InstanceTest t = new InstanceTest();
        t.test();
        context.sendBroadcast(intent);
    }

    @Override
    public View getView(Context context) {
        TextView textView = new TextView(context);
        textView.setText("我是插件里面view");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sender", "onClick plugin textview");
            }
        });
        textView.setLayoutParams(lp);
        return textView;
    }
}
