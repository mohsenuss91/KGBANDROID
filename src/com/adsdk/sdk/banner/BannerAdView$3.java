// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.adsdk.sdk.banner:
//            BannerAdView

class val.clickUrl extends AsyncTask
{

    final BannerAdView this$0;
    private final String val$clickUrl;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (val$clickUrl.startsWith("market"))
        {
            return null;
        }
        try
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet();
            httpget.setHeader("User-Agent", System.getProperty("http.agent"));
            httpget.setURI(new URI(val$clickUrl));
            defaulthttpclient.execute(httpget);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
            return null;
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            clientprotocolexception.printStackTrace();
            return null;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return null;
        }
        return null;
    }

    lException()
    {
        this$0 = final_banneradview;
        val$clickUrl = String.this;
        super();
    }
}
