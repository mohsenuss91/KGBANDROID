// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.objects;

import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.internal.TrackerView;

public class NativeAd extends IMNative
{

    String b;
    String c;
    String d;
    TrackerView e;

    public NativeAd(String s, String s1, String s2)
    {
        super(s, s1, s2);
        b = null;
        c = null;
        d = null;
        e = null;
        b = s;
        c = s1;
        d = s2;
    }
}
