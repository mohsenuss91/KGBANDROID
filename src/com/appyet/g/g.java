// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;

import com.appyet.g.b.j;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

// Referenced classes of package com.appyet.g:
//            e, c, a, h, 
//            i, n

public final class g
{

    URL a;
    Map b;
    Map c;
    e d;
    public c e;
    a f;
    TrustManager g[];
    KeyManager h[];
    Proxy i;
    public int j;
    private final int k;

    public g(URL url)
    {
        this(url, "aXMLRPC");
    }

    private g(URL url, String s)
    {
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        j.a = new j();
        a = url;
        k = 4;
        d = new e();
        e = new c();
        f = new a();
        b.put("Content-Type", "text/xml; charset=utf-8");
        b.put("User-Agent", s);
        if (a(128))
        {
            TrustManager atrustmanager[] = new TrustManager[1];
            atrustmanager[0] = new h(this);
            g = atrustmanager;
        }
        if (a(1024))
        {
            Properties properties = System.getProperties();
            String s1 = properties.getProperty("http.proxyHost");
            int l = Integer.parseInt(properties.getProperty("http.proxyPort", "0"));
            if (l > 0 && s1.length() > 0 && !s1.equals("null"))
            {
                i = new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(s1, l));
            }
        }
    }

    public final transient Object a(String s, Object aobj[])
    {
        return (new i(this)).a(s, aobj);
    }

    public final void a(String s)
    {
        b.put("User-Agent", s);
    }

    public final void a(String s, String s1)
    {
        if ("Content-Type".equals(s) || "Host".equals(s) || "Content-Length".equals(s))
        {
            throw new n("You cannot modify the Host, Content-Type or Content-Length header.");
        } else
        {
            b.put(s, s1);
            return;
        }
    }

    public final void a(Map map)
    {
        c c1 = e;
        if ((4 & c1.a) != 0)
        {
            c1.b = map;
        }
    }

    final boolean a(int l)
    {
        return (l & k) != 0;
    }
}
