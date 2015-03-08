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

interface Detail
{

    public abstract DefaultType getAccess();

    public abstract Annotation[] getAnnotations();

    public abstract Constructor[] getConstructors();

    public abstract List getFields();

    public abstract List getMethods();

    public abstract String getName();

    public abstract Namespace getNamespace();

    public abstract NamespaceList getNamespaceList();

    public abstract Order getOrder();

    public abstract DefaultType getOverride();

    public abstract Root getRoot();

    public abstract Class getSuper();

    public abstract Class getType();

    public abstract boolean isInstantiable();

    public abstract boolean isPrimitive();

    public abstract boolean isRequired();

    public abstract boolean isStrict();
}
