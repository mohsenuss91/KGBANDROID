// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.context.ApplicationContext;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataModule;
import com.appyet.metadata.MetadataModuleWeb;
import java.util.Iterator;
import java.util.List;

public final class bk
{

    private ApplicationContext a;

    public bk(ApplicationContext applicationcontext)
    {
        a = applicationcontext;
    }

    public final MetadataModuleWeb a(String s)
    {
        Iterator iterator = a.q.MetadataModuleWebs.iterator();
        MetadataModuleWeb metadatamoduleweb;
label0:
        do
        {
            if (iterator.hasNext())
            {
                metadatamoduleweb = (MetadataModuleWeb)iterator.next();
                Iterator iterator1 = a.q.MetadataModules.iterator();
                MetadataModule metadatamodule;
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    metadatamodule = (MetadataModule)iterator1.next();
                } while (metadatamodule.Id != metadatamoduleweb.ModuleId || !metadatamodule.Guid.equals(s));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return metadatamoduleweb;
    }
}
