// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.model.internal.c;

// Referenced classes of package com.google.android.gms.maps.model:
//            RuntimeRemoteException, BitmapDescriptor, LatLngBounds, LatLng

public final class GroundOverlay
{

    private final c aaw;

    public GroundOverlay(c c1)
    {
        aaw = (c)hn.f(c1);
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof GroundOverlay))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = aaw.a(((GroundOverlay)obj).aaw);
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final float getBearing()
    {
        float f;
        try
        {
            f = aaw.getBearing();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public final LatLngBounds getBounds()
    {
        LatLngBounds latlngbounds;
        try
        {
            latlngbounds = aaw.getBounds();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return latlngbounds;
    }

    public final float getHeight()
    {
        float f;
        try
        {
            f = aaw.getHeight();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public final String getId()
    {
        String s;
        try
        {
            s = aaw.getId();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return s;
    }

    public final LatLng getPosition()
    {
        LatLng latlng;
        try
        {
            latlng = aaw.getPosition();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return latlng;
    }

    public final float getTransparency()
    {
        float f;
        try
        {
            f = aaw.getTransparency();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public final float getWidth()
    {
        float f;
        try
        {
            f = aaw.getWidth();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public final float getZIndex()
    {
        float f;
        try
        {
            f = aaw.getZIndex();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public final int hashCode()
    {
        int i;
        try
        {
            i = aaw.hashCodeRemote();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final boolean isVisible()
    {
        boolean flag;
        try
        {
            flag = aaw.isVisible();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final void remove()
    {
        try
        {
            aaw.remove();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setBearing(float f)
    {
        try
        {
            aaw.setBearing(f);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setDimensions(float f)
    {
        try
        {
            aaw.setDimensions(f);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setDimensions(float f, float f1)
    {
        try
        {
            aaw.a(f, f1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setImage(BitmapDescriptor bitmapdescriptor)
    {
        try
        {
            aaw.l(bitmapdescriptor.ji());
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setPosition(LatLng latlng)
    {
        try
        {
            aaw.setPosition(latlng);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setPositionFromBounds(LatLngBounds latlngbounds)
    {
        try
        {
            aaw.setPositionFromBounds(latlngbounds);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setTransparency(float f)
    {
        try
        {
            aaw.setTransparency(f);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setVisible(boolean flag)
    {
        try
        {
            aaw.setVisible(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setZIndex(float f)
    {
        try
        {
            aaw.setZIndex(f);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }
}
