// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.google.a:
//            ad, v, ab, w, 
//            ae, aa

final class a
    implements ad, v
{

    private final DateFormat a;
    private final DateFormat b;
    private final DateFormat c;

    a()
    {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public a(int i, int j)
    {
        this(DateFormat.getDateTimeInstance(i, j, Locale.US), DateFormat.getDateTimeInstance(i, j));
    }

    a(String s)
    {
        this(((DateFormat) (new SimpleDateFormat(s, Locale.US))), ((DateFormat) (new SimpleDateFormat(s))));
    }

    private a(DateFormat dateformat, DateFormat dateformat1)
    {
        a = dateformat;
        b = dateformat1;
        c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private w a(Date date)
    {
        ab ab1;
        synchronized (b)
        {
            ab1 = new ab(a.format(date));
        }
        return ab1;
    }

    private Date a(w w1)
    {
        dateformat;
        JVM INSTR monitorenter ;
        Date date2;
        synchronized (b)
        {
            date2 = b.parse(w1.b());
        }
        return date2;
        ParseException parseexception;
        parseexception;
        Date date1 = a.parse(w1.b());
        dateformat;
        JVM INSTR monitorexit ;
        return date1;
        exception;
        dateformat;
        JVM INSTR monitorexit ;
        throw exception;
        ParseException parseexception1;
        parseexception1;
        Date date = c.parse(w1.b());
        dateformat;
        JVM INSTR monitorexit ;
        return date;
        ParseException parseexception2;
        parseexception2;
        throw new ae(w1.b(), parseexception2);
    }

    public final volatile w a(Object obj)
    {
        return a((Date)obj);
    }

    public final Object a(w w1, Type type)
    {
        if (!(w1 instanceof ab))
        {
            throw new aa("The date should be a string value");
        }
        Date date = a(w1);
        if (type == java/util/Date)
        {
            return date;
        }
        if (type == java/sql/Timestamp)
        {
            return new Timestamp(date.getTime());
        }
        if (type == java/sql/Date)
        {
            return new java.sql.Date(date.getTime());
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append(getClass()).append(" cannot deserialize to ").append(type).toString());
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(com/google/a/a.getSimpleName());
        stringbuilder.append('(').append(b.getClass().getSimpleName()).append(')');
        return stringbuilder.toString();
    }
}
