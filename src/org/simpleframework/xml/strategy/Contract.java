// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;


class Contract
{

    private String label;
    private String length;
    private String mark;
    private String refer;

    public Contract(String s, String s1, String s2, String s3)
    {
        length = s3;
        label = s2;
        refer = s1;
        mark = s;
    }

    public String getIdentity()
    {
        return mark;
    }

    public String getLabel()
    {
        return label;
    }

    public String getLength()
    {
        return length;
    }

    public String getReference()
    {
        return refer;
    }
}
