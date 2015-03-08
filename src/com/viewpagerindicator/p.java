// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.viewpagerindicator;

import android.graphics.Paint;

// Referenced classes of package com.viewpagerindicator:
//            UnderlinePageIndicator

final class p
    implements Runnable
{

    final UnderlinePageIndicator a;

    p(UnderlinePageIndicator underlinepageindicator)
    {
        a = underlinepageindicator;
        super();
    }

    public final void run()
    {
        if (UnderlinePageIndicator.a(a))
        {
            int i = Math.max(UnderlinePageIndicator.b(a).getAlpha() - UnderlinePageIndicator.c(a), 0);
            UnderlinePageIndicator.b(a).setAlpha(i);
            a.invalidate();
            if (i > 0)
            {
                a.postDelayed(this, 30L);
                return;
            }
        }
    }
}
