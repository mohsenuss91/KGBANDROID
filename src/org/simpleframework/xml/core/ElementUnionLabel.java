// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            TemplateLabel, GroupExtractor, ElementLabel, Label, 
//            UnionException, CompositeUnion, OverrideType, Contact, 
//            Expression, Context, Converter, Decorator

class ElementUnionLabel extends TemplateLabel
{

    private Contact contact;
    private GroupExtractor extractor;
    private Label label;
    private Expression path;
    private ElementUnion union;

    public ElementUnionLabel(Contact contact1, ElementUnion elementunion, Element element, Format format)
    {
        extractor = new GroupExtractor(contact1, elementunion, format);
        label = new ElementLabel(contact1, element, format);
        contact = contact1;
        union = elementunion;
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
            return new CompositeUnion(context, extractor, expression, contact1);
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
        Contact contact1 = getContact();
        if (!extractor.isValid(class1))
        {
            Object aobj[] = new Object[3];
            aobj[0] = class1;
            aobj[1] = union;
            aobj[2] = contact1;
            throw new UnionException("No type matches %s in %s for %s", aobj);
        } else
        {
            return extractor.getLabel(class1);
        }
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
        Contact contact1 = getContact();
        if (!extractor.isValid(class1))
        {
            Object aobj[] = new Object[3];
            aobj[0] = class1;
            aobj[1] = union;
            aobj[2] = contact1;
            throw new UnionException("No type matches %s in %s for %s", aobj);
        }
        if (extractor.isDeclared(class1))
        {
            return new OverrideType(contact1, class1);
        } else
        {
            return contact1;
        }
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

    public boolean isUnion()
    {
        return true;
    }

    public String toString()
    {
        return label.toString();
    }
}
