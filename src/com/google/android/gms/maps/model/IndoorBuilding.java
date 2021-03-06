// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.model.internal.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            RuntimeRemoteException, IndoorLevel

public final class IndoorBuilding
{

    private final d aaF;

    public IndoorBuilding(d d1)
    {
        aaF = (d)hn.f(d1);
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof IndoorBuilding))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = aaF.b(((IndoorBuilding)obj).aaF);
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final int getActiveLevelIndex()
    {
        int i;
        try
        {
            i = aaF.getActiveLevelIndex();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final int getDefaultLevelIndex()
    {
        int i;
        try
        {
            i = aaF.getActiveLevelIndex();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final List getLevels()
    {
        ArrayList arraylist;
        try
        {
            List list = aaF.getLevels();
            arraylist = new ArrayList(list.size());
            for (Iterator iterator = list.iterator(); iterator.hasNext(); arraylist.add(new IndoorLevel(com.google.android.gms.maps.model.internal.e.a.bb((IBinder)iterator.next())))) { }
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return arraylist;
    }

    public final int hashCode()
    {
        int i;
        try
        {
            i = aaF.hashCodeRemote();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final boolean isUnderground()
    {
        boolean flag;
        try
        {
            flag = aaF.isUnderground();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }
}
