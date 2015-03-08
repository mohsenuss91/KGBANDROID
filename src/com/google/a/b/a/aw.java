// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.c.a;
import com.google.a.k;

final class aw
    implements al
{

    final Class a;
    final Class b;
    final ak c;

    aw(Class class1, Class class2, ak ak)
    {
        a = class1;
        b = class2;
        c = ak;
        super();
    }

    public final ak a(k k, a a1)
    {
        Class class1 = a1.a;
        if (class1 == a || class1 == b)
        {
            return c;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(a.getName()).append("+").append(b.getName()).append(",adapter=").append(c).append("]").toString();
    }
}
