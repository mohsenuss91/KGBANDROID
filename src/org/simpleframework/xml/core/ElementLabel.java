// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, Introspector, Qualifier, Contact, 
//            Context, Primitive, Composite, Expression, 
//            OverrideType, Decorator, Converter

class ElementLabel extends TemplateLabel
{

    private Expression cache;
    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private Class expect;
    private Format format;
    private Element label;
    private String name;
    private String override;
    private String path;
    private boolean required;
    private Class type;

    public ElementLabel(Contact contact, Element element, Format format1)
    {
        detail = new Introspector(contact, this, format1);
        decorator = new Qualifier(contact);
        required = element.required();
        type = contact.getType();
        override = element.name();
        expect = element.type();
        data = element.data();
        format = format1;
        label = element;
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
        if (context.isPrimitive(contact))
        {
            return new Primitive(context, contact);
        }
        if (expect == Void.TYPE)
        {
            return new Composite(context, contact);
        } else
        {
            return new Composite(context, contact, expect);
        }
    }

    public Decorator getDecorator()
    {
        return decorator;
    }

    public Object getEmpty(Context context)
    {
        return null;
    }

    public Expression getExpression()
    {
        if (cache == null)
        {
            cache = detail.getExpression();
        }
        return cache;
    }

    public String getName()
    {
        if (name == null)
        {
            name = format.getStyle().getElement(detail.getName());
        }
        return name;
    }

    public String getOverride()
    {
        return override;
    }

    public String getPath()
    {
        if (path == null)
        {
            path = getExpression().getElement(getName());
        }
        return path;
    }

    public Class getType()
    {
        if (expect == Void.TYPE)
        {
            return type;
        } else
        {
            return expect;
        }
    }

    public Type getType(Class class1)
    {
        Contact contact = getContact();
        if (expect == Void.TYPE)
        {
            return contact;
        } else
        {
            return new OverrideType(contact, expect);
        }
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
