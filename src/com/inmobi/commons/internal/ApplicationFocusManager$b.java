// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.inmobi.commons.internal:
//            ApplicationFocusManager

class a extends Handler
{

    private boolean a;

    public void handleMessage(Message message)
    {
        if (message.what == 1001 && a)
        {
            a = false;
            ApplicationFocusManager.a(Boolean.valueOf(a));
        } else
        if (message.what == 1002 && !a)
        {
            a = true;
            ApplicationFocusManager.a(Boolean.valueOf(a));
            return;
        }
    }

    public (Looper looper)
    {
        super(looper);
        a = true;
    }
}
