// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.util:
//            WeakCache

class create
    implements Iterable
{

    private List list;
    private int size;
    final WeakCache this$0;

    private void create(int i)
    {
        do
        {
            int j = i - 1;
            if (i > 0)
            {
                list.add(new t>(WeakCache.this, null));
                i = j;
            } else
            {
                return;
            }
        } while (true);
    }

    private int segment(Object obj)
    {
        return Math.abs(obj.hashCode() % size);
    }

    public size get(Object obj)
    {
        int i = segment(obj);
        if (i < size)
        {
            return (size)list.get(i);
        } else
        {
            return null;
        }
    }

    public Iterator iterator()
    {
        return list.iterator();
    }

    public (int i)
    {
        this$0 = WeakCache.this;
        super();
        list = new ArrayList();
        size = i;
        create(i);
    }
}
