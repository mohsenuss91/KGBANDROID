// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;


public class CommonsException extends Exception
{

    public static final int APPLICATION_NOT_SET = 1;
    public static final int PRODUCT_NOT_FOUND = 2;
    private static final long serialVersionUID = 0x34cf5cc9bf91e4d9L;
    private int a;

    public CommonsException(int i)
    {
        a = i;
    }

    public int getCode()
    {
        return a;
    }

    public String toString()
    {
        switch (a)
        {
        default:
            return "Unknown.";

        case 1: // '\001'
            return "Application not set/initialize not called.";

        case 2: // '\002'
            return "Product not found.";
        }
    }
}
