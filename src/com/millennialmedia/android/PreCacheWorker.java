// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest, VideoAd, AdCache, DTOCachedVideo

class PreCacheWorker extends Thread
{

    private static boolean busy;
    private Context appContext;
    private DTOCachedVideo cachedVideos[];
    private boolean downloadedNewVideos;
    private String noVideosToCacheURL;

    private PreCacheWorker(DTOCachedVideo adtocachedvideo[], Context context, String s)
    {
        cachedVideos = adtocachedvideo;
        noVideosToCacheURL = s;
        appContext = context.getApplicationContext();
    }

    private void handleContent(DTOCachedVideo dtocachedvideo, HttpEntity httpentity)
    {
        Header header = httpentity.getContentType();
        if (header != null)
        {
            String s = header.getValue();
            if (s != null && s.equalsIgnoreCase("application/json"))
            {
                handleJson(dtocachedvideo, httpentity);
            } else
            if (s != null && s.startsWith("video/"))
            {
                handleVideoFile(dtocachedvideo, httpentity);
                return;
            }
        }
    }

    private void handleJson(final DTOCachedVideo cachedVideo, HttpEntity httpentity)
    {
        String s;
        boolean flag;
        VideoAd videoad;
        try
        {
            s = HttpGetRequest.convertStreamToString(httpentity.getContent());
            flag = TextUtils.isEmpty(s);
        }
        catch (IllegalStateException illegalstateexception)
        {
            illegalstateexception.printStackTrace();
            MMSDK.Log.d("Pre cache worker: Millennial ad return failed. Invalid response data.");
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            MMSDK.Log.d("Pre cache worker: Millennial ad return failed. Invalid response data.");
            return;
        }
        videoad = null;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        videoad = new VideoAd(s);
        if (videoad == null || !videoad.isValid())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        videoad.downloadPriority = 1;
        if (!AdCache.startDownloadTask(appContext, null, videoad, new _cls1()))
        {
            break MISSING_BLOCK_LABEL_107;
        }
        wait();
        return;
        try
        {
            MMSDK.Event.logEvent(cachedVideo.preCacheStartURL);
            MMSDK.Event.logEvent(cachedVideo.preCacheFailedURL);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            Object aobj[] = new Object[1];
            aobj[0] = interruptedexception.getMessage();
            MMSDK.Log.e("Pre cache worker interrupted: %s", aobj);
            return;
        }
    }

    private void handleVideoFile(DTOCachedVideo dtocachedvideo, HttpEntity httpentity)
    {
label0:
        {
            if (!TextUtils.isEmpty(dtocachedvideo.videoFileId))
            {
                MMSDK.Event.logEvent(dtocachedvideo.preCacheStartURL);
                if (!AdCache.downloadComponentToCache(dtocachedvideo.url, (new StringBuilder()).append(dtocachedvideo.videoFileId).append("video.dat").toString(), appContext))
                {
                    break label0;
                }
                MMSDK.Event.logEvent(dtocachedvideo.preCacheCompleteURL);
            }
            return;
        }
        MMSDK.Event.logEvent(dtocachedvideo.preCacheFailedURL);
    }

    static void preCacheVideos(DTOCachedVideo adtocachedvideo[], Context context, String s)
    {
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorenter ;
        if (!busy)
        {
            busy = true;
            (new PreCacheWorker(adtocachedvideo, context, s)).start();
        }
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        DTOCachedVideo adtocachedvideo[];
        int i;
        adtocachedvideo = cachedVideos;
        i = adtocachedvideo.length;
        int j = 0;
_L2:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        DTOCachedVideo dtocachedvideo = adtocachedvideo[j];
        HttpResponse httpresponse = (new HttpGetRequest()).get(dtocachedvideo.url);
        if (httpresponse != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        MMSDK.Log.d("Pre cache worker: HTTP response is null");
        break MISSING_BLOCK_LABEL_233;
        HttpEntity httpentity = httpresponse.getEntity();
        if (httpentity != null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        MMSDK.Log.d("Pre cache worker: Null HTTP entity");
        break MISSING_BLOCK_LABEL_233;
        Exception exception;
        exception;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorenter ;
        busy = false;
        if (!downloadedNewVideos && !TextUtils.isEmpty(noVideosToCacheURL))
        {
            MMSDK.Event.logEvent(noVideosToCacheURL);
        }
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        throw exception;
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception3;
        exception3;
        Object aobj[] = new Object[1];
        aobj[0] = exception3.getMessage();
        MMSDK.Log.d("Pre cache worker HTTP error: %s", aobj);
        break MISSING_BLOCK_LABEL_233;
        if (httpentity.getContentLength() == 0L)
        {
            MMSDK.Log.d("Pre cache worker: Millennial ad return failed. Zero content length returned.");
            break MISSING_BLOCK_LABEL_233;
        }
        handleContent(dtocachedvideo, httpentity);
        break MISSING_BLOCK_LABEL_233;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorenter ;
        busy = false;
        if (!downloadedNewVideos && !TextUtils.isEmpty(noVideosToCacheURL))
        {
            MMSDK.Event.logEvent(noVideosToCacheURL);
        }
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception4;
        exception4;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        throw exception4;
        Exception exception2;
        exception2;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        throw exception2;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }



/*
    static boolean access$102(PreCacheWorker precacheworker, boolean flag)
    {
        precacheworker.downloadedNewVideos = flag;
        return flag;
    }

*/

    private class _cls1
        implements AdCache.AdCacheTaskListener
    {

        final PreCacheWorker this$0;
        final DTOCachedVideo val$cachedVideo;

        public void downloadCompleted(CachedAd cachedad, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            AdCache.save(appContext, cachedad);
            downloadedNewVideos = true;
            MMSDK.Event.logEvent(cachedVideo.preCacheCompleteURL);
_L1:
            notify();
            this;
            JVM INSTR monitorexit ;
            return;
            MMSDK.Event.logEvent(cachedVideo.preCacheFailedURL);
              goto _L1
            Exception exception;
            exception;
            throw exception;
        }

        public void downloadStart(CachedAd cachedad)
        {
            MMSDK.Event.logEvent(cachedVideo.preCacheStartURL);
        }

        _cls1()
        {
            this$0 = PreCacheWorker.this;
            cachedVideo = dtocachedvideo;
            super();
        }
    }

}
