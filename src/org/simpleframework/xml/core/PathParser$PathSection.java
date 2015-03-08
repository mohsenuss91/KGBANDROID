// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Expression, PathParser

class end
    implements Expression
{

    private int begin;
    private List cache;
    private int end;
    private String path;
    private String section;
    final PathParser this$0;

    private String getCanonicalPath()
    {
        int i = 0;
        int j = 0;
        for (; i < begin; i++)
        {
            j = location.indexOf('/', j + 1);
        }

        int k = j;
        for (; i <= end; i++)
        {
            k = location.indexOf('/', k + 1);
            if (k == -1)
            {
                k = location.length();
            }
        }

        return location.substring(j + 1, k);
    }

    private String getFragment()
    {
        int i = 0;
        int j = start;
        int k = 0;
        int l = j;
        do
        {
label0:
            {
                if (i <= end)
                {
                    if (l < count)
                    {
                        break label0;
                    }
                    l++;
                }
                return new String(data, k, l - 1 - k);
            }
            char ac[] = data;
            int i1 = l + 1;
            if (ac[l] == '/' && ++i == begin)
            {
                k = i1;
                l = i1;
            } else
            {
                l = i1;
            }
        } while (true);
    }

    public String getAttribute(String s)
    {
        String s1 = getPath();
        if (s1 != null)
        {
            s = getAttributePath(s1, s);
        }
        return s;
    }

    public String getElement(String s)
    {
        String s1 = getPath();
        if (s1 != null)
        {
            s = getElementPath(s1, s);
        }
        return s;
    }

    public String getFirst()
    {
        return (String)names.get(begin);
    }

    public int getIndex()
    {
        return ((Integer)indexes.get(begin)).intValue();
    }

    public String getLast()
    {
        return (String)names.get(end);
    }

    public String getPath()
    {
        if (section == null)
        {
            section = getCanonicalPath();
        }
        return section;
    }

    public Expression getPath(int i)
    {
        return getPath(i, 0);
    }

    public Expression getPath(int i, int j)
    {
        return new <init>(i + begin, end - j);
    }

    public String getPrefix()
    {
        return (String)prefixes.get(begin);
    }

    public boolean isAttribute()
    {
        boolean flag = attribute;
        boolean flag1 = false;
        if (flag)
        {
            int i = end;
            int j = -1 + names.size();
            flag1 = false;
            if (i >= j)
            {
                flag1 = true;
            }
        }
        return flag1;
    }

    public boolean isEmpty()
    {
        return begin == end;
    }

    public boolean isPath()
    {
        return end - begin > 0;
    }

    public Iterator iterator()
    {
        if (cache.isEmpty())
        {
            for (int i = begin; i <= end; i++)
            {
                String s = (String)names.get(i);
                if (s != null)
                {
                    cache.add(s);
                }
            }

        }
        return cache.iterator();
    }

    public String toString()
    {
        if (path == null)
        {
            path = getFragment();
        }
        return path;
    }

    public _cls9(int i, int j)
    {
        this$0 = PathParser.this;
        super();
        cache = new ArrayList();
        begin = i;
        end = j;
    }
}
