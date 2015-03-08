// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

// Referenced classes of package org.simpleframework.xml.core:
//            Contact, Reflector

abstract class ParameterContact
    implements Contact
{

    protected final Constructor factory;
    protected final int index;
    protected final Annotation label;
    protected final Annotation labels[];
    protected final Class owner;

    public ParameterContact(Annotation annotation, Constructor constructor, int i)
    {
        labels = constructor.getParameterAnnotations()[i];
        owner = constructor.getDeclaringClass();
        factory = constructor;
        index = i;
        label = annotation;
    }

    public Object get(Object obj)
    {
        return null;
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public Annotation getAnnotation(Class class1)
    {
        Annotation aannotation[] = labels;
        int i = aannotation.length;
        for (int j = 0; j < i; j++)
        {
            Annotation annotation = aannotation[j];
            if (annotation.annotationType().equals(class1))
            {
                return annotation;
            }
        }

        return null;
    }

    public Class getDeclaringClass()
    {
        return owner;
    }

    public Class getDependent()
    {
        return Reflector.getParameterDependent(factory, index);
    }

    public Class[] getDependents()
    {
        return Reflector.getParameterDependents(factory, index);
    }

    public abstract String getName();

    public Class getType()
    {
        return factory.getParameterTypes()[index];
    }

    public boolean isReadOnly()
    {
        return false;
    }

    public void set(Object obj, Object obj1)
    {
    }

    public String toString()
    {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(index);
        aobj[1] = factory;
        return String.format("parameter %s of constructor %s", aobj);
    }
}
