// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.EndTextElementListener;
import com.appyet.data.FeedItem;

// Referenced classes of package com.appyet.b.a:
//            ay

final class bo
    implements EndTextElementListener
{

    final FeedItem a;
    final ay b;

    bo(ay ay, FeedItem feeditem)
    {
        b = ay;
        a = feeditem;
        super();
    }

    public final void end(String s)
    {
        String s1 = a.getDescription();
        if (s1 == null || s1.trim() == "" || s.length() > s1.length())
        {
            a.setDescription(s);
        }
    }
}
