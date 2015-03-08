// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Version;

// Referenced classes of package org.simpleframework.xml.core:
//            Scanner, ClassScanner, StructureBuilder, Detail, 
//            Support, ContactList, Contact, Caller, 
//            Structure, Context, Function, Decorator, 
//            Instantiator, ParameterMap, Section, Signature, 
//            Label

class ObjectScanner
    implements Scanner
{

    private StructureBuilder builder;
    private Detail detail;
    private ClassScanner scanner;
    private Structure structure;
    private Support support;

    public ObjectScanner(Detail detail1, Support support1)
    {
        scanner = new ClassScanner(detail1, support1);
        builder = new StructureBuilder(this, detail1, support1);
        support = support1;
        detail = detail1;
        scan(detail1);
    }

    private void commit(Detail detail1)
    {
        Class class1 = detail1.getType();
        if (structure == null)
        {
            structure = builder.build(class1);
        }
        builder = null;
    }

    private void field(Detail detail1)
    {
        Class class1 = detail1.getType();
        org.simpleframework.xml.DefaultType defaulttype = detail1.getOverride();
        Iterator iterator = support.getFields(class1, defaulttype).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Contact contact = (Contact)iterator.next();
            java.lang.annotation.Annotation annotation = contact.getAnnotation();
            if (annotation != null)
            {
                builder.process(contact, annotation);
            }
        } while (true);
    }

    private void method(Detail detail1)
    {
        Class class1 = detail1.getType();
        org.simpleframework.xml.DefaultType defaulttype = detail1.getOverride();
        Iterator iterator = support.getMethods(class1, defaulttype).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Contact contact = (Contact)iterator.next();
            java.lang.annotation.Annotation annotation = contact.getAnnotation();
            if (annotation != null)
            {
                builder.process(contact, annotation);
            }
        } while (true);
    }

    private void order(Detail detail1)
    {
        Class class1 = detail1.getType();
        builder.assemble(class1);
    }

    private void scan(Detail detail1)
    {
        order(detail1);
        field(detail1);
        method(detail1);
        validate(detail1);
        commit(detail1);
    }

    private void validate(Detail detail1)
    {
        Class class1 = detail1.getType();
        builder.commit(class1);
        builder.validate(class1);
    }

    public Caller getCaller(Context context)
    {
        return new Caller(this, context);
    }

    public Function getCommit()
    {
        return scanner.getCommit();
    }

    public Function getComplete()
    {
        return scanner.getComplete();
    }

    public Decorator getDecorator()
    {
        return scanner.getDecorator();
    }

    public Instantiator getInstantiator()
    {
        return structure.getInstantiator();
    }

    public String getName()
    {
        return detail.getName();
    }

    public Order getOrder()
    {
        return scanner.getOrder();
    }

    public ParameterMap getParameters()
    {
        return scanner.getParameters();
    }

    public Function getPersist()
    {
        return scanner.getPersist();
    }

    public Function getReplace()
    {
        return scanner.getReplace();
    }

    public Function getResolve()
    {
        return scanner.getResolve();
    }

    public Version getRevision()
    {
        return structure.getRevision();
    }

    public Section getSection()
    {
        return structure.getSection();
    }

    public Signature getSignature()
    {
        return scanner.getSignature();
    }

    public List getSignatures()
    {
        return scanner.getSignatures();
    }

    public Label getText()
    {
        return structure.getText();
    }

    public Class getType()
    {
        return detail.getType();
    }

    public Function getValidate()
    {
        return scanner.getValidate();
    }

    public Label getVersion()
    {
        return structure.getVersion();
    }

    public boolean isEmpty()
    {
        return scanner.getRoot() == null;
    }

    public boolean isPrimitive()
    {
        return structure.isPrimitive();
    }

    public boolean isStrict()
    {
        return detail.isStrict();
    }
}
