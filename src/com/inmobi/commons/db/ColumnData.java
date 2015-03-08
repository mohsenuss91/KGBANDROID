// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.db;


public class ColumnData
{

    private boolean a;
    private boolean b;
    private boolean c;
    private ColumnType d;

    public ColumnData()
    {
        a = false;
        b = false;
        c = false;
    }

    public ColumnType getDataType()
    {
        return d;
    }

    public boolean isAutoIncrement()
    {
        return b;
    }

    public boolean isMandatory()
    {
        return c;
    }

    public boolean isPrimaryKey()
    {
        return a;
    }

    public void setAutoIncrement(boolean flag)
    {
        b = flag;
    }

    public void setDataType(ColumnType columntype)
    {
        d = columntype;
    }

    public void setMandatory(boolean flag)
    {
        c = flag;
    }

    public void setPrimaryKey(boolean flag)
    {
        a = flag;
    }
}
