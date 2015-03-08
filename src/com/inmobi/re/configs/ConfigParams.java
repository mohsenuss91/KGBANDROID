// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.configs;

import android.graphics.Color;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.util.HashMap;
import java.util.Map;

public class ConfigParams
{

    static int g = 5;
    static String h = "[\"video/mp4\"]";
    String a;
    int b;
    int c;
    int d;
    int e;
    int f;
    HashMap i;

    public ConfigParams()
    {
        a = "#00000000";
        b = 320;
        c = 480;
        d = 100;
        e = 20;
        f = 5;
        i = new HashMap();
    }

    public String getAllowedContentType()
    {
        return h;
    }

    public int getMaxSaveContentSize()
    {
        return g;
    }

    public int getMaxVibDuration()
    {
        return 1000 * f;
    }

    public int getMaxVibPatternLength()
    {
        return e;
    }

    public int getPicHeight()
    {
        return c;
    }

    public int getPicQuality()
    {
        return d;
    }

    public int getPicWidth()
    {
        return b;
    }

    public UID getUID()
    {
        return UID.getCommonsUid();
    }

    public int getWebviewBgColor()
    {
        int j;
        try
        {
            j = Color.parseColor(a);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Invalid bg color. Reverting to default", exception);
            return Color.parseColor("#00000000");
        }
        return j;
    }

    public void setFromMap(Map map)
    {
        String s2;
        String as[];
        i = (HashMap)map.get("savecontent");
        g = InternalSDKUtil.getIntFromMap(i, "maxl", 1, 0x7fffffffL);
        String s = i.get("ctp").toString();
        h = s;
        String s1 = s.replace("\\", "");
        s2 = s1.substring(1, -1 + s1.length());
        if (!s2.contains(","))
        {
            break MISSING_BLOCK_LABEL_162;
        }
        as = s2.split(",");
        int j = 0;
        do
        {
            try
            {
                if (j >= as.length)
                {
                    break;
                }
                if (as[j].substring(1, -1 + as[j].length()).equals(""))
                {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                g = 5;
                h = "[\"video/mp4\"]";
                throw new IllegalArgumentException();
            }
            j++;
        } while (true);
        break MISSING_BLOCK_LABEL_189;
        if ((new String[] {
    s2
})[0].equals(""))
        {
            throw new IllegalArgumentException();
        }
        a = InternalSDKUtil.getStringFromMap(map, "wthc");
        c = InternalSDKUtil.getIntFromMap(map, "picH", 1, 0x7fffffffL);
        b = InternalSDKUtil.getIntFromMap(map, "picW", 1, 0x7fffffffL);
        d = InternalSDKUtil.getIntFromMap(map, "picA", 1, 100L);
        f = InternalSDKUtil.getIntFromMap(map, "mvd", 0, 0x7fffffffL);
        e = InternalSDKUtil.getIntFromMap(map, "mvp", 0, 0x7fffffffL);
        return;
    }

}
