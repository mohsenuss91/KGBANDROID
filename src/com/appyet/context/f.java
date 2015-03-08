// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.context;

import com.appyet.data.Module;
import com.appyet.manager.d;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataModule;
import com.appyet.metadata.MetadataModuleFeedSql;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.context:
//            ApplicationContext, d

public final class f
{

    public Module a;
    public List b;
    public Hashtable c;
    public Hashtable d;
    public List e;
    public Long f;
    public com.appyet.context.d g;
    public String h;
    public int i;
    public boolean j;
    private ApplicationContext k;

    public f(ApplicationContext applicationcontext)
    {
        i = 0;
        j = true;
        k = applicationcontext;
    }

    public final List a(long l, long l1)
    {
        Iterator iterator = k.q.MetadataModuleFeedSqls.iterator();
        MetadataModuleFeedSql metadatamodulefeedsql;
label0:
        do
        {
            if (iterator.hasNext())
            {
                metadatamodulefeedsql = (MetadataModuleFeedSql)iterator.next();
                Iterator iterator1 = k.q.MetadataModules.iterator();
                MetadataModule metadatamodule;
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    metadatamodule = (MetadataModule)iterator1.next();
                } while (metadatamodule.Id != metadatamodulefeedsql.ModuleId || !metadatamodule.Guid.equals(a.getGuid()));
                break;
            } else
            {
                return new ArrayList();
            }
        } while (true);
        return k.h.b(metadatamodulefeedsql.Query, l, l1);
    }
}
