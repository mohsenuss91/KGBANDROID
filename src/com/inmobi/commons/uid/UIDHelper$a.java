// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import android.content.Context;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.commons.uid:
//            UIDHelper, AdvertisingId

final class rations
    implements Runnable
{

    public final void run()
    {
        try
        {
            Class class1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Class class2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            Method method = class1.getDeclaredMethod("getAdvertisingIdInfo", new Class[] {
                android/content/Context
            });
            Object aobj[] = new Object[1];
            aobj[0] = InternalSDKUtil.getContext();
            Object obj = method.invoke(null, aobj);
            String s = (String)class2.getDeclaredMethod("getId", null).invoke(obj, null);
            UIDHelper.a().a(s);
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "gpid", s);
            Boolean boolean1 = (Boolean)class2.getDeclaredMethod("isLimitAdTrackingEnabled", null).invoke(obj, null);
            UIDHelper.a().a(boolean1.booleanValue());
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "limitadtrck", boolean1.booleanValue());
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Exception getting advertiser id", exception);
        }
    }

    rations()
    {
    }
}
