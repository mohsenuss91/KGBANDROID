// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDResizeController

class a
    implements Runnable
{

    final MRAIDResizeController a;

    public void run()
    {
        if (MRAIDResizeController.a(a).mListener != null)
        {
            MRAIDResizeController.a(a).mListener.onResize(MRAIDResizeController.b(a));
        }
    }

    (MRAIDResizeController mraidresizecontroller)
    {
        a = mraidresizecontroller;
        super();
    }
}
