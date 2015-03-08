// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.Collections;
import java.util.Map;

public class <init>
{

    private final Map agU;
    private final com.google.android.gms.internal.a.agV agV;

    public static <init> mi()
    {
        return new <init>(null);
    }

    public void a(String s, com.google.android.gms.internal.a a1)
    {
        agU.put(s, a1);
    }

    public Map mj()
    {
        return Collections.unmodifiableMap(agU);
    }

    public com.google.android.gms.internal.a mk()
    {
        return agV;
    }

    public String toString()
    {
        return (new StringBuilder("Properties: ")).append(mj()).append(" pushAfterEvaluate: ").append(agV).toString();
    }

    private (Map map, com.google.android.gms.internal.a a1)
    {
        agU = map;
        agV = a1;
    }

    agV(Map map, com.google.android.gms.internal.a a1, agV agv)
    {
        this(map, a1);
    }
}
