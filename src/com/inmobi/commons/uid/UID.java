// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import android.content.Context;
import com.inmobi.commons.IMIDType;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.inmobi.commons.uid:
//            UIDHelper, AdvertisingId, UIDUtil

public class UID
{

    public static final boolean FBA_DEF = false;
    public static final boolean GPID_DEF = true;
    public static final String KEY_FACEBOOK_ID = "FBA";
    public static final String KEY_GPID = "GPID";
    public static final String KEY_LOGIN_ID = "LID";
    public static final String KEY_LTVID = "LTVID";
    public static final String KEY_ODIN1 = "O1";
    public static final String KEY_SESSION_ID = "SID";
    public static final String KEY_UM5_ID = "UM5";
    public static final boolean LID_DEF = true;
    public static final boolean LTVE_DEF = true;
    public static final boolean O1_DEF = true;
    public static final boolean SID_DEF = true;
    public static final boolean UM5_DEF = true;
    private static UID a = new UID();
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private String i;

    public UID()
    {
        b = true;
        c = true;
        d = true;
        e = false;
        f = true;
        g = true;
        h = true;
        i = null;
    }

    public UID(Context context)
    {
        b = true;
        c = true;
        d = true;
        e = false;
        f = true;
        g = true;
        h = true;
        i = null;
        InternalSDKUtil.setContext(context);
    }

    public UID(Context context, Map map)
    {
        this(context);
        setFromMap(map);
    }

    public UID(Map map)
    {
        b = true;
        c = true;
        d = true;
        e = false;
        f = true;
        g = true;
        h = true;
        i = null;
        setFromMap(map);
    }

    private Map a(int j, String s)
    {
        int k;
        Context context;
        HashMap hashmap;
        k = UserInfo.getInstance().getDeviceIDMask();
        context = InternalSDKUtil.getContext();
        hashmap = new HashMap();
        if (i == null)
        {
            i = UIDHelper.getPlatformId();
        }
        if (k > 0) goto _L2; else goto _L1
_L1:
        if (b && a.b && InternalSDKUtil.isPlatformIdEnabled())
        {
            hashmap.put("O1", UIDHelper.getODIN1(i));
        }
        if (e && a.e)
        {
            String s5 = UIDHelper.getFBId(context);
            if (s5 != null)
            {
                hashmap.put("FBA", s5);
            }
        }
        if (f && a.f && InternalSDKUtil.isPlatformIdEnabled())
        {
            hashmap.put("UM5", UIDHelper.getUM5(i));
        }
_L4:
        if (d && a.d)
        {
            String s3 = UserInfo.getInstance().getIDType(IMIDType.ID_LOGIN);
            if (s3 != null)
            {
                hashmap.put("LID", s3);
            }
        }
        if (c && a.c)
        {
            String s2 = UserInfo.getInstance().getIDType(IMIDType.ID_SESSION);
            if (s2 != null)
            {
                hashmap.put("SID", s2);
            }
        }
        if (g && a.g)
        {
            Long long1 = AnalyticsInitializer.getRawConfigParams().getLTVId();
            if (long1 != null)
            {
                hashmap.put("LTVID", (new StringBuilder()).append(long1).toString());
            }
        }
        if (h && a.h)
        {
            AdvertisingId advertisingid = UIDHelper.getAdvertisingId();
            if (advertisingid != null)
            {
                String s1 = advertisingid.getAdId();
                if (s1 != null)
                {
                    hashmap.put("GPID", s1);
                }
            }
        }
        return hashmap;
_L2:
        if ((k & 2) != 2 && b && a.b && InternalSDKUtil.isPlatformIdEnabled())
        {
            hashmap.put("O1", UIDHelper.getODIN1(i));
        }
        if ((k & 4) != 4 && e && a.e)
        {
            String s4 = UIDHelper.getFBId(context);
            if (s4 != null)
            {
                hashmap.put("FBA", s4);
            }
        }
        if ((k & 8) != 8 && f && a.f && InternalSDKUtil.isPlatformIdEnabled())
        {
            hashmap.put("UM5", UIDHelper.getUM5(i));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private Map b(int j, String s)
    {
        int k;
        Context context;
        HashMap hashmap;
        k = UserInfo.getInstance().getDeviceIDMask();
        context = InternalSDKUtil.getContext();
        hashmap = new HashMap();
        if (i == null)
        {
            i = UIDHelper.getPlatformId();
        }
        if (k > 0) goto _L2; else goto _L1
_L1:
        if (b && a.b && InternalSDKUtil.isPlatformIdEnabled())
        {
            hashmap.put("O1", UIDHelper.a(UIDHelper.getODIN1(i), s));
        }
        if (e && a.e)
        {
            String s5 = UIDHelper.getFBId(context);
            if (s5 != null)
            {
                hashmap.put("FBA", UIDHelper.a(s5, s));
            }
        }
        if (f && a.f && InternalSDKUtil.isPlatformIdEnabled())
        {
            hashmap.put("UM5", UIDHelper.a(UIDHelper.getUM5(i), s));
        }
_L4:
        if (d && a.d)
        {
            String s3 = UserInfo.getInstance().getIDType(IMIDType.ID_LOGIN);
            if (s3 != null)
            {
                hashmap.put("LID", UIDHelper.a(s3, s));
            }
        }
        if (c && a.c)
        {
            String s2 = UserInfo.getInstance().getIDType(IMIDType.ID_SESSION);
            if (s2 != null)
            {
                hashmap.put("SID", UIDHelper.a(s2, s));
            }
        }
        if (g && a.g)
        {
            Long long1 = AnalyticsInitializer.getRawConfigParams().getLTVId();
            if (long1 != null)
            {
                hashmap.put("LTVID", UIDHelper.a((new StringBuilder()).append(long1).toString(), s));
            }
        }
        if (h && a.h)
        {
            AdvertisingId advertisingid = UIDHelper.getAdvertisingId();
            if (advertisingid != null)
            {
                String s1 = advertisingid.getAdId();
                if (s1 != null)
                {
                    hashmap.put("GPID", UIDHelper.a((new StringBuilder()).append(s1).toString(), s));
                }
            }
        }
        return hashmap;
_L2:
        if ((k & 2) != 2 && b && a.b && InternalSDKUtil.isPlatformIdEnabled())
        {
            hashmap.put("O1", UIDHelper.a(UIDHelper.getODIN1(i), s));
        }
        if ((k & 4) != 4 && e && a.e)
        {
            String s4 = UIDHelper.getFBId(context);
            if (s4 != null)
            {
                hashmap.put("FBA", UIDHelper.a(s4, s));
            }
        }
        if ((k & 8) != 8 && f && a.f && InternalSDKUtil.isPlatformIdEnabled())
        {
            hashmap.put("UM5", UIDHelper.a(UIDHelper.getUM5(i), s));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static UID getCommonsUid()
    {
        return a;
    }

    public String getDefaultUidMap(int j, String s, Map map)
    {
        Map map1 = b(j, s);
        if (map != null)
        {
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                String s2 = (String)map.get(s1);
                if (s2 != null)
                {
                    map1.put(s1, UIDHelper.a(s2, s));
                }
            } while (true);
        }
        return UIDUtil.getEncryptedJSON(map1);
    }

    public String getDefaultUidMapWithoutXor(int j, String s, Map map)
    {
        Map map1 = a(j, s);
        if (map != null)
        {
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                String s2 = (String)map.get(s1);
                if (s2 != null)
                {
                    map1.put(s1, s2);
                }
            } while (true);
        }
        return UIDUtil.getJSON(map1);
    }

    public String getUidMap(int j, String s, Map map)
    {
        try
        {
            InternalSDKUtil.initialize(InternalSDKUtil.getContext());
        }
        catch (Exception exception)
        {
            Log.internal("commons", "Unable to initialize commons.");
        }
        return getDefaultUidMap(j, s, map);
    }

    public String getUidMapWitoutXOR(int j, String s, Map map)
    {
        try
        {
            InternalSDKUtil.initialize(InternalSDKUtil.getContext());
        }
        catch (Exception exception)
        {
            Log.internal("commons", "Unable to initialize commons.");
        }
        return getDefaultUidMapWithoutXor(j, s, map);
    }

    public boolean isFba()
    {
        return e;
    }

    public boolean isGPId()
    {
        return h;
    }

    public boolean isLid()
    {
        return d;
    }

    public boolean isLtve()
    {
        return g;
    }

    public boolean isO1()
    {
        return b;
    }

    public boolean isSid()
    {
        return c;
    }

    public boolean isUm5()
    {
        return f;
    }

    public final void setFromMap(Map map)
    {
        b = InternalSDKUtil.getBooleanFromMap(map, "O1");
        c = InternalSDKUtil.getBooleanFromMap(map, "SID");
        d = InternalSDKUtil.getBooleanFromMap(map, "LID");
        e = InternalSDKUtil.getBooleanFromMap(map, "FBA");
        f = InternalSDKUtil.getBooleanFromMap(map, "UM5");
        g = InternalSDKUtil.getBooleanFromMap(map, "LTVID");
        h = InternalSDKUtil.getBooleanFromMap(map, "GPID");
    }

}
