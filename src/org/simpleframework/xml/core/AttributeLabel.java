// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, Introspector, Qualifier, Contact, 
//            Primitive, Expression, Decorator, Context, 
//            Converter

class AttributeLabel extends TemplateLabel
{

    private Decorator decorator;
    private Introspector detail;
    private String empty;
    private Format format;
    private Attribute label;
    private String name;
    private Expression path;
    private boolean required;
    private Class type;

    public AttributeLabel(Contact contact, Attribute attribute, Format format1)
    {
        detail = new Introspector(contact, this, format1);
        decorator = new Qualifier(contact);
        required = attribute.required();
        type = contact.getType();
        empty = attribute.empty();
        name = attribute.name();
        format = format1;
        label = attribute;
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
        String s = getEmpty(context);
        return new Primitive(context, getContact(), s);
    }

    public Decorator getDecorator()
    {
        return decorator;
    }

    public volatile Object getEmpty(Context context)
    {
        return getEmpty(context);
    }

    public String getEmpty(Context context)
    {
        if (detail.isEmpty(empty))
        {
            return null;
        } else
        {
            return empty;
        }
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
        return format.getStyle().getAttribute(detail.getName());
    }

    public String getOverride()
    {
        return name;
    }

    public String getPath()
    {
        return getExpression().getAttribute(getName());
    }

    public Class getType()
    {
        return type;
    }

    public boolean isAttribute()
    {
        return true;
    }

    public boolean isData()
    {
        return false;
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
