// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, Introspector, Qualifier, Contact, 
//            Context, AttributeException, Primitive, Expression, 
//            Decorator, Converter

class VersionLabel extends TemplateLabel
{

    private Decorator decorator;
    private Introspector detail;
    private Format format;
    private Version label;
    private String name;
    private Expression path;
    private boolean required;
    private Class type;

    public VersionLabel(Contact contact, Version version, Format format1)
    {
        detail = new Introspector(contact, this, format1);
        decorator = new Qualifier(contact);
        required = version.required();
        type = contact.getType();
        name = version.name();
        format = format1;
        label = version;
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
        Contact contact = getContact();
        if (!context.isFloat(contact))
        {
            Object aobj[] = new Object[2];
            aobj[0] = label;
            aobj[1] = contact;
            throw new AttributeException("Cannot use %s to represent %s", aobj);
        } else
        {
            return new Primitive(context, contact, s);
        }
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
        return null;
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
