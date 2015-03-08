// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.a.b;
import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class bf extends ak
{

    private final Map a;
    private final Map b;

    public bf(Class class1)
    {
        String s;
        String s1;
        a = new HashMap();
        b = new HashMap();
        Enum aenum[];
        int i;
        int j;
        Enum enum;
        b b1;
        try
        {
            aenum = (Enum[])class1.getEnumConstants();
            i = aenum.length;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            throw new AssertionError();
        }
        j = 0;
        if (j >= i) goto _L2; else goto _L1
_L1:
        enum = aenum[j];
        s = enum.name();
        b1 = (b)class1.getField(s).getAnnotation(com/google/a/a/b);
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        s1 = b1.a();
_L3:
        a.put(s1, enum);
        b.put(enum, s1);
        j++;
        break MISSING_BLOCK_LABEL_41;
_L2:
        return;
        s1 = s;
          goto _L3
    }

    public final Object a(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        } else
        {
            return (Enum)a.get(a1.h());
        }
    }

    public final void a(d d1, Object obj)
    {
        Enum enum = (Enum)obj;
        String s;
        if (enum == null)
        {
            s = null;
        } else
        {
            s = (String)b.get(enum);
        }
        d1.b(s);
    }
}
