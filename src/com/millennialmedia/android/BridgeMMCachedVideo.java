// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMActivity, VideoPlayerActivity, AdCache, 
//            MMJSResponse, HttpGetRequest, VideoAd, CachedAd

class BridgeMMCachedVideo extends MMJSObject
    implements AdCache.AdCacheTaskListener
{

    private boolean success;

    BridgeMMCachedVideo()
    {
    }

    private VideoPlayerActivity getVPA()
    {
        if (contextRef != null && (contextRef.get() instanceof MMActivity))
        {
            MMActivity mmactivity = (MMActivity)contextRef.get();
            if (mmactivity.getWrappedActivity() != null && (mmactivity.getWrappedActivity() instanceof VideoPlayerActivity))
            {
                return (VideoPlayerActivity)mmactivity.getWrappedActivity();
            }
        }
        return null;
    }

    public MMJSResponse availableCachedVideos(HashMap hashmap)
    {
        final Context context = (Context)contextRef.get();
        if (context != null)
        {
            final JSONArray array = new JSONArray();
            AdCache.iterateCachedAds(context, 2, new _cls1());
            MMJSResponse mmjsresponse = new MMJSResponse();
            mmjsresponse.result = 1;
            mmjsresponse.response = array;
            return mmjsresponse;
        } else
        {
            return null;
        }
    }

    public MMJSResponse cacheVideo(HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        Context context;
        String s;
        context = (Context)contextRef.get();
        s = (String)hashmap.get("url");
        if (s == null || context == null) goto _L2; else goto _L1
_L1:
        System.out.println(s);
        HttpResponse httpresponse = (new HttpGetRequest()).get(s);
        if (httpresponse != null) goto _L4; else goto _L3
_L3:
        MMSDK.Log.i("HTTP response is null");
        MMJSResponse mmjsresponse = null;
_L12:
        this;
        JVM INSTR monitorexit ;
        return mmjsresponse;
_L4:
        HttpEntity httpentity = httpresponse.getEntity();
        if (httpentity != null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        MMSDK.Log.d("Null HTTP entity");
        mmjsresponse = null;
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        MMSDK.Log.d((new StringBuilder("HTTP error: ")).append(exception1.getMessage()).toString());
        mmjsresponse = null;
        continue; /* Loop/switch isn't completed */
        if (httpentity.getContentLength() != 0L)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        MMSDK.Log.d("Millennial ad return failed. Zero content length returned.");
        mmjsresponse = null;
        continue; /* Loop/switch isn't completed */
        Header header = httpentity.getContentType();
        if (header == null) goto _L2; else goto _L5
_L5:
        if (header.getValue() == null) goto _L2; else goto _L6
_L6:
        boolean flag = header.getValue().equalsIgnoreCase("application/json");
        if (!flag) goto _L2; else goto _L7
_L7:
        VideoAd videoad = new VideoAd(HttpGetRequest.convertStreamToString(httpentity.getContent()));
        if (!videoad.isValid()) goto _L2; else goto _L8
_L8:
        boolean flag1;
        videoad.downloadPriority = 3;
        flag1 = AdCache.startDownloadTask(context, null, videoad, this);
        if (!flag1) goto _L10; else goto _L9
_L9:
        MMJSResponse mmjsresponse2;
        wait();
        if (!success)
        {
            break MISSING_BLOCK_LABEL_325;
        }
        mmjsresponse2 = MMJSResponse.responseWithSuccess(String.format("Cached video(%s)", new Object[] {
            s
        }));
        mmjsresponse = mmjsresponse2;
        notify();
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        illegalstateexception.printStackTrace();
        MMSDK.Log.d("Millennial ad return failed. Invalid response data.");
        mmjsresponse = null;
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        MMSDK.Log.d("Millennial ad return failed. Invalid response data.");
        mmjsresponse = null;
        continue; /* Loop/switch isn't completed */
        notify();
_L2:
        mmjsresponse = null;
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        MMSDK.Log.e(interruptedexception);
        Object aobj[] = new Object[1];
        aobj[0] = interruptedexception.getMessage();
        MMSDK.Log.e("Caching interrupted: %s", aobj);
        notify();
          goto _L2
        Exception exception2;
        exception2;
        notify();
        throw exception2;
_L10:
        MMJSResponse mmjsresponse1 = MMJSResponse.responseWithError(String.format("Unable to start download for Cached video(%s)", new Object[] {
            s
        }));
        mmjsresponse = mmjsresponse1;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public void downloadCompleted(CachedAd cachedad, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Context context = (Context)contextRef.get();
        if (!flag || context == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        AdCache.save(context, cachedad);
        success = flag;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void downloadStart(CachedAd cachedad)
    {
    }

    public MMJSResponse endVideo(HashMap hashmap)
    {
        final VideoPlayerActivity vpa = getVPA();
        if (vpa != null)
        {
            return runOnUiThreadFuture(new _cls3());
        } else
        {
            return null;
        }
    }

    public MMJSResponse pauseVideo(HashMap hashmap)
    {
        final VideoPlayerActivity vpa = getVPA();
        if (vpa != null)
        {
            return runOnUiThreadFuture(new _cls4());
        } else
        {
            return null;
        }
    }

    public MMJSResponse playCachedVideo(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("videoId");
        if (s != null && context != null)
        {
            VideoAd videoad = (VideoAd)AdCache.load(context, s);
            if (videoad != null && videoad.canShow(context, null, false))
            {
                videoad.show(context, getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
                return MMJSResponse.responseWithSuccess(String.format("Playing Video(%s)", new Object[] {
                    s
                }));
            }
        }
        return null;
    }

    public MMJSResponse playVideo(HashMap hashmap)
    {
        final VideoPlayerActivity vpa = getVPA();
        if (vpa != null)
        {
            return runOnUiThreadFuture(new _cls2());
        } else
        {
            return null;
        }
    }

    public MMJSResponse restartVideo(HashMap hashmap)
    {
        final VideoPlayerActivity vpa = getVPA();
        if (vpa != null)
        {
            return runOnUiThreadFuture(new _cls5());
        } else
        {
            return null;
        }
    }

    public MMJSResponse videoIdExists(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("videoId");
        if (s != null && context != null)
        {
            VideoAd videoad = (VideoAd)AdCache.load(context, s);
            if (videoad != null && videoad.isOnDisk(context) && !videoad.isExpired())
            {
                return MMJSResponse.responseWithSuccess(s);
            }
        }
        return null;
    }

    private class _cls1 extends AdCache.Iterator
    {

        final BridgeMMCachedVideo this$0;
        final JSONArray val$array;
        final Context val$context;

        boolean callback(CachedAd cachedad)
        {
            if ((cachedad instanceof VideoAd) && cachedad.isOnDisk(context) && !cachedad.isExpired())
            {
                array.put(cachedad.getId());
            }
            return true;
        }

        _cls1()
        {
            this$0 = BridgeMMCachedVideo.this;
            context = context1;
            array = jsonarray;
            super();
        }
    }


    private class _cls3
        implements Callable
    {

        final BridgeMMCachedVideo this$0;
        final VideoPlayerActivity val$vpa;

        public MMJSResponse call()
        {
            vpa.endVideo();
            return MMJSResponse.responseWithSuccess();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls3()
        {
            this$0 = BridgeMMCachedVideo.this;
            vpa = videoplayeractivity;
            super();
        }
    }


    private class _cls4
        implements Callable
    {

        final BridgeMMCachedVideo this$0;
        final VideoPlayerActivity val$vpa;

        public MMJSResponse call()
        {
            vpa.pauseVideoByUser();
            return MMJSResponse.responseWithSuccess();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls4()
        {
            this$0 = BridgeMMCachedVideo.this;
            vpa = videoplayeractivity;
            super();
        }
    }


    private class _cls2
        implements Callable
    {

        final BridgeMMCachedVideo this$0;
        final VideoPlayerActivity val$vpa;

        public MMJSResponse call()
        {
            vpa.resumeVideo();
            return MMJSResponse.responseWithSuccess();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls2()
        {
            this$0 = BridgeMMCachedVideo.this;
            vpa = videoplayeractivity;
            super();
        }
    }


    private class _cls5
        implements Callable
    {

        final BridgeMMCachedVideo this$0;
        final VideoPlayerActivity val$vpa;

        public MMJSResponse call()
        {
            vpa.restartVideo();
            return MMJSResponse.responseWithSuccess();
        }

        public volatile Object call()
        {
            return call();
        }

        _cls5()
        {
            this$0 = BridgeMMCachedVideo.this;
            vpa = videoplayeractivity;
            super();
        }
    }

}
