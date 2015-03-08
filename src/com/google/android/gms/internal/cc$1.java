// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.ads.b;
import com.google.ads.c;

class 
{

    static final int nW[];
    static final int nX[];

    static 
    {
        nX = new int[b.values().length];
        try
        {
            nX[b.d.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            nX[b.a.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            nX[b.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            nX[b.b.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        nW = new int[c.values().length];
        try
        {
            nW[c.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            nW[c.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            nW[c.a.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6)
        {
            return;
        }
    }
}
