// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;

// Referenced classes of package com.appyet.receiver:
//            a

public class AlarmReceiver extends BroadcastReceiver
{

    private ApplicationContext a;

    public AlarmReceiver()
    {
    }

    static ApplicationContext a(AlarmReceiver alarmreceiver)
    {
        return alarmreceiver.a;
    }

    public void onReceive(Context context, Intent intent)
    {
        a = (ApplicationContext)context.getApplicationContext();
        try
        {
            (new a(this, (byte)0)).a(new Void[0]);
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }
}
