// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import java.io.File;

// Referenced classes of package com.a.a.a.a:
//            b

public abstract class a
    implements b
{

    protected File a;
    private com.a.a.a.a.b.a b;

    public a(File file, com.a.a.a.a.b.a a1)
    {
        if (file == null)
        {
            throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[] {
                "cacheDir"
            }));
        }
        if (a1 == null)
        {
            throw new IllegalArgumentException(String.format("\"%s\" argument must be not null", new Object[] {
                "fileNameGenerator"
            }));
        } else
        {
            a = file;
            b = a1;
            return;
        }
    }

    public File a(String s)
    {
        String s1 = b.a(s);
        return new File(a, s1);
    }
}
