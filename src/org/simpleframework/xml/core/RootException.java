// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;


// Referenced classes of package org.simpleframework.xml.core:
//            PersistenceException

public class RootException extends PersistenceException
{

    public transient RootException(String s, Object aobj[])
    {
        super(s, aobj);
    }

    public transient RootException(Throwable throwable, String s, Object aobj[])
    {
        super(throwable, s, aobj);
    }
}
