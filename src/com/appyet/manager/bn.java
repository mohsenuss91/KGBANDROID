// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.appyet.manager:
//            ae, bl

final class bn extends ae
{

    final bl a;

    bn(bl bl)
    {
        a = bl;
        super();
    }

    public final boolean isRedirectRequested(HttpResponse httpresponse, HttpContext httpcontext)
    {
        boolean flag = super.isRedirectRequested(httpresponse, httpcontext);
        if (!flag)
        {
            int i = httpresponse.getStatusLine().getStatusCode();
            if (i == 301 || i == 302)
            {
                flag = true;
            }
        }
        return flag;
    }
}
