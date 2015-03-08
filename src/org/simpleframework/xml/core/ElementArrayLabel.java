// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, Introspector, Qualifier, Contact, 
//            Context, CompositeArray, PrimitiveArray, InstantiationException, 
//            ClassType, ArrayFactory, Factory, Expression, 
//            Decorator, Converter

class ElementArrayLabel extends TemplateLabel
{

    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private String entry;
    private Format format;
    private ElementArray label;
    private String name;
    private Expression path;
    private boolean required;
    private Class type;

    public ElementArrayLabel(Contact contact, ElementArray elementarray, Format format1)
    {
        detail = new Introspector(contact, this, format1);
        decorator = new Qualifier(contact);
        required = elementarray.required();
        type = contact.getType();
        entry = elementarray.entry();
        data = elementarray.data();
        name = elementarray.name();
        format = format1;
        label = elementarray;
    }

    private Converter getConverter(Context context, String s)
    {
        Type type1 = getDependent();
        Contact contact = getContact();
        if (!context.isPrimitive(type1))
        {
            return new CompositeArray(context, contact, type1, s);
        } else
        {
            return new PrimitiveArray(context, contact, type1, s);
        }
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public Contact getContact()
    {
        return detail.getContact();
    }

    public Converter getConverter(Context context)
    {
        Contact contact = getContact();
        String s = getEntry();
        if (!type.isArray())
        {
            Object aobj[] = new Object[2];
            aobj[0] = type;
            aobj[1] = contact;
            throw new InstantiationException("Type is not an array %s for %s", aobj);
        } else
        {
            return getConverter(context, s);
        }
    }

    public Decorator getDecorator()
    {
        return decorator;
    }

    public Type getDependent()
    {
        Class class1 = type.getComponentType();
        if (class1 == null)
        {
            return new ClassType(type);
        } else
        {
            return new ClassType(class1);
        }
    }

    public Object getEmpty(Context context)
    {
        ArrayFactory arrayfactory = new ArrayFactory(context, new ClassType(type));
        if (!label.empty())
        {
            return arrayfactory.getInstance();
        } else
        {
            return null;
        }
    }

    public String getEntry()
    {
        Style style = format.getStyle();
        if (detail.isEmpty(entry))
        {
            entry = detail.getEntry();
        }
        return style.getElement(entry);
    }

    public Expression getExpression()
    {
        if (path == null)
        {
            path = detail.getExpression();
        }
        return path;
    }

    public String getName()
    {
        return format.getStyle().getElement(detail.getName());
    }

    public String getOverride()
    {
        return name;
    }

    public String getPath()
    {
        return getExpression().getElement(getName());
    }

    public Class getType()
    {
        return type;
    }

    public boolean isData()
    {
        return data;
    }

    public boolean isRequired()
    {
        return required;
    }

    public String toString()
    {
        return detail.toString();
    }
}
