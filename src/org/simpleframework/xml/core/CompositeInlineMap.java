// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Repeater, MapFactory, Entry, Context, 
//            Converter

class CompositeInlineMap
    implements Repeater
{

    private final Entry entry;
    private final MapFactory factory;
    private final Converter key;
    private final Style style;
    private final Converter value;

    public CompositeInlineMap(Context context, Entry entry1, Type type)
    {
        factory = new MapFactory(context, type);
        value = entry1.getValue(context);
        key = entry1.getKey(context);
        style = context.getStyle();
        entry = entry1;
    }

    private Object read(InputNode inputnode, Map map)
    {
        InputNode inputnode1 = inputnode.getParent();
        String s = inputnode.getName();
        for (; inputnode != null; inputnode = inputnode1.getNext(s))
        {
            Object obj = key.read(inputnode);
            Object obj1 = value.read(inputnode);
            if (map != null)
            {
                map.put(obj, obj1);
            }
        }

        return map;
    }

    private void write(OutputNode outputnode, Map map, Mode mode)
    {
        String s = entry.getEntry();
        String s1 = style.getElement(s);
        OutputNode outputnode1;
        Object obj1;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); value.write(outputnode1, obj1))
        {
            Object obj = iterator.next();
            outputnode1 = outputnode.getChild(s1);
            obj1 = map.get(obj);
            outputnode1.setMode(mode);
            key.write(outputnode1, obj);
        }

    }

    public Object read(InputNode inputnode)
    {
        Map map = (Map)factory.getInstance();
        if (map != null)
        {
            return read(inputnode, map);
        } else
        {
            return null;
        }
    }

    public Object read(InputNode inputnode, Object obj)
    {
        Map map = (Map)obj;
        if (map != null)
        {
            return read(inputnode, map);
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
            while (!key.validate(inputnode) || !value.validate(inputnode)) 
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
        Map map = (Map)obj;
        if (!outputnode.isCommitted())
        {
            outputnode.remove();
        }
        write(outputnode1, map, mode);
    }
}
