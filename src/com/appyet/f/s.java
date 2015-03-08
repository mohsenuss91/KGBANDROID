// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.appyet.f:
//            q, t

class s
    implements q
{

    private Map a;
    private t b;

    s()
    {
        a = new HashMap();
        b = new t();
    }

    public final int a(String s1)
    {
        Object obj = a.get(s1);
        if (obj == null)
        {
            return -1;
        } else
        {
            return ((Integer)obj).intValue();
        }
    }

    public final void a(String s1, int i)
    {
        a.put(s1, Integer.valueOf(i));
        b.a(i, s1);
    }
}
