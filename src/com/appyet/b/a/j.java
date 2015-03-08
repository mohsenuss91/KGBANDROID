// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.EndTextElementListener;
import com.appyet.data.FeedItem;

// Referenced classes of package com.appyet.b.a:
//            a

final class j
    implements EndTextElementListener
{

    final FeedItem a;
    final a b;

    j(a a1, FeedItem feeditem)
    {
        b = a1;
        a = feeditem;
        super();
    }

    public final void end(String s)
    {
        String s1;
        try
        {
            s1 = a.getDescription();
        }
        catch (Exception exception)
        {
            return;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        if (s1.trim() != "" && s.length() <= s1.length())
        {
            break MISSING_BLOCK_LABEL_40;
        }
        a.setDescription(s);
    }
}
