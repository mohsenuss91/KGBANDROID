// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.model.internal.g;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            RuntimeRemoteException

public final class Polygon
{

    private final g aaT;

    public Polygon(g g1)
    {
        aaT = (g)hn.f(g1);
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof Polygon))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = aaT.a(((Polygon)obj).aaT);
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final int getFillColor()
    {
        int i;
        try
        {
            i = aaT.getFillColor();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final List getHoles()
    {
        List list;
        try
        {
            list = aaT.getHoles();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return list;
    }

    public final String getId()
    {
        String s;
        try
        {
            s = aaT.getId();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return s;
    }

    public final List getPoints()
    {
        List list;
        try
        {
            list = aaT.getPoints();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return list;
    }

    public final int getStrokeColor()
    {
        int i;
        try
        {
            i = aaT.getStrokeColor();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final float getStrokeWidth()
    {
        float f;
        try
        {
            f = aaT.getStrokeWidth();
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
            f = aaT.getZIndex();
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
            i = aaT.hashCodeRemote();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final boolean isGeodesic()
    {
        boolean flag;
        try
        {
            flag = aaT.isGeodesic();
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
            flag = aaT.isVisible();
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
            aaT.remove();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setFillColor(int i)
    {
        try
        {
            aaT.setFillColor(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setGeodesic(boolean flag)
    {
        try
        {
            aaT.setGeodesic(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setHoles(List list)
    {
        try
        {
            aaT.setHoles(list);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setPoints(List list)
    {
        try
        {
            aaT.setPoints(list);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setStrokeColor(int i)
    {
        try
        {
            aaT.setStrokeColor(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setStrokeWidth(float f)
    {
        try
        {
            aaT.setStrokeWidth(f);
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
            aaT.setVisible(flag);
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
            aaT.setZIndex(f);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }
}
