// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.convert;

import java.util.Map;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.convert:
//            Registry, Converter, Reference

public class RegistryStrategy
    implements Strategy
{

    private final Registry registry;
    private final Strategy strategy;

    public RegistryStrategy(Registry registry1)
    {
        this(registry1, ((Strategy) (new TreeStrategy())));
    }

    public RegistryStrategy(Registry registry1, Strategy strategy1)
    {
        registry = registry1;
        strategy = strategy1;
    }

    private boolean isReference(Value value)
    {
        return value != null && value.isReference();
    }

    private Converter lookup(Type type, Object obj)
    {
        Class class1 = type.getType();
        if (obj != null)
        {
            class1 = obj.getClass();
        }
        return registry.lookup(class1);
    }

    private Converter lookup(Type type, Value value)
    {
        Class class1 = type.getType();
        if (value != null)
        {
            class1 = value.getType();
        }
        return registry.lookup(class1);
    }

    private Value read(Type type, NodeMap nodemap, Value value)
    {
        Converter converter = lookup(type, value);
        InputNode inputnode = (InputNode)nodemap.getNode();
        if (converter != null)
        {
            Object obj = converter.read(inputnode);
            Class class1 = type.getType();
            if (value != null)
            {
                value.setValue(obj);
            }
            value = new Reference(value, obj, class1);
        }
        return value;
    }

    private boolean write(Type type, Object obj, NodeMap nodemap)
    {
        Converter converter = lookup(type, obj);
        OutputNode outputnode = (OutputNode)nodemap.getNode();
        if (converter != null)
        {
            converter.write(outputnode, obj);
            return true;
        } else
        {
            return false;
        }
    }

    public Value read(Type type, NodeMap nodemap, Map map)
    {
        Value value = strategy.read(type, nodemap, map);
        if (isReference(value))
        {
            return value;
        } else
        {
            return read(type, nodemap, value);
        }
    }

    public boolean write(Type type, Object obj, NodeMap nodemap, Map map)
    {
        boolean flag = strategy.write(type, obj, nodemap, map);
        if (!flag)
        {
            flag = write(type, obj, nodemap);
        }
        return flag;
    }
}
