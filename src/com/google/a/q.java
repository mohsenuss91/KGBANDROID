// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.d.a;
import com.google.a.d.d;

// Referenced classes of package com.google.a:
//            ak

final class q extends ak
{

    ak a;

    q()
    {
    }

    public final Object a(a a1)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            return a.a(a1);
        }
    }

    public final void a(d d, Object obj)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            a.a(d, obj);
            return;
        }
    }
}
