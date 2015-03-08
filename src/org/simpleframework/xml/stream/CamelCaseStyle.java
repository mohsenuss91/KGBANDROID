// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            Style, CamelCaseBuilder, Builder

public class CamelCaseStyle
    implements Style
{

    private final Builder builder;
    private final Style style;

    public CamelCaseStyle()
    {
        this(true, false);
    }

    public CamelCaseStyle(boolean flag)
    {
        this(flag, false);
    }

    public CamelCaseStyle(boolean flag, boolean flag1)
    {
        style = new CamelCaseBuilder(flag, flag1);
        builder = new Builder(style);
    }

    public String getAttribute(String s)
    {
        return builder.getAttribute(s);
    }

    public String getElement(String s)
    {
        return builder.getElement(s);
    }

    public void setAttribute(String s, String s1)
    {
        builder.setAttribute(s, s1);
    }

    public void setElement(String s, String s1)
    {
        builder.setElement(s, s1);
    }
}
