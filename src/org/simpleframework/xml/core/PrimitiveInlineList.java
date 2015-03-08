// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Repeater, CollectionFactory, Primitive, Context

class PrimitiveInlineList
    implements Repeater
{

    private final Type entry;
    private final CollectionFactory factory;
    private final String parent;
    private final Primitive root;

    public PrimitiveInlineList(Context context, Type type, Type type1, String s)
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

    private Object read(InputNode inputnode, Collection collection)
    {
        InputNode inputnode1 = inputnode.getParent();
        String s = inputnode.getName();
        for (; inputnode != null; inputnode = inputnode1.getNext(s))
        {
            Object obj = root.read(inputnode);
            if (obj != null)
            {
                collection.add(obj);
            }
        }

        return collection;
    }

    private void write(OutputNode outputnode, Object obj, Mode mode)
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
                    outputnode1.setMode(mode);
                    root.write(outputnode1, obj1);
                }
            }
        } while (true);
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
        String s = inputnode.getName();
        for (; inputnode != null; inputnode = inputnode1.getNext(s))
        {
            if (!root.validate(inputnode))
            {
                return false;
            }
        }

        return true;
    }

    public void write(OutputNode outputnode, Object obj)
    {
        OutputNode outputnode1 = outputnode.getParent();
        Mode mode = outputnode.getMode();
        if (!outputnode.isCommitted())
        {
            outputnode.remove();
        }
        write(outputnode1, obj, mode);
    }
}
