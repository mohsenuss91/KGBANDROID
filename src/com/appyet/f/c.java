// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.appyet.f:
//            i, a

final class c extends i
{

    final a a;

    c(a a1)
    {
        a = a1;
        super((byte)0);
    }

    public final Object call()
    {
        com.appyet.f.a.a(a).set(true);
        Process.setThreadPriority(10);
        a a1 = a;
        a a2 = a;
        Object[] _tmp = b;
        return com.appyet.f.a.a(a1, a2.b());
    }
}
