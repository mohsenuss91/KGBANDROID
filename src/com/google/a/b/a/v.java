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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package com.google.a.b.a:
//            w

public final class v extends ak
{

    public static final al a = new w();
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    public v()
    {
    }

    private void a(d d1, Time time)
    {
        this;
        JVM INSTR monitorenter ;
        if (time != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        d1.b(s1);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s = b.format(time);
        s1 = s;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private Time b(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (a1.f() != c.i) goto _L2; else goto _L1
_L1:
        a1.j();
        Time time = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return time;
_L2:
        time = new Time(b.parse(a1.h()).getTime());
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
        a(d1, (Time)obj);
    }

}
