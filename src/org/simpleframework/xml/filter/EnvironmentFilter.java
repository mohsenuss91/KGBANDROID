// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.filter;


// Referenced classes of package org.simpleframework.xml.filter:
//            Filter

public class EnvironmentFilter
    implements Filter
{

    private Filter filter;

    public EnvironmentFilter()
    {
        this(null);
    }

    public EnvironmentFilter(Filter filter1)
    {
        filter = filter1;
    }

    public String replace(String s)
    {
        String s1 = System.getenv(s);
        if (s1 != null)
        {
            return s1;
        }
        if (filter != null)
        {
            return filter.replace(s);
        } else
        {
            return null;
        }
    }
}
