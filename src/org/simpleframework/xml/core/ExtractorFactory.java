// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            PersistenceException, Extractor, Contact

class ExtractorFactory
{

    private final Contact contact;
    private final Format format;
    private final Annotation label;

    public ExtractorFactory(Contact contact1, Annotation annotation, Format format1)
    {
        contact = contact1;
        format = format1;
        label = annotation;
    }

    private ExtractorBuilder getBuilder(Annotation annotation)
    {
        if (annotation instanceof ElementUnion)
        {
            return new ExtractorBuilder(org/simpleframework/xml/ElementUnion, org/simpleframework/xml/core/ExtractorFactory$ElementExtractor);
        }
        if (annotation instanceof ElementListUnion)
        {
            return new ExtractorBuilder(org/simpleframework/xml/ElementListUnion, org/simpleframework/xml/core/ExtractorFactory$ElementListExtractor);
        }
        if (annotation instanceof ElementMapUnion)
        {
            return new ExtractorBuilder(org/simpleframework/xml/ElementMapUnion, org/simpleframework/xml/core/ExtractorFactory$ElementMapExtractor);
        } else
        {
            throw new PersistenceException("Annotation %s is not a union", new Object[] {
                annotation
            });
        }
    }

    private Object getInstance(Annotation annotation)
    {
        Constructor constructor = getBuilder(annotation).getConstructor();
        if (!constructor.isAccessible())
        {
            constructor.setAccessible(true);
        }
        Object aobj[] = new Object[3];
        aobj[0] = contact;
        aobj[1] = annotation;
        aobj[2] = format;
        return constructor.newInstance(aobj);
    }

    public Extractor getInstance()
    {
        return (Extractor)getInstance(label);
    }

    private class ExtractorBuilder
    {

        private final Class label;
        private final Class type;

        private Constructor getConstructor()
        {
            Class class1 = type;
            Class aclass[] = new Class[3];
            aclass[0] = org/simpleframework/xml/core/Contact;
            aclass[1] = label;
            aclass[2] = org/simpleframework/xml/stream/Format;
            return class1.getConstructor(aclass);
        }


        public ExtractorBuilder(Class class1, Class class2)
        {
            label = class1;
            type = class2;
        }
    }

}
