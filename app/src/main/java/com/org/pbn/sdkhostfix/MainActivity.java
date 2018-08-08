package com.org.pbn.sdkhostfix;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.org.pbn.sdk.sender.Sender;

public class MainActivity extends Activity {
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if("com.pbn.test.sender".equals(intent.getAction())){
                Toast.makeText(context, "hhahhhh", 1).show();
            }
        }
    };

    private FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.pbn.test.sender");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    public void send(View view) {
        Sender sender = new Sender();
        sender.send(this, "hello plugin");

        sender.showView(container);
    }
}
