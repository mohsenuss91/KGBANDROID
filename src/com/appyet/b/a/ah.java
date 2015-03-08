// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.EndTextElementListener;
import com.appyet.d.a;
import com.appyet.data.FeedItem;

// Referenced classes of package com.appyet.b.a:
//            w

final class ah
    implements EndTextElementListener
{

    final FeedItem a;
    final w b;

    ah(w w, FeedItem feeditem)
    {
        b = w;
        a = feeditem;
        super();
    }

    public final void end(String s)
    {
        a.setEnclosureDuration(Integer.valueOf(com.appyet.d.a.a(s)));
    }
}
