// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// Referenced classes of package com.google.analytics.tracking.android:
//            Dispatcher, GoogleAnalytics, Utils, Log, 
//            Hit, HitBuilder, GANetworkReceiver

class SimpleNetworkDispatcher
    implements Dispatcher
{

    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
    private final Context ctx;
    private GoogleAnalytics gaInstance;
    private final HttpClient httpClient;
    private URL mOverrideHostUrl;
    private final String userAgent;

    SimpleNetworkDispatcher(HttpClient httpclient, Context context)
    {
        this(httpclient, GoogleAnalytics.getInstance(context), context);
    }

    SimpleNetworkDispatcher(HttpClient httpclient, GoogleAnalytics googleanalytics, Context context)
    {
        ctx = context.getApplicationContext();
        userAgent = createUserAgentString("GoogleAnalytics", "3.0", android.os.Build.VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
        httpClient = httpclient;
        gaInstance = googleanalytics;
    }

    private HttpEntityEnclosingRequest buildRequest(String s, String s1)
    {
        String s2;
        if (TextUtils.isEmpty(s))
        {
            Log.w("Empty hit, discarding.");
            return null;
        }
        s2 = (new StringBuilder()).append(s1).append("?").append(s).toString();
        if (s2.length() >= 2036) goto _L2; else goto _L1
_L1:
        BasicHttpEntityEnclosingRequest basichttpentityenclosingrequest = new BasicHttpEntityEnclosingRequest("GET", s2);
_L4:
        basichttpentityenclosingrequest.addHeader("User-Agent", userAgent);
        return basichttpentityenclosingrequest;
_L2:
        basichttpentityenclosingrequest = new BasicHttpEntityEnclosingRequest("POST", s1);
        try
        {
            basichttpentityenclosingrequest.setEntity(new StringEntity(s));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            Log.w("Encoding error, discarding hit");
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void logDebugInformation(HttpEntityEnclosingRequest httpentityenclosingrequest)
    {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer();
        org.apache.http.Header aheader[] = httpentityenclosingrequest.getAllHeaders();
        int i = aheader.length;
        for (int j = 0; j < i; j++)
        {
            stringbuffer.append(aheader[j].toString()).append("\n");
        }

        stringbuffer.append(httpentityenclosingrequest.getRequestLine().toString()).append("\n");
        if (httpentityenclosingrequest.getEntity() == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        InputStream inputstream = httpentityenclosingrequest.getEntity().getContent();
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        int k = inputstream.available();
        if (k > 0)
        {
            try
            {
                byte abyte0[] = new byte[k];
                inputstream.read(abyte0);
                stringbuffer.append("POST:\n");
                stringbuffer.append(new String(abyte0)).append("\n");
            }
            catch (IOException ioexception)
            {
                Log.v("Error Writing hit to log...");
            }
        }
        Log.v(stringbuffer.toString());
        return;
    }

    public void close()
    {
        httpClient.getConnectionManager().shutdown();
    }

    String createUserAgentString(String s, String s1, String s2, String s3, String s4, String s5)
    {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] {
            s, s1, s2, s3, s4, s5
        });
    }

    public int dispatchHits(List list)
    {
        int i;
        boolean flag;
        int j;
        int k;
        i = Math.min(list.size(), 40);
        flag = true;
        j = 0;
        k = 0;
_L2:
        HttpHost httphost;
        String s1;
        HttpEntityEnclosingRequest httpentityenclosingrequest;
        int i1;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        Hit hit = (Hit)list.get(j);
        URL url = getUrl(hit);
        if (url == null)
        {
            if (Log.isVerbose())
            {
                Log.w((new StringBuilder("No destination: discarding hit: ")).append(hit.getHitParams()).toString());
            } else
            {
                Log.w("No destination: discarding hit.");
            }
            i1 = k + 1;
        } else
        {
label0:
            {
                httphost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
                String s = url.getPath();
                if (TextUtils.isEmpty(hit.getHitParams()))
                {
                    s1 = "";
                } else
                {
                    s1 = HitBuilder.postProcessHit(hit, System.currentTimeMillis());
                }
                httpentityenclosingrequest = buildRequest(s1, s);
                if (httpentityenclosingrequest != null)
                {
                    break label0;
                }
                i1 = k + 1;
            }
        }
_L3:
        j++;
        k = i1;
        if (true) goto _L2; else goto _L1
        boolean flag1;
        httpentityenclosingrequest.addHeader("Host", httphost.toHostString());
        if (Log.isVerbose())
        {
            logDebugInformation(httpentityenclosingrequest);
        }
        int l;
        boolean flag2;
        if (s1.length() > 8192)
        {
            Log.w("Hit too long (> 8192 bytes)--not sent");
            flag1 = flag;
        } else
        {
label1:
            {
                if (!gaInstance.isDryRunEnabled())
                {
                    break label1;
                }
                Log.i("Dry run enabled. Hit not actually sent.");
                flag1 = flag;
            }
        }
_L7:
        l = k + 1;
        flag2 = flag1;
        i1 = l;
        flag = flag2;
          goto _L3
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        GANetworkReceiver.sendRadioPoweredBroadcast(ctx);
        flag1 = false;
_L9:
        HttpResponse httpresponse;
        int j1;
        HttpEntity httpentity;
        httpresponse = httpClient.execute(httphost, httpentityenclosingrequest);
        j1 = httpresponse.getStatusLine().getStatusCode();
        httpentity = httpresponse.getEntity();
        if (httpentity == null) goto _L5; else goto _L4
_L4:
        httpentity.consumeContent();
_L5:
        if (j1 == 200) goto _L7; else goto _L6
_L6:
        Log.w((new StringBuilder("Bad response: ")).append(httpresponse.getStatusLine().getStatusCode()).toString());
          goto _L7
        ClientProtocolException clientprotocolexception;
        clientprotocolexception;
_L8:
        Log.w("ClientProtocolException sending hit; discarding hit...");
          goto _L7
        IOException ioexception;
        ioexception;
        Log.w((new StringBuilder("Exception sending hit: ")).append(ioexception.getClass().getSimpleName()).toString());
        Log.w(ioexception.getMessage());
        return k;
_L1:
        return k;
        ClientProtocolException clientprotocolexception1;
        clientprotocolexception1;
        flag1 = flag;
          goto _L8
        flag1 = flag;
          goto _L9
    }

    URL getUrl(Hit hit)
    {
        String s;
        if (mOverrideHostUrl != null)
        {
            return mOverrideHostUrl;
        }
        s = hit.getHitUrlScheme();
        String s1;
        URL url;
        if ("http:".equals(s))
        {
            s1 = "http://www.google-analytics.com/collect";
        } else
        {
            s1 = "https://ssl.google-analytics.com/collect";
        }
        try
        {
            url = new URL(s1);
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
        return url;
    }

    public boolean okToDispatch()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)ctx.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            Log.v("...no network connectivity");
            return false;
        } else
        {
            return true;
        }
    }

    public void overrideHostUrl(String s)
    {
        try
        {
            mOverrideHostUrl = new URL(s);
            return;
        }
        catch (MalformedURLException malformedurlexception)
        {
            mOverrideHostUrl = null;
        }
    }
}
