// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            ParameterMap, Parameter

class Signature
    implements Iterable
{

    private final Constructor factory;
    private final ParameterMap parameters;
    private final Class type;

    public Signature(Constructor constructor)
    {
        this(constructor, constructor.getDeclaringClass());
    }

    public Signature(Constructor constructor, Class class1)
    {
        parameters = new ParameterMap();
        factory = constructor;
        type = class1;
    }

    public Signature(Signature signature)
    {
        this(signature.factory, signature.type);
    }

    public void add(Parameter parameter)
    {
        Object obj = parameter.getKey();
        if (obj != null)
        {
            parameters.put(obj, parameter);
        }
    }

    public boolean contains(Object obj)
    {
        return parameters.containsKey(obj);
    }

    public Signature copy()
    {
        Signature signature = new Signature(this);
        for (Iterator iterator1 = iterator(); iterator1.hasNext(); signature.add((Parameter)iterator1.next())) { }
        return signature;
    }

    public Object create()
    {
        if (!factory.isAccessible())
        {
            factory.setAccessible(true);
        }
        return factory.newInstance(new Object[0]);
    }

    public Object create(Object aobj[])
    {
        if (!factory.isAccessible())
        {
            factory.setAccessible(true);
        }
        return factory.newInstance(aobj);
    }

    public Parameter get(int i)
    {
        return parameters.get(i);
    }

    public Parameter get(Object obj)
    {
        return (Parameter)parameters.get(obj);
    }

    public List getAll()
    {
        return parameters.getAll();
    }

    public Class getType()
    {
        return type;
    }

    public boolean isEmpty()
    {
        return parameters.isEmpty();
    }

    public Iterator iterator()
    {
        return parameters.iterator();
    }

    public Parameter remove(Object obj)
    {
        return (Parameter)parameters.remove(obj);
    }

    public void set(Object obj, Parameter parameter)
    {
        parameters.put(obj, parameter);
    }

    public int size()
    {
        return parameters.size();
    }

    public String toString()
    {
        return factory.toString();
    }
}
