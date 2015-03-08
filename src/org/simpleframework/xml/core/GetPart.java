// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.core:
//            MethodPart, MethodName, Reflector, MethodType

class GetPart
    implements MethodPart
{

    private final Cache cache = new ConcurrentCache();
    private final Annotation label;
    private final Annotation list[];
    private final Method method;
    private final String name;
    private final MethodType type;

    public GetPart(MethodName methodname, Annotation annotation, Annotation aannotation[])
    {
        method = methodname.getMethod();
        name = methodname.getName();
        type = methodname.getType();
        label = annotation;
        list = aannotation;
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public Annotation getAnnotation(Class class1)
    {
        if (cache.isEmpty())
        {
            Annotation aannotation[] = list;
            int i = aannotation.length;
            for (int j = 0; j < i; j++)
            {
                Annotation annotation = aannotation[j];
                Class class2 = annotation.annotationType();
                cache.cache(class2, annotation);
            }

        }
        return (Annotation)cache.fetch(class1);
    }

    public Class getDeclaringClass()
    {
        return method.getDeclaringClass();
    }

    public Class getDependent()
    {
        return Reflector.getReturnDependent(method);
    }

    public Class[] getDependents()
    {
        return Reflector.getReturnDependents(method);
    }

    public Method getMethod()
    {
        if (!method.isAccessible())
        {
            method.setAccessible(true);
        }
        return method;
    }

    public MethodType getMethodType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public Class getType()
    {
        return method.getReturnType();
    }

    public String toString()
    {
        return method.toGenericString();
    }
}
