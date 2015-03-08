// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.stream;


class list
{

    private int count;
    private String list[];

    private void resize(int i)
    {
        String as[] = new String[i];
        for (int j = 0; j < list.length; j++)
        {
            as[j] = list[j];
        }

        list = as;
    }

    public String get(int i)
    {
        if (i < list.length)
        {
            return list[i];
        } else
        {
            return null;
        }
    }

    public void set(int i, String s)
    {
        if (i >= list.length)
        {
            resize(i * 2);
        }
        if (i > count)
        {
            count = i;
        }
        list[i] = s;
    }

    public int size()
    {
        return count;
    }

    public (int i)
    {
        list = new String[i];
    }
}
