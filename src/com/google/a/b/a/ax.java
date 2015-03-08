// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.c.a;
import com.google.a.k;

final class ax
    implements al
{

    final Class a;
    final ak b;

    ax(Class class1, ak ak)
    {
        a = class1;
        b = ak;
        super();
    }

    public final ak a(k k, a a1)
    {
        if (a.isAssignableFrom(a1.a))
        {
            return b;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[typeHierarchy=")).append(a.getName()).append(",adapter=").append(b).append("]").toString();
    }
}
