// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Extractor, ElementLabel, Contact, Label

class union
    implements Extractor
{

    private final Contact contact;
    private final Format format;
    private final ElementUnion union;

    public volatile Annotation[] getAnnotations()
    {
        return getAnnotations();
    }

    public Element[] getAnnotations()
    {
        return union.value();
    }

    public volatile Label getLabel(Annotation annotation)
    {
        return getLabel((Element)annotation);
    }

    public Label getLabel(Element element)
    {
        return new ElementLabel(contact, element, format);
    }

    public volatile Class getType(Annotation annotation)
    {
        return getType((Element)annotation);
    }

    public Class getType(Element element)
    {
        Class class1 = element.type();
        if (class1 == Void.TYPE)
        {
            class1 = contact.getType();
        }
        return class1;
    }

    public (Contact contact1, ElementUnion elementunion, Format format1)
    {
        contact = contact1;
        format = format1;
        union = elementunion;
    }
}
