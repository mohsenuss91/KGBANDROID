// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;


public class LtvpErrorCode
{

    int a;
    String b;

    public LtvpErrorCode(int i, String s)
    {
        a = i;
        b = s;
    }

    public int getCode()
    {
        return a;
    }

    public String getMessage()
    {
        return b;
    }
}
