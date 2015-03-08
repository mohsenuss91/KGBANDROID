// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.lz;
import com.google.android.gms.internal.ma;
import com.google.android.gms.internal.mb;
import com.google.android.gms.internal.mf;
import java.util.List;

public final class af extends mb
{

    public String Jq;
    public long Jr;
    public long Js;
    public int versionCode;

    public af()
    {
        gn();
    }

    public static af g(byte abyte0[])
    {
        return (af)mf.a(new af(), abyte0);
    }

    public final void a(ma ma1)
    {
        ma1.p(1, versionCode);
        ma1.b(2, Jq);
        ma1.c(3, Jr);
        ma1.c(4, Js);
        super.a(ma1);
    }

    public final mf b(lz lz1)
    {
        return m(lz1);
    }

    protected final int c()
    {
        return super.c() + ma.r(1, versionCode) + ma.h(2, Jq) + ma.e(3, Jr) + ma.e(4, Js);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof af))
            {
                return false;
            }
            af af1 = (af)obj;
            if (versionCode != af1.versionCode)
            {
                return false;
            }
            if (Jq == null)
            {
                if (af1.Jq != null)
                {
                    return false;
                }
            } else
            if (!Jq.equals(af1.Jq))
            {
                return false;
            }
            if (Jr != af1.Jr)
            {
                return false;
            }
            if (Js != af1.Js)
            {
                return false;
            }
            if (amU == null || amU.isEmpty())
            {
                if (af1.amU != null && !af1.amU.isEmpty())
                {
                    return false;
                }
            } else
            {
                return amU.equals(af1.amU);
            }
        }
        return true;
    }

    public final af gn()
    {
        versionCode = 1;
        Jq = "";
        Jr = -1L;
        Js = -1L;
        amU = null;
        amY = -1;
        return this;
    }

    public final int hashCode()
    {
        int i = 31 * (527 + versionCode);
        int j;
        int k;
        List list;
        int l;
        if (Jq == null)
        {
            j = 0;
        } else
        {
            j = Jq.hashCode();
        }
        k = 31 * (31 * (31 * (j + i) + (int)(Jr ^ Jr >>> 32)) + (int)(Js ^ Js >>> 32));
        list = amU;
        l = 0;
        if (list != null)
        {
            boolean flag = amU.isEmpty();
            l = 0;
            if (!flag)
            {
                l = amU.hashCode();
            }
        }
        return k + l;
    }

    public final af m(lz lz1)
    {
        do
        {
            int i = lz1.nw();
            switch (i)
            {
            default:
                if (a(lz1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                versionCode = lz1.nz();
                break;

            case 18: // '\022'
                Jq = lz1.readString();
                break;

            case 24: // '\030'
                Jr = lz1.nC();
                break;

            case 32: // ' '
                Js = lz1.nC();
                break;
            }
        } while (true);
    }
}
