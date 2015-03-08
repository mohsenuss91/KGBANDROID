// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.util.Map;

public class PkParams
{

    public static String SK_ALGORITHM = "";
    public static String SK_EXPONENT = "";
    public static String SK_MODULUS = "";
    public static String SK_VERSION = "";
    UID a;

    public PkParams()
    {
        a = new UID();
    }

    public String getAlgorithm()
    {
        return SK_ALGORITHM;
    }

    public String getExponent()
    {
        return SK_EXPONENT;
    }

    public String getModulus()
    {
        return SK_MODULUS;
    }

    public UID getUID()
    {
        return a;
    }

    public String getVersion()
    {
        return SK_VERSION;
    }

    public void setFromMap(Map map)
    {
        Map map1 = (Map)map.get("pk");
        String s = InternalSDKUtil.getStringFromMap(map1, "ver");
        SK_VERSION = s;
        if (s.equals(""))
        {
            Log.internal("[InMobi]-4.4.1", "Key ver has illegal value");
            throw new IllegalArgumentException();
        }
        String s1 = InternalSDKUtil.getStringFromMap(map1, "alg");
        SK_ALGORITHM = s1;
        if (s1.equals(""))
        {
            Log.internal("[InMobi]-4.4.1", "Key alg has illegal value");
            throw new IllegalArgumentException();
        }
        if (SK_ALGORITHM.equalsIgnoreCase("rsa"))
        {
            Map map2 = (Map)map1.get("val");
            SK_EXPONENT = InternalSDKUtil.getStringFromMap(map2, "e");
            String s2 = InternalSDKUtil.getStringFromMap(map2, "m");
            SK_MODULUS = s2;
            if (s2.equals(""))
            {
                Log.internal("[InMobi]-4.4.1", "Key m has illegal value");
                throw new IllegalArgumentException();
            }
            if (SK_EXPONENT.equals(""))
            {
                Log.internal("[InMobi]-4.4.1", "Key e has illegal value");
                throw new IllegalArgumentException();
            }
            if (!InternalSDKUtil.isHexString(SK_EXPONENT))
            {
                Log.internal("[InMobi]-4.4.1", "Key e has illegal value");
                throw new IllegalArgumentException();
            }
            if (!InternalSDKUtil.isHexString(SK_MODULUS))
            {
                Log.internal("[InMobi]-4.4.1", "Key m has illegal value");
                throw new IllegalArgumentException();
            }
        }
    }

}
