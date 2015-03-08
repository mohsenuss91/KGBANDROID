// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

class HttpGetRequest
{

    private HttpClient client;
    private HttpGet getRequest;

    HttpGetRequest()
    {
        client = new DefaultHttpClient();
        getRequest = new HttpGet();
    }

    static String convertStreamToString(InputStream inputstream)
    {
        if (inputstream == null)
        {
            throw new IOException("Stream is null.");
        }
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream), 4096);
        StringBuilder stringbuilder = new StringBuilder();
_L3:
        String s = bufferedreader.readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L3
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
_L7:
        MMSDK.Log.d(outofmemoryerror);
        throw new IOException("Out of memory.");
        Exception exception;
        exception;
_L5:
        IOException ioexception1;
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            catch (IOException ioexception)
            {
                MMSDK.Log.d(ioexception);
            }
        }
        throw exception;
_L2:
        try
        {
            bufferedreader.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception1)
        {
            MMSDK.Log.d(ioexception1);
        }
        return stringbuilder.toString();
        exception;
        bufferedreader = null;
        if (true) goto _L5; else goto _L4
_L4:
        outofmemoryerror;
        bufferedreader = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static void log(final String urls[])
    {
        if (urls != null && urls.length > 0)
        {
            Utils.ThreadUtils.execute(new _cls1());
        }
    }

    HttpResponse get(String s)
    {
        boolean flag = TextUtils.isEmpty(s);
        HttpResponse httpresponse = null;
        if (!flag)
        {
            HttpResponse httpresponse1;
            try
            {
                getRequest.setURI(new URI(s));
                httpresponse1 = client.execute(getRequest);
            }
            catch (OutOfMemoryError outofmemoryerror)
            {
                MMSDK.Log.e("Out of memory!");
                return null;
            }
            httpresponse = httpresponse1;
        }
        return httpresponse;
    }

    void trackConversion(String s, boolean flag, long l, TreeMap treemap)
    {
        StringBuilder stringbuilder;
        int i;
        Iterator iterator;
        java.util.Map.Entry entry;
        Object aobj3[];
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        try
        {
            stringbuilder = new StringBuilder((new StringBuilder("http://cvt.mydas.mobi/handleConversion?firstlaunch=")).append(i).toString());
        }
        catch (IOException ioexception)
        {
            Object aobj[] = new Object[1];
            aobj[0] = ioexception.getMessage();
            MMSDK.Log.e("Conversion tracking error: %s", aobj);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        stringbuilder.append((new StringBuilder("&goalId=")).append(s).toString());
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        stringbuilder.append((new StringBuilder("&installtime=")).append(l / 1000L).toString());
        if (treemap == null)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        for (iterator = treemap.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(String.format("&%s=%s", aobj3)))
        {
            entry = (java.util.Map.Entry)iterator.next();
            aobj3 = new Object[2];
            aobj3[0] = entry.getKey();
            aobj3[1] = URLEncoder.encode((String)entry.getValue(), "UTF-8");
        }

        HttpResponse httpresponse;
        String s1 = stringbuilder.toString();
        MMSDK.Log.d("Sending conversion tracker report: %s", new Object[] {
            s1
        });
        getRequest.setURI(new URI(s1));
        httpresponse = client.execute(getRequest);
        if (httpresponse.getStatusLine().getStatusCode() == 200)
        {
            Object aobj2[] = new Object[1];
            aobj2[0] = Integer.valueOf(httpresponse.getStatusLine().getStatusCode());
            MMSDK.Log.v("Successful conversion tracking event: %d", aobj2);
            return;
        }
        Object aobj1[] = new Object[1];
        aobj1[0] = Integer.valueOf(httpresponse.getStatusLine().getStatusCode());
        MMSDK.Log.e("Conversion tracking error: %d", aobj1);
        return;
    }

    private class _cls1
        implements Runnable
    {

        final String val$urls[];

        public final void run()
        {
            String as[] = urls;
            int i = as.length;
            int j = 0;
            while (j < i) 
            {
                String s = as[j];
                MMSDK.Log.v("Logging event to: %s", new Object[] {
                    s
                });
                try
                {
                    (new HttpGetRequest()).get(s);
                }
                catch (Exception exception)
                {
                    MMSDK.Log.v(exception.getMessage());
                }
                j++;
            }
        }

        _cls1()
        {
            urls = as;
            super();
        }
    }

}
