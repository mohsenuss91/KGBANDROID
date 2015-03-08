// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package org.simpleframework.xml.core:
//            Model

class ModelList extends ArrayList
{

    public ModelList()
    {
    }

    public ModelList build()
    {
        ModelList modellist = new ModelList();
        for (Iterator iterator = iterator(); iterator.hasNext(); modellist.register((Model)iterator.next())) { }
        return modellist;
    }

    public boolean isEmpty()
    {
        for (Iterator iterator = iterator(); iterator.hasNext();)
        {
            Model model = (Model)iterator.next();
            if (model != null && !model.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    public Model lookup(int i)
    {
        if (i <= size())
        {
            return (Model)get(i - 1);
        } else
        {
            return null;
        }
    }

    public void register(Model model)
    {
        int i = model.getIndex();
        int j = size();
        for (int k = 0; k < i; k++)
        {
            if (k >= j)
            {
                add(null);
            }
            if (k == i - 1)
            {
                set(i - 1, model);
            }
        }

    }

    public Model take()
    {
        while (!isEmpty()) 
        {
            Model model = (Model)remove(0);
            if (!model.isEmpty())
            {
                return model;
            }
        }
        return null;
    }
}
