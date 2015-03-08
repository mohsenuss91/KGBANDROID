// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;

// Referenced classes of package org.simpleframework.xml.core:
//            Parameter

class  extends ArrayList
{

    private int height()
    {
        int i = width();
        int j = 0;
        if (i > 0)
        {
            j = get(0).ize();
        }
        return j;
    }

    private int width()
    {
        return size();
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public Parameter get(int i, int j)
    {
        return (Parameter)get(i).et(j);
    }

    public et get(int i)
    {
        for (int j = size(); j <= i; j++)
        {
            add(new init>());
        }

        return (init>)super.get(i);
    }

    public void insert(Parameter parameter, int i)
    {
        init> init> = get(i);
        if (init> != null)
        {
            init>.dd(parameter);
        }
    }



    public ()
    {
    }
}
