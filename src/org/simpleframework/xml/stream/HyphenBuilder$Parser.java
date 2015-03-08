// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            Splitter, HyphenBuilder

class <init> extends Splitter
{

    final HyphenBuilder this$0;

    protected void commit(char ac[], int i, int j)
    {
        builder.append(ac, i, j);
        if (i + j < count)
        {
            builder.append('-');
        }
    }

    protected void parse(char ac[], int i, int j)
    {
        ac[i] = toLower(ac[i]);
    }

    private _cls9(String s)
    {
        this$0 = HyphenBuilder.this;
        super(s);
    }

    this._cls0(String s, this._cls0 _pcls0)
    {
        this(s);
    }
}
