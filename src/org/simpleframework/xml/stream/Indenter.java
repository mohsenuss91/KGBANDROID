// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            Format

class Indenter
{

    private Cache cache;
    private int count;
    private int indent;
    private int index;

    public Indenter()
    {
        this(new Format());
    }

    public Indenter(Format format)
    {
        this(format, 16);
    }

    private Indenter(Format format, int i)
    {
        indent = format.getIndent();
        cache = new Cache(i);
    }

    private String create()
    {
        char ac[] = new char[1 + count];
        if (count > 0)
        {
            ac[0] = '\n';
            for (int i = 1; i <= count; i++)
            {
                ac[i] = ' ';
            }

            return new String(ac);
        } else
        {
            return "\n";
        }
    }

    private String indent(int i)
    {
        if (indent > 0)
        {
            String s = cache.get(i);
            if (s == null)
            {
                s = create();
                cache.set(i, s);
            }
            if (cache.size() > 0)
            {
                return s;
            }
        }
        return "";
    }

    public String pop()
    {
        int i = -1 + index;
        index = i;
        String s = indent(i);
        if (indent > 0)
        {
            count = count - indent;
        }
        return s;
    }

    public String push()
    {
        int i = index;
        index = i + 1;
        String s = indent(i);
        if (indent > 0)
        {
            count = count + indent;
        }
        return s;
    }

    public String top()
    {
        return indent(index);
    }

    private class Cache
    {

        private int count;
        private String list[];

        private void resize(int i)
        {
            String as[] = new String[i];
            for (int j = 0; j < list.length; j++)
            {
                as[j] = list[j];
            }

            list = as;
        }

        public String get(int i)
        {
            if (i < list.length)
            {
                return list[i];
            } else
            {
                return null;
            }
        }

        public void set(int i, String s)
        {
            if (i >= list.length)
            {
                resize(i * 2);
            }
            if (i > count)
            {
                count = i;
            }
            list[i] = s;
        }

        public int size()
        {
            return count;
        }

        public Cache(int i)
        {
            list = new String[i];
        }
    }

}
