// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

// Referenced classes of package org.simpleframework.xml.core:
//            Parameter, Label, Expression

class CacheParameter
    implements Parameter
{

    private final Annotation annotation;
    private final boolean attribute;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final String name;
    private final String path;
    private final boolean primitive;
    private final boolean required;
    private final String string;
    private final boolean text;
    private final Class type;

    public CacheParameter(Parameter parameter, Label label)
    {
        annotation = parameter.getAnnotation();
        expression = parameter.getExpression();
        attribute = parameter.isAttribute();
        primitive = parameter.isPrimitive();
        required = label.isRequired();
        string = parameter.toString();
        text = parameter.isText();
        index = parameter.getIndex();
        name = parameter.getName();
        path = parameter.getPath();
        type = parameter.getType();
        key = label.getKey();
    }

    public Annotation getAnnotation()
    {
        return annotation;
    }

    public Expression getExpression()
    {
        return expression;
    }

    public int getIndex()
    {
        return index;
    }

    public Object getKey()
    {
        return key;
    }

    public String getName()
    {
        return name;
    }

    public String getPath()
    {
        return path;
    }

    public Class getType()
    {
        return type;
    }

    public boolean isAttribute()
    {
        return attribute;
    }

    public boolean isPrimitive()
    {
        return primitive;
    }

    public boolean isRequired()
    {
        return required;
    }

    public boolean isText()
    {
        return text;
    }

    public String toString()
    {
        return string;
    }
}
