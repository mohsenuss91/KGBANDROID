// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package com.adsdk.sdk:
//            RequestException, Log, AdRequest

public abstract class RequestAd
{

    InputStream is;

    public RequestAd()
    {
    }

    abstract Object parse(InputStream inputstream, boolean flag);

    abstract Object parseTestString();

    public Object sendRequest(AdRequest adrequest)
    {
        if (is != null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        Log.d("Parse Real");
        String s = adrequest.toString();
        Log.d((new StringBuilder("Ad RequestPerform HTTP Get Url: ")).append(s).toString());
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        HttpConnectionParams.setSoTimeout(defaulthttpclient.getParams(), 10000);
        HttpConnectionParams.setConnectionTimeout(defaulthttpclient.getParams(), 10000);
        HttpProtocolParams.setUserAgent(defaulthttpclient.getParams(), adrequest.getUserAgent());
        HttpGet httpget = new HttpGet(s);
        httpget.setHeader("User-Agent", System.getProperty("http.agent"));
        HttpResponse httpresponse;
        int i;
        try
        {
            httpresponse = defaulthttpclient.execute(httpget);
            i = httpresponse.getStatusLine().getStatusCode();
        }
        catch (RequestException requestexception)
        {
            throw requestexception;
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            throw new RequestException("Error in HTTP request", clientprotocolexception);
        }
        catch (IOException ioexception)
        {
            throw new RequestException("Error in HTTP request", ioexception);
        }
        catch (Throwable throwable)
        {
            throw new RequestException("Error in HTTP request", throwable);
        }
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        return parse(httpresponse.getEntity().getContent(), adrequest.isVideoRequest());
        throw new RequestException((new StringBuilder("Server Error. Response code:")).append(i).toString());
        Log.d("Parse Injected");
        return parseTestString();
    }
}
