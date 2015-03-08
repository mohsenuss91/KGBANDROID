// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.google.android.youtube.player.internal.z;

// Referenced classes of package com.google.android.youtube.player:
//            YouTubeInitializationResult

public final class YouTubeStandalonePlayer
{

    private YouTubeStandalonePlayer()
    {
    }

    private static Intent a(Intent intent, Activity activity, String s, int i, boolean flag, boolean flag1)
    {
        Intent intent1 = intent.putExtra("developer_key", s).putExtra("app_package", activity.getPackageName()).putExtra("app_version", z.d(activity)).putExtra("autoplay", flag).putExtra("lightbox_mode", flag1).putExtra("start_time_millis", i);
        boolean flag2;
        if ((0x400 & activity.getWindow().getAttributes().flags) == 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        intent1.putExtra("window_has_status_bar", flag2);
        return intent;
    }

    public static Intent createPlaylistIntent(Activity activity, String s, String s1)
    {
        return createPlaylistIntent(activity, s, s1, 0, 0, false, false);
    }

    public static Intent createPlaylistIntent(Activity activity, String s, String s1, int i, int j, boolean flag, boolean flag1)
    {
        return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START")).putExtra("playlist_id", s1).putExtra("current_index", i), activity, s, j, flag, flag1);
    }

    public static Intent createVideoIntent(Activity activity, String s, String s1)
    {
        return createVideoIntent(activity, s, s1, 0, false, false);
    }

    public static Intent createVideoIntent(Activity activity, String s, String s1, int i, boolean flag, boolean flag1)
    {
        return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START")).putExtra("video_id", s1), activity, s, i, flag, flag1);
    }

    public static YouTubeInitializationResult getReturnedInitializationResult(Intent intent)
    {
        String s = intent.getExtras().getString("initialization_result");
        YouTubeInitializationResult youtubeinitializationresult;
        try
        {
            youtubeinitializationresult = YouTubeInitializationResult.valueOf(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
        catch (NullPointerException nullpointerexception)
        {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
        return youtubeinitializationresult;
    }
}
