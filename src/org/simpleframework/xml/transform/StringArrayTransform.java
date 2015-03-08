// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.util.regex.Pattern;

// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class StringArrayTransform
    implements Transform
{

    private final Pattern pattern;
    private final String token;

    public StringArrayTransform()
    {
        this(",");
    }

    public StringArrayTransform(String s)
    {
        pattern = Pattern.compile(s);
        token = s;
    }

    private String[] read(String s, String s1)
    {
        String as[] = pattern.split(s);
        for (int i = 0; i < as.length; i++)
        {
            String s2 = as[i];
            if (s2 != null)
            {
                as[i] = s2.trim();
            }
        }

        return as;
    }

    private String write(String as[], String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < as.length; i++)
        {
            String s1 = as[i];
            if (s1 == null)
            {
                continue;
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(s);
                stringbuilder.append(' ');
            }
            stringbuilder.append(s1);
        }

        return stringbuilder.toString();
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public String[] read(String s)
    {
        return read(s, token);
    }

    public volatile String write(Object obj)
    {
        return write((String[])obj);
    }

    public String write(String as[])
    {
        return write(as, token);
    }
}
