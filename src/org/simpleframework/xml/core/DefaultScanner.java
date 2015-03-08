// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.List;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Version;

// Referenced classes of package org.simpleframework.xml.core:
//            Scanner, DefaultDetail, ObjectScanner, Detail, 
//            Support, Context, Caller, Function, 
//            Decorator, Instantiator, ParameterMap, Section, 
//            Signature, Label

class DefaultScanner
    implements Scanner
{

    private Detail detail;
    private Scanner scanner;

    public DefaultScanner(Detail detail1, Support support)
    {
        detail = new DefaultDetail(detail1, DefaultType.FIELD);
        scanner = new ObjectScanner(detail, support);
    }

    public Caller getCaller(Context context)
    {
        return scanner.getCaller(context);
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
        return scanner.getInstantiator();
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
        return scanner.getRevision();
    }

    public Section getSection()
    {
        return scanner.getSection();
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
        return scanner.getText();
    }

    public Class getType()
    {
        return scanner.getType();
    }

    public Function getValidate()
    {
        return scanner.getValidate();
    }

    public Label getVersion()
    {
        return scanner.getVersion();
    }

    public boolean isEmpty()
    {
        return scanner.isEmpty();
    }

    public boolean isPrimitive()
    {
        return scanner.isPrimitive();
    }

    public boolean isStrict()
    {
        return scanner.isStrict();
    }
}
