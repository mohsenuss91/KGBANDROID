// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.hn;
import java.util.Date;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest

public final class xtras
{

    private final com.google.android.gms.internal. kr = new com.google.android.gms.internal.();

    static com.google.android.gms.internal. a(xtras xtras)
    {
        return xtras.kr;
    }

    public final kr addCustomEventExtrasBundle(Class class1, Bundle bundle)
    {
        kr.(class1, bundle);
        return this;
    }

    public final kr addKeyword(String s)
    {
        kr.(s);
        return this;
    }

    public final xtras addNetworkExtras(NetworkExtras networkextras)
    {
        kr.(networkextras);
        return this;
    }

    public final xtras addNetworkExtrasBundle(Class class1, Bundle bundle)
    {
        kr.(class1, bundle);
        return this;
    }

    public final kr addTestDevice(String s)
    {
        kr.(s);
        return this;
    }

    public final AdRequest build()
    {
        return new AdRequest(this, null);
    }

    public final kr setBirthday(Date date)
    {
        kr.(date);
        return this;
    }

    public final kr setContentUrl(String s)
    {
        hn.b(s, "Content URL must be non-null.");
        hn.b(s, "Content URL must be non-empty.");
        boolean flag;
        Object aobj[];
        if (s.length() <= 512)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aobj = new Object[2];
        aobj[0] = Integer.valueOf(512);
        aobj[1] = Integer.valueOf(s.length());
        hn.b(flag, "Content URL must not exceed %d in length.  Provided length was %d.", aobj);
        kr.(s);
        return this;
    }

    public final kr setGender(int i)
    {
        kr.(i);
        return this;
    }

    public final kr setLocation(Location location)
    {
        kr.(location);
        return this;
    }

    public final kr tagForChildDirectedTreatment(boolean flag)
    {
        kr.(flag);
        return this;
    }

    public xtras()
    {
    }
}
