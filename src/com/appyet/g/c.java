// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.g;

import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{

    int a;
    public Map b;

    public c()
    {
        b = new ConcurrentHashMap();
        a = 4;
    }

    public final void a(HttpURLConnection httpurlconnection)
    {
        if ((4 & a) != 0)
        {
            int i = 0;
            while (i < httpurlconnection.getHeaderFields().size()) 
            {
                String s = httpurlconnection.getHeaderFieldKey(i);
                if (s != null && "Set-Cookie".toLowerCase().equals(s.toLowerCase()))
                {
                    String as[] = httpurlconnection.getHeaderField(i).split(";")[0].split("=");
                    if (as.length >= 2)
                    {
                        b.put(as[0], as[1]);
                    }
                }
                i++;
            }
        }
    }

    public final void b(HttpURLConnection httpurlconnection)
    {
        if ((4 & a) == 0)
        {
            return;
        }
        Iterator iterator = b.entrySet().iterator();
        String s;
        java.util.Map.Entry entry;
        for (s = ""; iterator.hasNext(); s = (new StringBuilder()).append(s).append((String)entry.getKey()).append("=").append((String)entry.getValue()).append("; ").toString())
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        httpurlconnection.setRequestProperty("Cookie", s);
    }
}
