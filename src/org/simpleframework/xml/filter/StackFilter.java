// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.filter;

import java.util.Stack;

// Referenced classes of package org.simpleframework.xml.filter:
//            Filter

public class StackFilter
    implements Filter
{

    private Stack stack;

    public StackFilter()
    {
        stack = new Stack();
    }

    public void push(Filter filter)
    {
        stack.push(filter);
    }

    public String replace(String s)
    {
        int i = stack.size();
        do
        {
            int j = i - 1;
            if (j >= 0)
            {
                String s1 = ((Filter)stack.get(j)).replace(s);
                if (s1 != null)
                {
                    return s1;
                }
                i = j;
            } else
            {
                return null;
            }
        } while (true);
    }
}
