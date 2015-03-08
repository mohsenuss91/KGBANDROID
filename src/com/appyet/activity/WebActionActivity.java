// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.v;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.as;

// Referenced classes of package com.appyet.activity:
//            aj, ak, al, VideoPlayerActivity, 
//            MediaPlayerActivity

public class WebActionActivity extends Activity
{

    android.view.View.OnClickListener a;
    android.view.View.OnClickListener b;
    android.view.View.OnClickListener c;
    private ApplicationContext d;
    private Button e;
    private Button f;
    private Button g;
    private TextView h;
    private String i;

    public WebActionActivity()
    {
        a = new aj(this);
        b = new ak(this);
        c = new al(this);
    }

    static void a(WebActionActivity webactionactivity)
    {
        String s;
        Intent intent;
        try
        {
            s = v.a(webactionactivity.i);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (s.toLowerCase().contains("video"))
        {
            intent = new Intent(webactionactivity.d, com/appyet/activity/VideoPlayerActivity);
            intent.putExtra("URL", webactionactivity.i);
            intent.putExtra("TITLE", webactionactivity.i);
            webactionactivity.d.startActivity(intent);
            return;
        }
        if (s.toLowerCase().contains("audio"))
        {
            webactionactivity.d.c.a(webactionactivity.i, webactionactivity.i);
            webactionactivity.d.c.a(false);
            webactionactivity.startActivity(new Intent(webactionactivity, com/appyet/activity/MediaPlayerActivity));
            return;
        }
        Intent intent1 = new Intent("android.intent.action.VIEW");
        intent1.setDataAndType(Uri.parse(webactionactivity.i), s);
        webactionactivity.d.startActivity(intent1);
        return;
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(webactionactivity.i));
        webactionactivity.d.startActivity(intent2);
        return;
    }

    static ApplicationContext b(WebActionActivity webactionactivity)
    {
        return webactionactivity.d;
    }

    static String c(WebActionActivity webactionactivity)
    {
        return webactionactivity.i;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    protected void onCreate(Bundle bundle)
    {
        d = (ApplicationContext)getApplicationContext();
        ar.a(this);
        super.onCreate(bundle);
        setContentView(0x7f030067);
        setTitle(0x7f08009a);
        ((TextView)findViewById(0x7f0a0074)).setText(getTitle());
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 == null) goto _L2; else goto _L1
_L1:
        if (!bundle1.containsKey("URL")) goto _L4; else goto _L3
_L3:
        i = bundle1.getString("URL");
_L2:
        h = (TextView)findViewById(0x7f0a00d4);
        h.setText(i);
        e = (Button)findViewById(0x7f0a00d5);
        f = (Button)findViewById(0x7f0a00d6);
        g = (Button)findViewById(0x7f0a00d7);
        e.setOnClickListener(a);
        f.setOnClickListener(b);
        g.setOnClickListener(c);
        d.e.a("WebAction");
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
