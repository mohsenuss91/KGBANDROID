// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.NodeMap;

// Referenced classes of package org.simpleframework.xml.strategy:
//            Strategy, TreeStrategy, Visitor, Type, 
//            Value

public class VisitorStrategy
    implements Strategy
{

    private final Strategy strategy;
    private final Visitor visitor;

    public VisitorStrategy(Visitor visitor1)
    {
        this(visitor1, ((Strategy) (new TreeStrategy())));
    }

    public VisitorStrategy(Visitor visitor1, Strategy strategy1)
    {
        strategy = strategy1;
        visitor = visitor1;
    }

    public Value read(Type type, NodeMap nodemap, Map map)
    {
        if (visitor != null)
        {
            visitor.read(type, nodemap);
        }
        return strategy.read(type, nodemap, map);
    }

    public boolean write(Type type, Object obj, NodeMap nodemap, Map map)
    {
        boolean flag = strategy.write(type, obj, nodemap, map);
        if (visitor != null)
        {
            visitor.write(type, nodemap);
        }
        return flag;
    }
}
