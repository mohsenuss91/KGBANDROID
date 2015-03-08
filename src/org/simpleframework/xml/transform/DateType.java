// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.util.Date;

final class DateType extends Enum
{

    private static final DateType $VALUES[];
    public static final DateType FULL;
    public static final DateType LONG;
    public static final DateType NORMAL;
    public static final DateType SHORT;
    private DateFormat format;

    private DateType(String s, int i, String s1)
    {
        super(s, i);
        format = new DateFormat(s1);
    }

    public static Date getDate(String s)
    {
        return getType(s).getFormat().getDate(s);
    }

    private DateFormat getFormat()
    {
        return format;
    }

    public static String getText(Date date)
    {
        return FULL.getFormat().getText(date);
    }

    public static DateType getType(String s)
    {
        int i = s.length();
        if (i > 23)
        {
            return FULL;
        }
        if (i > 20)
        {
            return LONG;
        }
        if (i > 11)
        {
            return NORMAL;
        } else
        {
            return SHORT;
        }
    }

    public static DateType valueOf(String s)
    {
        return (DateType)Enum.valueOf(org/simpleframework/xml/transform/DateType, s);
    }

    public static DateType[] values()
    {
        return (DateType[])$VALUES.clone();
    }

    static 
    {
        FULL = new DateType("FULL", 0, "yyyy-MM-dd HH:mm:ss.S z");
        LONG = new DateType("LONG", 1, "yyyy-MM-dd HH:mm:ss z");
        NORMAL = new DateType("NORMAL", 2, "yyyy-MM-dd z");
        SHORT = new DateType("SHORT", 3, "yyyy-MM-dd");
        DateType adatetype[] = new DateType[4];
        adatetype[0] = FULL;
        adatetype[1] = LONG;
        adatetype[2] = NORMAL;
        adatetype[3] = SHORT;
        $VALUES = adatetype;
    }

    private class DateFormat
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

        public DateFormat(String s)
        {
            format = new SimpleDateFormat(s);
        }
    }

}
