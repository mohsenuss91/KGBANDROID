// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.text.SimpleDateFormat;
import java.util.Date;

class format
{

    private SimpleDateFormat format;

    public Date getDate(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Date date = format.parse(s);
        this;
        JVM INSTR monitorexit ;
        return date;
        Exception exception;
        exception;
        throw exception;
    }

    public String getText(Date date)
    {
        this;
        JVM INSTR monitorenter ;
        String s = format.format(date);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public (String s)
    {
        format = new SimpleDateFormat(s);
    }
}
