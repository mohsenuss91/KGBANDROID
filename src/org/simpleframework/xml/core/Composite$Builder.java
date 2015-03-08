// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Instance, Schema, Composite, Criteria

class value
{

    protected final Composite composite;
    protected final Criteria criteria;
    protected final Schema schema;
    protected final Instance value;

    public Object read(InputNode inputnode)
    {
        Object obj = value.getInstance();
        Section section = schema.getSection();
        value.setInstance(obj);
        Composite.access$100(composite, inputnode, obj, schema);
        Composite.access$200(composite, inputnode, obj, section);
        Composite.access$300(composite, inputnode, obj, section);
        Composite.access$400(composite, inputnode, obj, section);
        criteria.commit(obj);
        return obj;
    }

    public (Composite composite1, Criteria criteria1, Schema schema1, Instance instance)
    {
        composite = composite1;
        criteria = criteria1;
        schema = schema1;
        value = instance;
    }
}
