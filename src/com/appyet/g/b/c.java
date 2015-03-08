// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g.b;

import com.appyet.g.c.b;
import com.appyet.g.r;

// Referenced classes of package com.appyet.g.b:
//            i

public final class c
    implements i
{

    public c()
    {
    }

    public final b a(Object obj)
    {
        String s;
        if (((Boolean)obj).booleanValue())
        {
            s = "1";
        } else
        {
            s = "0";
        }
        return r.a("boolean", s);
    }
}
