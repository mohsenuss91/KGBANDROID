// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.convert;


public class ConvertException extends Exception
{

    public transient ConvertException(String s, Object aobj[])
    {
        super(String.format(s, aobj));
    }
}
