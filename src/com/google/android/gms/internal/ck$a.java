// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            eu, ck

final class _cls1
{

    private final Runnable le;
    private volatile boolean oL;

    static boolean a(_cls1 _pcls1)
    {
        return _pcls1.oL;
    }

    public final void aX()
    {
        eu.ss.postDelayed(le, 250L);
    }

    public final void cancel()
    {
        oL = true;
        eu.ss.removeCallbacks(le);
    }

    public _cls1.oN(ck ck)
    {
        oL = false;
        class _cls1
            implements Runnable
        {

            private final WeakReference oM;
            final ck oN;
            final ck.a oO;

            public void run()
            {
                ck ck1 = (ck)oM.get();
                if (!ck.a.a(oO) && ck1 != null)
                {
                    ck1.aW();
                    oO.aX();
                }
            }

            _cls1(ck ck1)
            {
                oO = ck.a.this;
                oN = ck1;
                super();
                oM = new WeakReference(oN);
            }
        }

        le = new _cls1(ck);
    }
}
