// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g.b;

import com.appyet.g.c.b;
import com.appyet.g.n;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.appyet.g.b:
//            i, j

public final class l
    implements i
{

    public l()
    {
    }

    public final b a(Object obj)
    {
        b b1 = new b("struct");
        try
        {
            b b2;
            for (Iterator iterator = ((Map)obj).entrySet().iterator(); iterator.hasNext(); b1.a(b2))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                b2 = new b("member");
                b b3 = new b("name");
                b b4 = new b("value");
                b3.a = (String)entry.getKey();
                b4.a(j.a().a(entry.getValue()));
                b2.a(b3);
                b2.a(b4);
            }

        }
        catch (com.appyet.g.l l1)
        {
            throw new n(l1);
        }
        return b1;
    }
}
