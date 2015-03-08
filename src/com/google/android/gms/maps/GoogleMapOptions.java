// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.a;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptionsCreator, a

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final GoogleMapOptionsCreator CREATOR = new GoogleMapOptionsCreator();
    private Boolean Zp;
    private Boolean Zq;
    private int Zr;
    private CameraPosition Zs;
    private Boolean Zt;
    private Boolean Zu;
    private Boolean Zv;
    private Boolean Zw;
    private Boolean Zx;
    private Boolean Zy;
    private final int xJ;

    public GoogleMapOptions()
    {
        Zr = -1;
        xJ = 1;
    }

    GoogleMapOptions(int i, byte byte0, byte byte1, int j, CameraPosition cameraposition, byte byte2, byte byte3, 
            byte byte4, byte byte5, byte byte6, byte byte7)
    {
        Zr = -1;
        xJ = i;
        Zp = a.a(byte0);
        Zq = a.a(byte1);
        Zr = j;
        Zs = cameraposition;
        Zt = a.a(byte2);
        Zu = a.a(byte3);
        Zv = a.a(byte4);
        Zw = a.a(byte5);
        Zx = a.a(byte6);
        Zy = a.a(byte7);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        TypedArray typedarray = context.getResources().obtainAttributes(attributeset, com.google.android.gms.R.styleable.MapAttrs);
        GoogleMapOptions googlemapoptions = new GoogleMapOptions();
        if (typedarray.hasValue(0))
        {
            googlemapoptions.mapType(typedarray.getInt(0, -1));
        }
        if (typedarray.hasValue(13))
        {
            googlemapoptions.zOrderOnTop(typedarray.getBoolean(13, false));
        }
        if (typedarray.hasValue(12))
        {
            googlemapoptions.useViewLifecycleInFragment(typedarray.getBoolean(12, false));
        }
        if (typedarray.hasValue(6))
        {
            googlemapoptions.compassEnabled(typedarray.getBoolean(6, true));
        }
        if (typedarray.hasValue(7))
        {
            googlemapoptions.rotateGesturesEnabled(typedarray.getBoolean(7, true));
        }
        if (typedarray.hasValue(8))
        {
            googlemapoptions.scrollGesturesEnabled(typedarray.getBoolean(8, true));
        }
        if (typedarray.hasValue(9))
        {
            googlemapoptions.tiltGesturesEnabled(typedarray.getBoolean(9, true));
        }
        if (typedarray.hasValue(11))
        {
            googlemapoptions.zoomGesturesEnabled(typedarray.getBoolean(11, true));
        }
        if (typedarray.hasValue(10))
        {
            googlemapoptions.zoomControlsEnabled(typedarray.getBoolean(10, true));
        }
        googlemapoptions.camera(CameraPosition.createFromAttributes(context, attributeset));
        typedarray.recycle();
        return googlemapoptions;
    }

    public final GoogleMapOptions camera(CameraPosition cameraposition)
    {
        Zs = cameraposition;
        return this;
    }

    public final GoogleMapOptions compassEnabled(boolean flag)
    {
        Zu = Boolean.valueOf(flag);
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final CameraPosition getCamera()
    {
        return Zs;
    }

    public final Boolean getCompassEnabled()
    {
        return Zu;
    }

    public final int getMapType()
    {
        return Zr;
    }

    public final Boolean getRotateGesturesEnabled()
    {
        return Zy;
    }

    public final Boolean getScrollGesturesEnabled()
    {
        return Zv;
    }

    public final Boolean getTiltGesturesEnabled()
    {
        return Zx;
    }

    public final Boolean getUseViewLifecycleInFragment()
    {
        return Zq;
    }

    final int getVersionCode()
    {
        return xJ;
    }

    public final Boolean getZOrderOnTop()
    {
        return Zp;
    }

    public final Boolean getZoomControlsEnabled()
    {
        return Zt;
    }

    public final Boolean getZoomGesturesEnabled()
    {
        return Zw;
    }

    final byte jl()
    {
        return a.c(Zp);
    }

    final byte jm()
    {
        return a.c(Zq);
    }

    final byte jn()
    {
        return a.c(Zt);
    }

    final byte jo()
    {
        return a.c(Zu);
    }

    final byte jp()
    {
        return a.c(Zv);
    }

    final byte jq()
    {
        return a.c(Zw);
    }

    final byte jr()
    {
        return a.c(Zx);
    }

    final byte js()
    {
        return a.c(Zy);
    }

    public final GoogleMapOptions mapType(int i)
    {
        Zr = i;
        return this;
    }

    public final GoogleMapOptions rotateGesturesEnabled(boolean flag)
    {
        Zy = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabled(boolean flag)
    {
        Zv = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions tiltGesturesEnabled(boolean flag)
    {
        Zx = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions useViewLifecycleInFragment(boolean flag)
    {
        Zq = Boolean.valueOf(flag);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (v.jG())
        {
            com.google.android.gms.maps.a.a(this, parcel, i);
            return;
        } else
        {
            com.google.android.gms.maps.GoogleMapOptionsCreator.a(this, parcel, i);
            return;
        }
    }

    public final GoogleMapOptions zOrderOnTop(boolean flag)
    {
        Zp = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions zoomControlsEnabled(boolean flag)
    {
        Zt = Boolean.valueOf(flag);
        return this;
    }

    public final GoogleMapOptions zoomGesturesEnabled(boolean flag)
    {
        Zw = Boolean.valueOf(flag);
        return this;
    }

}
