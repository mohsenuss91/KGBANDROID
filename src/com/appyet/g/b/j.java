// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g.b;

import com.appyet.g.c.b;
import com.appyet.g.l;
import com.appyet.g.n;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

// Referenced classes of package com.appyet.g.b:
//            c, f, g, l, 
//            e, d, a, b, 
//            h, k, i

public final class j
{

    public static j a;
    private k b;
    private c c;
    private f d;
    private g e;
    private com.appyet.g.b.l f;
    private e g;
    private d h;
    private a i;
    private com.appyet.g.b.b j;
    private h k;
    private int l;

    public j()
    {
        c = new c();
        d = new f();
        e = new g();
        f = new com.appyet.g.b.l();
        g = new e();
        h = new d();
        i = new a();
        j = new com.appyet.g.b.b();
        k = new h();
        l = 4;
        b = new k();
    }

    public static j a()
    {
        if (a == null)
        {
            throw new n("The SerializerHandler has not been initialized.");
        } else
        {
            return a;
        }
    }

    public final b a(Object obj)
    {
        Object obj1;
        if ((8 & l) != 0 && obj == null)
        {
            obj1 = k;
        } else
        if (obj instanceof String)
        {
            obj1 = b;
        } else
        if (obj instanceof Boolean)
        {
            obj1 = c;
        } else
        if ((obj instanceof Double) || (obj instanceof Float) || (obj instanceof BigDecimal))
        {
            obj1 = g;
        } else
        if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte))
        {
            obj1 = d;
        } else
        if (obj instanceof Long)
        {
            if ((2 & l) != 0)
            {
                obj1 = e;
            } else
            {
                long l1 = ((Long)obj).longValue();
                if (l1 > 0x7fffffffL || l1 < 0xffffffff80000000L)
                {
                    throw new l("FLAGS_8BYTE_INT must be set, if values outside the 4 byte integer range should be transfered.");
                }
                obj1 = d;
            }
        } else
        if (obj instanceof Date)
        {
            obj1 = h;
        } else
        if (obj instanceof Calendar)
        {
            obj = ((Calendar)obj).getTime();
            obj1 = h;
        } else
        if (obj instanceof Map)
        {
            obj1 = f;
        } else
        if (obj instanceof byte[])
        {
            byte abyte0[] = (byte[])(byte[])obj;
            Byte abyte[] = new Byte[abyte0.length];
            for (int i1 = 0; i1 < abyte.length; i1++)
            {
                abyte[i1] = new Byte(abyte0[i1]);
            }

            obj1 = j;
            obj = abyte;
        } else
        if (obj instanceof Byte[])
        {
            obj1 = j;
        } else
        if (obj instanceof Iterable)
        {
            obj1 = i;
        } else
        {
            throw new l((new StringBuilder("No serializer found for type '")).append(obj.getClass().getName()).append("'.").toString());
        }
        return ((i) (obj1)).a(obj);
    }
}
