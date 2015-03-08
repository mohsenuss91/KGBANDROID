// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appyet.context.ApplicationContext;

public class BootCompletedReceiver extends BroadcastReceiver
{

    public BootCompletedReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        ((ApplicationContext)context.getApplicationContext()).h();
    }
}
