// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.d;


public final class d extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    private static final d j[];
    private String h;
    private String i;

    private d(String s, int k, String s1)
    {
        super(s, k);
        h = s1;
        i = (new StringBuilder()).append(s1).append("://").toString();
    }

    public static d a(String s)
    {
        if (s != null)
        {
            d ad[] = values();
            int k = ad.length;
            for (int l = 0; l < k; l++)
            {
                d d1 = ad[l];
                if (d1.d(s))
                {
                    return d1;
                }
            }

        }
        return g;
    }

    private boolean d(String s)
    {
        return s.startsWith(i);
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/a/a/b/d/d, s);
    }

    public static d[] values()
    {
        return (d[])j.clone();
    }

    public final String b(String s)
    {
        return (new StringBuilder()).append(i).append(s).toString();
    }

    public final String c(String s)
    {
        if (!d(s))
        {
            Object aobj[] = new Object[2];
            aobj[0] = s;
            aobj[1] = h;
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", aobj));
        } else
        {
            return s.substring(i.length());
        }
    }

    static 
    {
        a = new d("HTTP", 0, "http");
        b = new d("HTTPS", 1, "https");
        c = new d("FILE", 2, "file");
        d = new d("CONTENT", 3, "content");
        e = new d("ASSETS", 4, "assets");
        f = new d("DRAWABLE", 5, "drawable");
        g = new d("UNKNOWN", 6, "");
        d ad[] = new d[7];
        ad[0] = a;
        ad[1] = b;
        ad[2] = c;
        ad[3] = d;
        ad[4] = e;
        ad[5] = f;
        ad[6] = g;
        j = ad;
    }
}
