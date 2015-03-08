// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;


class itchIconType
{

    static final int a[];

    static 
    {
        a = new int[itchIconType.values().length];
        try
        {
            a[itchIconType.CLOSE_BUTTON.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[itchIconType.CLOSE_TRANSPARENT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[itchIconType.FORWARD_ACTIVE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[itchIconType.FORWARD_INACTIVE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[itchIconType.BACK.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[itchIconType.REFRESH.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[itchIconType.CLOSE_ICON.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6)
        {
            return;
        }
    }
}
