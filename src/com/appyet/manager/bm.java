// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.appyet.manager:
//            bl

final class bm
    implements HttpRequestRetryHandler
{

    final bl a;

    bm(bl bl)
    {
        a = bl;
        super();
    }

    public final boolean retryRequest(IOException ioexception, int i, HttpContext httpcontext)
    {
        return i <= 0;
    }
}
