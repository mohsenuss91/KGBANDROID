// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.d;

import com.a.a.b.a.c;
import java.io.InputStream;

// Referenced classes of package com.a.a.b.d:
//            c, h, d

public final class g
    implements com.a.a.b.d.c
{

    private final com.a.a.b.d.c a;

    public g(com.a.a.b.d.c c1)
    {
        a = c1;
    }

    public final InputStream a(String s, Object obj)
    {
        InputStream inputstream = a.a(s, obj);
        switch (h.a[d.a(s).ordinal()])
        {
        default:
            return inputstream;

        case 1: // '\001'
        case 2: // '\002'
            return new c(inputstream);
        }
    }
}
