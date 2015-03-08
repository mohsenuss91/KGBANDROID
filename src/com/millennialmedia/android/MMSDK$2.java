// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            CachedAd

final class Iterator extends Iterator
{

    final Context val$context;

    final boolean callback(CachedAd cachedad)
    {
        Object aobj[] = new Object[4];
        aobj[0] = cachedad.getTypeString();
        aobj[1] = cachedad.getId();
        String s;
        String s1;
        if (cachedad.isOnDisk(val$context))
        {
            s = "";
        } else
        {
            s = "not ";
        }
        aobj[2] = s;
        if (cachedad.isExpired())
        {
            s1 = "";
        } else
        {
            s1 = "not ";
        }
        aobj[3] = s1;
        g.i("%s %s is %son disk. Is %sexpired.", aobj);
        return true;
    }

    ()
    {
        val$context = context1;
        super();
    }
}
