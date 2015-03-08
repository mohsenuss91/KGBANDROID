// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            hz, kw, hw

public final class adK extends hz
    implements SafeParcelable, com.google.android.gms.plus.model.people.n.Cover
{

    public static final kw CREATOR = new kw();
    private static final HashMap aco;
    private final Set acp;
    private a adI;
    private b adJ;
    private int adK;
    private final int xJ;

    protected final boolean a(ple.n.Cover cover)
    {
        return acp.contains(Integer.valueOf(cover.fI()));
    }

    protected final Object aF(String s)
    {
        return null;
    }

    protected final boolean aG(String s)
    {
        return false;
    }

    protected final Object b(fI fi)
    {
        switch (fi.fI())
        {
        default:
            throw new IllegalStateException((new StringBuilder("Unknown safe parcelable id=")).append(fi.fI()).toString());

        case 2: // '\002'
            return adI;

        case 3: // '\003'
            return adJ;

        case 4: // '\004'
            return Integer.valueOf(adK);
        }
    }

    public final int describeContents()
    {
        kw _tmp = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj)
    {
label0:
        {
            if (!(obj instanceof CREATOR))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            CREATOR creator = (CREATOR)obj;
            CREATOR creator1;
label1:
            do
            {
                for (Iterator iterator = aco.values().iterator(); iterator.hasNext();)
                {
                    creator1 = (aco)iterator.next();
                    if (!a(creator1))
                    {
                        continue label1;
                    }
                    if (creator.a(creator1))
                    {
                        if (!b(creator1).equals(creator.b(creator1)))
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                }

                break label0;
            } while (!creator.a(creator1));
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
        return kL();
    }

    public final com.google.android.gms.plus.model.people.n.Cover.CoverInfo getCoverInfo()
    {
        return adI;
    }

    public final com.google.android.gms.plus.model.people.n.Cover.CoverPhoto getCoverPhoto()
    {
        return adJ;
    }

    public final int getLayout()
    {
        return adK;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final boolean hasCoverInfo()
    {
        return acp.contains(Integer.valueOf(2));
    }

    public final boolean hasCoverPhoto()
    {
        return acp.contains(Integer.valueOf(3));
    }

    public final boolean hasLayout()
    {
        return acp.contains(Integer.valueOf(4));
    }

    public final int hashCode()
    {
        Iterator iterator = aco.values().iterator();
        int i = 0;
        while (iterator.hasNext()) 
        {
            acp acp1 = (aco)iterator.next();
            int j;
            if (a(acp1))
            {
                j = i + acp1.fI() + b(acp1).hashCode();
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

    final a kJ()
    {
        return adI;
    }

    final b kK()
    {
        return adJ;
    }

    public final adJ kL()
    {
        return this;
    }

    final Set kf()
    {
        return acp;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        kw _tmp = CREATOR;
        kw.a(this, parcel, i);
    }

    static 
    {
        HashMap hashmap = new HashMap();
        aco = hashmap;
        hashmap.put("coverInfo", a("coverInfo", 2, com/google/android/gms/internal/kt$b$a));
        aco.put("coverPhoto", a("coverPhoto", 3, com/google/android/gms/internal/kt$b$b));
        aco.put("layout", a("layout", 4, (new hw()).f("banner", 0), false));
    }

    public b()
    {
        xJ = 1;
        acp = new HashSet();
    }

    b(Set set, int i, a a1, b b1, int j)
    {
        acp = set;
        xJ = i;
        adI = a1;
        adJ = b1;
        adK = j;
    }
}
