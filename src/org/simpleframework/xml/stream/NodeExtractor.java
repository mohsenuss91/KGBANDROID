// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.util.LinkedList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class NodeExtractor extends LinkedList
{

    public NodeExtractor(Document document)
    {
        extract(document);
    }

    private void extract(Document document)
    {
        org.w3c.dom.Element element = document.getDocumentElement();
        if (element != null)
        {
            offer(element);
            extract(((Node) (element)));
        }
    }

    private void extract(Node node)
    {
        NodeList nodelist = node.getChildNodes();
        int i = nodelist.getLength();
        for (int j = 0; j < i; j++)
        {
            Node node1 = nodelist.item(j);
            if (node1.getNodeType() != 8)
            {
                offer(node1);
                extract(node1);
            }
        }

    }
}
