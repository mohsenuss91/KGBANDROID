// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.b.ae;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.a.b.a:
//            s

public final class r extends ak
{

    private final ae a;
    private final Map b;

    private r(ae ae1, Map map)
    {
        a = ae1;
        b = map;
    }

    r(ae ae1, Map map, byte byte0)
    {
        this(ae1, map);
    }

    public final Object a(a a1)
    {
        Object obj;
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        obj = a.a();
        a1.c();
_L1:
        s s2;
        if (!a1.e())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        String s1 = a1.g();
        s2 = (s)b.get(s1);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (s2.i)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        IllegalStateException illegalstateexception;
        a1.n();
          goto _L1
        try
        {
            s2.a(a1, obj);
        }
        // Misplaced declaration of an exception variable
        catch (IllegalStateException illegalstateexception)
        {
            throw new com.google.a.ae(illegalstateexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new AssertionError(illegalaccessexception);
        }
          goto _L1
        a1.d();
        return obj;
    }

    public final void a(d d1, Object obj)
    {
        if (obj == null)
        {
            d1.f();
            return;
        }
        d1.d();
        try
        {
            Iterator iterator = b.values().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                s s1 = (s)iterator.next();
                if (s1.h)
                {
                    d1.a(s1.g);
                    s1.a(d1, obj);
                }
            } while (true);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new AssertionError();
        }
        d1.e();
    }
}
