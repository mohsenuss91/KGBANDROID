// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.View;
import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDResizeController

class a
    implements android.view.IDResizeController.a
{

    final MRAIDResizeController a;

    public void onClick(View view)
    {
        IMWebView.userInitiatedClose = true;
        MRAIDResizeController.a(a).close();
    }

    (MRAIDResizeController mraidresizecontroller)
    {
        a = mraidresizecontroller;
        super();
    }
}
