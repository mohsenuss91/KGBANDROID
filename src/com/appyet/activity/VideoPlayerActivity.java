// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.ap;
import com.appyet.manager.ar;

// Referenced classes of package com.appyet.activity:
//            af, ag, ah, ai

public class VideoPlayerActivity extends SherlockActivity
    implements com.actionbarsherlock.widget.ShareActionProvider.OnShareTargetSelectedListener
{

    private ApplicationContext a;
    private String b;
    private String c;
    private VideoView d;
    private ProgressBar e;
    private boolean f;

    public VideoPlayerActivity()
    {
        f = false;
    }

    private Intent a()
    {
        Intent intent;
        if (!b.startsWith("http"))
        {
            break MISSING_BLOCK_LABEL_114;
        }
        intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        intent.putExtra("android.intent.extra.SUBJECT", b);
        intent.putExtra("android.intent.extra.TEXT", b);
        return intent;
        intent.putExtra("android.intent.extra.SUBJECT", c);
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(c).append(" ").append(b).toString());
        return intent;
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
        return null;
    }

    static VideoView a(VideoPlayerActivity videoplayeractivity)
    {
        return videoplayeractivity.d;
    }

    static ProgressBar b(VideoPlayerActivity videoplayeractivity)
    {
        return videoplayeractivity.e;
    }

    static boolean c(VideoPlayerActivity videoplayeractivity)
    {
        videoplayeractivity.f = true;
        return true;
    }

    static boolean d(VideoPlayerActivity videoplayeractivity)
    {
        return videoplayeractivity.f;
    }

    static ApplicationContext e(VideoPlayerActivity videoplayeractivity)
    {
        return videoplayeractivity.a;
    }

    static String f(VideoPlayerActivity videoplayeractivity)
    {
        return videoplayeractivity.b;
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
        a = (ApplicationContext)getApplicationContext();
        ar.a(this);
        super.onCreate(bundle);
        setContentView(0x7f030065);
        getSupportActionBar().hide();
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 == null) goto _L2; else goto _L1
_L1:
        if (!bundle1.containsKey("URL")) goto _L4; else goto _L3
_L3:
        b = bundle1.getString("URL");
_L5:
        if (bundle1.containsKey("TITLE"))
        {
            c = bundle1.getString("TITLE");
        }
_L2:
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        setTitle(c);
        e = (ProgressBar)findViewById(0x7f0a0073);
        d = (VideoView)findViewById(0x7f0a00e9);
        e.setVisibility(0);
        d.setVideoPath(b);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            d.setSystemUiVisibility(1);
        }
        d.setMediaController(new af(this, this));
        d.setOnPreparedListener(new ag(this));
        d.setOnCompletionListener(new ah(this));
        d.setOnErrorListener(new ai(this));
        d.requestFocus();
        d.start();
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.flags = 0x400 | layoutparams.flags;
        getWindow().setAttributes(layoutparams);
        getWindow().addFlags(256);
        a.e.a("VideoPlayer");
        return;
_L4:
        finish();
          goto _L5
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
          goto _L2
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f000c, menu);
        MenuItem menuitem = menu.findItem(0x7f0a00f3);
        if (b.startsWith("http"))
        {
            ShareActionProvider shareactionprovider = (ShareActionProvider)menuitem.getActionProvider();
            shareactionprovider.setShareHistoryFileName("share_history.xml");
            shareactionprovider.setOnShareTargetSelectedListener(this);
            shareactionprovider.setShareIntent(a());
            menuitem.setVisible(true);
        } else
        {
            menuitem.setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        finish();
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onPause()
    {
        if (d != null)
        {
            d.setVisibility(8);
        }
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onResume()
    {
        if (d != null)
        {
            d.setVisibility(0);
        }
        super.onResume();
    }

    public boolean onShareTargetSelected(ShareActionProvider shareactionprovider, Intent intent)
    {
        if (a.y == 3 || a.y == 4)
        {
            return false;
        } else
        {
            a.startActivity(intent);
            a.e.a("Share", intent.getAction(), "Video");
            return true;
        }
    }
}
