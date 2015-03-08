// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            CamelCaseBuilder

class <init> extends e
{

    private boolean capital;
    final CamelCaseBuilder this$0;

    protected void parse(char ac[], int i, int j)
    {
        if (element || capital)
        {
            ac[i] = toUpper(ac[i]);
        }
        capital = true;
    }

    private e(String s)
    {
        this$0 = CamelCaseBuilder.this;
        super(CamelCaseBuilder.this, s, null);
    }

    e(String s, e e)
    {
        this(s);
    }
}
