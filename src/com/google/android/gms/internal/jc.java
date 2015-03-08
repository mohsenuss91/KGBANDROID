// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

// Referenced classes of package com.google.android.gms.internal:
//            jh

public class jc
    implements FusedLocationProviderApi
{

    public jc()
    {
    }

    public Location getLastLocation(GoogleApiClient googleapiclient)
    {
        jh jh1 = LocationServices.e(googleapiclient);
        Location location;
        try
        {
            location = jh1.getLastLocation();
        }
        catch (Exception exception)
        {
            return null;
        }
        return location;
    }

    public PendingResult removeLocationUpdates(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.b(new _cls5(pendingintent));
    }

    public PendingResult removeLocationUpdates(GoogleApiClient googleapiclient, LocationListener locationlistener)
    {
        return googleapiclient.b(new _cls4(locationlistener));
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, PendingIntent pendingintent)
    {
        return googleapiclient.b(new _cls3(locationrequest, pendingintent));
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener)
    {
        return googleapiclient.b(new _cls1(locationrequest, locationlistener));
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
    {
        return googleapiclient.b(new _cls2(locationrequest, locationlistener, looper));
    }

    public PendingResult setMockLocation(GoogleApiClient googleapiclient, Location location)
    {
        return googleapiclient.b(new _cls7(location));
    }

    public PendingResult setMockMode(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.b(new _cls6(flag));
    }

    private class _cls5 extends a
    {
        private class a extends com.google.android.gms.location.LocationServices.a
        {

            public Result c(Status status)
            {
                return d(status);
            }

            public Status d(Status status)
            {
                return status;
            }

            private a()
            {
            }

            a(_cls1 _pcls1)
            {
                this();
            }
        }


        final PendingIntent Vr;
        final jc Vv;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((jh)a1);
        }

        protected void a(jh jh1)
        {
            jh1.removeLocationUpdates(Vr);
            b(Status.Ek);
        }

        _cls5(PendingIntent pendingintent)
        {
            Vv = jc.this;
            Vr = pendingintent;
            super(null);
        }
    }


    private class _cls4 extends a
    {

        final LocationListener Vu;
        final jc Vv;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((jh)a1);
        }

        protected void a(jh jh1)
        {
            jh1.removeLocationUpdates(Vu);
            b(Status.Ek);
        }

        _cls4(LocationListener locationlistener)
        {
            Vv = jc.this;
            Vu = locationlistener;
            super(null);
        }
    }


    private class _cls3 extends a
    {

        final PendingIntent Vr;
        final LocationRequest Vt;
        final jc Vv;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((jh)a1);
        }

        protected void a(jh jh1)
        {
            jh1.requestLocationUpdates(Vt, Vr);
            b(Status.Ek);
        }

        _cls3(LocationRequest locationrequest, PendingIntent pendingintent)
        {
            Vv = jc.this;
            Vt = locationrequest;
            Vr = pendingintent;
            super(null);
        }
    }


    private class _cls1 extends a
    {

        final LocationRequest Vt;
        final LocationListener Vu;
        final jc Vv;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((jh)a1);
        }

        protected void a(jh jh1)
        {
            jh1.requestLocationUpdates(Vt, Vu);
            b(Status.Ek);
        }

        _cls1(LocationRequest locationrequest, LocationListener locationlistener)
        {
            Vv = jc.this;
            Vt = locationrequest;
            Vu = locationlistener;
            super(null);
        }
    }


    private class _cls2 extends a
    {

        final LocationRequest Vt;
        final LocationListener Vu;
        final jc Vv;
        final Looper Vw;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((jh)a1);
        }

        protected void a(jh jh1)
        {
            jh1.requestLocationUpdates(Vt, Vu, Vw);
            b(Status.Ek);
        }

        _cls2(LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
        {
            Vv = jc.this;
            Vt = locationrequest;
            Vu = locationlistener;
            Vw = looper;
            super(null);
        }
    }


    private class _cls7 extends a
    {

        final jc Vv;
        final Location Vy;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((jh)a1);
        }

        protected void a(jh jh1)
        {
            jh1.setMockLocation(Vy);
            b(Status.Ek);
        }

        _cls7(Location location)
        {
            Vv = jc.this;
            Vy = location;
            super(null);
        }
    }


    private class _cls6 extends a
    {

        final jc Vv;
        final boolean Vx;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((jh)a1);
        }

        protected void a(jh jh1)
        {
            jh1.setMockMode(Vx);
            b(Status.Ek);
        }

        _cls6(boolean flag)
        {
            Vv = jc.this;
            Vx = flag;
            super(null);
        }
    }

}
