// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDExpandController

class a
    implements Runnable
{

    final MRAIDExpandController a;

    public void run()
    {
        if (MRAIDExpandController.a(a).mListener != null)
        {
            MRAIDExpandController.a(a).mListener.onExpand();
        }
    }

    (MRAIDExpandController mraidexpandcontroller)
    {
        a = mraidexpandcontroller;
        super();
    }
}
