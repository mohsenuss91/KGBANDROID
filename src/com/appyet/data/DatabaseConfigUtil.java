// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.data;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

// Referenced classes of package com.appyet.data:
//            Feed, FeedItem, FileCache, Module, 
//            Web, Forum

public class DatabaseConfigUtil extends OrmLiteConfigUtil
{

    private static final Class classes[] = {
        com/appyet/data/Feed, com/appyet/data/FeedItem, com/appyet/data/FileCache, com/appyet/data/Module, com/appyet/data/Web, com/appyet/data/Forum
    };

    public DatabaseConfigUtil()
    {
    }

    public static void main(String args[])
    {
        writeConfigFile("ormlite_config.txt", classes);
    }

}
