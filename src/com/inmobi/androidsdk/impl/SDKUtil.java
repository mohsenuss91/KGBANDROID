// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.inmobi.androidsdk.IMBrowserActivity;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.androidsdk.impl:
//            ConfigException

public class SDKUtil
{

    public static final String BROWSER_ACTIVITY = "com.inmobi.androidsdk.IMBrowserActivity";
    public static final long DEFAULT_SLOTID = -1L;
    private static boolean a = false;

    public SDKUtil()
    {
    }

    public static boolean getQAMode()
    {
        return a;
    }

    public static Activity getRootActivity(Activity activity)
    {
        for (; activity.getParent() != null; activity = activity.getParent()) { }
        return activity;
    }

    public static void validateAdConfiguration(Context context)
    {
        Iterator iterator;
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
        {
            Log.e("[InMobi]-[Network]-4.4.1", "App does not have INTERNET permissions. Please provide INTERNET permissions");
            throw new ConfigException(-1);
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
        {
            Log.e("[InMobi]-[Network]-4.4.1", "App does not have ACCESS_NETWORK_STATE permissions. Please provide ACCESS_NETWORK_STATE permissions");
            throw new ConfigException(-9);
        }
        iterator = context.getPackageManager().queryIntentActivities(new Intent(context, com/inmobi/androidsdk/IMBrowserActivity), 0x10000).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
        if (!resolveinfo.activityInfo.name.contentEquals("com.inmobi.androidsdk.IMBrowserActivity")) goto _L4; else goto _L3
_L3:
        if (resolveinfo == null)
        {
            Log.e("[InMobi]-[Network]-4.4.1", "IMBrowserActivity not declared in the manifest. Please declare it in the app manifest");
            throw new ConfigException(-2);
        }
        int i = resolveinfo.activityInfo.configChanges;
        if (i == 0)
        {
            Log.e("[InMobi]-[Network]-4.4.1", "IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest");
            throw new ConfigException(-3);
        }
        if ((i & 0x10) == 0)
        {
            Log.e("[InMobi]-[Network]-4.4.1", "Missing Config keyboard from android:configChangesof IMBRowserActivity");
            throw new ConfigException(-4);
        }
        if ((i & 0x20) == 0)
        {
            Log.e("[InMobi]-[Network]-4.4.1", "Missing Config keyboardHidden from android:configChangesof IMBRowserActivity");
            throw new ConfigException(-5);
        }
        if ((i & 0x80) == 0)
        {
            Log.e("[InMobi]-[Network]-4.4.1", "Missing Config orientation from android:configChangesof IMBRowserActivity");
            throw new ConfigException(-6);
        }
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            if ((i & 0x400) == 0)
            {
                Log.e("[InMobi]-[Network]-4.4.1", "Missing Config screenSize from android:configChangesof IMBRowserActivity");
                throw new ConfigException(-7);
            }
            if ((i & 0x800) == 0)
            {
                Log.e("[InMobi]-[Network]-4.4.1", "Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity");
                throw new ConfigException(-8);
            }
        }
        return;
_L2:
        resolveinfo = null;
        if (true) goto _L3; else goto _L5
_L5:
    }

}
