// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.strategy.Type;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, Label, TextException, TextList, 
//            Contact, Context, Converter, Decorator, 
//            Expression

class TextListLabel extends TemplateLabel
{

    private final String empty;
    private final Label label;
    private final Text text;

    public TextListLabel(Label label1, Text text1)
    {
        empty = text1.empty();
        label = label1;
        text = text1;
    }

    public Annotation getAnnotation()
    {
        return label.getAnnotation();
    }

    public Contact getContact()
    {
        return label.getContact();
    }

    public Converter getConverter(Context context)
    {
        Contact contact = getContact();
        if (!label.isCollection())
        {
            Object aobj[] = new Object[2];
            aobj[0] = contact;
            aobj[1] = label;
            throw new TextException("Cannot use %s to represent %s", aobj);
        } else
        {
            return new TextList(context, contact, label);
        }
    }

    public Decorator getDecorator()
    {
        return null;
    }

    public Type getDependent()
    {
        return label.getDependent();
    }

    public volatile Object getEmpty(Context context)
    {
        return getEmpty(context);
    }

    public String getEmpty(Context context)
    {
        return empty;
    }

    public String getEntry()
    {
        return label.getEntry();
    }

    public Expression getExpression()
    {
        return label.getExpression();
    }

    public Object getKey()
    {
        return label.getKey();
    }

    public String getName()
    {
        return label.getName();
    }

    public String[] getNames()
    {
        return label.getNames();
    }

    public String getOverride()
    {
        return label.getOverride();
    }

    public String getPath()
    {
        return label.getPath();
    }

    public String[] getPaths()
    {
        return label.getPaths();
    }

    public Class getType()
    {
        return label.getType();
    }

    public boolean isCollection()
    {
        return true;
    }

    public boolean isData()
    {
        return label.isData();
    }

    public boolean isInline()
    {
        return label.isInline();
    }

    public boolean isRequired()
    {
        return label.isRequired();
    }

    public boolean isTextList()
    {
        return true;
    }

    public String toString()
    {
        Object aobj[] = new Object[2];
        aobj[0] = text;
        aobj[1] = label;
        return String.format("%s %s", aobj);
    }
}
