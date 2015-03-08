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
//            Converter, CollectionFactory, Primitive, Instance, 
//            Context

class PrimitiveList
    implements Converter
{

    private final Type entry;
    private final CollectionFactory factory;
    private final String parent;
    private final Primitive root;

    public PrimitiveList(Context context, Type type, Type type1, String s)
    {
        factory = new CollectionFactory(context, type);
        root = new Primitive(context, type1);
        parent = s;
        entry = type1;
    }

    private boolean isOverridden(OutputNode outputnode, Object obj)
    {
        return factory.setOverride(entry, obj, outputnode);
    }

    private Object populate(InputNode inputnode, Object obj)
    {
        Collection collection = (Collection)obj;
        do
        {
            InputNode inputnode1 = inputnode.getNext();
            if (inputnode1 == null)
            {
                return collection;
            }
            collection.add(root.read(inputnode1));
        } while (true);
    }

    private boolean validate(InputNode inputnode, Class class1)
    {
        do
        {
            InputNode inputnode1 = inputnode.getNext();
            if (inputnode1 == null)
            {
                return true;
            }
            root.validate(inputnode1);
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
                OutputNode outputnode1 = outputnode.getChild(parent);
                if (!isOverridden(outputnode1, obj1))
                {
                    root.write(outputnode1, obj1);
                }
            }
        } while (true);
    }
}
