// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.EndTextElementListener;
import com.appyet.data.FeedItem;

// Referenced classes of package com.appyet.b.a:
//            a

final class p
    implements EndTextElementListener
{

    final FeedItem a;
    final a b;

    p(a a1, FeedItem feeditem)
    {
        b = a1;
        a = feeditem;
        super();
    }

    public final void end(String s)
    {
        try
        {
            a.setUniqueKey(s);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
