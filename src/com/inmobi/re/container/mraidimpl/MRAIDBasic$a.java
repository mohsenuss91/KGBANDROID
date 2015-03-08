// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDBasic

class a
    implements Runnable
{

    final String a;
    final MRAIDBasic b;

    public void run()
    {
        String s = InternalSDKUtil.getFinalRedirectedUrl(a);
        if (s != null)
        {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(s));
            intent.addFlags(0x10000000);
            try
            {
                MRAIDBasic.a(b).startActivity(intent);
            }
            catch (Exception exception)
            {
                MRAIDBasic.b(b).raiseError("Invalid url", "open");
                return;
            }
            if (MRAIDBasic.b(b).mListener != null)
            {
                MRAIDBasic.b(b).mListener.onLeaveApplication();
            }
        }
    }

    ener(MRAIDBasic mraidbasic, String s)
    {
        b = mraidbasic;
        a = s;
        super();
    }
}
