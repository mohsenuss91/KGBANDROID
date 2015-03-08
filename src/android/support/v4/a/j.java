// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package android.support.v4.a:
//            i

final class j extends Handler
{

    final i a;

    j(i k, Looper looper)
    {
        a = k;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 1: // '\001'
            i.a(a);
            break;
        }
    }
}
