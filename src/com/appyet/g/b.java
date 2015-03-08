// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;

import com.appyet.g.b.j;
import com.appyet.g.c.a;

public final class b
{

    private String a;
    private Object b[];

    public b(String s, Object aobj[])
    {
        a = s;
        b = aobj;
    }

    public final String a()
    {
        a a1 = new a();
        com.appyet.g.c.b b1 = new com.appyet.g.c.b("methodCall");
        a1.a = b1;
        com.appyet.g.c.b b2 = new com.appyet.g.c.b("methodName");
        b2.a = a;
        b1.a(b2);
        if (b != null && b.length > 0)
        {
            com.appyet.g.c.b b3 = new com.appyet.g.c.b("params");
            b1.a(b3);
            Object aobj[] = b;
            int i = aobj.length;
            for (int k = 0; k < i; k++)
            {
                Object obj = aobj[k];
                com.appyet.g.c.b b4 = new com.appyet.g.c.b("param");
                com.appyet.g.c.b b5 = new com.appyet.g.c.b("value");
                b4.a(b5);
                b5.a(j.a().a(obj));
                b3.a(b4);
            }

        }
        return a1.toString();
    }
}
