// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.metadata;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.appyet.metadata:
//            MetadataApplication, MetadataSetting

public class Metadata
{

    public MetadataApplication MetadataApplication;
    public List MetadataLanguages;
    public List MetadataModuleFeedSqls;
    public List MetadataModuleFeeds;
    public List MetadataModuleForums;
    public List MetadataModuleWebs;
    public List MetadataModules;
    public MetadataSetting MetadataSetting;
    public List MetadataThemes;

    public Metadata()
    {
        MetadataApplication = new MetadataApplication();
        MetadataSetting = new MetadataSetting();
        MetadataModules = new ArrayList();
        MetadataModuleFeeds = new ArrayList();
        MetadataModuleWebs = new ArrayList();
        MetadataLanguages = new ArrayList();
        MetadataModuleFeedSqls = new ArrayList();
        MetadataThemes = new ArrayList();
        MetadataModuleForums = new ArrayList();
    }
}
