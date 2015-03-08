// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.b.a;

// Referenced classes of package com.google.a:
//            al, ad, v, ai, 
//            k, ak

final class aj
    implements al
{

    private final com.google.a.c.a a;
    private final boolean b;
    private final Class c;
    private final ad d;
    private final v e;

    private aj(Object obj, com.google.a.c.a a1)
    {
        ad ad1;
        v v1;
        boolean flag;
        if (obj instanceof ad)
        {
            ad1 = (ad)obj;
        } else
        {
            ad1 = null;
        }
        d = ad1;
        if (obj instanceof v)
        {
            v1 = (v)obj;
        } else
        {
            v1 = null;
        }
        e = v1;
        if (d != null || e != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.a.b.a.a(flag);
        a = a1;
        b = false;
        c = null;
    }

    aj(Object obj, com.google.a.c.a a1, byte byte0)
    {
        this(obj, a1);
    }

    public final ak a(k k, com.google.a.c.a a1)
    {
        boolean flag;
        if (a != null)
        {
            if (a.equals(a1) || b && a.b == a1.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = c.isAssignableFrom(a1.a);
        }
        if (flag)
        {
            return new ai(d, e, k, a1, this, (byte)0);
        } else
        {
            return null;
        }
    }
}
