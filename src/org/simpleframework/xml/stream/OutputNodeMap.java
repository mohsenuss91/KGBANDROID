// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.stream:
//            NodeMap, OutputNode, OutputAttribute, Node

class OutputNodeMap extends LinkedHashMap
    implements NodeMap
{

    private final OutputNode source;

    public OutputNodeMap(OutputNode outputnode)
    {
        source = outputnode;
    }

    public volatile Node get(String s)
    {
        return get(s);
    }

    public OutputNode get(String s)
    {
        return (OutputNode)super.get(s);
    }

    public String getName()
    {
        return source.getName();
    }

    public volatile Node getNode()
    {
        return getNode();
    }

    public OutputNode getNode()
    {
        return source;
    }

    public Iterator iterator()
    {
        return keySet().iterator();
    }

    public volatile Node put(String s, String s1)
    {
        return put(s, s1);
    }

    public OutputNode put(String s, String s1)
    {
        OutputAttribute outputattribute = new OutputAttribute(source, s, s1);
        if (source != null)
        {
            put(s, outputattribute);
        }
        return outputattribute;
    }

    public volatile Node remove(String s)
    {
        return remove(s);
    }

    public OutputNode remove(String s)
    {
        return (OutputNode)super.remove(s);
    }
}
