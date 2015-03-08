// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.b.af;
import com.google.a.b.b;
import com.google.a.b.f;
import com.google.a.b.s;
import com.google.a.c.a;
import com.google.a.j;
import com.google.a.k;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.google.a.b.a:
//            q, s, r

public final class p
    implements al
{

    private final f a;
    private final j b;
    private final s c;

    public p(f f1, j j1, s s1)
    {
        a = f1;
        b = j1;
        c = s1;
    }

    private Map a(k k, a a1, Class class1)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (class1.isInterface())
        {
            return linkedhashmap;
        }
        java.lang.reflect.Type type = a1.b;
        for (; class1 != java/lang/Object; class1 = a1.a)
        {
            Field afield[] = class1.getDeclaredFields();
            int i = afield.length;
            com.google.a.a.b b1;
            String s1;
            for (int l = 0; l < i; l++)
            {
                Field field = afield[l];
                boolean flag = a(field, true);
                boolean flag1 = a(field, false);
                if (!flag && !flag1)
                {
                    continue;
                }
                field.setAccessible(true);
                java.lang.reflect.Type type3 = a1.b;
                java.lang.reflect.Type type4 = field.getGenericType();
                java.lang.reflect.Type type5 = com.google.a.b.b.a(type3, class1, type4);
                b1 = (com.google.a.a.b)field.getAnnotation(com/google/a/a/b);
                a a2;
                q q1;
                com.google.a.b.a.s s2;
                if (b1 == null)
                {
                    s1 = b.a(field);
                } else
                {
                    s1 = b1.a();
                }
                a2 = com.google.a.c.a.a(type5);
                q1 = new q(this, s1, flag, flag1, k, a2, field, af.a(a2.a));
                s2 = (com.google.a.b.a.s)linkedhashmap.put(((com.google.a.b.a.s) (q1)).g, q1);
                if (s2 != null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append(type).append(" declares multiple JSON fields named ").append(s2.g).toString());
                }
            }

            java.lang.reflect.Type type1 = a1.b;
            java.lang.reflect.Type type2 = class1.getGenericSuperclass();
            a1 = com.google.a.c.a.a(com.google.a.b.b.a(type1, class1, type2));
        }

        return linkedhashmap;
    }

    private boolean a(Field field, boolean flag)
    {
        return !c.a(field.getType(), flag) && !c.a(field, flag);
    }

    public final ak a(k k, a a1)
    {
        Class class1 = a1.a;
        if (!java/lang/Object.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            return new r(a.a(a1), a(k, a1, class1), (byte)0);
        }
    }
}
