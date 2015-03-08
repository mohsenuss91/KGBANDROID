// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.core:
//            MethodPart

class <init> extends LinkedHashMap
    implements Iterable
{

    public Iterator iterator()
    {
        return keySet().iterator();
    }

    public MethodPart take(String s)
    {
        return (MethodPart)remove(s);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
