// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.List;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

// Referenced classes of package org.simpleframework.xml.core:
//            Detail

class DefaultDetail
    implements Detail
{

    private final DefaultType access;
    private final Detail detail;

    public DefaultDetail(Detail detail1, DefaultType defaulttype)
    {
        detail = detail1;
        access = defaulttype;
    }

    public DefaultType getAccess()
    {
        return detail.getAccess();
    }

    public Annotation[] getAnnotations()
    {
        return detail.getAnnotations();
    }

    public Constructor[] getConstructors()
    {
        return detail.getConstructors();
    }

    public List getFields()
    {
        return detail.getFields();
    }

    public List getMethods()
    {
        return detail.getMethods();
    }

    public String getName()
    {
        return detail.getName();
    }

    public Namespace getNamespace()
    {
        return detail.getNamespace();
    }

    public NamespaceList getNamespaceList()
    {
        return detail.getNamespaceList();
    }

    public Order getOrder()
    {
        return detail.getOrder();
    }

    public DefaultType getOverride()
    {
        return access;
    }

    public Root getRoot()
    {
        return detail.getRoot();
    }

    public Class getSuper()
    {
        return detail.getSuper();
    }

    public Class getType()
    {
        return detail.getType();
    }

    public boolean isInstantiable()
    {
        return detail.isInstantiable();
    }

    public boolean isPrimitive()
    {
        return detail.isPrimitive();
    }

    public boolean isRequired()
    {
        return detail.isRequired();
    }

    public boolean isStrict()
    {
        return detail.isStrict();
    }

    public String toString()
    {
        return detail.toString();
    }
}
