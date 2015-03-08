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
//            ConverterScanner, Converter, Reference

public class AnnotationStrategy
    implements Strategy
{

    private final ConverterScanner scanner;
    private final Strategy strategy;

    public AnnotationStrategy()
    {
        this(((Strategy) (new TreeStrategy())));
    }

    public AnnotationStrategy(Strategy strategy1)
    {
        scanner = new ConverterScanner();
        strategy = strategy1;
    }

    private boolean isReference(Value value)
    {
        return value != null && value.isReference();
    }

    private Value read(Type type, NodeMap nodemap, Value value)
    {
        Converter converter = scanner.getConverter(type, value);
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
        Converter converter = scanner.getConverter(type, obj);
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
