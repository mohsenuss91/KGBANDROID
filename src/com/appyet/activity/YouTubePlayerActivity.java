// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.Window;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

// Referenced classes of package com.appyet.activity:
//            au

public class YouTubePlayerActivity extends au
    implements com.actionbarsherlock.widget.ShareActionProvider.OnShareTargetSelectedListener, com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener
{

    private ActionBarPaddedFrameLayout a;
    private YouTubePlayerSupportFragment b;
    private String c;
    private String d;
    private ApplicationContext e;
    private YouTubePlayer f;

    public YouTubePlayerActivity()
    {
    }

    private Intent b()
    {
        Intent intent;
        intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder("http://www.youtube.com/watch?v=")).append(c).toString());
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder("http://www.youtube.com/watch?v=")).append(c).toString());
        return intent;
        try
        {
            intent.putExtra("android.intent.extra.SUBJECT", d);
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(d).append(" http://www.youtube.com/watch?v=").append(c).toString());
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return intent;
    }

    protected final com.google.android.youtube.player.YouTubePlayer.Provider a()
    {
        YouTubePlayerSupportFragment youtubeplayersupportfragment;
        try
        {
            youtubeplayersupportfragment = (YouTubePlayerSupportFragment)getSupportFragmentManager().findFragmentById(0x7f0a00f2);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return youtubeplayersupportfragment;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    protected void onCreate(Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            getSupportActionBar().hide();
        }
        ar.a(this);
        super.onCreate(bundle);
        setContentView(0x7f030069);
        e = (ApplicationContext)getApplicationContext();
        setRequestedOrientation(6);
        try
        {
            Intent intent = getIntent();
            String s = intent.getData().toString();
            if (s.startsWith("appyet.youtube:") && s.length() > "appyet.youtube:".length())
            {
                c = s.substring("appyet.youtube:".length());
            }
            if (intent.getExtras() != null && intent.getExtras().containsKey("TITLE"))
            {
                d = intent.getExtras().getString("TITLE");
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        if (d != null)
        {
            setTitle(d);
        }
        try
        {
            a = (ActionBarPaddedFrameLayout)findViewById(0x7f0a00f1);
            b = (YouTubePlayerSupportFragment)getSupportFragmentManager().findFragmentById(0x7f0a00f2);
            b.initialize("AIzaSyAUXIsUMWrKnCggcFBPkitgjsRsoBktRfI", this);
            b.setRetainInstance(true);
            a.setActionBar(getSupportActionBar());
            e.e.a("YouTubePlayer");
            return;
        }
        catch (Exception exception1)
        {
            com.appyet.d.d.a(exception1);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        try
        {
            getSupportMenuInflater().inflate(0x7f0f000f, menu);
            ShareActionProvider shareactionprovider = (ShareActionProvider)menu.findItem(0x7f0a00f3).getActionProvider();
            shareactionprovider.setShareHistoryFileName("share_history.xml");
            shareactionprovider.setOnShareTargetSelectedListener(this);
            shareactionprovider.setShareIntent(b());
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onFullscreen(boolean flag)
    {
        ActionBarPaddedFrameLayout actionbarpaddedframelayout = a;
        boolean flag1;
        flag1 = false;
        if (!flag)
        {
            flag1 = true;
        }
        android.view.ViewGroup.LayoutParams layoutparams;
        actionbarpaddedframelayout.setEnablePadding(flag1);
        layoutparams = b.getView().getLayoutParams();
        if (flag)
        {
            try
            {
                layoutparams.width = -1;
                layoutparams.height = -1;
                return;
            }
            catch (Exception exception)
            {
                com.appyet.d.d.a(exception);
            }
            break MISSING_BLOCK_LABEL_69;
        }
        layoutparams.width = 0;
        layoutparams.height = -2;
        return;
    }

    public void onInitializationSuccess(com.google.android.youtube.player.YouTubePlayer.Provider provider, YouTubePlayer youtubeplayer, boolean flag)
    {
        try
        {
            f = youtubeplayer;
            f.addFullscreenControlFlag(8);
            f.setOnFullscreenListener(this);
            f.setFullscreen(true);
            f.setShowFullscreenButton(false);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        f.loadVideo(c);
    }

    protected void onResume()
    {
        try
        {
            if (f != null)
            {
                f.addFullscreenControlFlag(8);
                f.setOnFullscreenListener(this);
                f.setFullscreen(true);
                f.setShowFullscreenButton(false);
            }
        }
        catch (Exception exception)
        {
            finish();
        }
        super.onResume();
    }

    public boolean onShareTargetSelected(ShareActionProvider shareactionprovider, Intent intent)
    {
        if (e.y == 3)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (e.y == 4)
        {
            return false;
        }
        e.startActivity(intent);
        e.e.a("Share", intent.getAction(), "YouTube");
        return true;
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        return false;
    }

    private class ActionBarPaddedFrameLayout extends FrameLayout
    {

        private ActionBar a;
        private boolean b;

        protected final void onMeasure(int i, int j)
        {
            boolean flag = b;
            int k;
            k = 0;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_54;
            }
            ActionBar actionbar = a;
            k = 0;
            if (actionbar == null)
            {
                break MISSING_BLOCK_LABEL_54;
            }
            boolean flag1 = a.isShowing();
            k = 0;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_54;
            }
            k = a.getHeight();
            setPadding(0, k, 0, 0);
_L2:
            super.onMeasure(i, j);
            return;
            Exception exception;
            exception;
            com.appyet.d.d.a(exception);
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final void setActionBar(ActionBar actionbar)
        {
            a = actionbar;
            requestLayout();
        }

        public final void setEnablePadding(boolean flag)
        {
            b = flag;
            requestLayout();
        }

        public ActionBarPaddedFrameLayout(Context context)
        {
            this(context, null);
        }

        public ActionBarPaddedFrameLayout(Context context, AttributeSet attributeset)
        {
            this(context, attributeset, 0);
        }

        public ActionBarPaddedFrameLayout(Context context, AttributeSet attributeset, int i)
        {
            super(context, attributeset, i);
            b = true;
        }
    }

}
