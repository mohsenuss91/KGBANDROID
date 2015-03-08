// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Field;

class name
{

    private final String name;
    private final Class type;

    private boolean equals(name name1)
    {
        if (name1.type != type)
        {
            return false;
        } else
        {
            return name1.name.equals(name);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof name)
        {
            return equals((equals)obj);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public (Field field)
    {
        type = field.getDeclaringClass();
        name = field.getName();
    }
}
