// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            a

public final class AppVisibleCustomProperties
    implements SafeParcelable, Iterable
{

    public static final android.os.Parcelable.Creator CREATOR = new com.google.android.gms.drive.metadata.internal.a();
    public static final AppVisibleCustomProperties JK = (new a()).gy();
    final List JL;
    final int xJ;

    AppVisibleCustomProperties(int i, Collection collection)
    {
        xJ = i;
        hn.f(collection);
        JL = new ArrayList(collection);
    }

    private AppVisibleCustomProperties(Collection collection)
    {
        this(1, collection);
    }

    AppVisibleCustomProperties(Collection collection, _cls1 _pcls1)
    {
        this(collection);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final Iterator iterator()
    {
        return JL.iterator();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        a.a(this, parcel, i);
    }


    private class a
    {

        private final Map JM = new HashMap();

        public AppVisibleCustomProperties gy()
        {
            return new AppVisibleCustomProperties(JM.values(), null);
        }

        public a()
        {
        }
    }

}
