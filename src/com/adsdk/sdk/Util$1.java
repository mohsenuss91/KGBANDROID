// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

// Referenced classes of package com.adsdk.sdk:
//            Util

class <init> extends AsyncTask
{

    private final Context val$context;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            Util.access$0(AdvertisingIdClient.getAdvertisingIdInfo(val$context).getId());
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
        {
            googleplayservicesnotavailableexception.printStackTrace();
        }
        catch (IllegalStateException illegalstateexception)
        {
            illegalstateexception.printStackTrace();
        }
        catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
        {
            googleplayservicesrepairableexception.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    xt()
    {
        val$context = context1;
        super();
    }
}
