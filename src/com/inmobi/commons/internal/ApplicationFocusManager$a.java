// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.commons.internal:
//            ApplicationFocusManager, Log

final class 
    implements InvocationHandler
{

    private final Handler a = new <init>(ApplicationFocusManager.a().getLooper());

    public final void a(Activity activity)
    {
        a.sendEmptyMessageDelayed(1001, 3000L);
    }

    public final void b(Activity activity)
    {
        a.removeMessages(1001);
        a.sendEmptyMessage(1002);
    }

    public final Object invoke(Object obj, Method method, Object aobj[])
    {
        if (aobj == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (method.getName().equals("onActivityPaused"))
        {
            a((Activity)aobj[0]);
            break MISSING_BLOCK_LABEL_65;
        }
        try
        {
            if (method.getName().equals("onActivityResumed"))
            {
                b((Activity)aobj[0]);
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Unable to invoke method", exception);
        }
        return null;
    }

    ()
    {
    }
}
