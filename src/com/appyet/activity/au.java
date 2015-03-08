// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.Dialog;
import android.content.Intent;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;

public abstract class au extends SherlockFragmentActivity
    implements com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
{

    public au()
    {
    }

    protected abstract com.google.android.youtube.player.YouTubePlayer.Provider a();

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 1)
        {
            a().initialize("AIzaSyAUXIsUMWrKnCggcFBPkitgjsRsoBktRfI", this);
        }
    }

    public void onInitializationFailure(com.google.android.youtube.player.YouTubePlayer.Provider provider, YouTubeInitializationResult youtubeinitializationresult)
    {
        if (youtubeinitializationresult.isUserRecoverableError())
        {
            youtubeinitializationresult.getErrorDialog(this, 1).show();
            return;
        } else
        {
            String s = getString(0x7f080080);
            Object aobj[] = new Object[1];
            aobj[0] = youtubeinitializationresult.toString();
            Toast.makeText(this, String.format(s, aobj), 1).show();
            return;
        }
    }
}
