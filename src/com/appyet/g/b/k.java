// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g.b;

import com.appyet.g.c.b;
import com.appyet.g.r;

// Referenced classes of package com.appyet.g.b:
//            i

public final class k
    implements i
{

    private boolean a;
    private boolean b;

    public k()
    {
        a = true;
        b = true;
    }

    public final b a(Object obj)
    {
        String s = obj.toString();
        if (b)
        {
            s = s.replaceAll("&", "&amp;").replaceAll("<", "&lt;");
        }
        return r.a("string", s);
    }
}
