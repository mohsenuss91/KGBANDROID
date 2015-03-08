// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.DisplayMetrics;

// Referenced classes of package com.actionbarsherlock.internal:
//            ActionBarSherlockCompat

public final class ResourcesCompat
{

    private static final String TAG = "ResourcesCompat";

    private ResourcesCompat()
    {
    }

    public static boolean getResources_getBoolean(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return context.getResources().getBoolean(i);
        }
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        float f = (float)displaymetrics.widthPixels / displaymetrics.density;
        float f1 = (float)displaymetrics.heightPixels / displaymetrics.density;
        if (f < f1)
        {
            f1 = f;
        }
        if (i == com.actionbarsherlock.R.bool.abs__action_bar_embed_tabs)
        {
            return f >= 480F;
        }
        if (i == com.actionbarsherlock.R.bool.abs__split_action_bar_is_narrow)
        {
            return f < 480F;
        }
        if (i == com.actionbarsherlock.R.bool.abs__action_bar_expanded_action_views_exclusive)
        {
            return f1 < 600F;
        }
        if (i == com.actionbarsherlock.R.bool.abs__config_allowActionMenuItemTextWithIcon)
        {
            return f >= 480F;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown boolean resource ID ")).append(i).toString());
        }
    }

    public static int getResources_getInteger(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            return context.getResources().getInteger(i);
        }
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        float f = (float)displaymetrics.widthPixels / displaymetrics.density;
        if (i == com.actionbarsherlock.R.integer.abs__max_action_buttons)
        {
            if (f >= 600F)
            {
                return 5;
            }
            if (f >= 500F)
            {
                return 4;
            }
            return f < 360F ? 2 : 3;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown integer resource ID ")).append(i).toString());
        }
    }

    public static int loadLogoFromManifest(Activity activity)
    {
        String s;
        String s1;
        XmlResourceParser xmlresourceparser;
        int j;
        s = activity.getClass().getName();
        s1 = activity.getApplicationInfo().packageName;
        xmlresourceparser = activity.createPackageContext(s1, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
        j = xmlresourceparser.getEventType();
        int i;
        int k;
        k = j;
        i = 0;
_L11:
        if (k == 1) goto _L2; else goto _L1
_L1:
        if (k != 2) goto _L4; else goto _L3
_L3:
        String s2 = xmlresourceparser.getName();
        if (!"application".equals(s2)) goto _L6; else goto _L5
_L5:
        int k1 = -1 + xmlresourceparser.getAttributeCount();
_L12:
        if (k1 < 0) goto _L8; else goto _L7
_L7:
        if (!"logo".equals(xmlresourceparser.getAttributeName(k1))) goto _L10; else goto _L9
_L9:
        int l1 = xmlresourceparser.getAttributeResourceValue(k1, 0);
        int l = l1;
_L13:
        int i1 = xmlresourceparser.nextToken();
        i = l;
        k = i1;
          goto _L11
_L10:
        k1--;
          goto _L12
_L8:
        l = i;
          goto _L13
_L6:
        if (!"activity".equals(s2)) goto _L4; else goto _L14
_L14:
        int j1 = -1 + xmlresourceparser.getAttributeCount();
        boolean flag;
        String s3;
        Integer integer;
        flag = false;
        s3 = null;
        integer = null;
_L24:
        if (j1 < 0) goto _L16; else goto _L15
_L15:
        String s4 = xmlresourceparser.getAttributeName(j1);
        if (!"logo".equals(s4)) goto _L18; else goto _L17
_L17:
        integer = Integer.valueOf(xmlresourceparser.getAttributeResourceValue(j1, 0));
_L21:
        Exception exception;
        Exception exception1;
        boolean flag1;
        if (integer != null && s3 != null)
        {
            try
            {
                i = integer.intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception1)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
          goto _L19
_L18:
        if (!"name".equals(s4)) goto _L21; else goto _L20
_L20:
        s3 = ActionBarSherlockCompat.cleanActivityName(s1, xmlresourceparser.getAttributeValue(j1));
        flag1 = s.equals(s3);
        if (!flag1) goto _L16; else goto _L22
_L22:
        flag = true;
          goto _L21
_L16:
        if (flag) goto _L2; else goto _L4
_L4:
        l = i;
          goto _L13
        exception;
        exception1 = exception;
        i = 0;
_L23:
        exception1.printStackTrace();
_L2:
        return i;
        Exception exception2;
        exception2;
        i = l;
        exception1 = exception2;
        if (true) goto _L23; else goto _L19
_L19:
        j1--;
          goto _L24
    }
}
