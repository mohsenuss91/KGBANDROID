// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

// Referenced classes of package org.simpleframework.xml.core:
//            Label, Contact, Decorator, Expression, 
//            Context, Converter

class CacheLabel
    implements Label
{

    private final Annotation annotation;
    private final boolean attribute;
    private final boolean collection;
    private final Contact contact;
    private final boolean data;
    private final Decorator decorator;
    private final Type depend;
    private final String entry;
    private final Expression expression;
    private final boolean inline;
    private final Object key;
    private final Label label;
    private final boolean list;
    private final String name;
    private final String names[];
    private final String override;
    private final String path;
    private final String paths[];
    private final boolean required;
    private final boolean text;
    private final Class type;
    private final boolean union;

    public CacheLabel(Label label1)
    {
        annotation = label1.getAnnotation();
        expression = label1.getExpression();
        decorator = label1.getDecorator();
        attribute = label1.isAttribute();
        collection = label1.isCollection();
        contact = label1.getContact();
        depend = label1.getDependent();
        required = label1.isRequired();
        override = label1.getOverride();
        list = label1.isTextList();
        inline = label1.isInline();
        union = label1.isUnion();
        names = label1.getNames();
        paths = label1.getPaths();
        path = label1.getPath();
        type = label1.getType();
        name = label1.getName();
        entry = label1.getEntry();
        data = label1.isData();
        text = label1.isText();
        key = label1.getKey();
        label = label1;
    }

    public Annotation getAnnotation()
    {
        return annotation;
    }

    public Contact getContact()
    {
        return contact;
    }

    public Converter getConverter(Context context)
    {
        return label.getConverter(context);
    }

    public Decorator getDecorator()
    {
        return decorator;
    }

    public Type getDependent()
    {
        return depend;
    }

    public Object getEmpty(Context context)
    {
        return label.getEmpty(context);
    }

    public String getEntry()
    {
        return entry;
    }

    public Expression getExpression()
    {
        return expression;
    }

    public Object getKey()
    {
        return key;
    }

    public Label getLabel(Class class1)
    {
        return label.getLabel(class1);
    }

    public String getName()
    {
        return name;
    }

    public String[] getNames()
    {
        return names;
    }

    public String getOverride()
    {
        return override;
    }

    public String getPath()
    {
        return path;
    }

    public String[] getPaths()
    {
        return paths;
    }

    public Class getType()
    {
        return type;
    }

    public Type getType(Class class1)
    {
        return label.getType(class1);
    }

    public boolean isAttribute()
    {
        return attribute;
    }

    public boolean isCollection()
    {
        return collection;
    }

    public boolean isData()
    {
        return data;
    }

    public boolean isInline()
    {
        return inline;
    }

    public boolean isRequired()
    {
        return required;
    }

    public boolean isText()
    {
        return text;
    }

    public boolean isTextList()
    {
        return list;
    }

    public boolean isUnion()
    {
        return union;
    }

    public String toString()
    {
        return label.toString();
    }
}
