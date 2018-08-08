package com.org.pbn.sdk.common.fuc;

import android.content.Context;
import android.view.View;

public interface ISender {
    void sendMsg(Context context, String msg);
    View getView(Context context);
}