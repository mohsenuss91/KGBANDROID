// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventElement

class location extends EventElement
{

    private final StartElement element;
    private final Location location;

    public Iterator getAttributes()
    {
        return element.getAttributes();
    }

    public int getLine()
    {
        return location.getLineNumber();
    }

    public String getName()
    {
        return element.getName().getLocalPart();
    }

    public String getPrefix()
    {
        return element.getName().getPrefix();
    }

    public String getReference()
    {
        return element.getName().getNamespaceURI();
    }

    public Object getSource()
    {
        return element;
    }

    public (XMLEvent xmlevent)
    {
        element = xmlevent.asStartElement();
        location = xmlevent.getLocation();
    }
}
