// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

interface Contact
    extends Type
{

    public abstract Object get(Object obj);

    public abstract Annotation getAnnotation();

    public abstract Class getDeclaringClass();

    public abstract Class getDependent();

    public abstract Class[] getDependents();

    public abstract String getName();

    public abstract boolean isReadOnly();

    public abstract void set(Object obj, Object obj1);

    public abstract String toString();
}
