// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.util:
//            Match

public class Resolver extends AbstractSet
{

    protected final Cache cache = new Cache();
    protected final Stack stack = new Stack(null);

    public Resolver()
    {
    }

    private boolean match(char ac[], int i, char ac1[], int j)
    {
_L5:
        if (j >= ac1.length || i >= ac.length)
        {
            break; /* Loop/switch isn't completed */
        }
        if (ac1[j] != '*')
        {
            break MISSING_BLOCK_LABEL_125;
        }
        while (ac1[j] == '*') 
        {
            if (++j >= ac1.length)
            {
                return true;
            }
        }
        if (ac1[j] == '?' && ++j >= ac1.length)
        {
            return true;
        }
          goto _L1
_L3:
        i++;
_L1:
        if (i >= ac.length)
        {
            break; /* Loop/switch isn't completed */
        }
        if (ac[i] != ac1[j] && ac1[j] != '?')
        {
            continue; /* Loop/switch isn't completed */
        }
        if (ac1[j - 1] == '?')
        {
            break; /* Loop/switch isn't completed */
        }
        if (match(ac, i, ac1, j))
        {
            return true;
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (ac.length == i)
        {
            return false;
        }
        int k = j;
        int l = i;
        i = l + 1;
        char c = ac[l];
        j = k + 1;
        if (c != ac1[k] && ac1[j - 1] != '?')
        {
            return false;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (ac1.length == j)
        {
            return ac.length == i;
        }
        while (ac1[j] == '*') 
        {
            if (++j >= ac1.length)
            {
                return true;
            }
        }
        return false;
    }

    private boolean match(char ac[], char ac1[])
    {
        return match(ac, 0, ac1, 0);
    }

    private List resolveAll(String s, char ac[])
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator1 = stack.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Match match1 = (Match)iterator1.next();
            if (match(ac, match1.getPattern().toCharArray()))
            {
                cache.put(s, arraylist);
                arraylist.add(match1);
            }
        } while (true);
        return arraylist;
    }

    public volatile boolean add(Object obj)
    {
        return add((Match)obj);
    }

    public boolean add(Match match1)
    {
        stack.push(match1);
        return true;
    }

    public void clear()
    {
        cache.clear();
        stack.clear();
    }

    public Iterator iterator()
    {
        return stack.sequence();
    }

    public boolean remove(Match match1)
    {
        cache.clear();
        return stack.remove(match1);
    }

    public Match resolve(String s)
    {
        List list = (List)cache.get(s);
        if (list == null)
        {
            list = resolveAll(s);
        }
        if (list.isEmpty())
        {
            return null;
        } else
        {
            return (Match)list.get(0);
        }
    }

    public List resolveAll(String s)
    {
        List list = (List)cache.get(s);
        if (list != null)
        {
            return list;
        }
        char ac[] = s.toCharArray();
        if (ac == null)
        {
            return null;
        } else
        {
            return resolveAll(s, ac);
        }
    }

    public int size()
    {
        return stack.size();
    }

    private class Stack extends LinkedList
    {

        final Resolver this$0;

        public void purge(int i)
        {
            cache.clear();
            remove(i);
        }

        public volatile void push(Object obj)
        {
            push((Match)obj);
        }

        public void push(Match match1)
        {
            cache.clear();
            addFirst(match1);
        }

        public Iterator sequence()
        {
            class Sequence
                implements Iterator
            {

                private int cursor;
                final Stack this$1;

                public boolean hasNext()
                {
                    return cursor > 0;
                }

                public volatile Object next()
                {
                    return next();
                }

                public Match next()
                {
                    if (hasNext())
                    {
                        Stack stack1 = Stack.this;
                        int i = -1 + cursor;
                        cursor = i;
                        return (Match)stack1.get(i);
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
                    this$1 = Stack.this;
                    super();
                    cursor = size();
                }
            }

            return new Sequence();
        }

        private Stack()
        {
            this$0 = Resolver.this;
            super();
        }

        Stack(_cls1 _pcls1)
        {
            this();
        }
    }


    private class Cache extends LimitedCache
    {

        final Resolver this$0;

        public Cache()
        {
            this$0 = Resolver.this;
            super(1024);
        }
    }

}
