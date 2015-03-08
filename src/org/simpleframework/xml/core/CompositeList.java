// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, CollectionFactory, Traverser, Instance, 
//            PersistenceException, Context

class CompositeList
    implements Converter
{

    private final Type entry;
    private final CollectionFactory factory;
    private final String name;
    private final Traverser root;
    private final Type type;

    public CompositeList(Context context, Type type1, Type type2, String s)
    {
        factory = new CollectionFactory(context, type1);
        root = new Traverser(context);
        entry = type2;
        type = type1;
        name = s;
    }

    private Object populate(InputNode inputnode, Object obj)
    {
        Collection collection = (Collection)obj;
        do
        {
            InputNode inputnode1 = inputnode.getNext();
            Class class1 = entry.getType();
            if (inputnode1 == null)
            {
                return collection;
            }
            collection.add(root.read(inputnode1, class1));
        } while (true);
    }

    private boolean validate(InputNode inputnode, Class class1)
    {
        do
        {
            InputNode inputnode1 = inputnode.getNext();
            Class class2 = entry.getType();
            if (inputnode1 == null)
            {
                return true;
            }
            root.validate(inputnode1, class2);
        } while (true);
    }

    public Object read(InputNode inputnode)
    {
        Instance instance = factory.getInstance(inputnode);
        Object obj = instance.getInstance();
        if (!instance.isReference())
        {
            obj = populate(inputnode, obj);
        }
        return obj;
    }

    public Object read(InputNode inputnode, Object obj)
    {
        Instance instance = factory.getInstance(inputnode);
        if (instance.isReference())
        {
            obj = instance.getInstance();
        } else
        {
            instance.setInstance(obj);
            if (obj != null)
            {
                return populate(inputnode, obj);
            }
        }
        return obj;
    }

    public boolean validate(InputNode inputnode)
    {
        Instance instance = factory.getInstance(inputnode);
        if (!instance.isReference())
        {
            instance.setInstance(null);
            return validate(inputnode, instance.getType());
        } else
        {
            return true;
        }
    }

    public void write(OutputNode outputnode, Object obj)
    {
        Iterator iterator = ((Collection)obj).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = iterator.next();
            if (obj1 != null)
            {
                Class class1 = entry.getType();
                Class class2 = obj1.getClass();
                if (!class1.isAssignableFrom(class2))
                {
                    Object aobj[] = new Object[3];
                    aobj[0] = class2;
                    aobj[1] = entry;
                    aobj[2] = type;
                    throw new PersistenceException("Entry %s does not match %s for %s", aobj);
                }
                root.write(outputnode, obj1, class1, name);
            }
        } while (true);
    }
}
