// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import java.lang.reflect.Constructor;
import java.util.Date;

class DateFactory
{

    private final Constructor factory;

    public DateFactory(Class class1)
    {
        Class aclass[] = new Class[1];
        aclass[0] = Long.TYPE;
        this(class1, aclass);
    }

    public transient DateFactory(Class class1, Class aclass[])
    {
        factory = class1.getDeclaredConstructor(aclass);
    }

    public transient Date getInstance(Object aobj[])
    {
        return (Date)factory.newInstance(aobj);
    }
}
