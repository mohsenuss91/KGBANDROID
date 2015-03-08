// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

// Referenced classes of package com.adsdk.sdk.mraid:
//            VersionCode, Utils, MraidVideoPlayerActivity

public class Mraids
{

    public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";

    public Mraids()
    {
    }

    public static boolean isCalendarAvailable(Context context)
    {
        Intent intent = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
        return VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH) && Utils.deviceCanHandleIntent(context, intent);
    }

    public static boolean isInlineVideoAvailable(Context context)
    {
        return Utils.deviceCanHandleIntent(context, new Intent(context, com/adsdk/sdk/mraid/MraidVideoPlayerActivity));
    }

    public static boolean isSmsAvailable(Context context)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return Utils.deviceCanHandleIntent(context, intent);
    }

    public static boolean isStorePictureSupported(Context context)
    {
        return "mounted".equals(Environment.getExternalStorageState()) && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean isTelAvailable(Context context)
    {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return Utils.deviceCanHandleIntent(context, intent);
    }
}
