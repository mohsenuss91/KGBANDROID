// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.a;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class c extends FilterInputStream
{

    public c(InputStream inputstream)
    {
        super(inputstream);
    }

    public final long skip(long l)
    {
        long l1;
        long l2;
        for (l1 = 0L; l1 < l; l1 = l2 + l1)
        {
            l2 = in.skip(l - l1);
            if (l2 != 0L)
            {
                continue;
            }
            if (read() < 0)
            {
                break;
            }
            l2 = 1L;
        }

        return l1;
    }
}
