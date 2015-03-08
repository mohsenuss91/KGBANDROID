// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.b.b;
import com.google.a.b.f;
import com.google.a.c.a;
import com.google.a.k;
import java.util.Collection;

// Referenced classes of package com.google.a.b.a:
//            d

public final class c
    implements al
{

    private final f a;

    public c(f f1)
    {
        a = f1;
    }

    public final ak a(k k1, a a1)
    {
        java.lang.reflect.Type type = a1.b;
        Class class1 = a1.a;
        if (!java/util/Collection.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            java.lang.reflect.Type type1 = b.a(type, class1);
            return new d(k1, type1, k1.a(com.google.a.c.a.a(type1)), a.a(a1));
        }
    }
}
