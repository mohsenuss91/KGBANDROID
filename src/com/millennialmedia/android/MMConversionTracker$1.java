// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.util.TreeMap;

// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest

final class val.extraParams
    implements Runnable
{

    final TreeMap val$extraParams;
    final String val$goalId;
    final long val$installTimeUTC;
    final boolean val$isFirstLaunch;

    public final void run()
    {
        HttpGetRequest httpgetrequest = new HttpGetRequest();
        try
        {
            httpgetrequest.trackConversion(val$goalId, val$isFirstLaunch, val$installTimeUTC, val$extraParams);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    ()
    {
        val$goalId = s;
        val$isFirstLaunch = flag;
        val$installTimeUTC = l;
        val$extraParams = treemap;
        super();
    }
}
