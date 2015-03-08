// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.google.android.youtube.player.internal.ac;

final class c
    implements android.content.r
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

    public (Activity activity, Intent intent, int i)
    {
        a = (Activity)ac.a(activity, "activity cannot be null");
        b = (Intent)ac.a(intent, "intent cannot be null");
        c = ((Integer)ac.a(Integer.valueOf(i), "requestCode cannot be null")).intValue();
    }
}
