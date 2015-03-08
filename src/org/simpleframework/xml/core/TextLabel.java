// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, Introspector, Contact, Context, 
//            TextException, Primitive, Expression, Converter, 
//            Decorator

class TextLabel extends TemplateLabel
{

    private Contact contact;
    private boolean data;
    private Introspector detail;
    private String empty;
    private Text label;
    private Expression path;
    private boolean required;
    private Class type;

    public TextLabel(Contact contact1, Text text, Format format)
    {
        detail = new Introspector(contact1, this, format);
        required = text.required();
        type = contact1.getType();
        empty = text.empty();
        data = text.data();
        contact = contact1;
        label = text;
    }

    public Annotation getAnnotation()
    {
        return label;
    }

    public Contact getContact()
    {
        return contact;
    }

    public Converter getConverter(Context context)
    {
        String s = getEmpty(context);
        Contact contact1 = getContact();
        if (!context.isPrimitive(contact1))
        {
            Object aobj[] = new Object[2];
            aobj[0] = contact1;
            aobj[1] = label;
            throw new TextException("Cannot use %s to represent %s", aobj);
        } else
        {
            return new Primitive(context, contact1, s);
        }
    }

    public Decorator getDecorator()
    {
        return null;
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
        return "";
    }

    public String getOverride()
    {
        return contact.toString();
    }

    public String getPath()
    {
        return getExpression().getPath();
    }

    public Class getType()
    {
        return type;
    }

    public boolean isData()
    {
        return data;
    }

    public boolean isInline()
    {
        return true;
    }

    public boolean isRequired()
    {
        return required;
    }

    public boolean isText()
    {
        return true;
    }

    public String toString()
    {
        return detail.toString();
    }
}
