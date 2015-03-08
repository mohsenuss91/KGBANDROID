// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import com.inmobi.commons.metric.Logger;

// Referenced classes of package com.inmobi.commons.internal:
//            b

public class ApiStatCollector
{

    private static Logger a = new Logger(3, "apiStats", new b());

    public ApiStatCollector()
    {
    }

    public static Logger getLogger()
    {
        return a;
    }

}
