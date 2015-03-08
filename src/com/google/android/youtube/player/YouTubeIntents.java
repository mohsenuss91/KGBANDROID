// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.google.android.youtube.player.internal.z;
import java.util.List;

public final class YouTubeIntents
{

    private YouTubeIntents()
    {
    }

    private static Uri a(String s)
    {
        return Uri.parse((new StringBuilder("http://www.youtube.com/playlist?list=")).append(s).toString());
    }

    private static String a(Context context)
    {
        if (z.a(context.getPackageManager()))
        {
            return "com.google.android.youtube.googletv";
        } else
        {
            return "com.google.android.youtube";
        }
    }

    private static boolean a(Context context, Intent intent)
    {
        List list = context.getPackageManager().queryIntentActivities(intent, 0x10000);
        return list != null && !list.isEmpty();
    }

    private static boolean a(Context context, Uri uri)
    {
        return a(context, (new Intent("android.intent.action.VIEW", uri)).setPackage(a(context)));
    }

    private static Intent b(Context context, Uri uri)
    {
        return (new Intent("android.intent.action.VIEW", uri)).setPackage(a(context));
    }

    public static boolean canResolveOpenPlaylistIntent(Context context)
    {
        return a(context, Uri.parse("http://www.youtube.com/playlist?list="));
    }

    public static boolean canResolvePlayPlaylistIntent(Context context)
    {
        int i = getInstalledYouTubeVersionCode(context);
        boolean flag;
        if (z.a(context.getPackageManager()))
        {
            if (i >= 0x7fffffff)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (i >= 4000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && canResolveOpenPlaylistIntent(context);
    }

    public static boolean canResolvePlayVideoIntent(Context context)
    {
        return a(context, Uri.parse("http://www.youtube.com/watch?v="));
    }

    public static boolean canResolveSearchIntent(Context context)
    {
        if (z.a(context.getPackageManager()) && getInstalledYouTubeVersionCode(context) < 0x7fffffff)
        {
            return false;
        } else
        {
            return a(context, (new Intent("android.intent.action.SEARCH")).setPackage(a(context)));
        }
    }

    public static boolean canResolveUploadIntent(Context context)
    {
        return a(context, (new Intent("com.google.android.youtube.intent.action.UPLOAD")).setPackage(a(context)).setType("video/*"));
    }

    public static boolean canResolveUserIntent(Context context)
    {
        return a(context, Uri.parse("http://www.youtube.com/user/"));
    }

    public static Intent createOpenPlaylistIntent(Context context, String s)
    {
        Intent intent = b(context, a(s));
        intent.putExtra("authenticate", false);
        return intent;
    }

    public static Intent createPlayPlaylistIntent(Context context, String s)
    {
        Intent intent = b(context, a(s).buildUpon().appendQueryParameter("playnext", "1").build());
        intent.putExtra("authenticate", false);
        return intent;
    }

    public static Intent createPlayVideoIntent(Context context, String s)
    {
        return createPlayVideoIntentWithOptions(context, s, false, false);
    }

    public static Intent createPlayVideoIntentWithOptions(Context context, String s, boolean flag, boolean flag1)
    {
        return b(context, Uri.parse((new StringBuilder("http://www.youtube.com/watch?v=")).append(s).toString())).putExtra("force_fullscreen", flag).putExtra("finish_on_ended", flag1);
    }

    public static Intent createSearchIntent(Context context, String s)
    {
        return (new Intent("android.intent.action.SEARCH")).setPackage(a(context)).putExtra("query", s);
    }

    public static Intent createUploadIntent(Context context, Uri uri)
    {
        if (uri == null)
        {
            throw new IllegalArgumentException("videoUri parameter cannot be null.");
        }
        if (!uri.toString().startsWith("content://media/"))
        {
            throw new IllegalArgumentException("videoUri parameter must be a URI pointing to a valid video file. It must begin with \"content://media/\"");
        } else
        {
            return (new Intent("com.google.android.youtube.intent.action.UPLOAD")).setPackage(a(context)).setDataAndType(uri, "video/*");
        }
    }

    public static Intent createUserIntent(Context context, String s)
    {
        return b(context, Uri.parse((new StringBuilder("http://www.youtube.com/user/")).append(s).toString()));
    }

    public static int getInstalledYouTubeVersionCode(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(a(context), 0).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return -1;
        }
        return i;
    }

    public static String getInstalledYouTubeVersionName(Context context)
    {
        String s;
        try
        {
            s = context.getPackageManager().getPackageInfo(a(context), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return null;
        }
        return s;
    }

    public static boolean isYouTubeInstalled(Context context)
    {
        try
        {
            context.getPackageManager().getApplicationInfo(a(context), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        return true;
    }

    public final boolean canResolvePlayVideoIntentWithOptions(Context context)
    {
        int i = getInstalledYouTubeVersionCode(context);
        boolean flag;
        if (z.a(context.getPackageManager()))
        {
            if (i >= 0x7fffffff)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (i >= 3300)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && canResolvePlayVideoIntent(context);
    }
}
