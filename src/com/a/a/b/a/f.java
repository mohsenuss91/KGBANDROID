// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.a;


public final class f
{

    public final int a;
    public final int b;

    public f(int i, int j)
    {
        a = i;
        b = j;
    }

    public f(int i, int j, int k)
    {
        if (k % 180 == 0)
        {
            a = i;
            b = j;
            return;
        } else
        {
            a = j;
            b = i;
            return;
        }
    }

    public final String toString()
    {
        return (new StringBuilder(9)).append(a).append("x").append(b).toString();
    }
}
