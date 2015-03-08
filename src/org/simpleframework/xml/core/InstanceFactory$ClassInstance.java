// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            Instance, InstanceFactory

class type
    implements Instance
{

    final InstanceFactory this$0;
    private Class type;
    private Object value;

    public Object getInstance()
    {
        if (value == null)
        {
            value = getObject(type);
        }
        return value;
    }

    public Class getType()
    {
        return type;
    }

    public boolean isReference()
    {
        return false;
    }

    public Object setInstance(Object obj)
    {
        value = obj;
        return obj;
    }

    public (Class class1)
    {
        this$0 = InstanceFactory.this;
        super();
        type = class1;
    }
}
