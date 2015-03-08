// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            Splitter, CamelCaseBuilder

class <init> extends Splitter
{

    private boolean capital;
    final CamelCaseBuilder this$0;

    protected void commit(char ac[], int i, int j)
    {
        builder.append(ac, i, j);
    }

    protected void parse(char ac[], int i, int j)
    {
        if (attribute || capital)
        {
            ac[i] = toUpper(ac[i]);
        }
        capital = true;
    }

    private (String s)
    {
        this$0 = CamelCaseBuilder.this;
        super(s);
    }

    this._cls0(String s, this._cls0 _pcls0)
    {
        this(s);
    }
}
