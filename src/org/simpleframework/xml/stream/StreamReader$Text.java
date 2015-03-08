// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventToken

class text extends EventToken
{

    private final Characters text;

    public Object getSource()
    {
        return text;
    }

    public String getValue()
    {
        return text.getData();
    }

    public boolean isText()
    {
        return true;
    }

    public (XMLEvent xmlevent)
    {
        text = xmlevent.asCharacters();
    }
}
