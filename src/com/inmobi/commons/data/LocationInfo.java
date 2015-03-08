// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.data;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.List;

public class LocationInfo
{

    private static LocationManager a;
    private static boolean b;
    private static double c;
    private static double d;
    private static double e;
    private static boolean f;
    private static long g;

    public LocationInfo()
    {
    }

    private static LocationManager a()
    {
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorenter ;
        LocationManager locationmanager = a;
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorexit ;
        return locationmanager;
        Exception exception;
        exception;
        throw exception;
    }

    private static void a(double d1)
    {
        c = d1;
    }

    private static void a(long l)
    {
        g = l;
    }

    static void a(Location location)
    {
        if (location != null)
        {
            f = true;
            c = location.getLatitude();
            d = location.getLongitude();
            e = location.getAccuracy();
            g = location.getTime();
        }
    }

    private static void a(LocationManager locationmanager)
    {
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorenter ;
        a = locationmanager;
        com/inmobi/commons/data/LocationInfo;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(boolean flag)
    {
        b = flag;
    }

    private static Location b()
    {
        if (a() == null)
        {
            a((LocationManager)InternalSDKUtil.getContext().getSystemService("location"));
        }
        if (a() != null)
        {
            LocationManager locationmanager = a();
            List list = locationmanager.getProviders(true);
            for (int i = -1 + list.size(); i >= 0; i--)
            {
                String s = (String)list.get(i);
                if (!locationmanager.isProviderEnabled(s))
                {
                    continue;
                }
                Location location = locationmanager.getLastKnownLocation(s);
                if (location != null)
                {
                    return location;
                }
            }

        }
        return null;
    }

    private static void b(double d1)
    {
        d = d1;
    }

    static void b(boolean flag)
    {
        f = flag;
    }

    private static void c(double d1)
    {
        e = d1;
    }

    public static long getGeoTS()
    {
        return g;
    }

    public static double getLat()
    {
        return c;
    }

    public static double getLocAccuracy()
    {
        return e;
    }

    public static double getLon()
    {
        return d;
    }

    public static boolean isLocationDeniedByUser()
    {
        return b;
    }

    public static boolean isValidGeoInfo()
    {
        return f;
    }

    public static void updateBestKnownLocation()
    {
        LocationManager locationmanager;
        Criteria criteria;
        if (a() == null)
        {
            a((LocationManager)InternalSDKUtil.getContext().getSystemService("location"));
        }
        if (a() == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        locationmanager = a();
        criteria = new Criteria();
        if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto _L2; else goto _L1
_L1:
        criteria.setAccuracy(1);
_L4:
        String s;
        criteria.setCostAllowed(false);
        s = locationmanager.getBestProvider(criteria, true);
        if (isValidGeoInfo() || s == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        Location location;
        location = locationmanager.getLastKnownLocation(s);
        Log.debug("[InMobi]-4.4.1", (new StringBuilder("lastBestKnownLocation: ")).append(location).toString());
        if (location != null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        location = b();
        Log.debug("[InMobi]-4.4.1", (new StringBuilder("lastKnownLocation: ")).append(location).toString());
        a(location);
        return;
_L2:
        if (InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto _L4; else goto _L3
_L3:
        criteria.setAccuracy(2);
          goto _L4
        Exception exception;
        exception;
        Log.debug("[InMobi]-4.4.1", "Error getting the Location Info ", exception);
    }

    public static void verifyLocationPermission()
    {
        int i = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
        int j = InternalSDKUtil.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        if (i != 0 && j != 0)
        {
            b = true;
            return;
        } else
        {
            b = false;
            return;
        }
    }
}
