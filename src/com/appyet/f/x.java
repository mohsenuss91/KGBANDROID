// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package com.appyet.f:
//            y

public final class x extends SSLSocketFactory
{

    SSLContext a;

    public x(KeyStore keystore)
    {
        super(keystore);
        a = SSLContext.getInstance("TLS");
        y y1 = new y(this);
        a.init(null, new TrustManager[] {
            y1
        }, null);
    }

    public final Socket createSocket()
    {
        return a.getSocketFactory().createSocket();
    }

    public final Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        return a.getSocketFactory().createSocket(socket, s, i, flag);
    }
}
