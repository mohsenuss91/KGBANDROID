// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.android.gms.tagmanager:
//            bl

class aw
    implements bl
{

    private HttpURLConnection afM;

    aw()
    {
    }

    private InputStream a(HttpURLConnection httpurlconnection)
    {
        int i = httpurlconnection.getResponseCode();
        if (i == 200)
        {
            return httpurlconnection.getInputStream();
        }
        String s = (new StringBuilder("Bad response: ")).append(i).toString();
        if (i == 404)
        {
            throw new FileNotFoundException(s);
        } else
        {
            throw new IOException(s);
        }
    }

    private void b(HttpURLConnection httpurlconnection)
    {
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
    }

    public InputStream bV(String s)
    {
        afM = bW(s);
        return a(afM);
    }

    HttpURLConnection bW(String s)
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        httpurlconnection.setReadTimeout(20000);
        httpurlconnection.setConnectTimeout(20000);
        return httpurlconnection;
    }

    public void close()
    {
        b(afM);
    }
}
