// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

// Referenced classes of package org.simpleframework.xml.strategy:
//            WriteGraph, Contract

class WriteState extends WeakCache
{

    private Contract contract;

    public WriteState(Contract contract1)
    {
        contract = contract1;
    }

    public WriteGraph find(Object obj)
    {
        WriteGraph writegraph = (WriteGraph)fetch(obj);
        if (writegraph == null)
        {
            writegraph = new WriteGraph(contract);
            cache(obj, writegraph);
        }
        return writegraph;
    }
}
