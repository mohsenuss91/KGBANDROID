// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            hz, kr, ko

public final class kq extends hz
    implements SafeParcelable, Moment
{

    public static final kr CREATOR = new kr();
    private static final HashMap aco;
    private final Set acp;
    private String adc;
    private ko adk;
    private ko adl;
    private String qU;
    private String xD;
    private final int xJ;

    public kq()
    {
        xJ = 1;
        acp = new HashSet();
    }

    kq(Set set, int i, String s, ko ko1, String s1, ko ko2, String s2)
    {
        acp = set;
        xJ = i;
        xD = s;
        adk = ko1;
        adc = s1;
        adl = ko2;
        qU = s2;
    }

    public kq(Set set, String s, ko ko1, String s1, ko ko2, String s2)
    {
        acp = set;
        xJ = 1;
        xD = s;
        adk = ko1;
        adc = s1;
        adl = ko2;
        qU = s2;
    }

    protected final boolean a(hz.a a1)
    {
        return acp.contains(Integer.valueOf(a1.fI()));
    }

    protected final Object aF(String s)
    {
        return null;
    }

    protected final boolean aG(String s)
    {
        return false;
    }

    protected final Object b(hz.a a1)
    {
        switch (a1.fI())
        {
        case 3: // '\003'
        default:
            throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(a1.fI()).toString());

        case 2: // '\002'
            return xD;

        case 4: // '\004'
            return adk;

        case 5: // '\005'
            return adc;

        case 6: // '\006'
            return adl;

        case 7: // '\007'
            return qU;
        }
    }

    public final int describeContents()
    {
        kr _tmp = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof kq))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            kq kq1 = (kq)obj;
            hz.a a1;
label1:
            do
            {
                for (Iterator iterator = aco.values().iterator(); iterator.hasNext();)
                {
                    a1 = (hz.a)iterator.next();
                    if (!a(a1))
                    {
                        continue label1;
                    }
                    if (kq1.a(a1))
                    {
                        if (!b(a1).equals(kq1.b(a1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!kq1.a(a1));
            return false;
        }
        return true;
    }

    public final HashMap fB()
    {
        return aco;
    }

    public final Object freeze()
    {
        return ky();
    }

    public final String getId()
    {
        return xD;
    }

    public final ItemScope getResult()
    {
        return adk;
    }

    public final String getStartDate()
    {
        return adc;
    }

    public final ItemScope getTarget()
    {
        return adl;
    }

    public final String getType()
    {
        return qU;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final boolean hasId()
    {
        return acp.contains(Integer.valueOf(2));
    }

    public final boolean hasResult()
    {
        return acp.contains(Integer.valueOf(4));
    }

    public final boolean hasStartDate()
    {
        return acp.contains(Integer.valueOf(5));
    }

    public final boolean hasTarget()
    {
        return acp.contains(Integer.valueOf(6));
    }

    public final boolean hasType()
    {
        return acp.contains(Integer.valueOf(7));
    }

    public final int hashCode()
    {
        Iterator iterator = aco.values().iterator();
        int i = 0;
        while (iterator.hasNext()) 
        {
            hz.a a1 = (hz.a)iterator.next();
            int j;
            if (a(a1))
            {
                j = i + a1.fI() + b(a1).hashCode();
            } else
            {
                j = i;
            }
            i = j;
        }
        return i;
    }

    public final boolean isDataValid()
    {
        return true;
    }

    final Set kf()
    {
        return acp;
    }

    final ko kw()
    {
        return adk;
    }

    final ko kx()
    {
        return adl;
    }

    public final kq ky()
    {
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        kr _tmp = CREATOR;
        kr.a(this, parcel, i);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        aco = hashmap;
        hashmap.put("id", hz.a.j("id", 2));
        aco.put("result", hz.a.a("result", 4, com/google/android/gms/internal/ko));
        aco.put("startDate", hz.a.j("startDate", 5));
        aco.put("target", hz.a.a("target", 6, com/google/android/gms/internal/ko));
        aco.put("type", hz.a.j("type", 7));
    }
}
