// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.List;

// Referenced classes of package com.google.analytics.tracking.android:
//            Dispatcher, Log, Hit, HitBuilder

class NoopDispatcher
    implements Dispatcher
{

    NoopDispatcher()
    {
    }

    public void close()
    {
    }

    public int dispatchHits(List list)
    {
        if (list == null)
        {
            return 0;
        }
        int i = Math.min(list.size(), 40);
        if (Log.isVerbose())
        {
            Log.v("Hits not actually being sent as dispatch is false...");
            int j = 0;
            while (j < i) 
            {
                String s;
                String s1;
                if (TextUtils.isEmpty(((Hit)list.get(j)).getHitParams()))
                {
                    s = "";
                } else
                {
                    s = HitBuilder.postProcessHit((Hit)list.get(j), System.currentTimeMillis());
                }
                if (TextUtils.isEmpty(s))
                {
                    s1 = "Hit couldn't be read, wouldn't be sent:";
                } else
                if (s.length() <= 2036)
                {
                    s1 = "GET would be sent:";
                } else
                if (s.length() > 8192)
                {
                    s1 = "Would be too big:";
                } else
                {
                    s1 = "POST would be sent:";
                }
                Log.v((new StringBuilder()).append(s1).append(s).toString());
                j++;
            }
        }
        return i;
    }

    public boolean okToDispatch()
    {
        return true;
    }

    public void overrideHostUrl(String s)
    {
    }
}
