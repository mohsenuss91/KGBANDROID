// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.monetization:
//            a, IMNative, IMNativeListener

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        try
        {
            if (IMNative.d(a.a) != null)
            {
                IMNative.d(a.a).onNativeRequestSucceeded(a.a);
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
    }

    Log(a a1)
    {
        a = a1;
        super();
    }
}
