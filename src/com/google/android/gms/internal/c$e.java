// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            mb, md, ma, lz, 
//            mf

public final class j extends mb
{

    private static volatile amY eU[];
    public int key;
    public int value;

    public static j[] i()
    {
        if (eU == null)
        {
            synchronized (md.amX)
            {
                if (eU == null)
                {
                    eU = new eU[0];
                }
            }
        }
        return eU;
    }

    public final void a(ma ma1)
    {
        ma1.p(1, key);
        ma1.p(2, value);
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return f(lz1);
    }

    protected final int c()
    {
        return super.c() + ma.r(1, key) + ma.r(2, value);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof value))
            {
                return false;
            }
            value value1 = (value)obj;
            if (key != value1.key)
            {
                return false;
            }
            if (value != value1.value)
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (value1.amU != null && !value1.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(value1.amU);
            }
        }
        return true;
    }

    public final amU f(lz lz1)
    {
        do
        {
            int k = lz1.nw();
            switch (k)
            {
            default:
                if (a(lz1, k))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                key = lz1.nz();
                break;

            case 16: // '\020'
                value = lz1.nz();
                break;
            }
        } while (true);
    }

    public final int hashCode()
    {
        int k = 31 * (31 * (527 + key) + value);
        int l;
        if (amU == null || amU.isEmpty())
        {
            l = 0;
        } else
        {
            l = amU.hashCode();
        }
        return l + k;
    }

    public final amU j()
    {
        key = 0;
        value = 0;
        amU = null;
        amY = -1;
        return this;
    }

    public ()
    {
        j();
    }
}
