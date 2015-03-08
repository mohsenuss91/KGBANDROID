// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventElement

class source extends EventElement
{

    private final int line;
    private final String name;
    private final String prefix;
    private final String reference;
    private final XmlPullParser source;

    public int getLine()
    {
        return line;
    }

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

    public (XmlPullParser xmlpullparser)
    {
        reference = xmlpullparser.getNamespace();
        line = xmlpullparser.getLineNumber();
        prefix = xmlpullparser.getPrefix();
        name = xmlpullparser.getName();
        source = xmlpullparser;
    }
}
