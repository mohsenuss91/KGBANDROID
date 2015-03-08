// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.model.internal.f;

// Referenced classes of package com.google.android.gms.maps.model:
//            RuntimeRemoteException, BitmapDescriptor, LatLng

public final class Marker
{

    private final f aaL;

    public Marker(f f1)
    {
        aaL = (f)hn.f(f1);
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof Marker))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = aaL.h(((Marker)obj).aaL);
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final float getAlpha()
    {
        float f1;
        try
        {
            f1 = aaL.getAlpha();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f1;
    }

    public final String getId()
    {
        String s;
        try
        {
            s = aaL.getId();
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
            latlng = aaL.getPosition();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return latlng;
    }

    public final float getRotation()
    {
        float f1;
        try
        {
            f1 = aaL.getRotation();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f1;
    }

    public final String getSnippet()
    {
        String s;
        try
        {
            s = aaL.getSnippet();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return s;
    }

    public final String getTitle()
    {
        String s;
        try
        {
            s = aaL.getTitle();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return s;
    }

    public final int hashCode()
    {
        int i;
        try
        {
            i = aaL.hashCodeRemote();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final void hideInfoWindow()
    {
        try
        {
            aaL.hideInfoWindow();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final boolean isDraggable()
    {
        boolean flag;
        try
        {
            flag = aaL.isDraggable();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isFlat()
    {
        boolean flag;
        try
        {
            flag = aaL.isFlat();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isInfoWindowShown()
    {
        boolean flag;
        try
        {
            flag = aaL.isInfoWindowShown();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isVisible()
    {
        boolean flag;
        try
        {
            flag = aaL.isVisible();
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
            aaL.remove();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setAlpha(float f1)
    {
        try
        {
            aaL.setAlpha(f1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setAnchor(float f1, float f2)
    {
        try
        {
            aaL.setAnchor(f1, f2);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setDraggable(boolean flag)
    {
        try
        {
            aaL.setDraggable(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setFlat(boolean flag)
    {
        try
        {
            aaL.setFlat(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setIcon(BitmapDescriptor bitmapdescriptor)
    {
        try
        {
            aaL.m(bitmapdescriptor.ji());
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setInfoWindowAnchor(float f1, float f2)
    {
        try
        {
            aaL.setInfoWindowAnchor(f1, f2);
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
            aaL.setPosition(latlng);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setRotation(float f1)
    {
        try
        {
            aaL.setRotation(f1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setSnippet(String s)
    {
        try
        {
            aaL.setSnippet(s);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setTitle(String s)
    {
        try
        {
            aaL.setTitle(s);
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
            aaL.setVisible(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void showInfoWindow()
    {
        try
        {
            aaL.showInfoWindow();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }
}
