// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Support, ElementParameter, ElementListParameter, ElementArrayParameter, 
//            ElementMapUnionParameter, ElementListUnionParameter, ElementUnionParameter, ElementMapParameter, 
//            AttributeParameter, TextParameter, PersistenceException, Parameter

class ParameterFactory
{

    private final Format format;

    public ParameterFactory(Support support)
    {
        format = support.getFormat();
    }

    private ParameterBuilder getBuilder(Annotation annotation)
    {
        if (annotation instanceof Element)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementParameter, org/simpleframework/xml/Element);
        }
        if (annotation instanceof ElementList)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementListParameter, org/simpleframework/xml/ElementList);
        }
        if (annotation instanceof ElementArray)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementArrayParameter, org/simpleframework/xml/ElementArray);
        }
        if (annotation instanceof ElementMapUnion)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementMapUnionParameter, org/simpleframework/xml/ElementMapUnion, org/simpleframework/xml/ElementMap);
        }
        if (annotation instanceof ElementListUnion)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementListUnionParameter, org/simpleframework/xml/ElementListUnion, org/simpleframework/xml/ElementList);
        }
        if (annotation instanceof ElementUnion)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementUnionParameter, org/simpleframework/xml/ElementUnion, org/simpleframework/xml/Element);
        }
        if (annotation instanceof ElementMap)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/ElementMapParameter, org/simpleframework/xml/ElementMap);
        }
        if (annotation instanceof Attribute)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/AttributeParameter, org/simpleframework/xml/Attribute);
        }
        if (annotation instanceof Text)
        {
            return new ParameterBuilder(org/simpleframework/xml/core/TextParameter, org/simpleframework/xml/Text);
        } else
        {
            throw new PersistenceException("Annotation %s not supported", new Object[] {
                annotation
            });
        }
    }

    private Constructor getConstructor(Annotation annotation)
    {
        Constructor constructor = getBuilder(annotation).getConstructor();
        if (!constructor.isAccessible())
        {
            constructor.setAccessible(true);
        }
        return constructor;
    }

    public Parameter getInstance(Constructor constructor, Annotation annotation, int i)
    {
        return getInstance(constructor, annotation, null, i);
    }

    public Parameter getInstance(Constructor constructor, Annotation annotation, Annotation annotation1, int i)
    {
        Constructor constructor1 = getConstructor(annotation);
        if (annotation1 != null)
        {
            Object aobj1[] = new Object[5];
            aobj1[0] = constructor;
            aobj1[1] = annotation;
            aobj1[2] = annotation1;
            aobj1[3] = format;
            aobj1[4] = Integer.valueOf(i);
            return (Parameter)constructor1.newInstance(aobj1);
        } else
        {
            Object aobj[] = new Object[4];
            aobj[0] = constructor;
            aobj[1] = annotation;
            aobj[2] = format;
            aobj[3] = Integer.valueOf(i);
            return (Parameter)constructor1.newInstance(aobj);
        }
    }

    private class ParameterBuilder
    {

        private final Class entry;
        private final Class label;
        private final Class type;

        private transient Constructor getConstructor(Class aclass[])
        {
            return type.getConstructor(aclass);
        }

        public Constructor getConstructor()
        {
            if (entry != null)
            {
                return getConstructor(label, entry);
            } else
            {
                return getConstructor(label);
            }
        }

        public Constructor getConstructor(Class class1)
        {
            Class aclass[] = new Class[4];
            aclass[0] = java/lang/reflect/Constructor;
            aclass[1] = class1;
            aclass[2] = org/simpleframework/xml/stream/Format;
            aclass[3] = Integer.TYPE;
            return getConstructor(aclass);
        }

        public Constructor getConstructor(Class class1, Class class2)
        {
            Class aclass[] = new Class[5];
            aclass[0] = java/lang/reflect/Constructor;
            aclass[1] = class1;
            aclass[2] = class2;
            aclass[3] = org/simpleframework/xml/stream/Format;
            aclass[4] = Integer.TYPE;
            return getConstructor(aclass);
        }

        public ParameterBuilder(Class class1, Class class2)
        {
            this(class1, class2, null);
        }

        public ParameterBuilder(Class class1, Class class2, Class class3)
        {
            label = class2;
            entry = class3;
            type = class1;
        }
    }

}
