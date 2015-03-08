// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.io.ObjectInputStream;
import java.util.Date;

// Referenced classes of package com.millennialmedia.android:
//            CachedAd

final class erator extends erator
{

    final Context val$context;

    final boolean callback(String s, int i, Date date, String s1, long l, ObjectInputStream objectinputstream)
    {
        if (date != null && date.getTime() <= System.currentTimeMillis())
        {
            try
            {
                CachedAd cachedad = (CachedAd)objectinputstream.readObject();
                Object aobj[] = new Object[1];
                aobj[0] = cachedad.getId();
                d("Deleting expired ad %s.", aobj);
                cachedad.delete(val$context);
            }
            catch (Exception exception)
            {
                d("There was a problem reading the cached ad %s.", new Object[] {
                    s
                });
                d(exception);
                return true;
            }
        }
        return true;
    }

    erator()
    {
        val$context = context1;
        super();
    }
}
