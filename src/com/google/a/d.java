// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;


// Referenced classes of package com.google.a:
//            j, e, f, g, 
//            h, i

public abstract class d extends Enum
    implements j
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    private static final d f[];

    private d(String s, int k)
    {
        super(s, k);
    }

    d(String s, int k, byte byte0)
    {
        this(s, k);
    }

    static String a(String s)
    {
        int k = 0;
        StringBuilder stringbuilder = new StringBuilder();
        char c1;
        for (c1 = s.charAt(0); k < -1 + s.length() && !Character.isLetter(c1); c1 = s.charAt(k))
        {
            stringbuilder.append(c1);
            k++;
        }

        if (k == s.length())
        {
            s = stringbuilder.toString();
        } else
        if (!Character.isUpperCase(c1))
        {
            char c2 = Character.toUpperCase(c1);
            int l = k + 1;
            String s1;
            if (l < s.length())
            {
                s1 = (new StringBuilder()).append(c2).append(s.substring(l)).toString();
            } else
            {
                s1 = String.valueOf(c2);
            }
            return stringbuilder.append(s1).toString();
        }
        return s;
    }

    static String a(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int k = 0; k < s.length(); k++)
        {
            char c1 = s.charAt(k);
            if (Character.isUpperCase(c1) && stringbuilder.length() != 0)
            {
                stringbuilder.append(s1);
            }
            stringbuilder.append(c1);
        }

        return stringbuilder.toString();
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/google/a/d, s);
    }

    public static d[] values()
    {
        return (d[])f.clone();
    }

    static 
    {
        a = new e("IDENTITY");
        b = new f("UPPER_CAMEL_CASE");
        c = new g("UPPER_CAMEL_CASE_WITH_SPACES");
        d = new h("LOWER_CASE_WITH_UNDERSCORES");
        e = new i("LOWER_CASE_WITH_DASHES");
        d ad[] = new d[5];
        ad[0] = a;
        ad[1] = b;
        ad[2] = c;
        ad[3] = d;
        ad[4] = e;
        f = ad;
    }
}
