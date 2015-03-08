// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class a
    implements Runnable
{

    final IMWebView a;

    public void run()
    {
        if (a.getParent() != null)
        {
            ((ViewGroup)a.getParent()).removeView(a);
        }
        a.b.set(true);
        IMWebView.o(a);
    }

    olean(IMWebView imwebview)
    {
        a = imwebview;
        super();
    }
}
