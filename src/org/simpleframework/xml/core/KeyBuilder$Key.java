// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


class type
{

    private final ype type;
    private final String value;

    public boolean equals(Object obj)
    {
        if (obj instanceof type)
        {
            return equals((equals)obj);
        } else
        {
            return false;
        }
    }

    public boolean equals(equals equals1)
    {
        if (type == equals1.type)
        {
            return equals1.value.equals(value);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return value.hashCode();
    }

    public String toString()
    {
        return value;
    }

    public ype(ype ype, String s)
    {
        value = s;
        type = ype;
    }
}
