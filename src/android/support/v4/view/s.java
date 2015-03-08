// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.KeyEvent;

// Referenced classes of package android.support.v4.view:
//            v

class s
    implements v
{

    s()
    {
    }

    private static int a(int i, int j, int k, int l)
    {
        boolean flag = true;
        boolean flag1;
        int i1;
        if ((j & 1) != 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        i1 = k | l;
        if ((i1 & 1) == 0)
        {
            flag = false;
        }
        if (flag1)
        {
            if (flag)
            {
                throw new IllegalArgumentException("bad arguments");
            }
            i &= ~i1;
        } else
        if (flag)
        {
            return i & ~j;
        }
        return i;
    }

    public int a(int i)
    {
        int j;
        if ((i & 0xc0) != 0)
        {
            j = i | 1;
        } else
        {
            j = i;
        }
        if ((j & 0x30) != 0)
        {
            j |= 2;
        }
        return j & 0xf7;
    }

    public void a(KeyEvent keyevent)
    {
    }

    public boolean b(int i)
    {
        return a(a(0xf7 & a(i), 1, 64, 128), 2, 16, 32) == 1;
    }

    public boolean c(int i)
    {
        return (0xf7 & a(i)) == 0;
    }
}
