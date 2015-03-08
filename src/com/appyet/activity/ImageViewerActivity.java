// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.ap;
import com.appyet.manager.ar;

public class ImageViewerActivity extends SherlockFragmentActivity
{

    private ApplicationContext a;

    public ImageViewerActivity()
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    protected void onCreate(Bundle bundle)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
        super.onCreate(bundle);
        ar.a(this);
        setContentView(0x7f03004f);
        a = (ApplicationContext)getApplicationContext();
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        FragmentManager fragmentmanager = getSupportFragmentManager();
        FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
        if (fragmentmanager.findFragmentByTag("ImageViewerFragment") == null)
        {
            com.appyet.c.ar ar1 = new com.appyet.c.ar();
            ar1.setRetainInstance(true);
            fragmenttransaction.add(0x7f0a00be, ar1, "ImageViewerFragment");
        }
        fragmenttransaction.commit();
        getSupportActionBar().hide();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            getWindow().getDecorView().setSystemUiVisibility(1);
        }
        a.e.a("ImageViewer");
    }
}
