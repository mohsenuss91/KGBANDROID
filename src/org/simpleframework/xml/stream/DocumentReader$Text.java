// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import org.w3c.dom.Node;

// Referenced classes of package org.simpleframework.xml.stream:
//            EventToken

class node extends EventToken
{

    private final Node node;

    public Object getSource()
    {
        return node;
    }

    public String getValue()
    {
        return node.getNodeValue();
    }

    public boolean isText()
    {
        return true;
    }

    public (Node node1)
    {
        node = node1;
    }
}
