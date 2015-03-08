// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.stream:
//            Style

class Builder
    implements Style
{

    private final Cache attributes = new ConcurrentCache();
    private final Cache elements = new ConcurrentCache();
    private final Style style;

    public Builder(Style style1)
    {
        style = style1;
    }

    public String getAttribute(String s)
    {
        String s1 = (String)attributes.fetch(s);
        if (s1 == null)
        {
            if ((s1 = style.getAttribute(s)) != null)
            {
                attributes.cache(s, s1);
                return s1;
            }
        }
        return s1;
    }

    public String getElement(String s)
    {
        String s1 = (String)elements.fetch(s);
        if (s1 == null)
        {
            if ((s1 = style.getElement(s)) != null)
            {
                elements.cache(s, s1);
                return s1;
            }
        }
        return s1;
    }

    public void setAttribute(String s, String s1)
    {
        attributes.cache(s, s1);
    }

    public void setElement(String s, String s1)
    {
        elements.cache(s, s1);
    }
}
