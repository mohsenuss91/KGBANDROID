// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.objects;

import android.content.Context;
import android.util.Base64;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NativeConfigParams;
import com.inmobi.commons.ads.cache.AdData;
import com.inmobi.commons.ads.cache.AdDatabaseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.IMNative;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.monetization.internal.objects:
//            NativeAd

public class NativeAdsCache
{

    static NativeAdsCache a;

    private NativeAdsCache(Context context)
    {
    }

    public static NativeAdsCache getInstance()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/inmobi/monetization/internal/objects/NativeAdsCache;
        JVM INSTR monitorenter ;
        a = new NativeAdsCache(InternalSDKUtil.getContext());
        com/inmobi/monetization/internal/objects/NativeAdsCache;
        JVM INSTR monitorexit ;
_L2:
        AdDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getNativeSdkConfigParams().getmMaxCacheSize());
        return a;
        Exception exception;
        exception;
        throw exception;
    }

    public IMNative getCachedAd(String s)
    {
        NativeAd nativead;
        try
        {
            JSONObject jsonobject = new JSONObject(AdDatabaseManager.getInstance().getAd(s).getContent());
            nativead = new NativeAd((new String(Base64.decode(jsonobject.getString("pubContent"), 0))).trim(), jsonobject.getString("contextCode"), jsonobject.getString("namespace"));
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Exception getting cached ad", exception);
            return null;
        }
        return nativead;
    }

    public int getNumCachedAds(String s)
    {
        int i;
        try
        {
            i = AdDatabaseManager.getInstance().getNoOfAds(s);
        }
        catch (Exception exception)
        {
            return 0;
        }
        return i;
    }

    public void saveNativeAds(String s, List list)
    {
        if (list != null && list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                AdData addata = new AdData();
                addata.setContent((String)list.get(i));
                addata.setTimestamp(System.currentTimeMillis());
                addata.setAppId(s);
                addata.setAdType("native");
                AdDatabaseManager.getInstance().insertAd(addata);
            }

        }
    }
}
