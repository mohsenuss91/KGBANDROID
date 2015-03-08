// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.appyet.f:
//            n

public final class m
{

    private static final Map a = new n();

    public static Date a(String s)
    {
        String s1;
        Iterator iterator = a.keySet().iterator();
        String s2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_75;
            }
            s2 = (String)iterator.next();
        } while (!s.toLowerCase().matches(s2));
        s1 = (String)a.get(s2);
_L1:
        if (s1 == null)
        {
            throw new ParseException("Unknown date format.", 0);
        } else
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat(s1);
            simpledateformat.setLenient(false);
            return simpledateformat.parse(s);
        }
        s1 = null;
          goto _L1
    }

}
