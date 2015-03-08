// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ae;
import com.google.a.ak;
import com.google.a.al;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.google.a.b.a:
//            f

public final class e extends ak
{

    public static final al a = new f();
    private final DateFormat b;
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat d;

    public e()
    {
        b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        d = simpledateformat;
    }

    private Date a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Date date3 = c.parse(s);
        Date date1 = date3;
_L1:
        this;
        JVM INSTR monitorexit ;
        return date1;
        ParseException parseexception;
        parseexception;
        Date date2 = b.parse(s);
        date1 = date2;
          goto _L1
        ParseException parseexception1;
        parseexception1;
        Date date = d.parse(s);
        date1 = date;
          goto _L1
        ParseException parseexception2;
        parseexception2;
        throw new ae(s, parseexception2);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void a(d d1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        d1.f();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d1.b(b.format(date));
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final Object a(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        } else
        {
            return a(a1.h());
        }
    }

    public final volatile void a(d d1, Object obj)
    {
        a(d1, (Date)obj);
    }

}
