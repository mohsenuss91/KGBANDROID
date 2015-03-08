// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;


public final class  extends Enum
{

    public static final a CE;
    public static final a ES;
    public static final a LB;
    public static final a LE;
    public static final a PI;
    public static final a SS;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsFunctions$FunctionName, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        SS = new <init>("SS", 0);
        ES = new <init>("ES", 1);
        LB = new <init>("LB", 2);
        LE = new <init>("LE", 3);
        CE = new <init>("CE", 4);
        PI = new <init>("PI", 5);
        e_3B_.clone aclone[] = new <init>[6];
        aclone[0] = SS;
        aclone[1] = ES;
        aclone[2] = LB;
        aclone[3] = LE;
        aclone[4] = CE;
        aclone[5] = PI;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
