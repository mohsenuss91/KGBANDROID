// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.as;

public class MediaPlayerActivity extends Activity
{

    private ApplicationContext a;

    public MediaPlayerActivity()
    {
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
        super.onCreate(bundle);
        ar.a(this);
        setContentView(0x7f030059);
        ((TextView)findViewById(0x7f0a0074)).setText(getTitle());
        a.e.a("AudioPlayer");
    }

    protected void onPause()
    {
        super.onPause();
        try
        {
            a.c.k();
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }

    protected void onResume()
    {
        super.onResume();
        try
        {
            a.c.a(this);
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }
}
