// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;

// Referenced classes of package com.google.android.gms.internal:
//            ep

final class qr
    implements Runnable
{

    final Context qr;

    public final void run()
    {
        synchronized (ep.bP())
        {
            ep.w(ep.n(qr));
            ep.bP().notifyAll();
        }
    }

    (Context context)
    {
        qr = context;
        super();
    }
}
