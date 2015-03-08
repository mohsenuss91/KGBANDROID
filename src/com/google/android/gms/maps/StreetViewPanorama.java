// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama
{

    private final IStreetViewPanoramaDelegate ZK;

    protected StreetViewPanorama(IStreetViewPanoramaDelegate istreetviewpanoramadelegate)
    {
        ZK = (IStreetViewPanoramaDelegate)hn.f(istreetviewpanoramadelegate);
    }

    public void animateTo(StreetViewPanoramaCamera streetviewpanoramacamera, long l)
    {
        try
        {
            ZK.animateTo(streetviewpanoramacamera, l);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public StreetViewPanoramaLocation getLocation()
    {
        StreetViewPanoramaLocation streetviewpanoramalocation;
        try
        {
            streetviewpanoramalocation = ZK.getStreetViewPanoramaLocation();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return streetviewpanoramalocation;
    }

    public StreetViewPanoramaCamera getPanoramaCamera()
    {
        StreetViewPanoramaCamera streetviewpanoramacamera;
        try
        {
            streetviewpanoramacamera = ZK.getPanoramaCamera();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return streetviewpanoramacamera;
    }

    public boolean isPanningGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = ZK.isPanningGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isStreetNamesEnabled()
    {
        boolean flag;
        try
        {
            flag = ZK.isStreetNamesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isUserNavigationEnabled()
    {
        boolean flag;
        try
        {
            flag = ZK.isUserNavigationEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isZoomGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = ZK.isZoomGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    IStreetViewPanoramaDelegate jw()
    {
        return ZK;
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation streetviewpanoramaorientation)
    {
        Point point;
        try
        {
            point = (Point)e.e(ZK.orientationToPoint(streetviewpanoramaorientation));
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return point;
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point)
    {
        StreetViewPanoramaOrientation streetviewpanoramaorientation;
        try
        {
            streetviewpanoramaorientation = ZK.pointToOrientation(e.h(point));
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return streetviewpanoramaorientation;
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener onstreetviewpanoramacamerachangelistener)
    {
        if (onstreetviewpanoramacamerachangelistener == null)
        {
            try
            {
                ZK.setOnStreetViewPanoramaCameraChangeListener(null);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }
        ZK.setOnStreetViewPanoramaCameraChangeListener(new _cls2(onstreetviewpanoramacamerachangelistener));
        return;
    }

    public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener onstreetviewpanoramachangelistener)
    {
        if (onstreetviewpanoramachangelistener == null)
        {
            try
            {
                ZK.setOnStreetViewPanoramaChangeListener(null);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }
        ZK.setOnStreetViewPanoramaChangeListener(new _cls1(onstreetviewpanoramachangelistener));
        return;
    }

    public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener onstreetviewpanoramaclicklistener)
    {
        if (onstreetviewpanoramaclicklistener == null)
        {
            try
            {
                ZK.setOnStreetViewPanoramaClickListener(null);
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }
        ZK.setOnStreetViewPanoramaClickListener(new _cls3(onstreetviewpanoramaclicklistener));
        return;
    }

    public void setPanningGesturesEnabled(boolean flag)
    {
        try
        {
            ZK.enablePanning(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setPosition(LatLng latlng)
    {
        try
        {
            ZK.setPosition(latlng);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setPosition(LatLng latlng, int i)
    {
        try
        {
            ZK.setPositionWithRadius(latlng, i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setPosition(String s)
    {
        try
        {
            ZK.setPositionWithID(s);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setStreetNamesEnabled(boolean flag)
    {
        try
        {
            ZK.enableStreetNames(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setUserNavigationEnabled(boolean flag)
    {
        try
        {
            ZK.enableUserNavigation(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setZoomGesturesEnabled(boolean flag)
    {
        try
        {
            ZK.enableZoom(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    private class _cls2 extends com.google.android.gms.maps.internal.p.a
    {

        final StreetViewPanorama ZM;
        final OnStreetViewPanoramaCameraChangeListener ZN;

        public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetviewpanoramacamera)
        {
            ZN.onStreetViewPanoramaCameraChange(streetviewpanoramacamera);
        }

        _cls2(OnStreetViewPanoramaCameraChangeListener onstreetviewpanoramacamerachangelistener)
        {
            ZM = StreetViewPanorama.this;
            ZN = onstreetviewpanoramacamerachangelistener;
            super();
        }

        private class OnStreetViewPanoramaCameraChangeListener
        {

            public abstract void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetviewpanoramacamera);
        }

    }


    private class _cls1 extends com.google.android.gms.maps.internal.q.a
    {

        final OnStreetViewPanoramaChangeListener ZL;
        final StreetViewPanorama ZM;

        public void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetviewpanoramalocation)
        {
            ZL.onStreetViewPanoramaChange(streetviewpanoramalocation);
        }

        _cls1(OnStreetViewPanoramaChangeListener onstreetviewpanoramachangelistener)
        {
            ZM = StreetViewPanorama.this;
            ZL = onstreetviewpanoramachangelistener;
            super();
        }

        private class OnStreetViewPanoramaChangeListener
        {

            public abstract void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetviewpanoramalocation);
        }

    }


    private class _cls3 extends com.google.android.gms.maps.internal.r.a
    {

        final StreetViewPanorama ZM;
        final OnStreetViewPanoramaClickListener ZO;

        public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetviewpanoramaorientation)
        {
            ZO.onStreetViewPanoramaClick(streetviewpanoramaorientation);
        }

        _cls3(OnStreetViewPanoramaClickListener onstreetviewpanoramaclicklistener)
        {
            ZM = StreetViewPanorama.this;
            ZO = onstreetviewpanoramaclicklistener;
            super();
        }

        private class OnStreetViewPanoramaClickListener
        {

            public abstract void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetviewpanoramaorientation);
        }

    }

}
