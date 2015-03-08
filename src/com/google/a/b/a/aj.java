// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import com.google.a.x;
import java.net.URI;
import java.net.URISyntaxException;

final class aj extends ak
{

    aj()
    {
    }

    private static URI b(a a1)
    {
        if (a1.f() != c.i) goto _L2; else goto _L1
_L1:
        a1.j();
_L4:
        return null;
_L2:
        String s = a1.h();
        if ("null".equals(s)) goto _L4; else goto _L3
_L3:
        URI uri = new URI(s);
        return uri;
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        throw new x(urisyntaxexception);
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final void a(d d1, Object obj)
    {
        URI uri = (URI)obj;
        String s;
        if (uri == null)
        {
            s = null;
        } else
        {
            s = uri.toASCIIString();
        }
        d1.b(s);
    }
}
