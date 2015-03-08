// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


public final class HasChildren extends Enum
{

    public static final HasChildren FALSE;
    public static final HasChildren TRUE;
    public static final HasChildren UNKNOWN;
    private static final HasChildren a[];

    private HasChildren(String s, int i)
    {
        super(s, i);
    }

    public static HasChildren valueOf(String s)
    {
        return (HasChildren)Enum.valueOf(com/inmobi/commons/HasChildren, s);
    }

    public static HasChildren[] values()
    {
        return (HasChildren[])a.clone();
    }

    static 
    {
        TRUE = new HasChildren("TRUE", 0);
        FALSE = new HasChildren("FALSE", 1);
        UNKNOWN = new HasChildren("UNKNOWN", 2);
        HasChildren ahaschildren[] = new HasChildren[3];
        ahaschildren[0] = TRUE;
        ahaschildren[1] = FALSE;
        ahaschildren[2] = UNKNOWN;
        a = ahaschildren;
    }
}
