// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.a.a;


// Referenced classes of package com.google.b.a.a:
//            f

public final class e
{

    public final int a;
    public boolean b;
    public Class c;
    public Class d;

    private e(int i, f f1)
    {
        a = i;
        b = f.access$000(f1);
        c = f.access$100(f1);
        Class class1;
        if (b)
        {
            class1 = f.access$200(f1);
        } else
        {
            class1 = null;
        }
        d = class1;
    }

    public static e a(int i, f f1)
    {
        return new e(i, f1);
    }
}
