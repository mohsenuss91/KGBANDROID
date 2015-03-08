// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

// Referenced classes of package org.simpleframework.xml.core:
//            Label, Contact, Context, Converter, 
//            Decorator, Expression

class Variable
    implements Label
{

    private final Label label;
    private final Object value;

    public Variable(Label label1, Object obj)
    {
        label = label1;
        value = obj;
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
        Converter converter = label.getConverter(context);
        if (converter instanceof Adapter)
        {
            return converter;
        } else
        {
            return new Adapter(converter, label, value);
        }
    }

    public Decorator getDecorator()
    {
        return label.getDecorator();
    }

    public Type getDependent()
    {
        return label.getDependent();
    }

    public Object getEmpty(Context context)
    {
        return label.getEmpty(context);
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

    public Label getLabel(Class class1)
    {
        return this;
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

    public Type getType(Class class1)
    {
        return label.getType(class1);
    }

    public Object getValue()
    {
        return value;
    }

    public boolean isAttribute()
    {
        return label.isAttribute();
    }

    public boolean isCollection()
    {
        return label.isCollection();
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

    public boolean isText()
    {
        return label.isText();
    }

    public boolean isTextList()
    {
        return label.isTextList();
    }

    public boolean isUnion()
    {
        return label.isUnion();
    }

    public String toString()
    {
        return label.toString();
    }

    private class Adapter
        implements Repeater
    {

        private final Label label;
        private final Converter reader;
        private final Object value;

        public Object read(InputNode inputnode)
        {
            return read(inputnode, value);
        }

        public Object read(InputNode inputnode, Object obj)
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            String s = inputnode.getName();
            if (reader instanceof Repeater)
            {
                return ((Repeater)reader).read(inputnode, obj);
            } else
            {
                Object aobj[] = new Object[3];
                aobj[0] = s;
                aobj[1] = label;
                aobj[2] = position;
                throw new PersistenceException("Element '%s' is already used with %s at %s", aobj);
            }
        }

        public boolean validate(InputNode inputnode)
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            String s = inputnode.getName();
            if (reader instanceof Repeater)
            {
                return ((Repeater)reader).validate(inputnode);
            } else
            {
                throw new PersistenceException("Element '%s' declared twice at %s", new Object[] {
                    s, position
                });
            }
        }

        public void write(OutputNode outputnode, Object obj)
        {
            write(outputnode, obj);
        }

        public Adapter(Converter converter, Label label1, Object obj)
        {
            reader = converter;
            value = obj;
            label = label1;
        }
    }

}
