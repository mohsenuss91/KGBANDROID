// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.c;

import com.a.a.b.a.m;

public final class b
{

    public static final int a[];

    static 
    {
        a = new int[m.values().length];
        try
        {
            a[m.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[m.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1)
        {
            return;
        }
    }
}
