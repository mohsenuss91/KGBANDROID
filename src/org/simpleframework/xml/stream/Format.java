// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            IdentityStyle, Verbosity, Style

public class Format
{

    private final int indent;
    private final String prolog;
    private final Style style;
    private final Verbosity verbosity;

    public Format()
    {
        this(3);
    }

    public Format(int i)
    {
        this(i, ((String) (null)), ((Style) (new IdentityStyle())));
    }

    public Format(int i, String s)
    {
        this(i, s, ((Style) (new IdentityStyle())));
    }

    public Format(int i, String s, Style style1)
    {
        this(i, s, style1, Verbosity.HIGH);
    }

    public Format(int i, String s, Style style1, Verbosity verbosity1)
    {
        verbosity = verbosity1;
        prolog = s;
        indent = i;
        style = style1;
    }

    public Format(int i, Style style1)
    {
        this(i, ((String) (null)), style1);
    }

    public Format(int i, Style style1, Verbosity verbosity1)
    {
        this(i, null, style1, verbosity1);
    }

    public Format(int i, Verbosity verbosity1)
    {
        this(i, ((Style) (new IdentityStyle())), verbosity1);
    }

    public Format(String s)
    {
        this(3, s);
    }

    public Format(Style style1)
    {
        this(3, style1);
    }

    public Format(Style style1, Verbosity verbosity1)
    {
        this(3, style1, verbosity1);
    }

    public Format(Verbosity verbosity1)
    {
        this(3, verbosity1);
    }

    public int getIndent()
    {
        return indent;
    }

    public String getProlog()
    {
        return prolog;
    }

    public Style getStyle()
    {
        return style;
    }

    public Verbosity getVerbosity()
    {
        return verbosity;
    }
}
