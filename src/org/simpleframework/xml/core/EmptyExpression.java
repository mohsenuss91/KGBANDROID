// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Expression

class EmptyExpression
    implements Expression
{

    private final List list = new LinkedList();
    private final Style style;

    public EmptyExpression(Format format)
    {
        style = format.getStyle();
    }

    public String getAttribute(String s)
    {
        return style.getAttribute(s);
    }

    public String getElement(String s)
    {
        return style.getElement(s);
    }

    public String getFirst()
    {
        return null;
    }

    public int getIndex()
    {
        return 0;
    }

    public String getLast()
    {
        return null;
    }

    public String getPath()
    {
        return "";
    }

    public Expression getPath(int i)
    {
        return null;
    }

    public Expression getPath(int i, int j)
    {
        return null;
    }

    public String getPrefix()
    {
        return null;
    }

    public boolean isAttribute()
    {
        return false;
    }

    public boolean isEmpty()
    {
        return true;
    }

    public boolean isPath()
    {
        return false;
    }

    public Iterator iterator()
    {
        return list.iterator();
    }
}
