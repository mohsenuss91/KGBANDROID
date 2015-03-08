// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.customevents;

import android.content.Context;
import android.os.AsyncTask;

public abstract class CustomEventBanner
{

    protected CustomEventBannerListener listener;
    protected String trackingPixel;

    public CustomEventBanner()
    {
    }

    public abstract void loadBanner(Context context, CustomEventBannerListener customeventbannerlistener, String s, String s1, int i, int j);

    protected void reportImpression()
    {
        (new _cls1()).execute(new Void[0]);
    }

    private class _cls1 extends AsyncTask
    {

        final CustomEventBanner this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            DefaultHttpClient defaulthttpclient;
            HttpGet httpget;
            defaulthttpclient = new DefaultHttpClient();
            httpget = new HttpGet();
            httpget.setHeader("User-Agent", System.getProperty("http.agent"));
            if (!trackingPixel.startsWith("http://") && !trackingPixel.startsWith("https://")) goto _L2; else goto _L1
_L1:
            String s = trackingPixel;
_L4:
            httpget.setURI(new URI(s));
            defaulthttpclient.execute(httpget);
            break MISSING_BLOCK_LABEL_148;
_L2:
            String s1 = (new StringBuilder("http://")).append(trackingPixel).toString();
            s = s1;
            if (true) goto _L4; else goto _L3
_L3:
            URISyntaxException urisyntaxexception;
            urisyntaxexception;
            urisyntaxexception.printStackTrace();
            break MISSING_BLOCK_LABEL_148;
            ClientProtocolException clientprotocolexception;
            clientprotocolexception;
            clientprotocolexception.printStackTrace();
            break MISSING_BLOCK_LABEL_148;
            IOException ioexception;
            ioexception;
            ioexception.printStackTrace();
            return null;
        }

        _cls1()
        {
            this$0 = CustomEventBanner.this;
            super();
        }
    }

}
