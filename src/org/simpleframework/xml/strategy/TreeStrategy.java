// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.Map;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

// Referenced classes of package org.simpleframework.xml.strategy:
//            Strategy, Loader, ArrayValue, Type, 
//            ObjectValue, Value

public class TreeStrategy
    implements Strategy
{

    private final String label;
    private final String length;
    private final Loader loader;

    public TreeStrategy()
    {
        this("class", "length");
    }

    public TreeStrategy(String s, String s1)
    {
        loader = new Loader();
        length = s1;
        label = s;
    }

    private Value readArray(Class class1, NodeMap nodemap)
    {
        Node node = nodemap.remove(length);
        int i = 0;
        if (node != null)
        {
            i = Integer.parseInt(node.getValue());
        }
        return new ArrayValue(class1, i);
    }

    private Class readValue(Type type, NodeMap nodemap)
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
        return class1;
    }

    private Class writeArray(Class class1, Object obj, NodeMap nodemap)
    {
        int i = Array.getLength(obj);
        if (length != null)
        {
            nodemap.put(length, String.valueOf(i));
        }
        return class1.getComponentType();
    }

    public Value read(Type type, NodeMap nodemap, Map map)
    {
        Class class1 = readValue(type, nodemap);
        Class class2 = type.getType();
        if (class2.isArray())
        {
            return readArray(class1, nodemap);
        }
        if (class2 != class1)
        {
            return new ObjectValue(class1);
        } else
        {
            return null;
        }
    }

    public boolean write(Type type, Object obj, NodeMap nodemap, Map map)
    {
        Class class1 = obj.getClass();
        Class class2 = type.getType();
        Class class3;
        if (class1.isArray())
        {
            class3 = writeArray(class2, obj, nodemap);
        } else
        {
            class3 = class1;
        }
        if (class1 != class2)
        {
            nodemap.put(label, class3.getName());
        }
        return false;
    }
}
