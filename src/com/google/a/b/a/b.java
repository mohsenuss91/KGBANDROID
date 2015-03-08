// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.c.a;
import com.google.a.k;
import java.lang.reflect.GenericArrayType;

// Referenced classes of package com.google.a.b.a:
//            a

final class b
    implements al
{

    b()
    {
    }

    public final ak a(k k1, a a1)
    {
        java.lang.reflect.Type type = a1.b;
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class)type).isArray()))
        {
            return null;
        } else
        {
            java.lang.reflect.Type type1 = com.google.a.b.b.d(type);
            return new com.google.a.b.a.a(k1, k1.a(com.google.a.c.a.a(type1)), com.google.a.b.b.b(type1));
        }
    }
}
