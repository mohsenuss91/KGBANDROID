// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.util.Log;
import android.view.ViewGroup;
import com.inmobi.monetization.internal.TrackerView;

// Referenced classes of package com.inmobi.monetization:
//            IMNative

class a
    implements Runnable
{

    final ViewGroup a;
    final IMNative b;

    public void run()
    {
        try
        {
            b.a = new TrackerView(a.getContext(), IMNative.a(b), IMNative.b(b));
            a.addView(b.a);
            return;
        }
        catch (Exception exception)
        {
            Log.e("[InMobi]-[Monetization]", "Failed to attach the view");
        }
        IMNative.a(b, f);
    }

    ackerView(IMNative imnative, ViewGroup viewgroup)
    {
        b = imnative;
        a = viewgroup;
        super();
    }
}
