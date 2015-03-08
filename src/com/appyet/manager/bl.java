// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.appyet.a.e;
import com.appyet.a.f;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.j;
import com.appyet.f.x;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package com.appyet.manager:
//            bm, bn, ar, bo

public final class bl
{

    public static String a = "esaza6apret";
    private ApplicationContext b;
    private int c;
    private int d;

    public bl(ApplicationContext applicationcontext)
    {
        b = applicationcontext;
        c = 46000;
        d = 46000;
    }

    public static String a(String s)
    {
label0:
        {
            String s1;
            String s2;
            try
            {
                s1 = (new URL(s)).getHost();
                if (s1.indexOf('.') == s1.lastIndexOf('.'))
                {
                    break label0;
                }
                s2 = s1.substring(1 + s1.indexOf('.'));
            }
            catch (Exception exception)
            {
                com.appyet.d.d.a(exception);
                return null;
            }
            s1 = s2;
        }
        return s1;
    }

    private static void a(DefaultHttpClient defaulthttpclient)
    {
        if (defaulthttpclient == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        if (defaulthttpclient.getConnectionManager() != null)
        {
            defaulthttpclient.getConnectionManager().shutdown();
        }
        return;
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        return;
    }

    public static boolean a(f f1)
    {
        return f1 != null && f1.b != null && f1.f == 200;
    }

    private DefaultHttpClient b()
    {
        DefaultHttpClient defaulthttpclient;
        try
        {
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(null, null);
            x x1 = new x(keystore);
            x1.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            BasicHttpParams basichttpparams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
            HttpConnectionParams.setConnectionTimeout(basichttpparams, c);
            HttpConnectionParams.setSoTimeout(basichttpparams, d);
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", x1, 443));
            defaulthttpclient = new DefaultHttpClient(new SingleClientConnManager(basichttpparams, schemeregistry), basichttpparams);
            defaulthttpclient.setHttpRequestRetryHandler(new bm(this));
            defaulthttpclient.setRedirectHandler(new bn(this));
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return new DefaultHttpClient();
        }
        return defaulthttpclient;
    }

    public static void b(f f1)
    {
        if (f1 != null)
        {
            a(f1.a);
        }
    }

    public final f a(com.appyet.a.d d1)
    {
        HttpEntity httpentity;
        f f1;
        httpentity = null;
        f1 = new f();
        if (d1.a == null)
        {
            return null;
        }
        URI uri = new URI(d1.a.replace(" ", "%20"));
        if (d1.f != e.a) goto _L2; else goto _L1
_L1:
        HttpGet httpget;
        httpget = new HttpGet(uri);
        if (d1.b != null && d1.b.length() > 0 && d1.c != null)
        {
            String s2 = j.b((new StringBuilder()).append(d1.b).append(":").append(d1.c).toString());
            httpget.setHeader("Authorization", (new StringBuilder("Basic ")).append(s2).toString());
        }
        httpget.addHeader("Connection", "keep-alive");
        httpget.addHeader("Accept-Encoding", "gzip");
        httpget.addHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.3");
        httpget.addHeader("Accept", "application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        httpget.addHeader("User-Agent", b.v);
        httpget.addHeader("Accept-Language", ar.c(b));
        if (d1.e == null || d1.e.equals("")) goto _L4; else goto _L3
_L3:
        httpget.addHeader("If-None-Match", d1.e);
_L7:
        NameValuePair namevaluepair2;
        for (Iterator iterator = d1.g.iterator(); iterator.hasNext(); httpget.addHeader(namevaluepair2.getName(), namevaluepair2.getValue()))
        {
            namevaluepair2 = (NameValuePair)iterator.next();
        }

          goto _L5
        NoHttpResponseException nohttpresponseexception;
        nohttpresponseexception;
        DefaultHttpClient defaulthttpclient1;
        Object obj1;
        defaulthttpclient1 = null;
        obj1 = null;
_L30:
        Exception exception;
        HttpEntity httpentity1;
        DefaultHttpClient defaulthttpclient;
        Object obj;
        String s;
        f1.f = 504;
        DefaultHttpClient defaulthttpclient2;
        HttpResponse httpresponse;
        HttpResponse httpresponse1;
        Header header;
        Header header1;
        Header header2;
        Header header3;
        HeaderElement aheaderelement[];
        Header header4;
        Header header5;
        HttpEntity httpentity2;
        GZIPInputStream gzipinputstream;
        InputStream inputstream;
        NameValuePair namevaluepair;
        boolean flag;
        NumberFormatException numberformatexception1;
        Iterator iterator1;
        String s1;
        NameValuePair namevaluepair1;
        HttpPost httppost;
        Iterator iterator2;
        DefaultHttpClient defaulthttpclient3;
        HttpResponse httpresponse2;
        Iterator iterator3;
        String s3;
        NameValuePair namevaluepair3;
        NameValuePair namevaluepair4;
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            catch (Exception exception4)
            {
                com.appyet.d.d.a(exception4);
            }
        }
        if (httpentity != null)
        {
            try
            {
                httpentity.consumeContent();
            }
            catch (Exception exception3)
            {
                com.appyet.d.d.a(exception3);
            }
        }
        a(defaulthttpclient1);
        com.appyet.d.d.a(nohttpresponseexception);
        return f1;
_L4:
        if (d1.d == null || d1.d.equals("")) goto _L7; else goto _L6
_L6:
        httpget.addHeader("If-Modified-Since", d1.d);
          goto _L7
        exception;
        httpentity1 = null;
        defaulthttpclient = null;
        obj = null;
_L29:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (Exception exception2)
            {
                com.appyet.d.d.a(exception2);
            }
        }
        if (httpentity1 != null)
        {
            try
            {
                httpentity1.consumeContent();
            }
            catch (Exception exception1)
            {
                com.appyet.d.d.a(exception1);
            }
        }
        a(defaulthttpclient);
        com.appyet.d.d.a(exception);
        return null;
_L5:
        if (d1.h.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_536;
        }
        iterator1 = d1.h.iterator();
        s1 = "";
        while (iterator1.hasNext()) 
        {
            namevaluepair1 = (NameValuePair)iterator1.next();
            s1 = (new StringBuilder()).append(s1).append(namevaluepair1.getName()).append("=").append(namevaluepair1.getValue()).toString();
        }
        httpget.setHeader("Cookie", s1);
        defaulthttpclient2 = b();
        defaulthttpclient1 = defaulthttpclient2;
        httpresponse = defaulthttpclient1.execute(httpget);
        defaulthttpclient = defaulthttpclient1;
        httpresponse1 = httpresponse;
_L24:
        header = httpresponse1.getFirstHeader("Content-Encoding");
        header1 = httpresponse1.getFirstHeader("Content-Length");
        if (header1 == null) goto _L9; else goto _L8
_L8:
        f1.e = Long.parseLong(header1.getValue());
_L25:
        header2 = httpresponse1.getFirstHeader("Location");
        if (header2 == null) goto _L11; else goto _L10
_L10:
        if (header2.getValue() == null) goto _L11; else goto _L12
_L12:
        flag = header2.getValue().trim().equals("");
        if (flag) goto _L11; else goto _L13
_L13:
        f1.i = (new URL(header2.getValue().trim())).toString();
_L26:
        header3 = httpresponse1.getFirstHeader("Content-Type");
        if (header3 == null) goto _L15; else goto _L14
_L14:
        aheaderelement = header3.getElements();
        if (aheaderelement.length != 1) goto _L15; else goto _L16
_L16:
        namevaluepair = aheaderelement[0].getParameterByName("charset");
        if (namevaluepair == null) goto _L15; else goto _L17
_L17:
        s = namevaluepair.getValue();
_L32:
        if (s == null) goto _L19; else goto _L18
_L18:
        f1.d = s;
_L27:
        if (header3 == null) goto _L21; else goto _L20
_L20:
        f1.c = header3.getValue();
_L28:
        if (httpresponse1.getStatusLine() != null)
        {
            f1.f = httpresponse1.getStatusLine().getStatusCode();
        }
        header4 = httpresponse1.getFirstHeader("Last-Modified");
        if (header4 == null)
        {
            break MISSING_BLOCK_LABEL_822;
        }
        f1.g = header4.getValue();
        header5 = httpresponse1.getFirstHeader("ETag");
        if (header5 == null)
        {
            break MISSING_BLOCK_LABEL_850;
        }
        f1.h = header5.getValue();
        httpentity2 = httpresponse1.getEntity();
        httpentity1 = httpentity2;
        if (httpentity1 == null) goto _L23; else goto _L22
_L22:
        inputstream = httpentity1.getContent();
        obj = inputstream;
_L31:
        if (header == null)
        {
            break MISSING_BLOCK_LABEL_917;
        }
        if (!header.getValue().equalsIgnoreCase("gzip"))
        {
            break MISSING_BLOCK_LABEL_917;
        }
        gzipinputstream = new GZIPInputStream(((InputStream) (obj)));
        obj = gzipinputstream;
        f1.b = ((InputStream) (obj));
        f1.a = defaulthttpclient;
        return f1;
_L2:
        httppost = new HttpPost(d1.a);
        httppost.addHeader("Connection", "keep-alive");
        httppost.addHeader("Accept-Encoding", "gzip");
        httppost.addHeader("Accept-Charset", "ISO-8859-1,utf-8");
        httppost.addHeader("Accept", "application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        httppost.addHeader("User-Agent", b.v);
        for (iterator2 = d1.g.iterator(); iterator2.hasNext(); httppost.addHeader(namevaluepair4.getName(), namevaluepair4.getValue()))
        {
            namevaluepair4 = (NameValuePair)iterator2.next();
        }

        if (d1.h.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_1164;
        }
        iterator3 = d1.h.iterator();
        s3 = "";
        while (iterator3.hasNext()) 
        {
            namevaluepair3 = (NameValuePair)iterator3.next();
            s3 = (new StringBuilder()).append(s3).append(namevaluepair3.getName()).append("=").append(namevaluepair3.getValue()).toString();
        }
        httppost.setHeader("Cookie", s3);
        httppost.setEntity(new UrlEncodedFormEntity(d1.i, "UTF-8"));
        defaulthttpclient3 = b();
        defaulthttpclient1 = defaulthttpclient3;
        httpresponse2 = defaulthttpclient1.execute(null);
        defaulthttpclient = defaulthttpclient1;
        httpresponse1 = httpresponse2;
          goto _L24
        numberformatexception1;
_L9:
        f1.e = -1L;
          goto _L25
_L11:
        f1.i = null;
          goto _L26
_L19:
        f1.d = null;
          goto _L27
_L21:
        f1.c = "text/plain";
          goto _L28
        exception;
        defaulthttpclient = defaulthttpclient1;
        httpentity1 = null;
        obj = null;
          goto _L29
        exception;
        obj = null;
          goto _L29
        exception;
          goto _L29
        nohttpresponseexception;
        httpentity = null;
        obj1 = null;
          goto _L30
        nohttpresponseexception;
        HttpEntity httpentity3 = httpentity1;
        defaulthttpclient1 = defaulthttpclient;
        httpentity = httpentity3;
        obj1 = null;
          goto _L30
        nohttpresponseexception;
        httpentity = httpentity1;
        defaulthttpclient1 = defaulthttpclient;
        obj1 = obj;
          goto _L30
        nohttpresponseexception;
        httpentity = httpentity1;
        defaulthttpclient1 = defaulthttpclient;
        obj1 = obj;
          goto _L30
_L23:
        obj = null;
          goto _L31
_L15:
        s = null;
          goto _L32
        nohttpresponseexception;
        defaulthttpclient1 = defaulthttpclient;
        httpentity = null;
        obj1 = null;
          goto _L30
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L11
        exception;
        httpentity1 = null;
        obj = null;
          goto _L29
    }

    public final bo a()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)b.getSystemService("connectivity");
        bo bo1;
        try
        {
            if (connectivitymanager.getActiveNetworkInfo() == null || !connectivitymanager.getActiveNetworkInfo().isConnectedOrConnecting())
            {
                return bo.a;
            }
            NetworkInfo networkinfo = connectivitymanager.getNetworkInfo(1);
            NetworkInfo networkinfo1 = connectivitymanager.getNetworkInfo(0);
            if (networkinfo.isConnected())
            {
                return bo.b;
            }
            if (networkinfo1.isConnectedOrConnecting())
            {
                return bo.c;
            }
            bo1 = com.appyet.manager.bo.d;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return bo.a;
        }
        return bo1;
    }

}
