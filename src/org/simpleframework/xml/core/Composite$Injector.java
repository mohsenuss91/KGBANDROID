// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Schema, Instantiator, Instance, Criteria, 
//            Composite

class <init> extends <init>
{

    final Composite this$0;

    private Object readInject(InputNode inputnode)
    {
        Object obj = schema.getInstantiator().getInstance(criteria);
        value.setInstance(obj);
        criteria.commit(obj);
        return obj;
    }

    public Object read(InputNode inputnode)
    {
        Section section = schema.getSection();
        Composite.access$100(composite, inputnode, null, schema);
        Composite.access$200(composite, inputnode, null, section);
        Composite.access$300(composite, inputnode, null, section);
        Composite.access$400(composite, inputnode, null, section);
        return readInject(inputnode);
    }

    private (Composite composite1, Criteria criteria, Schema schema, Instance instance)
    {
        this$0 = Composite.this;
        super(composite1, criteria, schema, instance);
    }

    init>(Composite composite1, Criteria criteria, Schema schema, Instance instance, init> init>)
    {
        this(composite1, criteria, schema, instance);
    }
}
