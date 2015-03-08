// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.location.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            je, jl, kb, jn, 
//            jz, jp, jr, jv

public interface jf
    extends IInterface
{

    public abstract void a(long l, boolean flag, PendingIntent pendingintent);

    public abstract void a(PendingIntent pendingintent);

    public abstract void a(PendingIntent pendingintent, je je, String s);

    public abstract void a(Location location, int i);

    public abstract void a(je je, String s);

    public abstract void a(jl jl, kb kb, PendingIntent pendingintent);

    public abstract void a(jn jn, kb kb, jz jz);

    public abstract void a(jp jp, kb kb);

    public abstract void a(jr jr, kb kb, PendingIntent pendingintent);

    public abstract void a(jv jv, kb kb, jz jz);

    public abstract void a(kb kb, PendingIntent pendingintent);

    public abstract void a(LocationRequest locationrequest, PendingIntent pendingintent);

    public abstract void a(LocationRequest locationrequest, a a1);

    public abstract void a(LocationRequest locationrequest, a a1, String s);

    public abstract void a(a a1);

    public abstract void a(LatLng latlng, jn jn, kb kb, jz jz);

    public abstract void a(LatLngBounds latlngbounds, int i, jn jn, kb kb, jz jz);

    public abstract void a(LatLngBounds latlngbounds, int i, String s, jn jn, kb kb, jz jz);

    public abstract void a(String s, kb kb, jz jz);

    public abstract void a(String s, LatLngBounds latlngbounds, jn jn, kb kb, jz jz);

    public abstract void a(String s, List list, List list1, kb kb, jz jz);

    public abstract void a(List list, PendingIntent pendingintent, je je, String s);

    public abstract void a(String as[], je je, String s);

    public abstract void b(kb kb, PendingIntent pendingintent);

    public abstract void b(String s, kb kb, jz jz);

    public abstract Location bo(String s);

    public abstract b bp(String s);

    public abstract Location iR();

    public abstract IBinder iS();

    public abstract void removeActivityUpdates(PendingIntent pendingintent);

    public abstract void setMockLocation(Location location);

    public abstract void setMockMode(boolean flag);
}
