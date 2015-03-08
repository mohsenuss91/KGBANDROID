// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;

import android.content.Context;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.adsdk.sdk.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.adsdk.sdk.nativeads:
//            NativeViewBinder, NativeAd, NativeAdListener

public class NativeAdView extends FrameLayout
{

    private View adView;
    private Handler handler;
    private boolean impressionReported;
    private NativeAdListener listener;
    private List trackers;

    public NativeAdView(Context context, NativeAd nativead, NativeViewBinder nativeviewbinder, NativeAdListener nativeadlistener)
    {
        super(context);
        if (nativead == null || nativeviewbinder == null)
        {
            return;
        } else
        {
            adView = inflate(context, nativeviewbinder.getAdLayoutId(), null);
            trackers = nativead.getTrackers();
            handler = new Handler();
            listener = nativeadlistener;
            fillAdView(nativead, nativeviewbinder);
            addView(adView);
            return;
        }
    }

    private void notifyImpression()
    {
        if (listener != null)
        {
            handler.post(new _cls1());
        }
    }

    private void trackImpression(final String url)
    {
        (new _cls2()).execute(new Void[0]);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        if (impressionReported) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        impressionReported = true;
        notifyImpression();
        iterator = trackers.iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        super.dispatchDraw(canvas);
        return;
_L3:
        NativeAd.Tracker tracker = (NativeAd.Tracker)iterator.next();
        if (tracker.type.equals("impression"))
        {
            trackImpression(tracker.url);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void fillAdView(NativeAd nativead, NativeViewBinder nativeviewbinder)
    {
        Iterator iterator = nativeviewbinder.getTextAssetsBindingsKeySet().iterator();
_L5:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Iterator iterator1 = nativeviewbinder.getImageAssetsBindingsKeySet().iterator();
_L8:
        String s2;
        int k;
        String s;
        int i;
        ClassCastException classcastexception;
        TextView textview;
        String s1;
        RatingBar ratingbar;
        int j;
        if (!iterator1.hasNext())
        {
            return;
        }
        s2 = (String)iterator1.next();
        k = nativeviewbinder.getIdForImageAsset(s2);
          goto _L3
_L2:
        s = (String)iterator.next();
        i = nativeviewbinder.getIdForTextAsset(s);
        if (i == 0) goto _L5; else goto _L4
_L4:
        if (!s.equals("rating"))
        {
            break MISSING_BLOCK_LABEL_147;
        }
        ratingbar = (RatingBar)adView.findViewById(i);
        if (ratingbar != null)
        {
            try
            {
                j = Integer.parseInt(nativead.getTextAsset(s));
                ratingbar.setIsIndicator(true);
                ratingbar.setRating(j);
            }
            // Misplaced declaration of an exception variable
            catch (ClassCastException classcastexception)
            {
                Log.e((new StringBuilder("Cannot fill view for ")).append(s).toString());
            }
        }
          goto _L5
        textview = (TextView)adView.findViewById(i);
        s1 = nativead.getTextAsset(s);
        if (textview == null || s1 == null) goto _L5; else goto _L6
_L6:
        textview.setText(s1);
          goto _L5
_L3:
        if (k == 0) goto _L8; else goto _L7
_L7:
        ImageView imageview;
        android.graphics.Bitmap bitmap;
        imageview = (ImageView)adView.findViewById(k);
        bitmap = nativead.getImageAsset(s2).bitmap;
        if (imageview != null && bitmap != null)
        {
            try
            {
                imageview.setImageBitmap(bitmap);
            }
            catch (ClassCastException classcastexception1)
            {
                Log.e((new StringBuilder("Cannot fill view for ")).append(s2).toString());
            }
        }
          goto _L8
    }


    private class _cls1
        implements Runnable
    {

        final NativeAdView this$0;

        public void run()
        {
            listener.impression();
        }

        _cls1()
        {
            this$0 = NativeAdView.this;
            super();
        }
    }


    private class _cls2 extends AsyncTask
    {

        final NativeAdView this$0;
        private final String val$url;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
                HttpGet httpget = new HttpGet();
                httpget.setHeader("User-Agent", System.getProperty("http.agent"));
                httpget.setURI(new URI(url));
                defaulthttpclient.execute(httpget);
            }
            catch (URISyntaxException urisyntaxexception)
            {
                urisyntaxexception.printStackTrace();
            }
            catch (ClientProtocolException clientprotocolexception)
            {
                clientprotocolexception.printStackTrace();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            return null;
        }

        _cls2()
        {
            this$0 = NativeAdView.this;
            url = s;
            super();
        }
    }

}
