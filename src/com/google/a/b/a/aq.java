// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import java.util.Locale;
import java.util.StringTokenizer;

final class aq extends ak
{

    aq()
    {
    }

    public final Object a(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        StringTokenizer stringtokenizer = new StringTokenizer(a1.h(), "_");
        String s;
        String s1;
        String s2;
        if (stringtokenizer.hasMoreElements())
        {
            s = stringtokenizer.nextToken();
        } else
        {
            s = null;
        }
        if (stringtokenizer.hasMoreElements())
        {
            s1 = stringtokenizer.nextToken();
        } else
        {
            s1 = null;
        }
        if (stringtokenizer.hasMoreElements())
        {
            s2 = stringtokenizer.nextToken();
        } else
        {
            s2 = null;
        }
        if (s1 == null && s2 == null)
        {
            return new Locale(s);
        }
        if (s2 == null)
        {
            return new Locale(s, s1);
        } else
        {
            return new Locale(s, s1, s2);
        }
    }

    public final void a(d d1, Object obj)
    {
        Locale locale = (Locale)obj;
        String s;
        if (locale == null)
        {
            s = null;
        } else
        {
            s = locale.toString();
        }
        d1.b(s);
    }
}
