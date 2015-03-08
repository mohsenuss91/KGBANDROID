// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.d;

import com.google.a.b.a.g;
import com.google.a.b.u;

// Referenced classes of package com.google.a.d:
//            a

final class b extends u
{

    b()
    {
    }

    public final void a(a a1)
    {
        if (a1 instanceof g)
        {
            ((g)a1).o();
            return;
        }
        int i = com.google.a.d.a.a(a1);
        if (i == 0)
        {
            i = com.google.a.d.a.b(a1);
        }
        if (i == 13)
        {
            com.google.a.d.a.a(a1, 9);
            return;
        }
        if (i == 12)
        {
            com.google.a.d.a.a(a1, 8);
            return;
        }
        if (i == 14)
        {
            com.google.a.d.a.a(a1, 10);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a name but was ")).append(a1.f()).append("  at line ").append(com.google.a.d.a.c(a1)).append(" column ").append(com.google.a.d.a.d(a1)).toString());
        }
    }
}
