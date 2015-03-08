// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest

final class val.logString
    implements Runnable
{

    final String val$logString;

    public final void run()
    {
        HttpGetRequest httpgetrequest = new HttpGetRequest();
        try
        {
            httpgetrequest.get(val$logString);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    ()
    {
        val$logString = s;
        super();
    }
}
