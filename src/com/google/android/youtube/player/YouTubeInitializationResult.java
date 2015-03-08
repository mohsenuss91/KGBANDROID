// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.app.Activity;
import android.app.Dialog;
import com.google.android.youtube.player.internal.m;
import com.google.android.youtube.player.internal.z;

public final class YouTubeInitializationResult extends Enum
{

    public static final YouTubeInitializationResult CLIENT_LIBRARY_UPDATE_REQUIRED;
    public static final YouTubeInitializationResult DEVELOPER_KEY_INVALID;
    public static final YouTubeInitializationResult ERROR_CONNECTING_TO_SERVICE;
    public static final YouTubeInitializationResult INTERNAL_ERROR;
    public static final YouTubeInitializationResult INVALID_APPLICATION_SIGNATURE;
    public static final YouTubeInitializationResult NETWORK_ERROR;
    public static final YouTubeInitializationResult SERVICE_DISABLED;
    public static final YouTubeInitializationResult SERVICE_INVALID;
    public static final YouTubeInitializationResult SERVICE_MISSING;
    public static final YouTubeInitializationResult SERVICE_VERSION_UPDATE_REQUIRED;
    public static final YouTubeInitializationResult SUCCESS;
    public static final YouTubeInitializationResult UNKNOWN_ERROR;
    private static final YouTubeInitializationResult a[];

    private YouTubeInitializationResult(String s, int i)
    {
        super(s, i);
    }

    public static YouTubeInitializationResult valueOf(String s)
    {
        return (YouTubeInitializationResult)Enum.valueOf(com/google/android/youtube/player/YouTubeInitializationResult, s);
    }

    public static YouTubeInitializationResult[] values()
    {
        return (YouTubeInitializationResult[])a.clone();
    }

    public final Dialog getErrorDialog(Activity activity, int i)
    {
        return getErrorDialog(activity, i, null);
    }

    public final Dialog getErrorDialog(Activity activity, int i, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        android.app.AlertDialog.Builder builder;
        builder = new android.app.AlertDialog.Builder(activity);
        if (oncancellistener != null)
        {
            builder.setOnCancelListener(oncancellistener);
        }
        _cls1.a[ordinal()];
        JVM INSTR tableswitch 1 3: default 56
    //                   1 143
    //                   2 155
    //                   3 143;
           goto _L1 _L2 _L3 _L2
_L3:
        break MISSING_BLOCK_LABEL_155;
_L1:
        Intent intent = null;
_L4:
        a a1 = new a(activity, intent, i);
        m m1 = new m(activity);
        switch (_cls1.a[ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Unexpected errorReason: ")).append(name()).toString());

        case 1: // '\001'
            return builder.setTitle(m1.b).setMessage(m1.c).setPositiveButton(m1.d, a1).create();

        case 2: // '\002'
            return builder.setTitle(m1.e).setMessage(m1.f).setPositiveButton(m1.g, a1).create();

        case 3: // '\003'
            return builder.setTitle(m1.h).setMessage(m1.i).setPositiveButton(m1.j, a1).create();
        }
_L2:
        intent = z.b(z.a(activity));
          goto _L4
        intent = z.a(z.a(activity));
          goto _L4
    }

    public final boolean isUserRecoverableError()
    {
        switch (_cls1.a[ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return true;
        }
    }

    static 
    {
        SUCCESS = new YouTubeInitializationResult("SUCCESS", 0);
        INTERNAL_ERROR = new YouTubeInitializationResult("INTERNAL_ERROR", 1);
        UNKNOWN_ERROR = new YouTubeInitializationResult("UNKNOWN_ERROR", 2);
        SERVICE_MISSING = new YouTubeInitializationResult("SERVICE_MISSING", 3);
        SERVICE_VERSION_UPDATE_REQUIRED = new YouTubeInitializationResult("SERVICE_VERSION_UPDATE_REQUIRED", 4);
        SERVICE_DISABLED = new YouTubeInitializationResult("SERVICE_DISABLED", 5);
        SERVICE_INVALID = new YouTubeInitializationResult("SERVICE_INVALID", 6);
        ERROR_CONNECTING_TO_SERVICE = new YouTubeInitializationResult("ERROR_CONNECTING_TO_SERVICE", 7);
        CLIENT_LIBRARY_UPDATE_REQUIRED = new YouTubeInitializationResult("CLIENT_LIBRARY_UPDATE_REQUIRED", 8);
        NETWORK_ERROR = new YouTubeInitializationResult("NETWORK_ERROR", 9);
        DEVELOPER_KEY_INVALID = new YouTubeInitializationResult("DEVELOPER_KEY_INVALID", 10);
        INVALID_APPLICATION_SIGNATURE = new YouTubeInitializationResult("INVALID_APPLICATION_SIGNATURE", 11);
        YouTubeInitializationResult ayoutubeinitializationresult[] = new YouTubeInitializationResult[12];
        ayoutubeinitializationresult[0] = SUCCESS;
        ayoutubeinitializationresult[1] = INTERNAL_ERROR;
        ayoutubeinitializationresult[2] = UNKNOWN_ERROR;
        ayoutubeinitializationresult[3] = SERVICE_MISSING;
        ayoutubeinitializationresult[4] = SERVICE_VERSION_UPDATE_REQUIRED;
        ayoutubeinitializationresult[5] = SERVICE_DISABLED;
        ayoutubeinitializationresult[6] = SERVICE_INVALID;
        ayoutubeinitializationresult[7] = ERROR_CONNECTING_TO_SERVICE;
        ayoutubeinitializationresult[8] = CLIENT_LIBRARY_UPDATE_REQUIRED;
        ayoutubeinitializationresult[9] = NETWORK_ERROR;
        ayoutubeinitializationresult[10] = DEVELOPER_KEY_INVALID;
        ayoutubeinitializationresult[11] = INVALID_APPLICATION_SIGNATURE;
        a = ayoutubeinitializationresult;
    }

    private class _cls1
    {

        static final int a[];

        static 
        {
            a = new int[YouTubeInitializationResult.values().length];
            try
            {
                a[YouTubeInitializationResult.SERVICE_MISSING.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                a[YouTubeInitializationResult.SERVICE_DISABLED.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[YouTubeInitializationResult.SERVICE_VERSION_UPDATE_REQUIRED.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2)
            {
                return;
            }
        }
    }


    private class a
        implements android.content.DialogInterface.OnClickListener
    {

        private final Activity a;
        private final Intent b;
        private final int c;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            try
            {
                a.startActivityForResult(b, c);
                dialoginterface.dismiss();
                return;
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                Log.e("YouTubeAndroidPlayerAPI", String.format("Can't perform resolution for YouTubeInitalizationError", new Object[] {
                    activitynotfoundexception
                }));
            }
        }

        public a(Activity activity, Intent intent, int i)
        {
            a = (Activity)ac.a(activity, "activity cannot be null");
            b = (Intent)ac.a(intent, "intent cannot be null");
            c = ((Integer)ac.a(Integer.valueOf(i), "requestCode cannot be null")).intValue();
        }
    }

}
