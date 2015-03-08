// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a.a;

import com.a.a.a.a.b.a;
import com.a.a.a.a.c;
import com.a.a.c.d;
import java.io.File;

public final class b extends c
{

    public b(File file)
    {
        this(file, ((a) (new com.a.a.a.a.b.b())), 0x200000);
    }

    public b(File file, a a, int i)
    {
        super(file, a, i);
        if (i < 0x200000)
        {
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(2);
            d.c("You set too small disc cache size (less than %1$d Mb)", aobj);
        }
    }

    protected final int b(File file)
    {
        return (int)file.length();
    }
}
