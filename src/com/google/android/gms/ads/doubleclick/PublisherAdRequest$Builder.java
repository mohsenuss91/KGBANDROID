// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.doubleclick;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.hn;
import java.util.Date;

// Referenced classes of package com.google.android.gms.ads.doubleclick:
//            PublisherAdRequest

public final class 
{

    private final com.google.android.gms.internal.uilder.kr kr = new com.google.android.gms.internal.uilder.kr();

    static com.google.android.gms.internal.uilder a( )
    {
        return .kr;
    }

    public final kr addCustomEventExtrasBundle(Class class1, Bundle bundle)
    {
        kr.kr(class1, bundle);
        return this;
    }

    public final kr addKeyword(String s)
    {
        kr.kr(s);
        return this;
    }

    public final kr addNetworkExtras(NetworkExtras networkextras)
    {
        kr.kr(networkextras);
        return this;
    }

    public final kr addNetworkExtrasBundle(Class class1, Bundle bundle)
    {
        kr.kr(class1, bundle);
        return this;
    }

    public final kr addTestDevice(String s)
    {
        kr.kr(s);
        return this;
    }

    public final PublisherAdRequest build()
    {
        return new PublisherAdRequest(this, null);
    }

    public final kr setBirthday(Date date)
    {
        kr.kr(date);
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
        kr.kr(s);
        return this;
    }

    public final kr setGender(int i)
    {
        kr.kr(i);
        return this;
    }

    public final kr setLocation(Location location)
    {
        kr.kr(location);
        return this;
    }

    public final kr setManualImpressionsEnabled(boolean flag)
    {
        kr.kr(flag);
        return this;
    }

    public final kr setPublisherProvidedId(String s)
    {
        kr.kr(s);
        return this;
    }

    public final kr tagForChildDirectedTreatment(boolean flag)
    {
        kr.kr(flag);
        return this;
    }

    public ()
    {
    }
}
