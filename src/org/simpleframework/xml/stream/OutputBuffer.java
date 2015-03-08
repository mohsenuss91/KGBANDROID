// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;

import java.io.Writer;

class OutputBuffer
{

    private StringBuilder text;

    public OutputBuffer()
    {
        text = new StringBuilder();
    }

    public void append(char c)
    {
        text.append(c);
    }

    public void append(String s)
    {
        text.append(s);
    }

    public void append(String s, int i, int j)
    {
        text.append(s, i, j);
    }

    public void append(char ac[])
    {
        text.append(ac, 0, ac.length);
    }

    public void append(char ac[], int i, int j)
    {
        text.append(ac, i, j);
    }

    public void clear()
    {
        text.setLength(0);
    }

    public void write(Writer writer)
    {
        writer.append(text);
    }
}
