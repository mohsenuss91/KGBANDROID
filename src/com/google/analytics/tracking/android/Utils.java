// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils
{

    private static final char HEXBYTES[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };

    Utils()
    {
    }

    public static String filterCampaign(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        if (s.contains("?"))
        {
            String as1[] = s.split("[\\?]");
            if (as1.length > 1)
            {
                s = as1[1];
            }
        }
        StringBuilder stringbuilder;
        if (s.contains("%3D"))
        {
            Map map;
            String as[];
            int i;
            String s1;
            try
            {
                s1 = URLDecoder.decode(s, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                return null;
            }
            s = s1;
        } else
        if (!s.contains("="))
        {
            return null;
        }
        map = parseURLParameters(s);
        as = (new String[] {
            "dclid", "utm_source", "gclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "gmob_t"
        });
        stringbuilder = new StringBuilder();
        for (i = 0; i < as.length; i++)
        {
            if (!TextUtils.isEmpty((CharSequence)map.get(as[i])))
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append("&");
                }
                stringbuilder.append(as[i]).append("=").append((String)map.get(as[i]));
            }
        }

        return stringbuilder.toString();
    }

    static int fromHexDigit(char c)
    {
        int i = c - 48;
        if (i > 9)
        {
            i -= 7;
        }
        return i;
    }

    static String getLanguage(Locale locale)
    {
        while (locale == null || TextUtils.isEmpty(locale.getLanguage())) 
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(locale.getLanguage().toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry()))
        {
            stringbuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringbuilder.toString();
    }

    static byte[] hexDecode(String s)
    {
        byte abyte0[] = new byte[s.length() / 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (byte)(fromHexDigit(s.charAt(i * 2)) << 4 | fromHexDigit(s.charAt(1 + i * 2)));
        }

        return abyte0;
    }

    static String hexEncode(byte abyte0[])
    {
        char ac[] = new char[2 * abyte0.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = 0xff & abyte0[i];
            ac[i * 2] = HEXBYTES[j >> 4];
            ac[1 + i * 2] = HEXBYTES[j & 0xf];
        }

        return new String(ac);
    }

    public static Map parseURLParameters(String s)
    {
        HashMap hashmap = new HashMap();
        String as[] = s.split("&");
        int i = as.length;
        int j = 0;
        while (j < i) 
        {
            String as1[] = as[j].split("=");
            if (as1.length > 1)
            {
                hashmap.put(as1[0], as1[1]);
            } else
            if (as1.length == 1 && as1[0].length() != 0)
            {
                hashmap.put(as1[0], null);
            }
            j++;
        }
        return hashmap;
    }

    public static void putIfAbsent(Map map, String s, String s1)
    {
        if (!map.containsKey(s))
        {
            map.put(s, s1);
        }
    }

    public static boolean safeParseBoolean(String s, boolean flag)
    {
        if (s != null)
        {
            if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("1"))
            {
                flag = true;
            } else
            if (s.equalsIgnoreCase("false") || s.equalsIgnoreCase("no") || s.equalsIgnoreCase("0"))
            {
                return false;
            }
        }
        return flag;
    }

    public static double safeParseDouble(String s)
    {
        return safeParseDouble(s, 0.0D);
    }

    public static double safeParseDouble(String s, double d)
    {
        if (s == null)
        {
            return d;
        }
        double d1;
        try
        {
            d1 = Double.parseDouble(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            return d;
        }
        return d1;
    }

    public static long safeParseLong(String s)
    {
        if (s == null)
        {
            return 0L;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0L;
        }
        return l;
    }

}
