// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

// Referenced classes of package org.simpleframework.xml.strategy:
//            Loader, ReadGraph, Contract

class ReadState extends WeakCache
{

    private final Contract contract;
    private final Loader loader = new Loader();

    public ReadState(Contract contract1)
    {
        contract = contract1;
    }

    private ReadGraph create(Object obj)
    {
        ReadGraph readgraph = (ReadGraph)fetch(obj);
        if (readgraph == null)
        {
            readgraph = new ReadGraph(contract, loader);
            cache(obj, readgraph);
        }
        return readgraph;
    }

    public ReadGraph find(Object obj)
    {
        ReadGraph readgraph = (ReadGraph)fetch(obj);
        if (readgraph != null)
        {
            return readgraph;
        } else
        {
            return create(obj);
        }
    }
}
