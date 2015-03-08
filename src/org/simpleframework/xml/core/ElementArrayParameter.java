// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateParameter, ElementArrayLabel, Label, Expression

class ElementArrayParameter extends TemplateParameter
{

    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    public ElementArrayParameter(Constructor constructor, ElementArray elementarray, Format format, int i)
    {
        contact = new Contact(elementarray, constructor, i);
        label = new ElementArrayLabel(contact, elementarray, format);
        expression = label.getExpression();
        path = label.getPath();
        type = label.getType();
        name = label.getName();
        key = label.getKey();
        index = i;
    }

    public Annotation getAnnotation()
    {
        return contact.getAnnotation();
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

    public boolean isPrimitive()
    {
        return type.isPrimitive();
    }

    public boolean isRequired()
    {
        return label.isRequired();
    }

    public String toString()
    {
        return contact.toString();
    }

    private class Contact extends ParameterContact
    {

        public String getName()
        {
            return ((ElementArray)label).name();
        }

        public Contact(ElementArray elementarray, Constructor constructor, int i)
        {
            super(elementarray, constructor, i);
        }
    }

}
