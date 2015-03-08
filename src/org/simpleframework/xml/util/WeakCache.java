// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;

import java.util.Iterator;

// Referenced classes of package org.simpleframework.xml.util:
//            Cache

public class WeakCache
    implements Cache
{

    private SegmentList list;

    public WeakCache()
    {
        this(10);
    }

    public WeakCache(int i)
    {
        list = new SegmentList(i);
    }

    private Segment map(Object obj)
    {
        return list.get(obj);
    }

    public void cache(Object obj, Object obj1)
    {
        map(obj).cache(obj, obj1);
    }

    public boolean contains(Object obj)
    {
        return map(obj).contains(obj);
    }

    public Object fetch(Object obj)
    {
        return map(obj).fetch(obj);
    }

    public boolean isEmpty()
    {
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            if (!((Segment)iterator.next()).isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    public Object take(Object obj)
    {
        return map(obj).take(obj);
    }

    private class SegmentList
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
                    list.add(new Segment(null));
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

        public Segment get(Object obj)
        {
            int i = segment(obj);
            if (i < size)
            {
                return (Segment)list.get(i);
            } else
            {
                return null;
            }
        }

        public Iterator iterator()
        {
            return list.iterator();
        }

        public SegmentList(int i)
        {
            this$0 = WeakCache.this;
            super();
            list = new ArrayList();
            size = i;
            create(i);
        }
    }


    private class Segment extends WeakHashMap
    {

        final WeakCache this$0;

        public void cache(Object obj, Object obj1)
        {
            this;
            JVM INSTR monitorenter ;
            put(obj, obj1);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public boolean contains(Object obj)
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = containsKey(obj);
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        public Object fetch(Object obj)
        {
            this;
            JVM INSTR monitorenter ;
            Object obj1 = get(obj);
            this;
            JVM INSTR monitorexit ;
            return obj1;
            Exception exception;
            exception;
            throw exception;
        }

        public Object take(Object obj)
        {
            this;
            JVM INSTR monitorenter ;
            Object obj1 = remove(obj);
            this;
            JVM INSTR monitorexit ;
            return obj1;
            Exception exception;
            exception;
            throw exception;
        }

        private Segment()
        {
            this$0 = WeakCache.this;
            super();
        }

        Segment(_cls1 _pcls1)
        {
            this();
        }
    }

}
