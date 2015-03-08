// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;


public class Web
{

    public static final String COLUMN_DATA = "Data";
    public static final String COLUMN_GUID = "Guid";
    public static final String COLUMN_MODULE_ID = "ModuleId";
    public static final String COLUMN_TYPE = "Type";
    public static final String COLUMN_WEB_ID = "WebId";
    private String mData;
    private String mGuid;
    private Long mModuleId;
    private String mType;
    private Long mWebId;

    public Web()
    {
    }

    public String getData()
    {
        return mData;
    }

    public String getGuid()
    {
        return mGuid;
    }

    public Long getModuleId()
    {
        return mModuleId;
    }

    public String getType()
    {
        return mType;
    }

    public Long getWebId()
    {
        return mWebId;
    }

    public void setData(String s)
    {
        mData = s;
    }

    public void setGuid(String s)
    {
        mGuid = s;
    }

    public void setModuleId(Long long1)
    {
        mModuleId = long1;
    }

    public void setType(String s)
    {
        mType = s;
    }

    public void setWebId(Long long1)
    {
        mWebId = long1;
    }
}
