// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.c.a;
import com.google.a.k;

// Referenced classes of package com.google.a.b.a:
//            bf

final class as
    implements al
{

    as()
    {
    }

    public final ak a(k k, a a1)
    {
        Class class1 = a1.a;
        if (!java/lang/Enum.isAssignableFrom(class1) || class1 == java/lang/Enum)
        {
            return null;
        }
        if (!class1.isEnum())
        {
            class1 = class1.getSuperclass();
        }
        return new bf(class1);
    }
}
