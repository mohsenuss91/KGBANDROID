// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.os.SystemClock;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            i

final class j
    implements Runnable
{

    final i a;

    j(i k)
    {
        a = k;
        super();
    }

    public final void run()
    {
        i.a(a, 0.01F * i.a(a));
        if (i.b(a) >= i.c(a))
        {
            i.d(a);
            i.b(a, i.c(a));
        }
        a.scheduleSelf(i.e(a), 16L + SystemClock.uptimeMillis());
        a.invalidateSelf();
    }
}
