// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

final class HttpRedirection
{

    private static final String HEADER_LOCATION = "Location";
    private static final String HTTPS = "https";
    private static final String LOG_URL_FORMAT = "Redirecting to: %s";
    private static final String METHOD_GET = "GET";

    HttpRedirection()
    {
    }

    static final String navigateRedirects(String s)
    {
        String s1;
        if (s == null)
        {
            return null;
        }
        HttpURLConnection.setFollowRedirects(false);
        s1 = s;
_L1:
        URL url;
        HttpURLConnection httpurlconnection;
        int i;
        String s4;
        URI uri;
        try
        {
            if (s1.startsWith("https"))
            {
                break MISSING_BLOCK_LABEL_157;
            }
            url = new URL(s1);
            httpurlconnection = (HttpURLConnection)url.openConnection();
            httpurlconnection.setConnectTimeout(3000);
            httpurlconnection.setRequestMethod("GET");
            httpurlconnection.connect();
            i = httpurlconnection.getResponseCode();
        }
        catch (MalformedURLException malformedurlexception)
        {
            return s1;
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            String s3 = s1;
            MMSDK.Log.d("Connection timeout.");
            return s3;
        }
        catch (IOException ioexception)
        {
            return s1;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            String s2 = s1;
            MMSDK.Log.d("URI Syntax incorrect.");
            return s2;
        }
        if (i < 300 || i >= 400)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        s4 = httpurlconnection.getHeaderField("Location");
        uri = new URI(s4);
        if (uri.isAbsolute())
        {
            break MISSING_BLOCK_LABEL_146;
        }
        s1 = url.toURI().resolve(uri).toString();
_L2:
        MMSDK.Log.v("Redirecting to: %s", new Object[] {
            s1
        });
          goto _L1
        if (s4 != null)
        {
            s1 = s4;
        }
          goto _L2
        return s1;
          goto _L1
    }

    static void startActivityFromUri(RedirectionListenerImpl redirectionlistenerimpl)
    {
        if (redirectionlistenerimpl == null || redirectionlistenerimpl.url == null || redirectionlistenerimpl.weakContext == null)
        {
            return;
        } else
        {
            Utils.ThreadUtils.execute(new _cls1());
            return;
        }
    }

    private class RedirectionListenerImpl
        implements Listener
    {

        long creatorAdImplInternalId;
        Uri destinationUri;
        String orientation;
        String url;
        WeakReference weakContext;

        public boolean canOpenOverlay()
        {
            return false;
        }

        public JSONObject getAdProperties()
        {
            return null;
        }

        public OverlaySettings getOverlaySettings()
        {
            return null;
        }

        public boolean isActivityStartable(Uri uri)
        {
            return true;
        }

        public boolean isExpandingToUrl()
        {
            return false;
        }

        public boolean isHandlingMMVideo(Uri uri)
        {
            return false;
        }

        public void startingActivity(Uri uri)
        {
            MMSDK.Log.d("Starting activity for %s", new Object[] {
                uri
            });
        }

        public void startingVideo()
        {
        }

        public void updateLastVideoViewedTime()
        {
        }

        RedirectionListenerImpl()
        {
        }
    }


    private class _cls1
        implements Runnable
    {

        final WeakReference val$listenerReference;

        private void handleDestinationUri(RedirectionListenerImpl redirectionlistenerimpl)
        {
            Context context = (Context)redirectionlistenerimpl.weakContext.get();
            if (context == null) goto _L2; else goto _L1
_L1:
            String s;
            Intent intent;
            s = redirectionlistenerimpl.destinationUri.getScheme();
            intent = null;
            if (s == null) goto _L4; else goto _L3
_L3:
            if (s.equalsIgnoreCase("mmvideo")) goto _L6; else goto _L5
_L5:
            intent = Utils.IntentUtils.getIntentForUri(redirectionlistenerimpl);
_L4:
            if (intent == null) goto _L2; else goto _L7
_L7:
            String s1;
            OverlaySettings overlaysettings = redirectionlistenerimpl.getOverlaySettings();
            if (intent != null && overlaysettings != null)
            {
                if (redirectionlistenerimpl.orientation != null)
                {
                    overlaysettings.orientation = redirectionlistenerimpl.orientation;
                }
                intent.putExtra("settings", overlaysettings);
            }
            s1 = intent.getStringExtra("class");
            if (s1 != null && s1.equals(com/millennialmedia/android/AdViewOverlayActivity.getCanonicalName())) goto _L2; else goto _L8
_L8:
            if (redirectionlistenerimpl.isActivityStartable(redirectionlistenerimpl.destinationUri))
            {
                Utils.IntentUtils.startActivity(context, intent);
                redirectionlistenerimpl.startingActivity(redirectionlistenerimpl.destinationUri);
            }
_L2:
            return;
_L6:
            boolean flag = redirectionlistenerimpl.isHandlingMMVideo(redirectionlistenerimpl.destinationUri);
            intent = null;
            if (!flag)
            {
                VideoAd.playAd(context, redirectionlistenerimpl.destinationUri.getHost(), redirectionlistenerimpl);
                intent = null;
            }
            if (true) goto _L4; else goto _L9
_L9:
            ActivityNotFoundException activitynotfoundexception;
            activitynotfoundexception;
            Object aobj[] = new Object[1];
            aobj[0] = redirectionlistenerimpl.destinationUri;
            MMSDK.Log.e("No activity found for %s", aobj);
            return;
        }

        public final void run()
        {
            String s;
label0:
            {
                RedirectionListenerImpl redirectionlistenerimpl = (RedirectionListenerImpl)listenerReference.get();
                if (redirectionlistenerimpl != null)
                {
                    s = HttpRedirection.navigateRedirects(redirectionlistenerimpl.url);
                    if (s != null)
                    {
                        redirectionlistenerimpl.destinationUri = Uri.parse(s);
                        if (redirectionlistenerimpl.destinationUri == null)
                        {
                            break label0;
                        }
                        handleDestinationUri(redirectionlistenerimpl);
                    }
                }
                return;
            }
            MMSDK.Log.v("Could not start activity for %s", new Object[] {
                s
            });
        }

        _cls1()
        {
            listenerReference = weakreference;
            super();
        }
    }

}
