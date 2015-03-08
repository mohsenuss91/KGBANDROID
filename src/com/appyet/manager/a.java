// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.FileCache;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.manager:
//            d, al, bp

public final class a
{

    public static String a = "X5nFe16r7FbKpb16l";
    private ApplicationContext b;
    private long c;
    private long d;

    public a(ApplicationContext applicationcontext)
    {
        b = applicationcontext;
    }

    public final void a()
    {
        List list;
        HashMap hashmap;
        try
        {
            c = 0L;
            d = 0L;
            b.h.a();
            b;
            if (!ApplicationContext.a())
            {
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        list = b.h.e();
        hashmap = new HashMap();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); hashmap.put(((FileCache)iterator.next()).getFileCacheName(), null)) { }
        b.j.a(hashmap);
        b.d.a((new Date()).getTime());
        d = b.j.b();
        c = b.j.c();
        return;
    }

}
