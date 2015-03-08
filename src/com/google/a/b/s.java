// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.c;
import com.google.a.a.d;
import com.google.a.ak;
import com.google.a.al;
import com.google.a.b;
import com.google.a.c.a;
import com.google.a.k;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.a.b:
//            t

public final class s
    implements al, Cloneable
{

    public static final s a = new s();
    private double b;
    private int c;
    private boolean d;
    private boolean e;
    private List f;
    private List g;

    public s()
    {
        b = -1D;
        c = 136;
        d = true;
        f = Collections.emptyList();
        g = Collections.emptyList();
    }

    private s a()
    {
        s s1;
        try
        {
            s1 = (s)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return s1;
    }

    private boolean a(c c1, d d1)
    {
        boolean flag;
        if (c1 != null && c1.a() > b)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            boolean flag1;
            if (d1 != null && d1.a() <= b)
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            if (flag1)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Class class1)
    {
        return !java/lang/Enum.isAssignableFrom(class1) && (class1.isAnonymousClass() || class1.isLocalClass());
    }

    private static boolean b(Class class1)
    {
        if (class1.isMemberClass())
        {
            boolean flag;
            if ((8 & class1.getModifiers()) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return true;
            }
        }
        return false;
    }

    public final ak a(k k, a a1)
    {
        Class class1 = a1.a;
        boolean flag = a(class1, true);
        boolean flag1 = a(class1, false);
        if (!flag && !flag1)
        {
            return null;
        } else
        {
            return new t(this, flag1, flag, k, a1);
        }
    }

    public final boolean a(Class class1, boolean flag)
    {
        if (b != -1D && !a((c)class1.getAnnotation(com/google/a/a/c), (d)class1.getAnnotation(com/google/a/a/d)))
        {
            return true;
        }
        if (!d && b(class1))
        {
            return true;
        }
        if (a(class1))
        {
            return true;
        }
        List list;
        Iterator iterator;
        if (flag)
        {
            list = f;
        } else
        {
            list = g;
        }
        for (iterator = list.iterator(); iterator.hasNext();)
        {
            if (((b)iterator.next()).b())
            {
                return true;
            }
        }

        return false;
    }

    public final boolean a(Field field, boolean flag)
    {
label0:
        {
            if ((c & field.getModifiers()) != 0)
            {
                return true;
            }
            if (b != -1D && !a((c)field.getAnnotation(com/google/a/a/c), (d)field.getAnnotation(com/google/a/a/d)))
            {
                return true;
            }
            if (field.isSynthetic())
            {
                return true;
            }
            if (e)
            {
                com.google.a.a.a a1 = (com.google.a.a.a)field.getAnnotation(com/google/a/a/a);
                if (a1 == null || (flag ? !a1.a() : !a1.b()))
                {
                    return true;
                }
            }
            if (!d && b(field.getType()))
            {
                return true;
            }
            if (a(field.getType()))
            {
                return true;
            }
            List list;
            Iterator iterator;
            if (flag)
            {
                list = f;
            } else
            {
                list = g;
            }
            if (list.isEmpty())
            {
                break label0;
            }
            new com.google.a.c(field);
            iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((b)iterator.next()).a());
            return true;
        }
        return false;
    }

    protected final Object clone()
    {
        return a();
    }

}
