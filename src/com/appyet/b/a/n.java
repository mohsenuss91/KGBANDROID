// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.EndElementListener;
import com.appyet.data.FeedItem;
import java.util.List;

// Referenced classes of package com.appyet.b.a:
//            a

final class n
    implements EndElementListener
{

    final FeedItem a;
    final a b;

    n(a a1, FeedItem feeditem)
    {
        b = a1;
        a = feeditem;
        super();
    }

    public final void end()
    {
        try
        {
            FeedItem feeditem = a.copy();
            feeditem.setFeed(b.f);
            b.g.add(feeditem);
            a.clear();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
