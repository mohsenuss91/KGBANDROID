// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;


public class Module
{

    public static final String COLUMN_GROUP_NAME = "GroupName";
    public static final String COLUMN_GUID = "Guid";
    public static final String COLUMN_ICON = "Icon";
    public static final String COLUMN_IS_HIDDEN = "IsHidden";
    public static final String COLUMN_LAYOUT = "Layout";
    public static final String COLUMN_MODULE_ID = "ModuleId";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_SORT_ORDER = "SortOrder";
    public static final String COLUMN_STATUS_LABEL = "StatusLabel";
    public static final String COLUMN_TYPE = "Type";
    private String mGroupName;
    private String mGuid;
    private String mIcon;
    private boolean mIsHidden;
    private boolean mIsSelected;
    private String mLayout;
    private Long mModuleId;
    private String mName;
    private int mSortOrder;
    private String mStatusLabel;
    private String mType;

    public Module()
    {
    }

    public String getGroupName()
    {
        return mGroupName;
    }

    public String getGuid()
    {
        return mGuid;
    }

    public String getIcon()
    {
        return mIcon;
    }

    public boolean getIsHidden()
    {
        return mIsHidden;
    }

    public boolean getIsSelected()
    {
        return mIsSelected;
    }

    public String getLayout()
    {
        return mLayout;
    }

    public Long getModuleId()
    {
        return mModuleId;
    }

    public String getName()
    {
        return mName;
    }

    public int getSortOrder()
    {
        return mSortOrder;
    }

    public String getStatusLabel()
    {
        return mStatusLabel;
    }

    public String getType()
    {
        return mType;
    }

    public void setGroupName(String s)
    {
        mGroupName = s;
    }

    public void setGuid(String s)
    {
        mGuid = s;
    }

    public void setIcon(String s)
    {
        mIcon = s;
    }

    public void setIsHidden(boolean flag)
    {
        mIsHidden = flag;
    }

    public void setIsSelected(boolean flag)
    {
        mIsSelected = flag;
    }

    public void setLayout(String s)
    {
        mLayout = s;
    }

    public void setModuleId(Long long1)
    {
        mModuleId = long1;
    }

    public void setName(String s)
    {
        mName = s;
    }

    public void setSortOrder(int i)
    {
        mSortOrder = i;
    }

    public void setStatusLabel(String s)
    {
        mStatusLabel = s;
    }

    public void setType(String s)
    {
        mType = s;
    }
}
