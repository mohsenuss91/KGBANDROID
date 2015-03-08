// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, ElementListLabel, GroupExtractor, Label, 
//            UnionException, CompositeListUnion, Contact, Expression, 
//            Context, Converter, Decorator

class ElementListUnionLabel extends TemplateLabel
{

    private Contact contact;
    private GroupExtractor extractor;
    private Label label;
    private Expression path;

    public ElementListUnionLabel(Contact contact1, ElementListUnion elementlistunion, ElementList elementlist, Format format)
    {
        label = new ElementListLabel(contact1, elementlist, format);
        extractor = new GroupExtractor(contact1, elementlistunion, format);
        contact = contact1;
    }

    public Annotation getAnnotation()
    {
        return label.getAnnotation();
    }

    public Contact getContact()
    {
        return contact;
    }

    public Converter getConverter(Context context)
    {
        Expression expression = getExpression();
        Contact contact1 = getContact();
        if (contact1 == null)
        {
            Object aobj[] = new Object[1];
            aobj[0] = label;
            throw new UnionException("Union %s was not declared on a field or method", aobj);
        } else
        {
            return new CompositeListUnion(context, extractor, expression, contact1);
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
        if (path == null)
        {
            path = label.getExpression();
        }
        return path;
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
        return extractor.getNames();
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
        return extractor.getPaths();
    }

    public Class getType()
    {
        return label.getType();
    }

    public Type getType(Class class1)
    {
        return getContact();
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

    public boolean isTextList()
    {
        return extractor.isTextList();
    }

    public boolean isUnion()
    {
        return true;
    }

    public String toString()
    {
        return label.toString();
    }
}
