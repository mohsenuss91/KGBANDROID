// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;


// Referenced classes of package com.inmobi.commons.metric:
//            Logger, Storage

class a
    implements Runnable
{

    final Logger a;

    public void run()
    {
        Logger.a(a).sendFile();
    }

    (Logger logger)
    {
        a = logger;
        super();
    }
}
