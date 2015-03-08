// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.stream:
//            NodeMap, EventNode, Attribute, InputAttribute, 
//            InputNode, Node

class InputNodeMap extends LinkedHashMap
    implements NodeMap
{

    private final InputNode source;

    protected InputNodeMap(InputNode inputnode)
    {
        source = inputnode;
    }

    public InputNodeMap(InputNode inputnode, EventNode eventnode)
    {
        source = inputnode;
        build(eventnode);
    }

    private void build(EventNode eventnode)
    {
        Iterator iterator1 = eventnode.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Attribute attribute = (Attribute)iterator1.next();
            InputAttribute inputattribute = new InputAttribute(source, attribute);
            if (!attribute.isReserved())
            {
                put(inputattribute.getName(), inputattribute);
            }
        } while (true);
    }

    public InputNode get(String s)
    {
        return (InputNode)super.get(s);
    }

    public volatile Node get(String s)
    {
        return get(s);
    }

    public String getName()
    {
        return source.getName();
    }

    public InputNode getNode()
    {
        return source;
    }

    public volatile Node getNode()
    {
        return getNode();
    }

    public Iterator iterator()
    {
        return keySet().iterator();
    }

    public InputNode put(String s, String s1)
    {
        InputAttribute inputattribute = new InputAttribute(source, s, s1);
        if (s != null)
        {
            put(s, inputattribute);
        }
        return inputattribute;
    }

    public volatile Node put(String s, String s1)
    {
        return put(s, s1);
    }

    public InputNode remove(String s)
    {
        return (InputNode)super.remove(s);
    }

    public volatile Node remove(String s)
    {
        return remove(s);
    }
}
