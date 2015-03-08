// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.analytics.tracking.android:
//            Hit

class HitBuilder
{

    HitBuilder()
    {
    }

    static String encode(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError((new StringBuilder("URL encoding failed for: ")).append(s).toString());
        }
        return s1;
    }

    static Map generateHitParams(Map map)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = map.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((String)entry.getKey()).startsWith("&") && entry.getValue() != null)
            {
                String s = ((String)entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(s))
                {
                    hashmap.put(s, entry.getValue());
                }
            }
        } while (true);
        return hashmap;
    }

    static String postProcessHit(Hit hit, long l)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(hit.getHitParams());
        if (hit.getHitTime() > 0L)
        {
            long l1 = l - hit.getHitTime();
            if (l1 >= 0L)
            {
                stringbuilder.append("&qt=").append(l1);
            }
        }
        stringbuilder.append("&z=").append(hit.getHitId());
        return stringbuilder.toString();
    }
}
