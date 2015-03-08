// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;


// Referenced classes of package com.google.android.gms.maps.model:
//            CameraPosition, LatLng

public final class aan
{

    private LatLng aak;
    private float aal;
    private float aam;
    private float aan;

    public final aan bearing(float f)
    {
        aan = f;
        return this;
    }

    public final CameraPosition build()
    {
        return new CameraPosition(aak, aal, aam, aan);
    }

    public final aan target(LatLng latlng)
    {
        aak = latlng;
        return this;
    }

    public final aak tilt(float f)
    {
        aam = f;
        return this;
    }

    public final aam zoom(float f)
    {
        aal = f;
        return this;
    }

    public ()
    {
    }

    public (CameraPosition cameraposition)
    {
        aak = cameraposition.target;
        aal = cameraposition.zoom;
        aam = cameraposition.tilt;
        aan = cameraposition.bearing;
    }
}
