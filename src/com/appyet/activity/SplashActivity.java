// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import com.appyet.context.ApplicationContext;
import com.appyet.metadata.Metadata;
import com.appyet.metadata.MetadataSetting;

// Referenced classes of package com.appyet.activity:
//            ab, MainActivity

public class SplashActivity extends Activity
{

    private LinearLayout a;
    private ApplicationContext b;

    public SplashActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030061);
        b = (ApplicationContext)getApplicationContext();
        a = (LinearLayout)findViewById(0x7f0a00dc);
        a.setBackgroundColor(Color.parseColor(b.q.MetadataSetting.SplashScreenBgColor));
    }

    protected void onPause()
    {
        super.onPause();
        overridePendingTransition(0x7f04000e, 0x7f040010);
    }

    protected void onResume()
    {
        super.onResume();
        if (b.q.MetadataSetting.IsShowSplashScreen && b.q.MetadataSetting.SplashTime > 0)
        {
            (new Handler()).postDelayed(new ab(this), 1000 * b.q.MetadataSetting.SplashTime);
            return;
        } else
        {
            finish();
            startActivity(new Intent(this, com/appyet/activity/MainActivity));
            return;
        }
    }
}
