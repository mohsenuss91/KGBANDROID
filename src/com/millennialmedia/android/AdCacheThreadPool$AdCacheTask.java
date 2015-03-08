// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            CachedAd, HandShake, AdCache, AdCacheThreadPool

class listenerRef
    implements Comparable, Runnable
{

    private CachedAd ad;
    private String adName;
    private WeakReference contextRef;
    private WeakReference listenerRef;
    final AdCacheThreadPool this$0;

    public int compareTo(listenerRef listenerref)
    {
        return ad.downloadPriority - listenerref.ad.downloadPriority;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof compareTo))
        {
            return false;
        } else
        {
            compareTo compareto = (compareTo)obj;
            return ad.equals(compareto.ad);
        }
    }

    public void run()
    {
        ad ad1;
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
            ad1 = (listenerRef)listenerRef.get();
        } else
        {
            ad1 = null;
        }
        if (ad1 != null)
        {
            ad1.wnloadStart(ad);
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
        if (ad1 != null)
        {
            ad1.wnloadCompleted(ad, flag);
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

    (Context context, String s, CachedAd cachedad,  )
    {
        this$0 = AdCacheThreadPool.this;
        super();
        contextRef = new WeakReference(context.getApplicationContext());
        adName = s;
        ad = cachedad;
        if ( != null)
        {
            listenerRef = new WeakReference();
        }
    }
}
