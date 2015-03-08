// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Extractor, ElementMapLabel, Contact, Label

class union
    implements Extractor
{

    private final Contact contact;
    private final Format format;
    private final ElementMapUnion union;

    public volatile Annotation[] getAnnotations()
    {
        return getAnnotations();
    }

    public ElementMap[] getAnnotations()
    {
        return union.value();
    }

    public volatile Label getLabel(Annotation annotation)
    {
        return getLabel((ElementMap)annotation);
    }

    public Label getLabel(ElementMap elementmap)
    {
        return new ElementMapLabel(contact, elementmap, format);
    }

    public volatile Class getType(Annotation annotation)
    {
        return getType((ElementMap)annotation);
    }

    public Class getType(ElementMap elementmap)
    {
        return elementmap.valueType();
    }

    public (Contact contact1, ElementMapUnion elementmapunion, Format format1)
    {
        contact = contact1;
        format = format1;
        union = elementmapunion;
    }
}
