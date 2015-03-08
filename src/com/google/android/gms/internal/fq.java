// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            fr, fn

public class fq
    implements SafeParcelable
{

    public static final fr CREATOR = new fr();
    public final String name;
    public final int weight;
    final int xJ;
    public final String xY;
    public final boolean xZ;
    public final boolean ya;
    public final String yb;
    public final fn yc[];
    final int yd[];
    public final String ye;

    fq(int i, String s, String s1, boolean flag, int j, boolean flag1, String s2, 
            fn afn[], int ai[], String s3)
    {
        xJ = i;
        name = s;
        xY = s1;
        xZ = flag;
        weight = j;
        ya = flag1;
        yb = s2;
        yc = afn;
        yd = ai;
        ye = s3;
    }

    fq(String s, String s1, boolean flag, int i, boolean flag1, String s2, fn afn[], 
            int ai[], String s3)
    {
        this(2, s, s1, flag, i, flag1, s2, afn, ai, s3);
    }

    public int describeContents()
    {
        fr _tmp = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag = obj instanceof fq;
        boolean flag1 = false;
        if (flag)
        {
            fq fq1 = (fq)obj;
            boolean flag2 = name.equals(fq1.name);
            flag1 = false;
            if (flag2)
            {
                boolean flag3 = xY.equals(fq1.xY);
                flag1 = false;
                if (flag3)
                {
                    boolean flag4 = xZ;
                    boolean flag5 = fq1.xZ;
                    flag1 = false;
                    if (flag4 == flag5)
                    {
                        flag1 = true;
                    }
                }
            }
        }
        return flag1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        fr _tmp = CREATOR;
        fr.a(this, parcel, i);
    }

}
