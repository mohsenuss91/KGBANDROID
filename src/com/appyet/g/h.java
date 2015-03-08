// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package com.appyet.g:
//            g

final class h
    implements X509TrustManager
{

    final g a;

    h(g g)
    {
        a = g;
        super();
    }

    public final void checkClientTrusted(X509Certificate ax509certificate[], String s)
    {
    }

    public final void checkServerTrusted(X509Certificate ax509certificate[], String s)
    {
    }

    public final X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }
}
