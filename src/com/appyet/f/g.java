// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.appyet.f:
//            f, a

final class g extends Handler
{

    private g()
    {
    }

    g(byte byte0)
    {
        this();
    }

    public final void handleMessage(Message message)
    {
        f f1 = (f)message.obj;
        a a1;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            a.c(f1.a, f1.b[0]);
            return;

        case 2: // '\002'
            a1 = f1.a;
            break;
        }
        Object[] _tmp = f1.b;
        a1.c();
    }
}
