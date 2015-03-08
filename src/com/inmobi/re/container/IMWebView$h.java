// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;


class ewState
{

    static final int a[];

    static 
    {
        a = new int[ewState.values().length];
        try
        {
            a[ewState.RESIZING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[ewState.RESIZED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ewState.EXPANDING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[ewState.EXPANDED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[ewState.HIDDEN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[ewState.DEFAULT.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5)
        {
            return;
        }
    }
}
