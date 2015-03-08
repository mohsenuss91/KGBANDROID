// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;

import java.util.HashMap;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

// Referenced classes of package org.simpleframework.xml.strategy:
//            Contract, ArrayValue, CycleException, Reference, 
//            Type, ObjectValue, Allocate, Loader, 
//            Value

class ReadGraph extends HashMap
{

    private final String label;
    private final String length;
    private final Loader loader;
    private final String mark;
    private final String refer;

    public ReadGraph(Contract contract, Loader loader1)
    {
        refer = contract.getReference();
        mark = contract.getIdentity();
        length = contract.getLength();
        label = contract.getLabel();
        loader = loader1;
    }

    private Value readArray(Type type, Class class1, NodeMap nodemap)
    {
        Node node = nodemap.remove(length);
        int i = 0;
        if (node != null)
        {
            i = Integer.parseInt(node.getValue());
        }
        return new ArrayValue(class1, i);
    }

    private Value readInstance(Type type, Class class1, NodeMap nodemap)
    {
        Node node = nodemap.remove(mark);
        if (node == null)
        {
            return readReference(type, class1, nodemap);
        }
        String s = node.getValue();
        if (containsKey(s))
        {
            throw new CycleException("Element '%s' already exists", new Object[] {
                s
            });
        } else
        {
            return readValue(type, class1, nodemap, s);
        }
    }

    private Value readReference(Type type, Class class1, NodeMap nodemap)
    {
        Node node = nodemap.remove(refer);
        if (node == null)
        {
            return readValue(type, class1, nodemap);
        }
        String s = node.getValue();
        Object obj = get(s);
        if (!containsKey(s))
        {
            throw new CycleException("Invalid reference '%s' found", new Object[] {
                s
            });
        } else
        {
            return new Reference(obj, class1);
        }
    }

    private Value readValue(Type type, Class class1, NodeMap nodemap)
    {
        if (type.getType().isArray())
        {
            return readArray(type, class1, nodemap);
        } else
        {
            return new ObjectValue(class1);
        }
    }

    private Value readValue(Type type, Class class1, NodeMap nodemap, String s)
    {
        Value value = readValue(type, class1, nodemap);
        if (s != null)
        {
            return new Allocate(value, this, s);
        } else
        {
            return value;
        }
    }

    public Value read(Type type, NodeMap nodemap)
    {
        Node node = nodemap.remove(label);
        Class class1 = type.getType();
        if (class1.isArray())
        {
            class1 = class1.getComponentType();
        }
        if (node != null)
        {
            String s = node.getValue();
            class1 = loader.load(s);
        }
        return readInstance(type, class1, nodemap);
    }
}
