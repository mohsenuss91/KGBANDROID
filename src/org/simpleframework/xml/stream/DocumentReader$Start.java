// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventElement

class element extends EventElement
{

    private final Element element;

    public NamedNodeMap getAttributes()
    {
        return element.getAttributes();
    }

    public String getName()
    {
        return element.getLocalName();
    }

    public String getPrefix()
    {
        return element.getPrefix();
    }

    public String getReference()
    {
        return element.getNamespaceURI();
    }

    public Object getSource()
    {
        return element;
    }

    public _cls9(Node node)
    {
        element = (Element)node;
    }
}
