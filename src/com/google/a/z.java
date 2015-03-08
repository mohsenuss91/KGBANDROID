// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.b.w;
import java.util.Set;

// Referenced classes of package com.google.a:
//            w, y

public final class z extends com.google.a.w
{

    private final w a = new w();

    public z()
    {
    }

    public final void a(String s, com.google.a.w w1)
    {
        if (w1 == null)
        {
            w1 = y.a;
        }
        a.put(s, w1);
    }

    public final boolean equals(Object obj)
    {
        return obj == this || (obj instanceof z) && ((z)obj).a.equals(a);
    }

    public final int hashCode()
    {
        return a.hashCode();
    }

    public final Set n()
    {
        return a.entrySet();
    }
}
