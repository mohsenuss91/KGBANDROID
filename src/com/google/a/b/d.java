// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

// Referenced classes of package com.google.a.b:
//            a, b

final class d
    implements Serializable, ParameterizedType
{

    private final Type a;
    private final Type b;
    private final Type c[];

    public transient d(Type type, Type type1, Type atype[])
    {
        boolean flag = true;
        int i = 0;
        super();
        Type type2;
        if (type1 instanceof Class)
        {
            Class class1 = (Class)type1;
            boolean flag1;
            if (type != null || class1.getEnclosingClass() == null)
            {
                flag1 = flag;
            } else
            {
                flag1 = false;
            }
            com.google.a.b.a.a(flag1);
            if (type != null && class1.getEnclosingClass() == null)
            {
                flag = false;
            }
            com.google.a.b.a.a(flag);
        }
        if (type == null)
        {
            type2 = null;
        } else
        {
            type2 = com.google.a.b.b.a(type);
        }
        a = type2;
        b = com.google.a.b.b.a(type1);
        for (c = (Type[])atype.clone(); i < c.length; i++)
        {
            com.google.a.b.a.a(c[i]);
            com.google.a.b.b.e(c[i]);
            c[i] = com.google.a.b.b.a(c[i]);
        }

    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof ParameterizedType) && com.google.a.b.b.a(this, (ParameterizedType)obj);
    }

    public final Type[] getActualTypeArguments()
    {
        return (Type[])c.clone();
    }

    public final Type getOwnerType()
    {
        return a;
    }

    public final Type getRawType()
    {
        return b;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(c) ^ b.hashCode() ^ com.google.a.b.b.a(a);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(30 * (1 + c.length));
        stringbuilder.append(com.google.a.b.b.c(b));
        if (c.length == 0)
        {
            return stringbuilder.toString();
        }
        stringbuilder.append("<").append(com.google.a.b.b.c(c[0]));
        for (int i = 1; i < c.length; i++)
        {
            stringbuilder.append(", ").append(com.google.a.b.b.c(c[i]));
        }

        return stringbuilder.append(">").toString();
    }
}
