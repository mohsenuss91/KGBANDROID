// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;

import android.sax.EndTextElementListener;
import com.appyet.data.Feed;

// Referenced classes of package com.appyet.b.a:
//            w

final class ai
    implements EndTextElementListener
{

    final w a;

    ai(w w1)
    {
        a = w1;
        super();
    }

    public final void end(String s)
    {
        a.f.setWebLink(s);
    }
}
