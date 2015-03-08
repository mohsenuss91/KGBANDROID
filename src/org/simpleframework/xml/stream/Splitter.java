// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


abstract class Splitter
{

    protected StringBuilder builder;
    protected int count;
    protected int off;
    protected char text[];

    public Splitter(String s)
    {
        builder = new StringBuilder();
        text = s.toCharArray();
        count = text.length;
    }

    private boolean acronym()
    {
        int i = off;
        int j = 0;
        for (; i < count && isUpper(text[i]); i++)
        {
            j++;
        }

        if (j > 1)
        {
            if (i < count && isUpper(text[i - 1]))
            {
                i--;
            }
            commit(text, off, i - off);
            off = i;
        }
        boolean flag = false;
        if (j > 1)
        {
            flag = true;
        }
        return flag;
    }

    private boolean isDigit(char c)
    {
        return Character.isDigit(c);
    }

    private boolean isLetter(char c)
    {
        return Character.isLetter(c);
    }

    private boolean isSpecial(char c)
    {
        return !Character.isLetterOrDigit(c);
    }

    private boolean isUpper(char c)
    {
        return Character.isUpperCase(c);
    }

    private boolean number()
    {
        int i = off;
        int j = 0;
        for (; i < count && isDigit(text[i]); i++)
        {
            j++;
        }

        if (j > 0)
        {
            commit(text, off, i - off);
        }
        off = i;
        boolean flag = false;
        if (j > 0)
        {
            flag = true;
        }
        return flag;
    }

    private void token()
    {
        int i = off;
        do
        {
            if (i >= count)
            {
                break;
            }
            char c = text[i];
            if (!isLetter(c) || i > off && isUpper(c))
            {
                break;
            }
            i++;
        } while (true);
        if (i > off)
        {
            parse(text, off, i - off);
            commit(text, off, i - off);
        }
        off = i;
    }

    protected abstract void commit(char ac[], int i, int j);

    protected abstract void parse(char ac[], int i, int j);

    public String process()
    {
        do
        {
            if (off >= count)
            {
                break;
            }
            for (; off < count && isSpecial(text[off]); off = 1 + off) { }
            if (!acronym())
            {
                token();
                number();
            }
        } while (true);
        return builder.toString();
    }

    protected char toLower(char c)
    {
        return Character.toLowerCase(c);
    }

    protected char toUpper(char c)
    {
        return Character.toUpperCase(c);
    }
}
