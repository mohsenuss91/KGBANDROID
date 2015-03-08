// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.util.Log;
import com.inmobi.monetization.internal.TrackerView;

// Referenced classes of package com.inmobi.monetization:
//            IMNative

class a
    implements Runnable
{

    final IMNative a;

    public void run()
    {
        if (a.a != null)
        {
            a.a.destroy();
            a.a = null;
            return;
        }
        try
        {
            Log.e("[InMobi]-[Monetization]", "Please attach the native ad view before calling detach");
            IMNative.a(a, f);
            return;
        }
        catch (Exception exception)
        {
            IMNative.a(a, f);
        }
        com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Failed to detach a view");
        return;
    }

    ackerView(IMNative imnative)
    {
        a = imnative;
        super();
    }
}
