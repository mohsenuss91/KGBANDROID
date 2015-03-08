// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.util.Date;
import java.util.GregorianCalendar;

// Referenced classes of package org.simpleframework.xml.transform:
//            Transform, DateTransform

class GregorianCalendarTransform
    implements Transform
{

    private final DateTransform transform;

    public GregorianCalendarTransform()
    {
        this(java/util/Date);
    }

    public GregorianCalendarTransform(Class class1)
    {
        transform = new DateTransform(class1);
    }

    private GregorianCalendar read(Date date)
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        if (date != null)
        {
            gregoriancalendar.setTime(date);
        }
        return gregoriancalendar;
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public GregorianCalendar read(String s)
    {
        return read(transform.read(s));
    }

    public volatile String write(Object obj)
    {
        return write((GregorianCalendar)obj);
    }

    public String write(GregorianCalendar gregoriancalendar)
    {
        return transform.write(gregoriancalendar.getTime());
    }
}
