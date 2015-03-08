// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            hl

public final class FQ
{

    public final int FP;
    public final int FQ;

    public final boolean equals(Object obj)
    {
        if (obj instanceof FQ)
        {
            if (this == obj)
            {
                return true;
            }
            FQ fq = (FQ)obj;
            if (fq.FP == FP && fq.FQ == FQ)
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(FP);
        aobj[1] = Integer.valueOf(FQ);
        return hl.hashCode(aobj);
    }

    public (int i, int j)
    {
        FP = i;
        FQ = j;
    }
}
