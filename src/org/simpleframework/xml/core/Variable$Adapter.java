// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Repeater, PersistenceException, Label, Converter

class label
    implements Repeater
{

    private final Label label;
    private final Converter reader;
    private final Object value;

    public Object read(InputNode inputnode)
    {
        return read(inputnode, value);
    }

    public Object read(InputNode inputnode, Object obj)
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        String s = inputnode.getName();
        if (reader instanceof Repeater)
        {
            return ((Repeater)reader).read(inputnode, obj);
        } else
        {
            Object aobj[] = new Object[3];
            aobj[0] = s;
            aobj[1] = label;
            aobj[2] = position;
            throw new PersistenceException("Element '%s' is already used with %s at %s", aobj);
        }
    }

    public boolean validate(InputNode inputnode)
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        String s = inputnode.getName();
        if (reader instanceof Repeater)
        {
            return ((Repeater)reader).validate(inputnode);
        } else
        {
            throw new PersistenceException("Element '%s' declared twice at %s", new Object[] {
                s, position
            });
        }
    }

    public void write(OutputNode outputnode, Object obj)
    {
        write(outputnode, obj);
    }

    public ion(Converter converter, Label label1, Object obj)
    {
        reader = converter;
        value = obj;
        label = label1;
    }
}
