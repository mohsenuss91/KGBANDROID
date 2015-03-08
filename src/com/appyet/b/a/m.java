// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.EndTextElementListener;
import com.appyet.data.Feed;

// Referenced classes of package com.appyet.b.a:
//            a

final class m
    implements EndTextElementListener
{

    final a a;

    m(a a1)
    {
        a = a1;
        super();
    }

    public final void end(String s)
    {
        try
        {
            if (a.f.getPubDateString() == null)
            {
                a.f.setPubDateString(s);
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
