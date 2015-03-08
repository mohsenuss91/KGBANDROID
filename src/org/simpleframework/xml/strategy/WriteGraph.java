// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.IdentityHashMap;
import org.simpleframework.xml.stream.NodeMap;

// Referenced classes of package org.simpleframework.xml.strategy:
//            Contract, Type

class WriteGraph extends IdentityHashMap
{

    private final String label;
    private final String length;
    private final String mark;
    private final String refer;

    public WriteGraph(Contract contract)
    {
        refer = contract.getReference();
        mark = contract.getIdentity();
        length = contract.getLength();
        label = contract.getLabel();
    }

    private Class writeArray(Class class1, Object obj, NodeMap nodemap)
    {
        int i = Array.getLength(obj);
        if (!containsKey(obj))
        {
            nodemap.put(length, String.valueOf(i));
        }
        return class1.getComponentType();
    }

    private boolean writeReference(Object obj, NodeMap nodemap)
    {
        String s = (String)get(obj);
        int i = size();
        if (s != null)
        {
            nodemap.put(refer, s);
            return true;
        } else
        {
            String s1 = String.valueOf(i);
            nodemap.put(mark, s1);
            put(obj, s1);
            return false;
        }
    }

    public boolean write(Type type, Object obj, NodeMap nodemap)
    {
        Class class1 = obj.getClass();
        Class class2 = type.getType();
        Class class3;
        if (class1.isArray())
        {
            class3 = writeArray(class1, obj, nodemap);
        } else
        {
            class3 = class1;
        }
        if (class1 != class2)
        {
            nodemap.put(label, class3.getName());
        }
        return writeReference(obj, nodemap);
    }
}
