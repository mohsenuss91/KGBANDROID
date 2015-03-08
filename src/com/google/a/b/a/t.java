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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Referenced classes of package com.google.a.b.a:
//            u

public final class t extends ak
{

    public static final al a = new u();
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    public t()
    {
    }

    private void a(d d1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        d1.b(s1);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s = b.format(date);
        s1 = s;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private Date b(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (a1.f() != c.i) goto _L2; else goto _L1
_L1:
        a1.j();
        Date date = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return date;
_L2:
        date = new Date(b.parse(a1.h()).getTime());
        if (true) goto _L4; else goto _L3
_L3:
        ParseException parseexception;
        parseexception;
        throw new ae(parseexception);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final volatile void a(d d1, Object obj)
    {
        a(d1, (Date)obj);
    }

}
