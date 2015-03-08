// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.util.Date;

// Referenced classes of package org.simpleframework.xml.transform:
//            Transform, DateFactory, DateType

class DateTransform
    implements Transform
{

    private final DateFactory factory;

    public DateTransform(Class class1)
    {
        factory = new DateFactory(class1);
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public Date read(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Date date;
        Long long1 = Long.valueOf(DateType.getDate(s).getTime());
        date = factory.getInstance(new Object[] {
            long1
        });
        this;
        JVM INSTR monitorexit ;
        return date;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile String write(Object obj)
    {
        return write((Date)obj);
    }

    public String write(Date date)
    {
        this;
        JVM INSTR monitorenter ;
        String s = DateType.getText(date);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}
