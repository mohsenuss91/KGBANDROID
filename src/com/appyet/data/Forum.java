// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;


public class Forum
{

    public static final String COLUMN_FORUM_ID = "ForumId";
    public static final String COLUMN_GUID = "Guid";
    public static final String COLUMN_LINK = "Link";
    public static final String COLUMN_MODULE_ID = "ModuleId";
    private static final long serialVersionUID = 1L;
    private Long mForumId;
    private String mGuid;
    private String mLink;
    private long mModuleId;

    public Forum()
    {
    }

    public Long getForumId()
    {
        return mForumId;
    }

    public String getGuid()
    {
        return mGuid;
    }

    public String getLink()
    {
        return mLink;
    }

    public Long getModuleId()
    {
        return Long.valueOf(mModuleId);
    }

    public void setForumId(Long long1)
    {
        mForumId = long1;
    }

    public void setGuid(String s)
    {
        mGuid = s;
    }

    public void setLink(String s)
    {
        mLink = s;
    }

    public void setModuleId(Long long1)
    {
        mModuleId = long1.longValue();
    }
}
