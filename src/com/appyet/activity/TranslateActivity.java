// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.bp;

// Referenced classes of package com.appyet.activity:
//            ac, ad, ae

public class TranslateActivity extends Activity
{

    private ApplicationContext a;
    private String b;
    private String c;
    private android.view.View.OnClickListener d;
    private android.view.View.OnClickListener e;

    public TranslateActivity()
    {
        b = "en";
        d = new ac(this);
        e = new ad(this);
    }

    static ApplicationContext a(TranslateActivity translateactivity)
    {
        return translateactivity.a;
    }

    static String a(TranslateActivity translateactivity, String s)
    {
        translateactivity.b = s;
        return s;
    }

    static String b(TranslateActivity translateactivity)
    {
        return translateactivity.c;
    }

    static String c(TranslateActivity translateactivity)
    {
        return translateactivity.b;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ar.a(this);
        setContentView(0x7f030064);
        setTitle(0x7f080075);
        ((TextView)findViewById(0x7f0a0074)).setText(getTitle());
        a = (ApplicationContext)getApplicationContext();
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 == null) goto _L2; else goto _L1
_L1:
        if (!bundle1.containsKey("URL")) goto _L4; else goto _L3
_L3:
        c = bundle1.getString("URL");
_L2:
        ((Button)findViewById(0x7f0a00e7)).setOnClickListener(d);
        ((Button)findViewById(0x7f0a00e8)).setOnClickListener(e);
        Spinner spinner = (Spinner)findViewById(0x7f0a00e6);
        spinner.setSelection(a.d.J());
        spinner.setOnItemSelectedListener(new ae(this));
        a.e.a("Translate");
        return;
_L4:
        try
        {
            finish();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
