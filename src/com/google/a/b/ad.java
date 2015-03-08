// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;


final class ad
    implements java.util.Map.Entry
{

    ad a;
    ad b;
    ad c;
    ad d;
    ad e;
    final Object f;
    Object g;
    int h;

    ad()
    {
        f = null;
        e = this;
        d = this;
    }

    ad(ad ad1, Object obj, ad ad2, ad ad3)
    {
        a = ad1;
        f = obj;
        h = 1;
        d = ad2;
        e = ad3;
        ad3.d = this;
        ad2.e = this;
    }

    public final ad a()
    {
        ad ad2;
        for (ad ad1 = b; ad1 != null; ad1 = ad2)
        {
            ad2 = ad1.b;
            this = ad1;
        }

        return this;
    }

    public final ad b()
    {
        ad ad2;
        for (ad ad1 = c; ad1 != null; ad1 = ad2)
        {
            ad2 = ad1.c;
            this = ad1;
        }

        return this;
    }

    public final boolean equals(Object obj)
    {
        boolean flag;
        boolean flag1;
        flag = obj instanceof java.util.Map.Entry;
        flag1 = false;
        if (!flag) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry = (java.util.Map.Entry)obj;
        if (f != null) goto _L4; else goto _L3
_L3:
        Object obj2;
        obj2 = entry.getKey();
        flag1 = false;
        if (obj2 != null) goto _L2; else goto _L5
_L5:
        if (g != null) goto _L7; else goto _L6
_L6:
        Object obj1;
        obj1 = entry.getValue();
        flag1 = false;
        if (obj1 != null) goto _L2; else goto _L8
_L8:
        flag1 = true;
_L2:
        return flag1;
_L4:
        boolean flag2;
        flag2 = f.equals(entry.getKey());
        flag1 = false;
        if (!flag2) goto _L2; else goto _L5
_L7:
        boolean flag3;
        flag3 = g.equals(entry.getValue());
        flag1 = false;
        if (!flag3) goto _L2; else goto _L8
    }

    public final Object getKey()
    {
        return f;
    }

    public final Object getValue()
    {
        return g;
    }

    public final int hashCode()
    {
        int i;
        Object obj;
        int j;
        if (f == null)
        {
            i = 0;
        } else
        {
            i = f.hashCode();
        }
        obj = g;
        j = 0;
        if (obj != null)
        {
            j = g.hashCode();
        }
        return i ^ j;
    }

    public final Object setValue(Object obj)
    {
        Object obj1 = g;
        g = obj;
        return obj1;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(f).append("=").append(g).toString();
    }
}
