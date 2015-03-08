// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.core:
//            Instance

class InstanceFactory
{

    private final Cache cache = new ConcurrentCache();

    public InstanceFactory()
    {
    }

    public Instance getInstance(Class class1)
    {
        return new ClassInstance(class1);
    }

    public Instance getInstance(Value value)
    {
        return new ValueInstance(value);
    }

    protected Object getObject(Class class1)
    {
        Constructor constructor = (Constructor)cache.fetch(class1);
        if (constructor == null)
        {
            constructor = class1.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible())
            {
                constructor.setAccessible(true);
            }
            cache.cache(class1, constructor);
        }
        return constructor.newInstance(new Object[0]);
    }

    private class ClassInstance
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

        public ClassInstance(Class class1)
        {
            this$0 = InstanceFactory.this;
            super();
            type = class1;
        }
    }


    private class ValueInstance
        implements Instance
    {

        final InstanceFactory this$0;
        private final Class type;
        private final Value value;

        public Object getInstance()
        {
            Object obj;
            if (value.isReference())
            {
                obj = value.getValue();
            } else
            {
                obj = getObject(type);
                if (value != null)
                {
                    value.setValue(obj);
                    return obj;
                }
            }
            return obj;
        }

        public Class getType()
        {
            return type;
        }

        public boolean isReference()
        {
            return value.isReference();
        }

        public Object setInstance(Object obj)
        {
            if (value != null)
            {
                value.setValue(obj);
            }
            return obj;
        }

        public ValueInstance(Value value1)
        {
            this$0 = InstanceFactory.this;
            super();
            type = value1.getType();
            value = value1;
        }
    }

}
