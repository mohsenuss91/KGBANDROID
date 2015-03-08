// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


// Referenced classes of package org.simpleframework.xml.stream:
//            Style

class HyphenBuilder
    implements Style
{

    HyphenBuilder()
    {
    }

    public String getAttribute(String s)
    {
        String s1 = null;
        if (s != null)
        {
            s1 = (new Parser(s, null)).process();
        }
        return s1;
    }

    public String getElement(String s)
    {
        String s1 = null;
        if (s != null)
        {
            s1 = (new Parser(s, null)).process();
        }
        return s1;
    }

    private class Parser extends Splitter
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

        private Parser(String s)
        {
            this$0 = HyphenBuilder.this;
            super(s);
        }

        Parser(String s, _cls1 _pcls1)
        {
            this(s);
        }
    }

}
