// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.adsdk.sdk.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.adsdk.sdk.video:
//            WebFrame, WebViewClient

class userAgent extends AsyncTask
{

    final WebFrame this$0;
    String userAgent;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        String s = as[0];
        URL url = new URL(s);
        String s1;
        HashSet hashset;
        HttpURLConnection httpurlconnection;
        URL url1;
        Log.d((new StringBuilder("Checking URL redirect:")).append(s).toString());
        s1 = url.toString();
        hashset = new HashSet();
        hashset.add(s1);
        httpurlconnection = null;
        url1 = url;
_L7:
        HttpURLConnection httpurlconnection2 = (HttpURLConnection)url1.openConnection();
        int i;
        httpurlconnection2.setRequestProperty("User-Agent", userAgent);
        httpurlconnection2.setInstanceFollowRedirects(false);
        i = httpurlconnection2.getResponseCode();
        if (i != 200) goto _L2; else goto _L1
_L1:
        httpurlconnection2.disconnect();
_L6:
        if (httpurlconnection2 != null)
        {
            httpurlconnection2.disconnect();
        }
        s = s1;
_L4:
        return s;
        MalformedURLException malformedurlexception;
        malformedurlexception;
        if (s != null) goto _L4; else goto _L3
_L3:
        return "";
_L2:
        s1 = httpurlconnection2.getHeaderField("location");
        httpurlconnection2.disconnect();
        if (hashset.add(s1))
        {
            break MISSING_BLOCK_LABEL_178;
        }
        Log.d("URL redirect cycle detected");
        if (httpurlconnection2 != null)
        {
            httpurlconnection2.disconnect();
        }
        return "";
        URL url2 = new URL(s1);
        if (i != 302 && i != 301 && i != 307 && i != 303) goto _L6; else goto _L5
_L5:
        httpurlconnection = httpurlconnection2;
        url1 = url2;
          goto _L7
        IOException ioexception1;
        ioexception1;
        HttpURLConnection httpurlconnection1;
        String s2 = s1;
        httpurlconnection1 = httpurlconnection2;
        s = s2;
_L11:
        if (s == null)
        {
            s = "";
        }
        if (httpurlconnection1 == null) goto _L4; else goto _L8
_L8:
        httpurlconnection1.disconnect();
        return s;
        Exception exception1;
        exception1;
        Exception exception;
        httpurlconnection = httpurlconnection2;
        exception = exception1;
_L10:
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        throw exception;
        exception;
        if (true) goto _L10; else goto _L9
_L9:
        IOException ioexception;
        ioexception;
        s = s1;
        httpurlconnection1 = httpurlconnection;
          goto _L11
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (s == null || s.equals(""))
        {
            s = "about:blank";
        }
        Log.d((new StringBuilder("Show URL: ")).append(s).toString());
        WebFrame.access$1(WebFrame.this).setAllowedUrl(s);
        WebFrame.access$2(WebFrame.this).loadUrl(s);
        requestLayout();
    }

    public ()
    {
        this$0 = WebFrame.this;
        super();
        userAgent = WebFrame.access$0(WebFrame.this);
    }
}
