// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;

import com.appyet.g.a.a;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

// Referenced classes of package com.appyet.g:
//            g, j, l, n, 
//            q, b, a, c, 
//            e, k, p, f

final class i extends Thread
{

    final g a;
    private f b;
    private long c;
    private String d;
    private Object e[];
    private volatile boolean f;
    private HttpURLConnection g;

    public i(g g1)
    {
        a = g1;
        super();
    }

    private HttpURLConnection a(URLConnection urlconnection)
    {
        int i1;
        i1 = 0;
        if (!(urlconnection instanceof HttpURLConnection))
        {
            throw new IllegalArgumentException("The URL is not valid for a http connection.");
        }
        if (!(urlconnection instanceof HttpsURLConnection)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = (HttpsURLConnection)urlconnection;
        if (a.a(64))
        {
            ((HttpsURLConnection) (obj)).setHostnameVerifier(new j(this));
        }
        if (a.g == null) goto _L4; else goto _L3
_L3:
        String as[];
        int j1;
        try
        {
            as = (new String[] {
                "TLS", "SSL"
            });
            j1 = as.length;
        }
        catch (Exception exception)
        {
            throw new l(exception);
        }
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        SSLContext sslcontext = SSLContext.getInstance(as[i1]);
        sslcontext.init(a.h, a.g, new SecureRandom());
        ((HttpsURLConnection) (obj)).setSSLSocketFactory(sslcontext.getSocketFactory());
        i1++;
        if (true) goto _L5; else goto _L4
_L5:
        break MISSING_BLOCK_LABEL_86;
_L2:
        obj = (HttpURLConnection)urlconnection;
_L4:
        return ((HttpURLConnection) (obj));
    }

    public final Object a(String s, Object aobj[])
    {
        b b1;
        URLConnection urlconnection;
        com.appyet.g.a a1;
        HttpURLConnection httpurlconnection;
        int i1;
        Object obj;
        boolean flag;
        String s1;
        URL url;
        Object obj1;
        Object obj2;
        java.io.InputStream inputstream;
        int j1;
        try
        {
            if (a.a(1) && !s.matches("^[A-Za-z0-9\\._:/]*$"))
            {
                throw new n("Method name must only contain A-Z a-z . : _ / ");
            }
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            throw new q("The XMLRPC call timed out.");
        }
        catch (IOException ioexceptionIOException ioexception1, )
        {
            if (!f || c <= 0L)
            {
                throw new l(ioexception);
            } else
            {
                throw new k(a, (byte)0);
            }
        }
        b1 = new b(s, aobj);
        if (a.i == null)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        urlconnection = a.a.openConnection(a.i);
_L1:
        g = a(urlconnection);
        g.setInstanceFollowRedirects(false);
        g.setRequestMethod("POST");
        g.setDoOutput(true);
        g.setDoInput(true);
        if (a.j > 0)
        {
            g.setConnectTimeout(1000 * a.j);
            g.setReadTimeout(1000 * a.j);
        }
        java.util.Map.Entry entry;
        for (Iterator iterator = a.b.entrySet().iterator(); iterator.hasNext(); g.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_283;
        urlconnection = a.a.openConnection();
          goto _L1
        a1 = a.f;
        httpurlconnection = g;
        if (a1. != null && a1.b != null && a1..length() > 0 && a1.b.length() > 0) goto _L3; else goto _L2
_L2:
        a.e.b(g);
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(g.getOutputStream());
        outputstreamwriter.write(b1.a());
        outputstreamwriter.flush();
        outputstreamwriter.close();
        j1 = g.getResponseCode();
        i1 = j1;
_L13:
        if (i1 != 403 && i1 != 401) goto _L5; else goto _L4
_L4:
        if (!a.a(16)) goto _L7; else goto _L6
_L6:
        obj = g.getErrorStream();
          goto _L8
_L16:
        if (!a.a(32)) goto _L10; else goto _L9
_L9:
        if (i1 == 302)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s1 = g.getHeaderField("Location");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_487;
        }
        if (s1.length() > 0)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        s1 = g.getHeaderField("location");
        url = a.a;
        a.a = new URL(s1);
        g.disconnect();
        obj1 = a(s, aobj);
        if (!flag) goto _L12; else goto _L11
_L11:
        a.a = url;
        return obj1;
_L3:
        String s2 = com.appyet.g.a.a.b((new StringBuilder()).append(a1.).append(":").append(a1.b).toString());
        httpurlconnection.addRequestProperty("Authorization", (new StringBuilder("Basic ")).append(s2).toString());
        continue; /* Loop/switch isn't completed */
        ioexception1;
        i1 = g.getResponseCode();
          goto _L13
_L7:
        throw new l((new StringBuilder("Invalid status code '")).append(i1).append("' returned from server.").toString());
_L5:
        inputstream = g.getInputStream();
        if (!"gzip".equals(urlconnection.getContentEncoding())) goto _L15; else goto _L14
_L14:
        obj = new GZIPInputStream(inputstream);
          goto _L8
_L10:
        throw new l("The server responded with a http 301 or 302 status code, but forwarding has not been enabled (FLAGS_FORWARD).");
_L17:
        if (a.a(16) || i1 == 200)
        {
            break MISSING_BLOCK_LABEL_747;
        }
        throw new l("The status code of the http response must be 200.");
        if (a.a(1) && !g.getContentType().startsWith("text/xml; charset=utf-8"))
        {
            throw new l("The Content-Type of the response must be text/xml.");
        }
        a.e.a(g);
        obj2 = a.d.a(((java.io.InputStream) (obj)));
        return obj2;
_L15:
        obj = inputstream;
_L8:
        if (i1 != 301 && i1 != 302) goto _L17; else goto _L16
_L12:
        return obj1;
        if (true) goto _L2; else goto _L18
_L18:
    }

    public final void run()
    {
        if (b == null)
        {
            return;
        }
        a.c.put(Long.valueOf(c), this);
        a(d, e);
        b;
        c;
        Map map;
        Long long1;
        map = a.c;
        long1 = Long.valueOf(c);
_L2:
        map.remove(long1);
        return;
        p p1;
        p1;
        b;
        c;
        map = a.c;
        long1 = Long.valueOf(c);
        continue; /* Loop/switch isn't completed */
        l l1;
        l1;
        b;
        c;
        map = a.c;
        long1 = Long.valueOf(c);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        a.c.remove(Long.valueOf(c));
        throw exception;
        k k1;
        k1;
        map = a.c;
        long1 = Long.valueOf(c);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
