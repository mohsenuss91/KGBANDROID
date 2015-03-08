// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.net;

import android.util.Log;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AnalyticsCommon
{

    public AnalyticsCommon()
    {
    }

    private static void a(HttpURLConnection httpurlconnection)
    {
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setDoInput(true);
        httpurlconnection.setConnectTimeout(60000);
        httpurlconnection.setReadTimeout(60000);
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        InternalSDKUtil.addCommonPropertiesToConnection(httpurlconnection);
    }

    public static String getURLEncoded(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8");
        }
        catch (Exception exception)
        {
            return "";
        }
        return s1;
    }

    public void closeResource(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        IOException ioexception;
        ioexception;
        Log.d("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Exception closing resource: ")).append(closeable).toString(), ioexception);
        return;
    }

    public void postData(HttpURLConnection httpurlconnection, String s)
    {
        httpurlconnection.setRequestProperty("Content-Length", Integer.toString(s.length()));
        BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(httpurlconnection.getOutputStream()));
        bufferedwriter.write(s);
        closeResource(bufferedwriter);
        return;
        Exception exception;
        exception;
        bufferedwriter = null;
_L2:
        closeResource(bufferedwriter);
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public HttpURLConnection setupConnection(String s)
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        a(httpurlconnection);
        return httpurlconnection;
    }
}
