// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            hx

public final class hw
    implements SafeParcelable, hz.b
{

    public static final hx CREATOR = new hx();
    private final HashMap GT;
    private final HashMap GU;
    private final ArrayList GV;
    private final int xJ;

    public hw()
    {
        xJ = 1;
        GT = new HashMap();
        GU = new HashMap();
        GV = null;
    }

    hw(int i, ArrayList arraylist)
    {
        xJ = i;
        GT = new HashMap();
        GU = new HashMap();
        GV = null;
        a(arraylist);
    }

    private void a(ArrayList arraylist)
    {
        a a1;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); f(a1.GW, a1.GX))
        {
            a1 = (a)iterator.next();
        }

    }

    public final String a(Integer integer)
    {
        String s = (String)GU.get(integer);
        if (s == null && GT.containsKey("gms_unknown"))
        {
            s = "gms_unknown";
        }
        return s;
    }

    public final int describeContents()
    {
        hx _tmp = CREATOR;
        return 0;
    }

    public final hw f(String s, int i)
    {
        GT.put(s, Integer.valueOf(i));
        GU.put(Integer.valueOf(i), s);
        return this;
    }

    public final int fA()
    {
        return 0;
    }

    final ArrayList fy()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = GT.keySet().iterator(); iterator.hasNext(); arraylist.add(new a(s, ((Integer)GT.get(s)).intValue())))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public final int fz()
    {
        return 7;
    }

    public final Object g(Object obj)
    {
        return a((Integer)obj);
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        hx _tmp = CREATOR;
        hx.a(this, parcel, i);
    }


    private class a
        implements SafeParcelable
    {

        public static final hy CREATOR = new hy();
        final String GW;
        final int GX;
        final int versionCode;

        public final int describeContents()
        {
            hy _tmp = CREATOR;
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i)
        {
            hy _tmp = CREATOR;
            hy.a(this, parcel, i);
        }


        a(int i, String s, int j)
        {
            versionCode = i;
            GW = s;
            GX = j;
        }

        a(String s, int i)
        {
            versionCode = 1;
            GW = s;
            GX = i;
        }
    }

}
