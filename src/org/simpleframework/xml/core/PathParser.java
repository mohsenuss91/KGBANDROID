// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.core:
//            Expression, PathException

class PathParser
    implements Expression
{

    protected boolean attribute;
    protected Cache attributes;
    protected StringBuilder builder;
    protected String cache;
    protected int count;
    protected char data[];
    protected Cache elements;
    protected List indexes;
    protected String location;
    protected List names;
    protected int off;
    protected String path;
    protected List prefixes;
    protected int start;
    protected Style style;
    protected Type type;

    public PathParser(String s, Type type1, Format format)
    {
        attributes = new ConcurrentCache();
        elements = new ConcurrentCache();
        indexes = new ArrayList();
        prefixes = new ArrayList();
        names = new ArrayList();
        builder = new StringBuilder();
        style = format.getStyle();
        type = type1;
        path = s;
        parse(s);
    }

    private void align()
    {
        if (names.size() > indexes.size())
        {
            indexes.add(Integer.valueOf(1));
        }
    }

    private void attribute()
    {
        int i = 1 + off;
        for (off = i; off < count;)
        {
            char ac[] = data;
            int j = off;
            off = j + 1;
            char c = ac[j];
            if (!isValid(c))
            {
                Object aobj1[] = new Object[3];
                aobj1[0] = Character.valueOf(c);
                aobj1[1] = path;
                aobj1[2] = type;
                throw new PathException("Illegal character '%s' in attribute for '%s' in %s", aobj1);
            }
        }

        if (off <= i)
        {
            Object aobj[] = new Object[2];
            aobj[0] = path;
            aobj[1] = type;
            throw new PathException("Attribute reference in '%s' for %s is empty", aobj);
        } else
        {
            attribute = true;
            attribute(i, off - i);
            return;
        }
    }

    private void attribute(int i, int j)
    {
        String s = new String(data, i, j);
        if (j > 0)
        {
            attribute(s);
        }
    }

    private void attribute(String s)
    {
        String s1 = style.getAttribute(s);
        prefixes.add(null);
        names.add(s1);
    }

    private void build()
    {
        int i = names.size();
        int j = i - 1;
        int k = 0;
        while (k < i) 
        {
            String s = (String)prefixes.get(k);
            String s1 = (String)names.get(k);
            int l = ((Integer)indexes.get(k)).intValue();
            if (k > 0)
            {
                builder.append('/');
            }
            if (attribute && k == j)
            {
                builder.append('@');
                builder.append(s1);
            } else
            {
                if (s != null)
                {
                    builder.append(s);
                    builder.append(':');
                }
                builder.append(s1);
                builder.append('[');
                builder.append(l);
                builder.append(']');
            }
            k++;
        }
        location = builder.toString();
    }

    private void element()
    {
        int i;
        int j;
        i = off;
        j = 0;
_L8:
        if (off >= count) goto _L2; else goto _L1
_L1:
        char c;
        char ac[] = data;
        int k = off;
        off = k + 1;
        c = ac[k];
        if (isValid(c))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        if (c != '@') goto _L4; else goto _L3
_L3:
        off = -1 + off;
_L2:
        element(i, j);
        return;
_L4:
        if (c != '[')
        {
            break; /* Loop/switch isn't completed */
        }
        index();
        if (true) goto _L2; else goto _L5
_L5:
        if (c == '/') goto _L2; else goto _L6
_L6:
        Object aobj[] = new Object[3];
        aobj[0] = Character.valueOf(c);
        aobj[1] = path;
        aobj[2] = type;
        throw new PathException("Illegal character '%s' in element for '%s' in %s", aobj);
        j++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void element(int i, int j)
    {
        String s = new String(data, i, j);
        if (j > 0)
        {
            element(s);
        }
    }

    private void element(String s)
    {
        int i = s.indexOf(':');
        String s1 = null;
        if (i > 0)
        {
            s1 = s.substring(0, i);
            s = s.substring(i + 1);
        }
        String s2 = style.getElement(s);
        prefixes.add(s1);
        names.add(s2);
    }

    private void index()
    {
        int i;
        if (data[-1 + off] == '[')
        {
            i = 0;
            do
            {
                if (off >= count)
                {
                    break;
                }
                char ac1[] = data;
                int k = off;
                off = k + 1;
                char c = ac1[k];
                if (!isDigit(c))
                {
                    break;
                }
                i = -48 + (c + i * 10);
            } while (true);
        } else
        {
            i = 0;
        }
        char ac[] = data;
        int j = off;
        off = j + 1;
        if (ac[j - 1] != ']')
        {
            Object aobj[] = new Object[2];
            aobj[0] = path;
            aobj[1] = type;
            throw new PathException("Invalid index for path '%s' in %s", aobj);
        } else
        {
            indexes.add(Integer.valueOf(i));
            return;
        }
    }

    private boolean isDigit(char c)
    {
        return Character.isDigit(c);
    }

    private boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    private boolean isLetter(char c)
    {
        return Character.isLetterOrDigit(c);
    }

    private boolean isSpecial(char c)
    {
        return c == '_' || c == '-' || c == ':';
    }

    private boolean isValid(char c)
    {
        return isLetter(c) || isSpecial(c);
    }

    private void parse(String s)
    {
        if (s != null)
        {
            count = s.length();
            data = new char[count];
            s.getChars(0, count, data, 0);
        }
        path();
    }

    private void path()
    {
        if (data[off] == '/')
        {
            Object aobj1[] = new Object[2];
            aobj1[0] = path;
            aobj1[1] = type;
            throw new PathException("Path '%s' in %s references document root", aobj1);
        }
        if (data[off] == '.')
        {
            skip();
        }
        while (off < count) 
        {
            if (attribute)
            {
                Object aobj[] = new Object[2];
                aobj[0] = path;
                aobj[1] = type;
                throw new PathException("Path '%s' in %s references an invalid attribute", aobj);
            }
            segment();
        }
        truncate();
        build();
    }

    private void segment()
    {
        char c = data[off];
        if (c == '/')
        {
            Object aobj[] = new Object[2];
            aobj[0] = path;
            aobj[1] = type;
            throw new PathException("Invalid path expression '%s' in %s", aobj);
        }
        if (c == '@')
        {
            attribute();
        } else
        {
            element();
        }
        align();
    }

    private void skip()
    {
        if (data.length > 1)
        {
            if (data[1 + off] != '/')
            {
                Object aobj[] = new Object[2];
                aobj[0] = path;
                aobj[1] = type;
                throw new PathException("Path '%s' in %s has an illegal syntax", aobj);
            }
            off = 1 + off;
        }
        int i = 1 + off;
        off = i;
        start = i;
    }

    private void truncate()
    {
        if (-1 + off >= data.length)
        {
            off = -1 + off;
        } else
        if (data[-1 + off] == '/')
        {
            off = -1 + off;
            return;
        }
    }

    public String getAttribute(String s)
    {
        if (!isEmpty(location))
        {
            String s1 = (String)attributes.fetch(s);
            if (s1 == null)
            {
                s1 = getAttributePath(location, s);
                if (s1 != null)
                {
                    attributes.cache(s, s1);
                }
            }
            return s1;
        } else
        {
            return style.getAttribute(s);
        }
    }

    protected String getAttributePath(String s, String s1)
    {
        String s2 = style.getAttribute(s1);
        if (isEmpty(s))
        {
            return s2;
        } else
        {
            return (new StringBuilder()).append(s).append("/@").append(s2).toString();
        }
    }

    public String getElement(String s)
    {
        if (!isEmpty(location))
        {
            String s1 = (String)elements.fetch(s);
            if (s1 == null)
            {
                s1 = getElementPath(location, s);
                if (s1 != null)
                {
                    elements.cache(s, s1);
                }
            }
            return s1;
        } else
        {
            return style.getElement(s);
        }
    }

    protected String getElementPath(String s, String s1)
    {
        String s2 = style.getElement(s1);
        if (isEmpty(s2))
        {
            return s;
        }
        if (isEmpty(s))
        {
            return s2;
        } else
        {
            return (new StringBuilder()).append(s).append("/").append(s2).append("[1]").toString();
        }
    }

    public String getFirst()
    {
        return (String)names.get(0);
    }

    public int getIndex()
    {
        return ((Integer)indexes.get(0)).intValue();
    }

    public String getLast()
    {
        int i = -1 + names.size();
        return (String)names.get(i);
    }

    public String getPath()
    {
        return location;
    }

    public Expression getPath(int i)
    {
        return getPath(i, 0);
    }

    public Expression getPath(int i, int j)
    {
        int k = -1 + names.size();
        if (k - j >= i)
        {
            return new PathSection(i, k - j);
        } else
        {
            return new PathSection(i, i);
        }
    }

    public String getPrefix()
    {
        return (String)prefixes.get(0);
    }

    public boolean isAttribute()
    {
        return attribute;
    }

    public boolean isEmpty()
    {
        return isEmpty(location);
    }

    public boolean isPath()
    {
        return names.size() > 1;
    }

    public Iterator iterator()
    {
        return names.iterator();
    }

    public String toString()
    {
        int i = off - start;
        if (cache == null)
        {
            cache = new String(data, start, i);
        }
        return cache;
    }

    private class PathSection
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
            return new PathSection(i + begin, end - j);
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

        public PathSection(int i, int j)
        {
            this$0 = PathParser.this;
            super();
            cache = new ArrayList();
            begin = i;
            end = j;
        }
    }

}
