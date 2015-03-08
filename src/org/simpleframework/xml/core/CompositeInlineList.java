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
//            Repeater, CollectionFactory, Traverser, PersistenceException, 
//            Context

class CompositeInlineList
    implements Repeater
{

    private final Type entry;
    private final CollectionFactory factory;
    private final String name;
    private final Traverser root;
    private final Type type;

    public CompositeInlineList(Context context, Type type1, Type type2, String s)
    {
        factory = new CollectionFactory(context, type1);
        root = new Traverser(context);
        entry = type2;
        type = type1;
        name = s;
    }

    private Object read(InputNode inputnode, Class class1)
    {
        Object obj = root.read(inputnode, class1);
        Class class2 = obj.getClass();
        if (!entry.getType().isAssignableFrom(class2))
        {
            Object aobj[] = new Object[3];
            aobj[0] = class2;
            aobj[1] = entry;
            aobj[2] = type;
            throw new PersistenceException("Entry %s does not match %s for %s", aobj);
        } else
        {
            return obj;
        }
    }

    private Object read(InputNode inputnode, Collection collection)
    {
        InputNode inputnode1 = inputnode.getParent();
        String s = inputnode.getName();
        for (; inputnode != null; inputnode = inputnode1.getNext(s))
        {
            Object obj = read(inputnode, entry.getType());
            if (obj != null)
            {
                collection.add(obj);
            }
        }

        return collection;
    }

    public Object read(InputNode inputnode)
    {
        Collection collection = (Collection)factory.getInstance();
        if (collection != null)
        {
            return read(inputnode, collection);
        } else
        {
            return null;
        }
    }

    public Object read(InputNode inputnode, Object obj)
    {
        Collection collection = (Collection)obj;
        if (collection != null)
        {
            return read(inputnode, collection);
        } else
        {
            return read(inputnode);
        }
    }

    public boolean validate(InputNode inputnode)
    {
        InputNode inputnode1 = inputnode.getParent();
        Class class1 = entry.getType();
        String s = inputnode.getName();
        for (; inputnode != null; inputnode = inputnode1.getNext(s))
        {
            if (!root.validate(inputnode, class1))
            {
                return false;
            }
        }

        return true;
    }

    public void write(OutputNode outputnode, Object obj)
    {
        Collection collection = (Collection)obj;
        OutputNode outputnode1 = outputnode.getParent();
        if (!outputnode.isCommitted())
        {
            outputnode.remove();
        }
        write(outputnode1, collection);
    }

    public void write(OutputNode outputnode, Collection collection)
    {
        Iterator iterator = collection.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (obj != null)
            {
                Class class1 = entry.getType();
                Class class2 = obj.getClass();
                if (!class1.isAssignableFrom(class2))
                {
                    Object aobj[] = new Object[3];
                    aobj[0] = class2;
                    aobj[1] = class1;
                    aobj[2] = type;
                    throw new PersistenceException("Entry %s does not match %s for %s", aobj);
                }
                root.write(outputnode, obj, class1, name);
            }
        } while (true);
    }
}
