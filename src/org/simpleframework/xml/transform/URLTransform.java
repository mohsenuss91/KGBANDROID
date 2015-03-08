// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.net.URL;

// Referenced classes of package org.simpleframework.xml.transform:
//            Transform

class URLTransform
    implements Transform
{

    URLTransform()
    {
    }

    public volatile Object read(String s)
    {
        return read(s);
    }

    public URL read(String s)
    {
        return new URL(s);
    }

    public volatile String write(Object obj)
    {
        return write((URL)obj);
    }

    public String write(URL url)
    {
        return url.toString();
    }
}
