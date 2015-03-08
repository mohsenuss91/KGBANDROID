// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class l
{

    private static String a[];
    private static final String b[] = {
        "EEE, dd MMM yy HH:mm:ss z", "EEE, dd MMM yy HH:mm z", "dd MMM yy HH:mm:ss z", "dd MMM yy HH:mm z"
    };
    private static final String c[] = {
        "yyyy-MM-dd'T'HH:mm:ss.SSSz", "yyyy-MM-dd't'HH:mm:ss.SSSz", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd't'HH:mm:ss.SSS'z'", "yyyy-MM-dd'T'HH:mm:ssz", "yyyy-MM-dd't'HH:mm:ssz", "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd't'HH:mm:ss'z'", "yyyy-MM-dd'T'HH:mmz", "yyyy-MM'T'HH:mmz", 
        "yyyy'T'HH:mmz", "yyyy-MM-dd't'HH:mmz", "yyyy-MM-dd'T'HH:mm'Z'", "yyyy-MM-dd't'HH:mm'z'", "yyyy-MM-dd", "yyyy-MM", "yyyy"
    };

    public static Date a(String s)
    {
        int i = s.indexOf("T");
        if (i >= 0)
        {
            String s1;
            Date date;
            int j;
            String s2;
            String s3;
            String s4;
            int k;
            int i1;
            if (s.endsWith("Z"))
            {
                s1 = (new StringBuilder()).append(s.substring(0, -1 + s.length())).append("+00:00").toString();
            } else
            {
                s1 = s;
            }
            k = s1.indexOf("+", i);
            if (k == -1)
            {
                i1 = s1.indexOf("-", i);
            } else
            {
                i1 = k;
            }
            if (i1 >= 0)
            {
                String s5 = s1.substring(0, i1);
                int j1 = s5.indexOf(",");
                if (j1 >= 0)
                {
                    s5 = s5.substring(0, j1);
                }
                String s6 = s1.substring(i1);
                s1 = (new StringBuilder()).append(s5).append("GMT").append(s6).toString();
            }
        } else
        {
            s1 = (new StringBuilder()).append(s).append("T00:00GMT").toString();
        }
        date = a(c, s1);
        if (date == null)
        {
            j = s.indexOf(" UT");
            if (j >= 0)
            {
                s3 = s.substring(0, j);
                s4 = s.substring(j + 3);
                s2 = (new StringBuilder()).append(s3).append(" GMT").append(s4).toString();
            } else
            {
                s2 = s;
            }
            date = a(b, s2);
            if (date == null && a.length > 0)
            {
                date = a(a, s);
            }
        }
        return date;
    }

    private static Date a(String as[], String s)
    {
        Date date;
        String s1;
        int i;
        SimpleDateFormat simpledateformat;
        ParsePosition parseposition;
        int j;
        int k;
        if (s != null)
        {
            s1 = s.trim();
        } else
        {
            s1 = null;
        }
        i = 0;
        date = null;
        if (date != null || i >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        simpledateformat = new SimpleDateFormat(as[i], Locale.US);
        simpledateformat.setLenient(true);
        parseposition = new ParsePosition(0);
        date = simpledateformat.parse(s1, parseposition);
        j = parseposition.getIndex();
        k = s1.length();
        if (j != k)
        {
            date = null;
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_14;
_L1:
        return date;
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

}
