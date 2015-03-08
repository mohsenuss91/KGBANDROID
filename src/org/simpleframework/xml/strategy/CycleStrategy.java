// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.NodeMap;

// Referenced classes of package org.simpleframework.xml.strategy:
//            Strategy, Contract, WriteState, ReadState, 
//            ReadGraph, WriteGraph, Type, Value

public class CycleStrategy
    implements Strategy
{

    private final Contract contract;
    private final ReadState read;
    private final WriteState write;

    public CycleStrategy()
    {
        this("id", "reference");
    }

    public CycleStrategy(String s, String s1)
    {
        this(s, s1, "class");
    }

    public CycleStrategy(String s, String s1, String s2)
    {
        this(s, s1, s2, "length");
    }

    public CycleStrategy(String s, String s1, String s2, String s3)
    {
        contract = new Contract(s, s1, s2, s3);
        write = new WriteState(contract);
        read = new ReadState(contract);
    }

    public Value read(Type type, NodeMap nodemap, Map map)
    {
        ReadGraph readgraph = read.find(map);
        if (readgraph != null)
        {
            return readgraph.read(type, nodemap);
        } else
        {
            return null;
        }
    }

    public boolean write(Type type, Object obj, NodeMap nodemap, Map map)
    {
        WriteGraph writegraph = write.find(map);
        if (writegraph != null)
        {
            return writegraph.write(type, obj, nodemap);
        } else
        {
            return false;
        }
    }
}
