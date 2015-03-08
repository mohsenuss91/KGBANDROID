// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MetricEndPoint
{

    public MetricEndPoint()
    {
    }

    public static void sendData(String s, String s1)
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        InternalSDKUtil.addCommonPropertiesToConnection(httpurlconnection);
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setDoInput(false);
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(httpurlconnection.getOutputStream());
        outputstreamwriter.write(s1);
        outputstreamwriter.flush();
        outputstreamwriter.close();
        httpurlconnection.getResponseCode();
    }
}
