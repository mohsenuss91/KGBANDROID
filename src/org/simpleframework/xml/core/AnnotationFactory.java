// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Verbosity;

// Referenced classes of package org.simpleframework.xml.core:
//            Detail, Support, AnnotationHandler

class AnnotationFactory
{

    private final Format format;
    private final boolean required;

    public AnnotationFactory(Detail detail, Support support)
    {
        required = detail.isRequired();
        format = support.getFormat();
    }

    private ClassLoader getClassLoader()
    {
        return org/simpleframework/xml/core/AnnotationFactory.getClassLoader();
    }

    private Annotation getInstance(Class class1)
    {
        ClassLoader classloader = getClassLoader();
        Class class2 = class1.getComponentType();
        if (class1.isArray())
        {
            if (isPrimitive(class2))
            {
                return getInstance(classloader, org/simpleframework/xml/Element);
            } else
            {
                return getInstance(classloader, org/simpleframework/xml/ElementArray);
            }
        }
        if (isPrimitive(class1) && isAttribute())
        {
            return getInstance(classloader, org/simpleframework/xml/Attribute);
        } else
        {
            return getInstance(classloader, org/simpleframework/xml/Element);
        }
    }

    private Annotation getInstance(ClassLoader classloader, Class class1)
    {
        return getInstance(classloader, class1, false);
    }

    private Annotation getInstance(ClassLoader classloader, Class class1, boolean flag)
    {
        AnnotationHandler annotationhandler = new AnnotationHandler(class1, required, flag);
        return (Annotation)Proxy.newProxyInstance(classloader, new Class[] {
            class1
        }, annotationhandler);
    }

    private boolean isAttribute()
    {
        Verbosity verbosity = format.getVerbosity();
        boolean flag = false;
        if (verbosity != null)
        {
            Verbosity verbosity1 = Verbosity.LOW;
            flag = false;
            if (verbosity == verbosity1)
            {
                flag = true;
            }
        }
        return flag;
    }

    private boolean isPrimitive(Class class1)
    {
        while (java/lang/Number.isAssignableFrom(class1) || class1 == java/lang/Boolean || class1 == java/lang/Character) 
        {
            return true;
        }
        return class1.isPrimitive();
    }

    private boolean isPrimitiveKey(Class aclass[])
    {
        if (aclass != null && aclass.length > 0)
        {
            Class class1 = aclass[0].getSuperclass();
            Class class2;
            for (class2 = aclass[0]; class1 != null && (class1.isEnum() || class2.isEnum());)
            {
                return true;
            }

            return isPrimitive(class2);
        } else
        {
            return false;
        }
    }

    public Annotation getInstance(Class class1, Class aclass[])
    {
        ClassLoader classloader = getClassLoader();
        if (java/util/Map.isAssignableFrom(class1))
        {
            if (isPrimitiveKey(aclass) && isAttribute())
            {
                return getInstance(classloader, org/simpleframework/xml/ElementMap, true);
            } else
            {
                return getInstance(classloader, org/simpleframework/xml/ElementMap);
            }
        }
        if (java/util/Collection.isAssignableFrom(class1))
        {
            return getInstance(classloader, org/simpleframework/xml/ElementList);
        } else
        {
            return getInstance(class1);
        }
    }
}
