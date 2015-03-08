// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.os.Parcel;

// Referenced classes of package com.inmobi.re.controller:
//            c

public class rcelable extends rcelable
{

    public static final android.os.er.Dimensions.height CREATOR = new c();
    public int height;
    public int width;
    public int x;
    public int y;

    public String toString()
    {
        return (new StringBuilder("x: ")).append(x).append(", y: ").append(y).append(", width: ").append(width).append(", height: ").append(height).toString();
    }


    public rcelable()
    {
        x = -1;
        y = -1;
        width = -1;
        height = -1;
    }

    protected height(Parcel parcel)
    {
        super(parcel);
    }
}
