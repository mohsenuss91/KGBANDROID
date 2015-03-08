// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            AdCache

final class val.context
    implements Runnable
{

    final Context val$context;

    public final void run()
    {
        d("AdCache");
        AdCache.cleanUpExpiredAds(val$context);
        AdCache.cleanupCache(val$context);
    }

    ()
    {
        val$context = context1;
        super();
    }
}
