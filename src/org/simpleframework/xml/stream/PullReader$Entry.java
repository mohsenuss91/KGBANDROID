// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventAttribute

class source extends EventAttribute
{

    private final String name;
    private final String prefix;
    private final String reference;
    private final XmlPullParser source;
    private final String value;

    public String getName()
    {
        return name;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getReference()
    {
        return reference;
    }

    public Object getSource()
    {
        return source;
    }

    public String getValue()
    {
        return value;
    }

    public boolean isReserved()
    {
        return false;
    }

    public (XmlPullParser xmlpullparser, int i)
    {
        reference = xmlpullparser.getAttributeNamespace(i);
        prefix = xmlpullparser.getAttributePrefix(i);
        value = xmlpullparser.getAttributeValue(i);
        name = xmlpullparser.getAttributeName(i);
        source = xmlpullparser;
    }
}
