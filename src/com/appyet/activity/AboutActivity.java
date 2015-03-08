// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.ar;

public class AboutActivity extends Activity
{

    private ApplicationContext a;

    public AboutActivity()
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        ar.a(this);
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        a = (ApplicationContext)getApplicationContext();
        ((TextView)findViewById(0x7f0a0074)).setText(getString(0x7f080116));
        ((TextView)findViewById(0x7f0a0040)).setText(a.b());
    }

    protected void onResume()
    {
        super.onResume();
        ar.a(this);
    }
}
