// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.context.e;

final class y
{

    static final int a[];

    static 
    {
        a = new int[e.values().length];
        try
        {
            a[e.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[e.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[e.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[e.d.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[e.f.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[e.g.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[e.e.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6)
        {
            return;
        }
    }
}
