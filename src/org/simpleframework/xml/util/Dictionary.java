// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package org.simpleframework.xml.util:
//            Entry

public class Dictionary extends AbstractSet
{

    protected final Table map = new Table();

    public Dictionary()
    {
    }

    public volatile boolean add(Object obj)
    {
        return add((Entry)obj);
    }

    public boolean add(Entry entry)
    {
        return map.put(entry.getName(), entry) != null;
    }

    public Entry get(String s)
    {
        return (Entry)map.get(s);
    }

    public Iterator iterator()
    {
        return map.values().iterator();
    }

    public Entry remove(String s)
    {
        return (Entry)map.remove(s);
    }

    public int size()
    {
        return map.size();
    }

    private class Table extends HashMap
    {

        public Table()
        {
        }
    }

}
