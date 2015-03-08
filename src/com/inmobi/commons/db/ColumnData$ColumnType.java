// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.db;


public final class  extends Enum
{

    public static final a INTEGER;
    public static final a REAL;
    public static final a TEXT;
    public static final a VARCHAR;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/db/ColumnData$ColumnType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        INTEGER = new <init>("INTEGER", 0);
        VARCHAR = new <init>("VARCHAR", 1);
        REAL = new <init>("REAL", 2);
        TEXT = new <init>("TEXT", 3);
        e_3B_.clone aclone[] = new <init>[4];
        aclone[0] = INTEGER;
        aclone[1] = VARCHAR;
        aclone[2] = REAL;
        aclone[3] = TEXT;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
