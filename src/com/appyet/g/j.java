// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

// Referenced classes of package com.appyet.g:
//            i

final class j
    implements HostnameVerifier
{

    final i a;

    j(i i)
    {
        a = i;
        super();
    }

    public final boolean verify(String s, SSLSession sslsession)
    {
        return true;
    }
}
