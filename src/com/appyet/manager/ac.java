// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class ac
    implements Callable
{

    final long a;
    final d b;

    ac(d d1, long l)
    {
        b = d1;
        a = l;
        super();
    }

    public final Object call()
    {
        d.a(b, a);
        return null;
    }
}
