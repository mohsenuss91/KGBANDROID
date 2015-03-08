// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


public class PersistenceException extends Exception
{

    public transient PersistenceException(String s, Object aobj[])
    {
        super(String.format(s, aobj));
    }

    public transient PersistenceException(Throwable throwable, String s, Object aobj[])
    {
        super(String.format(s, aobj), throwable);
    }
}
