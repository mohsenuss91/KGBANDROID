// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;


final class 
{

    private int leavesSkipped;
    private int leavesToSkip;
    private int size;
    private  stack;

    final void add( )
    {
        . = null;
        . = null;
        . = null;
        . = 1;
        if (leavesToSkip > 0 && (1 & size) == 0)
        {
            size = 1 + size;
            leavesToSkip = -1 + leavesToSkip;
            leavesSkipped = 1 + leavesSkipped;
        }
        . = stack;
        stack = ;
        size = 1 + size;
        if (leavesToSkip > 0 && (1 & size) == 0)
        {
            size = 1 + size;
            leavesToSkip = -1 + leavesToSkip;
            leavesSkipped = 1 + leavesSkipped;
        }
        int i = 4;
        while ((size & i - 1) == i - 1) 
        {
            if (leavesSkipped == 0)
            {
                 3 = stack;
                 4 = 3.;
                 5 = 4.;
                4. = 5.;
                stack = 4;
                4.stack = 5;
                4.stack = 3;
                4. = 1 + 3.;
                5. = 4;
                3. = 4;
            } else
            if (leavesSkipped == 1)
            {
                 1 = stack;
                 2 = 1.;
                stack = 2;
                2.stack = 1;
                2. = 1 + 1.;
                1. = 2;
                leavesSkipped = 0;
            } else
            if (leavesSkipped == 2)
            {
                leavesSkipped = 0;
            }
            i *= 2;
        }
    }

    final void reset(int i)
    {
        leavesToSkip = (-1 + 2 * Integer.highestOneBit(i)) - i;
        size = 0;
        leavesSkipped = 0;
        stack = null;
    }

    final stack root()
    {
        stack stack1 = stack;
        if (stack1. != null)
        {
            throw new IllegalStateException();
        } else
        {
            return stack1;
        }
    }

    ()
    {
    }
}
