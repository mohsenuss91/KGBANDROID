// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{

    public String a;
    private List b;
    private String c;

    public b(String s)
    {
        b = new ArrayList();
        c = s;
    }

    public final void a(b b1)
    {
        b.add(b1);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (a != null && a.length() > 0)
        {
            stringbuilder.append("\n<").append(c).append(">").append(a).append("</").append(c).append(">\n");
            return stringbuilder.toString();
        }
        if (b.size() > 0)
        {
            stringbuilder.append("\n<").append(c).append(">");
            for (Iterator iterator = b.iterator(); iterator.hasNext(); stringbuilder.append(((b)iterator.next()).toString())) { }
            stringbuilder.append("</").append(c).append(">\n");
            return stringbuilder.toString();
        } else
        {
            stringbuilder.append("\n<").append(c).append("/>\n");
            return stringbuilder.toString();
        }
    }
}
