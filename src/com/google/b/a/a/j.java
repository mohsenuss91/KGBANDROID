// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.a.a;

import java.util.Arrays;

public final class j
{

    final int a;
    final byte b[];

    j(int i, byte abyte0[])
    {
        a = i;
        b = abyte0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof j))
            {
                return false;
            }
            j j1 = (j)obj;
            if (a != j1.a || !Arrays.equals(b, j1.b))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i = 527 + a;
        for (int k = 0; k < b.length; k++)
        {
            i = i * 31 + b[k];
        }

        return i;
    }
}
