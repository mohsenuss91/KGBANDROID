// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.d;
import java.sql.Timestamp;
import java.util.Date;

// Referenced classes of package com.google.a.b.a:
//            an

final class ao extends ak
{

    final ak a;
    final an b;

    ao(an an, ak ak1)
    {
        b = an;
        a = ak1;
        super();
    }

    public final Object a(a a1)
    {
        Date date = (Date)a.a(a1);
        if (date != null)
        {
            return new Timestamp(date.getTime());
        } else
        {
            return null;
        }
    }

    public final volatile void a(d d, Object obj)
    {
        Timestamp timestamp = (Timestamp)obj;
        a.a(d, timestamp);
    }
}
