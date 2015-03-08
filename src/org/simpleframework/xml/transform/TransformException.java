// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import org.simpleframework.xml.core.PersistenceException;

public class TransformException extends PersistenceException
{

    public transient TransformException(String s, Object aobj[])
    {
        super(String.format(s, aobj), new Object[0]);
    }

    public transient TransformException(Throwable throwable, String s, Object aobj[])
    {
        super(String.format(s, aobj), new Object[] {
            throwable
        });
    }
}
