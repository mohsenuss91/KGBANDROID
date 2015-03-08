// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.os.Handler;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.abstraction.INativeAdListener;

// Referenced classes of package com.inmobi.monetization:
//            IMNative, IMErrorCode

class a
    implements INativeAdListener
{

    final IMNative a;

    a(IMNative imnative)
    {
        a = imnative;
        super();
    }

    public void onNativeRequestFailed(IMErrorCode imerrorcode)
    {
        try
        {
            IMNative.a(a, IMNative.a.f);
            IMNative.e(a).post(new a(imerrorcode));
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
        }
    }

    public void onNativeRequestSucceeded(IMNative imnative)
    {
        try
        {
            IMNative.a(a, IMNative.a.c);
            IMNative.a(a, IMNative.c(imnative));
            IMNative.b(a, IMNative.a(imnative));
            IMNative.c(a, IMNative.b(imnative));
            IMNative.a(a, true);
            IMNative.e(a).post(new b());
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
        }
    }

    private class a
        implements Runnable
    {

        final IMErrorCode a;
        final com.inmobi.monetization.a b;

        public void run()
        {
            if (IMNative.d(b.a) != null)
            {
                IMNative.d(b.a).onNativeRequestFailed(a);
            }
        }

        a(IMErrorCode imerrorcode)
        {
            b = com.inmobi.monetization.a.this;
            a = imerrorcode;
            super();
        }
    }


    private class b
        implements Runnable
    {

        final com.inmobi.monetization.a a;

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

        b()
        {
            a = com.inmobi.monetization.a.this;
            super();
        }
    }

}
