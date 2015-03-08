// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.content.DialogInterface;
import android.net.http.SslError;
import com.inmobi.commons.internal.WrapperFunctions;

// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class a
    implements android.content.ace.OnClickListener
{

    final SslError a;
    final IMWebView b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        IMWebView.a(b, WrapperFunctions.getSSLErrorUrl(a));
    }

    unctions(IMWebView imwebview, SslError sslerror)
    {
        b = imwebview;
        a = sslerror;
        super();
    }
}
