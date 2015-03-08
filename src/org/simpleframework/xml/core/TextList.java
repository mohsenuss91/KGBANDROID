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
//            Repeater, ClassType, CollectionFactory, Primitive, 
//            Instance, Context, Label

class TextList
    implements Repeater
{

    private final CollectionFactory factory;
    private final Primitive primitive;
    private final Type type = new ClassType(java/lang/String);

    public TextList(Context context, Type type1, Label label)
    {
        factory = new CollectionFactory(context, type1);
        primitive = new Primitive(context, type);
    }

    public Object read(InputNode inputnode)
    {
        Instance instance = factory.getInstance(inputnode);
        Object obj = instance.getInstance();
        if (instance.isReference())
        {
            return instance.getInstance();
        } else
        {
            return read(inputnode, obj);
        }
    }

    public Object read(InputNode inputnode, Object obj)
    {
        Collection collection = (Collection)obj;
        Object obj1 = primitive.read(inputnode);
        if (obj1 != null)
        {
            collection.add(obj1);
        }
        return obj;
    }

    public boolean validate(InputNode inputnode)
    {
        return true;
    }

    public void write(OutputNode outputnode, Object obj)
    {
        Collection collection = (Collection)obj;
        OutputNode outputnode1 = outputnode.getParent();
        Object obj1;
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); primitive.write(outputnode1, obj1))
        {
            obj1 = iterator.next();
        }

    }
}
