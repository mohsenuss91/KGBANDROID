// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventToken

class source extends EventToken
{

    private final XmlPullParser source;
    private final String text;

    public Object getSource()
    {
        return source;
    }

    public String getValue()
    {
        return text;
    }

    public boolean isText()
    {
        return true;
    }

    public (XmlPullParser xmlpullparser)
    {
        text = xmlpullparser.getText();
        source = xmlpullparser;
    }
}
