// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g.b;

import com.appyet.g.c.b;
import com.appyet.g.r;
import java.text.SimpleDateFormat;

// Referenced classes of package com.appyet.g.b:
//            i

public final class d
    implements i
{

    private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss");

    public d()
    {
    }

    public final b a(Object obj)
    {
        return r.a("dateTime.iso8601", a.format(obj));
    }

}
