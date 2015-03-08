// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.c.a;
import com.google.a.k;

final class at
    implements al
{

    final Class a;
    final ak b;

    at(Class class1, ak ak)
    {
        a = class1;
        b = ak;
        super();
    }

    public final ak a(k k, a a1)
    {
        if (a1.a == a)
        {
            return b;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(a.getName()).append(",adapter=").append(b).append("]").toString();
    }
}
