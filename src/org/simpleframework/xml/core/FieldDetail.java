// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

class FieldDetail
{

    private final Field field;
    private final Annotation list[];
    private final String name;

    public FieldDetail(Field field1)
    {
        list = field1.getDeclaredAnnotations();
        name = field1.getName();
        field = field1;
    }

    public Annotation[] getAnnotations()
    {
        return list;
    }

    public Field getField()
    {
        return field;
    }

    public String getName()
    {
        return name;
    }
}
