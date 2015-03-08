// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;


public class Widget
{

    public static final String COLUMN_MODULE_ID = "ModuleId";
    public static final String COLUMN_POSITION = "Position";
    public static final String COLUMN_WIDGET_ID = "WidgetId";
    private Long mModuleId;
    private Long mPosition;
    private Long mWidgetId;

    public Widget()
    {
    }

    public Long getModuleId()
    {
        return mModuleId;
    }

    public Long getPosition()
    {
        return mPosition;
    }

    public Long getWidgetId()
    {
        return mWidgetId;
    }

    public void setModuleId(Long long1)
    {
        mModuleId = long1;
    }

    public void setPosition(Long long1)
    {
        mPosition = long1;
    }

    public void setWidgetId(Long long1)
    {
        mWidgetId = long1;
    }
}
