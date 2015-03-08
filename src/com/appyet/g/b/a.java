// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g.b;

import com.appyet.g.c.b;
import com.appyet.g.l;
import com.appyet.g.n;
import java.util.Iterator;

// Referenced classes of package com.appyet.g.b:
//            i, j

public final class a
    implements i
{

    public a()
    {
    }

    public final b a(Object obj)
    {
        Iterable iterable = (Iterable)obj;
        b b1 = new b("array");
        b b2 = new b("data");
        b1.a(b2);
        try
        {
            b b3;
            for (Iterator iterator = iterable.iterator(); iterator.hasNext(); b2.a(b3))
            {
                Object obj1 = iterator.next();
                b3 = new b("value");
                b3.a(j.a().a(obj1));
            }

        }
        catch (l l1)
        {
            throw new n(l1);
        }
        return b1;
    }
}
