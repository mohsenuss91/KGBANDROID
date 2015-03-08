// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, MapFactory, Entry, Context, 
//            Instance

class CompositeMap
    implements Converter
{

    private final Entry entry;
    private final MapFactory factory;
    private final Converter key;
    private final Style style;
    private final Converter value;

    public CompositeMap(Context context, Entry entry1, Type type)
    {
        factory = new MapFactory(context, type);
        value = entry1.getValue(context);
        key = entry1.getKey(context);
        style = context.getStyle();
        entry = entry1;
    }

    private Object populate(InputNode inputnode, Object obj)
    {
        Map map = (Map)obj;
        do
        {
            InputNode inputnode1 = inputnode.getNext();
            if (inputnode1 == null)
            {
                return map;
            }
            map.put(key.read(inputnode1), value.read(inputnode1));
        } while (true);
    }

    private boolean validate(InputNode inputnode, Class class1)
    {
_L6:
        InputNode inputnode1 = inputnode.getNext();
        if (inputnode1 != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        boolean flag;
        flag = key.validate(inputnode1);
        flag1 = false;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (!value.validate(inputnode1))
        {
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
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
        Map map = (Map)obj;
        OutputNode outputnode1;
        Object obj2;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); value.write(outputnode1, obj2))
        {
            Object obj1 = iterator.next();
            String s = entry.getEntry();
            outputnode1 = outputnode.getChild(style.getElement(s));
            obj2 = map.get(obj1);
            key.write(outputnode1, obj1);
        }

    }
}
