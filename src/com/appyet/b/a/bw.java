// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.EndElementListener;
import com.appyet.data.FeedItem;
import java.util.List;

// Referenced classes of package com.appyet.b.a:
//            ay

final class bw
    implements EndElementListener
{

    final FeedItem a;
    final ay b;

    bw(ay ay1, FeedItem feeditem)
    {
        b = ay1;
        a = feeditem;
        super();
    }

    public final void end()
    {
        FeedItem feeditem = a.copy();
        feeditem.setFeed(b.f);
        b.g.add(feeditem);
        a.clear();
    }
}
