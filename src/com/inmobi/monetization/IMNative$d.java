// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.TrackerView;
import java.util.HashMap;

// Referenced classes of package com.inmobi.monetization:
//            IMNative

class a
    implements Runnable
{

    final HashMap a;
    final IMNative b;

    public void run()
    {
        try
        {
            b.a.click(a);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Monetization]", "Failed to track click");
        }
    }

    ackerView(IMNative imnative, HashMap hashmap)
    {
        b = imnative;
        a = hashmap;
        super();
    }
}
