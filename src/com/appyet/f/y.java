// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

// Referenced classes of package com.appyet.f:
//            x

final class y
    implements X509TrustManager
{

    final x a;

    y(x x)
    {
        a = x;
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
