// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            CachedAd

final class erator extends erator
{

    final Context val$context;

    final boolean callback(CachedAd cachedad)
    {
        Object aobj[] = new Object[1];
        aobj[0] = cachedad.getId();
        d("Deleting ad %s.", aobj);
        cachedad.delete(val$context);
        return true;
    }

    erator()
    {
        val$context = context1;
        super();
    }
}
