// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class ap extends ak
{

    ap()
    {
    }

    public final Object a(a a1)
    {
        int i = 0;
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        a1.c();
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        do
        {
            if (a1.f() == c.d)
            {
                break;
            }
            String s = a1.g();
            int k1 = a1.m();
            if ("year".equals(s))
            {
                j1 = k1;
            } else
            if ("month".equals(s))
            {
                i1 = k1;
            } else
            if ("dayOfMonth".equals(s))
            {
                l = k1;
            } else
            if ("hourOfDay".equals(s))
            {
                k = k1;
            } else
            if ("minute".equals(s))
            {
                j = k1;
            } else
            if ("second".equals(s))
            {
                i = k1;
            }
        } while (true);
        a1.d();
        return new GregorianCalendar(j1, i1, l, k, j, i);
    }

    public final void a(d d1, Object obj)
    {
        Calendar calendar = (Calendar)obj;
        if (calendar == null)
        {
            d1.f();
            return;
        } else
        {
            d1.d();
            d1.a("year");
            d1.a(calendar.get(1));
            d1.a("month");
            d1.a(calendar.get(2));
            d1.a("dayOfMonth");
            d1.a(calendar.get(5));
            d1.a("hourOfDay");
            d1.a(calendar.get(11));
            d1.a("minute");
            d1.a(calendar.get(12));
            d1.a("second");
            d1.a(calendar.get(13));
            d1.e();
            return;
        }
    }
}
