// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.db;

import java.util.LinkedHashMap;

public class TableData
{

    private String a;
    private LinkedHashMap b;

    public TableData()
    {
    }

    public LinkedHashMap getmColumns()
    {
        return b;
    }

    public String getmTableName()
    {
        return a;
    }

    public void setmColumns(LinkedHashMap linkedhashmap)
    {
        b = linkedhashmap;
    }

    public void setmTableName(String s)
    {
        a = s;
    }
}
