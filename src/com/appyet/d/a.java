// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.d;

import android.content.Context;
import android.text.format.DateFormat;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bp;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a
{

    public static String a = "22XH9inECtciY0h";

    public static int a(String s)
    {
        int i;
        String as[] = s.split(":");
        if (as.length == 3)
        {
            return 1000 * (60 * (60 * Integer.parseInt(as[0])) + 60 * Integer.parseInt(as[1]) + Integer.parseInt(as[2]));
        }
        if (as.length == 2)
        {
            return 1000 * (60 * Integer.parseInt(as[0]) + Integer.parseInt(as[1]));
        }
        if (as.length != 1)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        i = Integer.parseInt(as[0]);
        return i * 1000;
        Exception exception;
        exception;
        return 0;
    }

    public static String a(long l)
    {
        long l3;
        long l4;
        long l1;
        long al[];
        long l2;
        long l5;
        String s;
        String s1;
        String s2;
        String s3;
        try
        {
            l1 = l / 1000L;
            al = (new long[] {
                0L, 0L, 0L
            });
        }
        catch (Exception exception)
        {
            return "0:00:00";
        }
        if (l1 >= 60L)
        {
            l2 = l1 % 60L;
        } else
        {
            l2 = l1;
        }
        al[2] = l2;
        l3 = l1 / 60L;
        if (l3 >= 60L)
        {
            l4 = l3 % 60L;
        } else
        {
            l4 = l3;
        }
        al[1] = l4;
        l5 = l3 / 60L;
        if (l5 >= 24L)
        {
            l5 %= 24L;
        }
        al[0] = l5;
        s = String.valueOf(al[0]);
        if (al[1] >= 10L)
        {
            s1 = String.valueOf(al[1]);
        } else
        {
            s1 = (new StringBuilder("0")).append(String.valueOf(al[1])).toString();
        }
        if (al[2] < 10L) goto _L2; else goto _L1
_L1:
        s3 = String.valueOf(al[2]);
_L3:
        return (new StringBuilder()).append(s).append(":").append(s1).append(":").append(s3).toString();
_L2:
        s2 = (new StringBuilder("0")).append(String.valueOf(al[2])).toString();
        s3 = s2;
          goto _L3
    }

    private static String a(Context context, long l)
    {
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        long al[];
        String s;
        Object aobj[];
        String s1;
        String s2;
        Object aobj1[];
        String s3;
        Object aobj2[];
        try
        {
            l1 = ((new Date()).getTime() - l) / 1000L;
        }
        catch (Exception exception)
        {
            return "";
        }
        if (l1 < 0L)
        {
            l1 = 0L;
        }
        al = (new long[] {
            0L, 0L, 0L, 0L
        });
        if (l1 >= 60L)
        {
            l2 = l1 % 60L;
        } else
        {
            l2 = l1;
        }
        al[3] = l2;
        l3 = l1 / 60L;
        if (l3 >= 60L)
        {
            l4 = l3 % 60L;
        } else
        {
            l4 = l3;
        }
        al[2] = l4;
        l5 = l3 / 60L;
        if (l5 >= 24L)
        {
            l6 = l5 % 24L;
        } else
        {
            l6 = l5;
        }
        al[1] = l6;
        al[0] = l5 / 24L;
        if (al[0] > 0L)
        {
            s3 = context.getString(0x7f080049);
            aobj2 = new Object[1];
            aobj2[0] = Long.valueOf(al[0]);
            return String.format(s3, aobj2);
        }
        if (al[1] > 0L)
        {
            s2 = context.getString(0x7f080048);
            aobj1 = new Object[1];
            aobj1[0] = Long.valueOf(al[1]);
            return String.format(s2, aobj1);
        }
        s = context.getString(0x7f080047);
        aobj = new Object[1];
        aobj[0] = Long.valueOf(al[2]);
        s1 = String.format(s, aobj);
        return s1;
    }

    public static String a(Context context, Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return a(context, date.getTime());
        }
    }

    public static String a(ApplicationContext applicationcontext, Date date)
    {
        if (date == null || applicationcontext == null)
        {
            return null;
        }
        String s;
        try
        {
            if (applicationcontext.d.j().equals(""))
            {
                java.text.DateFormat dateformat = DateFormat.getDateFormat(applicationcontext);
                java.text.DateFormat dateformat1 = DateFormat.getTimeFormat(applicationcontext);
                return (new StringBuilder()).append(dateformat.format(date)).append(" ").append(dateformat1.format(date)).toString();
            }
            s = (new SimpleDateFormat(applicationcontext.d.j())).format(date);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public static boolean a(Date date, Date date1)
    {
        return date.getTime() / 0x5265c00L == date1.getTime() / 0x5265c00L;
    }

    private static String b(Context context, long l)
    {
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        long al[];
        String s;
        Object aobj[];
        String s1;
        String s2;
        Object aobj1[];
        String s3;
        Object aobj2[];
        try
        {
            l1 = ((new Date()).getTime() - l) / 1000L;
        }
        catch (Exception exception)
        {
            return "";
        }
        if (l1 < 0L)
        {
            l1 = 0L;
        }
        al = (new long[] {
            0L, 0L, 0L, 0L
        });
        if (l1 >= 60L)
        {
            l2 = l1 % 60L;
        } else
        {
            l2 = l1;
        }
        al[3] = l2;
        l3 = l1 / 60L;
        if (l3 >= 60L)
        {
            l4 = l3 % 60L;
        } else
        {
            l4 = l3;
        }
        al[2] = l4;
        l5 = l3 / 60L;
        if (l5 >= 24L)
        {
            l6 = l5 % 24L;
        } else
        {
            l6 = l5;
        }
        al[1] = l6;
        al[0] = l5 / 24L;
        if (al[0] > 0L)
        {
            s3 = context.getString(0x7f08004c);
            aobj2 = new Object[1];
            aobj2[0] = Long.valueOf(al[0]);
            return String.format(s3, aobj2);
        }
        if (al[1] > 0L)
        {
            s2 = context.getString(0x7f08004b);
            aobj1 = new Object[1];
            aobj1[0] = Long.valueOf(al[1]);
            return String.format(s2, aobj1);
        }
        s = context.getString(0x7f08004a);
        aobj = new Object[1];
        aobj[0] = Long.valueOf(al[2]);
        s1 = String.format(s, aobj);
        return s1;
    }

    public static String b(Context context, Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return b(context, date.getTime());
        }
    }

    public static String b(ApplicationContext applicationcontext, Date date)
    {
        if (date == null || applicationcontext == null)
        {
            return null;
        }
        String s;
        try
        {
            s = java.text.DateFormat.getDateInstance(1).format(date);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public static String c(ApplicationContext applicationcontext, Date date)
    {
        if (date == null || applicationcontext == null)
        {
            return null;
        }
        String s;
        try
        {
            s = java.text.DateFormat.getDateInstance(3).format(date);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public static String d(ApplicationContext applicationcontext, Date date)
    {
        if (date == null || applicationcontext == null)
        {
            return null;
        }
        String s;
        try
        {
            s = java.text.DateFormat.getTimeInstance(3).format(date);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

}
