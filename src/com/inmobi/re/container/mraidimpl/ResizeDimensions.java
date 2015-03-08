// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;


public class ResizeDimensions
{

    int a;
    int b;
    int c;
    int d;

    public ResizeDimensions(int i, int j, int k, int l)
    {
        a = i;
        b = j;
        c = k;
        d = l;
    }

    public int getHeight()
    {
        return d;
    }

    public int getWidth()
    {
        return c;
    }

    public int getX()
    {
        return a;
    }

    public int getY()
    {
        return b;
    }
}
