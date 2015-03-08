// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.EndTextElementListener;
import com.appyet.data.FeedItem;

// Referenced classes of package com.appyet.b.a:
//            w

final class aq
    implements EndTextElementListener
{

    final FeedItem a;
    final w b;

    aq(w w, FeedItem feeditem)
    {
        b = w;
        a = feeditem;
        super();
    }

    public final void end(String s)
    {
        try
        {
            if (a.getPubDateString() == null || a.getPubDateString().compareTo(s) < -1)
            {
                a.setPubDateString(s);
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
