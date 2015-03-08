// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.a;

import java.util.Comparator;

public final class i
    implements Comparator
{

    public i()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        String s = (String)obj;
        String s1 = (String)obj1;
        return s.substring(0, s.lastIndexOf("_")).compareTo(s1.substring(0, s1.lastIndexOf("_")));
    }
}
