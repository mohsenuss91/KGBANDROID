// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.core:
//            ModelList, PathException, Detail, Model

class ModelMap extends LinkedHashMap
    implements Iterable
{

    private final Detail detail;

    public ModelMap(Detail detail1)
    {
        detail = detail1;
    }

    public ModelMap getModels()
    {
        ModelMap modelmap = new ModelMap(detail);
        String s;
        ModelList modellist;
        for (Iterator iterator1 = keySet().iterator(); iterator1.hasNext(); modelmap.put(s, modellist))
        {
            s = (String)iterator1.next();
            modellist = (ModelList)get(s);
            if (modellist != null)
            {
                modellist = modellist.build();
            }
            if (modelmap.containsKey(s))
            {
                Object aobj[] = new Object[2];
                aobj[0] = s;
                aobj[1] = detail;
                throw new PathException("Path with name '%s' is a duplicate in %s ", aobj);
            }
        }

        return modelmap;
    }

    public Iterator iterator()
    {
        return values().iterator();
    }

    public Model lookup(String s, int i)
    {
        ModelList modellist = (ModelList)get(s);
        if (modellist != null)
        {
            return modellist.lookup(i);
        } else
        {
            return null;
        }
    }

    public void register(String s, Model model)
    {
        ModelList modellist = (ModelList)get(s);
        if (modellist == null)
        {
            modellist = new ModelList();
            put(s, modellist);
        }
        modellist.register(model);
    }
}
