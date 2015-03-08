// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package org.simpleframework.xml.stream:
//            OutputNode

class OutputStack extends ArrayList
{

    private final Set active;

    public OutputStack(Set set)
    {
        active = set;
    }

    public OutputNode bottom()
    {
        if (size() <= 0)
        {
            return null;
        } else
        {
            return (OutputNode)get(0);
        }
    }

    public Iterator iterator()
    {
        return new Sequence();
    }

    public OutputNode pop()
    {
        int i = size();
        if (i <= 0)
        {
            return null;
        } else
        {
            return purge(i - 1);
        }
    }

    public OutputNode purge(int i)
    {
        OutputNode outputnode = (OutputNode)remove(i);
        if (outputnode != null)
        {
            active.remove(outputnode);
        }
        return outputnode;
    }

    public OutputNode push(OutputNode outputnode)
    {
        active.add(outputnode);
        add(outputnode);
        return outputnode;
    }

    public OutputNode top()
    {
        int i = size();
        if (i <= 0)
        {
            return null;
        } else
        {
            return (OutputNode)get(i - 1);
        }
    }

    private class Sequence
        implements Iterator
    {

        private int cursor;
        final OutputStack this$0;

        public boolean hasNext()
        {
            return cursor > 0;
        }

        public volatile Object next()
        {
            return next();
        }

        public OutputNode next()
        {
            if (hasNext())
            {
                OutputStack outputstack = OutputStack.this;
                int i = -1 + cursor;
                cursor = i;
                return (OutputNode)outputstack.get(i);
            } else
            {
                return null;
            }
        }

        public void remove()
        {
            purge(cursor);
        }

        public Sequence()
        {
            this$0 = OutputStack.this;
            super();
            cursor = size();
        }
    }

}
