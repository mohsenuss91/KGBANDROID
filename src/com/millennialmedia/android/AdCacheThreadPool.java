// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.millennialmedia.android:
//            CachedAd

final class AdCacheThreadPool
{

    private static AdCacheThreadPool sharedThreadPool;
    private ThreadPoolExecutor executor;
    private PriorityBlockingQueue queue;

    private AdCacheThreadPool()
    {
        TimeUnit timeunit = TimeUnit.SECONDS;
        PriorityBlockingQueue priorityblockingqueue = new PriorityBlockingQueue(32);
        queue = priorityblockingqueue;
        executor = new ThreadPoolExecutor(1, 2, 30L, timeunit, priorityblockingqueue);
    }

    static AdCacheThreadPool sharedThreadPool()
    {
        com/millennialmedia/android/AdCacheThreadPool;
        JVM INSTR monitorenter ;
        AdCacheThreadPool adcachethreadpool;
        if (sharedThreadPool == null)
        {
            sharedThreadPool = new AdCacheThreadPool();
        }
        adcachethreadpool = sharedThreadPool;
        com/millennialmedia/android/AdCacheThreadPool;
        JVM INSTR monitorexit ;
        return adcachethreadpool;
        Exception exception;
        exception;
        throw exception;
    }

    final boolean startDownloadTask(Context context, String s, CachedAd cachedad, AdCache.AdCacheTaskListener adcachetasklistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null || cachedad == null) goto _L2; else goto _L1
_L1:
        AdCacheTask adcachetask = new AdCacheTask(context, s, cachedad, adcachetasklistener);
        if (queue.contains(adcachetask) || cachedad.isOnDisk(context)) goto _L2; else goto _L3
_L3:
        executor.execute(adcachetask);
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    private class AdCacheTask
        implements Comparable, Runnable
    {

        private CachedAd ad;
        private String adName;
        private WeakReference contextRef;
        private WeakReference listenerRef;
        final AdCacheThreadPool this$0;

        public int compareTo(AdCacheTask adcachetask)
        {
            return ad.downloadPriority - adcachetask.ad.downloadPriority;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((AdCacheTask)obj);
        }

        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (!(obj instanceof AdCacheTask))
            {
                return false;
            } else
            {
                AdCacheTask adcachetask = (AdCacheTask)obj;
                return ad.equals(adcachetask.ad);
            }
        }

        public void run()
        {
            AdCache.AdCacheTaskListener adcachetasklistener;
            boolean flag;
            String s;
            Context context;
            String s1;
            String s2;
            Context context1;
            String s3;
            Context context2;
            String s4;
            String s5;
            Context context3;
            String s6;
            if (listenerRef != null)
            {
                adcachetasklistener = (AdCache.AdCacheTaskListener)listenerRef.get();
            } else
            {
                adcachetasklistener = null;
            }
            if (adcachetasklistener != null)
            {
                adcachetasklistener.downloadStart(ad);
            }
            HandShake.sharedHandShake((Context)contextRef.get()).lockAdTypeDownload(adName);
            flag = ad.download((Context)contextRef.get());
            HandShake.sharedHandShake((Context)contextRef.get()).unlockAdTypeDownload(adName);
            if (flag) goto _L2; else goto _L1
_L1:
            s = AdCache.getIncompleteDownload((Context)contextRef.get(), adName);
            if (s == null || !ad.getId().equals(s)) goto _L4; else goto _L3
_L3:
            ad.delete((Context)contextRef.get());
            context3 = (Context)contextRef.get();
            s6 = adName;
            context1 = context3;
            s3 = s6;
_L10:
            context2 = context1;
            s1 = s3;
            s4 = null;
_L7:
            AdCache.setIncompleteDownload(context2, s1, s4);
_L8:
            if (adcachetasklistener != null)
            {
                adcachetasklistener.downloadCompleted(ad, flag);
            }
            return;
_L4:
            context = (Context)contextRef.get();
            s1 = adName;
            if (ad.downloadAllOrNothing) goto _L6; else goto _L5
_L5:
            s5 = ad.getId();
            context2 = context;
            s4 = s5;
              goto _L7
_L2:
            AdCache.setIncompleteDownload((Context)contextRef.get(), adName, null);
              goto _L8
_L6:
            s2 = s1;
            context1 = context;
            s3 = s2;
            if (true) goto _L10; else goto _L9
_L9:
        }

        AdCacheTask(Context context, String s, CachedAd cachedad, AdCache.AdCacheTaskListener adcachetasklistener)
        {
            this$0 = AdCacheThreadPool.this;
            super();
            contextRef = new WeakReference(context.getApplicationContext());
            adName = s;
            ad = cachedad;
            if (adcachetasklistener != null)
            {
                listenerRef = new WeakReference(adcachetasklistener);
            }
        }
    }

}
