// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            i

public final class LineItem
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new i();
    String aiH;
    String aiI;
    String ajb;
    String ajc;
    int ajd;
    String description;
    private final int xJ;

    LineItem()
    {
        xJ = 1;
        ajd = 0;
    }

    LineItem(int j, String s, String s1, String s2, String s3, int k, String s4)
    {
        xJ = j;
        description = s;
        ajb = s1;
        ajc = s2;
        aiH = s3;
        ajd = k;
        aiI = s4;
    }

    public static Builder newBuilder()
    {
        LineItem lineitem = new LineItem();
        lineitem.getClass();
        return lineitem. new Builder(null);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getCurrencyCode()
    {
        return aiI;
    }

    public final String getDescription()
    {
        return description;
    }

    public final String getQuantity()
    {
        return ajb;
    }

    public final int getRole()
    {
        return ajd;
    }

    public final String getTotalPrice()
    {
        return aiH;
    }

    public final String getUnitPrice()
    {
        return ajc;
    }

    public final int getVersionCode()
    {
        return xJ;
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        i.a(this, parcel, j);
    }


    private class Builder
    {

        final LineItem aje;

        public final LineItem build()
        {
            return aje;
        }

        public final Builder setCurrencyCode(String s)
        {
            aje.aiI = s;
            return this;
        }

        public final Builder setDescription(String s)
        {
            aje.description = s;
            return this;
        }

        public final Builder setQuantity(String s)
        {
            aje.ajb = s;
            return this;
        }

        public final Builder setRole(int j)
        {
            aje.ajd = j;
            return this;
        }

        public final Builder setTotalPrice(String s)
        {
            aje.aiH = s;
            return this;
        }

        public final Builder setUnitPrice(String s)
        {
            aje.ajc = s;
            return this;
        }

        private Builder()
        {
            aje = LineItem.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}
