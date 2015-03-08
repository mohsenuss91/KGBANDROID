// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest

final class val.urls
    implements Runnable
{

    final String val$urls[];

    public final void run()
    {
        String as[] = val$urls;
        int i = as.length;
        int j = 0;
        while (j < i) 
        {
            String s = as[j];
            val.urls("Logging event to: %s", new Object[] {
                s
            });
            try
            {
                (new HttpGetRequest()).get(s);
            }
            catch (Exception exception)
            {
                t(exception.getMessage());
            }
            j++;
        }
    }

    ()
    {
        val$urls = as;
        super();
    }
}
