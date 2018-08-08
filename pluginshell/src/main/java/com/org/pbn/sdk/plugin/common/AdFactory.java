package com.org.pbn.sdk.plugin.common;

import android.content.Context;

import com.org.pbn.sdk.common.fuc.ISender;

public interface AdFactory {
    ISender createSender(Context context, String msg);
}