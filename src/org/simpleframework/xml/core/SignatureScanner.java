// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;

// Referenced classes of package org.simpleframework.xml.core:
//            SignatureBuilder, ParameterFactory, UnionException, Parameter, 
//            ParameterMap, Signature, ConstructorException, Support

class SignatureScanner
{

    private final SignatureBuilder builder;
    private final Constructor constructor;
    private final ParameterFactory factory;
    private final ParameterMap registry;
    private final Class type;

    public SignatureScanner(Constructor constructor1, ParameterMap parametermap, Support support)
    {
        builder = new SignatureBuilder(constructor1);
        factory = new ParameterFactory(support);
        type = constructor1.getDeclaringClass();
        constructor = constructor1;
        registry = parametermap;
        scan(type);
    }

    private List create(Annotation annotation, int i)
    {
        Parameter parameter = factory.getInstance(constructor, annotation, i);
        if (parameter != null)
        {
            register(parameter);
        }
        return Collections.singletonList(parameter);
    }

    private Annotation[] extract(Annotation annotation)
    {
        Method amethod[] = annotation.annotationType().getDeclaredMethods();
        if (amethod.length != 1)
        {
            Object aobj[] = new Object[2];
            aobj[0] = annotation;
            aobj[1] = type;
            throw new UnionException("Annotation '%s' is not a valid union for %s", aobj);
        } else
        {
            return (Annotation[])(Annotation[])amethod[0].invoke(annotation, new Object[0]);
        }
    }

    private List process(Annotation annotation, int i)
    {
        if (annotation instanceof Attribute)
        {
            return create(annotation, i);
        }
        if (annotation instanceof Element)
        {
            return create(annotation, i);
        }
        if (annotation instanceof ElementList)
        {
            return create(annotation, i);
        }
        if (annotation instanceof ElementArray)
        {
            return create(annotation, i);
        }
        if (annotation instanceof ElementMap)
        {
            return create(annotation, i);
        }
        if (annotation instanceof ElementListUnion)
        {
            return union(annotation, i);
        }
        if (annotation instanceof ElementMapUnion)
        {
            return union(annotation, i);
        }
        if (annotation instanceof ElementUnion)
        {
            return union(annotation, i);
        }
        if (annotation instanceof Text)
        {
            return create(annotation, i);
        } else
        {
            return Collections.emptyList();
        }
    }

    private void register(Parameter parameter)
    {
        String s = parameter.getPath();
        Object obj = parameter.getKey();
        if (registry.containsKey(obj))
        {
            validate(parameter, obj);
        }
        if (registry.containsKey(s))
        {
            validate(parameter, s);
        }
        registry.put(s, parameter);
        registry.put(obj, parameter);
    }

    private void scan(Class class1)
    {
        Class aclass[] = constructor.getParameterTypes();
        for (int i = 0; i < aclass.length; i++)
        {
            scan(aclass[i], i);
        }

    }

    private void scan(Class class1, int i)
    {
        Annotation aannotation[][] = constructor.getParameterAnnotations();
        for (int j = 0; j < aannotation[i].length; j++)
        {
            Parameter parameter;
            for (Iterator iterator = process(aannotation[i][j], i).iterator(); iterator.hasNext(); builder.insert(parameter, i))
            {
                parameter = (Parameter)iterator.next();
            }

        }

    }

    private List union(Annotation annotation, int i)
    {
        Signature signature = new Signature(constructor);
        Annotation aannotation[] = extract(annotation);
        int j = aannotation.length;
        for (int k = 0; k < j; k++)
        {
            Annotation annotation1 = aannotation[k];
            Parameter parameter = factory.getInstance(constructor, annotation, annotation1, i);
            String s = parameter.getPath();
            if (signature.contains(s))
            {
                Object aobj[] = new Object[3];
                aobj[0] = s;
                aobj[1] = annotation;
                aobj[2] = type;
                throw new UnionException("Annotation name '%s' used more than once in %s for %s", aobj);
            }
            signature.set(s, parameter);
            register(parameter);
        }

        return signature.getAll();
    }

    private void validate(Parameter parameter, Object obj)
    {
        Parameter parameter1 = (Parameter)registry.get(obj);
        if (parameter.isText() != parameter1.isText())
        {
            Annotation annotation = parameter.getAnnotation();
            Annotation annotation1 = parameter1.getAnnotation();
            String s = parameter.getPath();
            if (!annotation.equals(annotation1))
            {
                Object aobj1[] = new Object[2];
                aobj1[0] = s;
                aobj1[1] = type;
                throw new ConstructorException("Annotations do not match for '%s' in %s", aobj1);
            }
            if (parameter1.getType() != parameter.getType())
            {
                Object aobj[] = new Object[2];
                aobj[0] = s;
                aobj[1] = type;
                throw new ConstructorException("Parameter types do not match for '%s' in %s", aobj);
            }
        }
    }

    public List getSignatures()
    {
        return builder.build();
    }

    public boolean isValid()
    {
        return builder.isValid();
    }
}
