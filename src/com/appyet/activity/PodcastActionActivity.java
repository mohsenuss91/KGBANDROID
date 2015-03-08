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
import com.appyet.context.f;
import com.appyet.d.d;
import com.appyet.data.FeedItem;
import com.appyet.manager.af;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.as;
import java.util.List;

// Referenced classes of package com.appyet.activity:
//            v, w, x, y, 
//            VideoPlayerActivity, MediaPlayerActivity

public class PodcastActionActivity extends Activity
{

    android.view.View.OnClickListener a;
    android.view.View.OnClickListener b;
    android.view.View.OnClickListener c;
    android.view.View.OnClickListener d;
    private ApplicationContext e;
    private Button f;
    private Button g;
    private Button h;
    private Button i;
    private TextView j;
    private int k;
    private FeedItem l;

    public PodcastActionActivity()
    {
        a = new v(this);
        b = new w(this);
        c = new x(this);
        d = new y(this);
    }

    static ApplicationContext a(PodcastActionActivity podcastactionactivity)
    {
        return podcastactionactivity.e;
    }

    static void a(PodcastActionActivity podcastactionactivity, boolean flag)
    {
        try
        {
            if (podcastactionactivity.l.getEnclosureType().toLowerCase().contains("video"))
            {
                Intent intent = new Intent(podcastactionactivity.e, com/appyet/activity/VideoPlayerActivity);
                intent.putExtra("URL", podcastactionactivity.l.getEnclosureLink());
                intent.putExtra("TITLE", podcastactionactivity.l.getTitle());
                podcastactionactivity.e.startActivity(intent);
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        if (podcastactionactivity.l.getEnclosureType().toLowerCase().contains("audio"))
        {
            if (podcastactionactivity.e.c.f() == null || podcastactionactivity.e.c.f().getFeedItemId() != podcastactionactivity.l.getFeedItemId())
            {
                podcastactionactivity.e.c.a(podcastactionactivity.l);
            }
            if (!podcastactionactivity.e.c.g())
            {
                podcastactionactivity.e.c.a(flag);
            }
            podcastactionactivity.startActivity(new Intent(podcastactionactivity, com/appyet/activity/MediaPlayerActivity));
            return;
        }
        Intent intent1 = new Intent("android.intent.action.VIEW");
        intent1.setDataAndType(Uri.parse(podcastactionactivity.l.getEnclosureLink().toString()), podcastactionactivity.l.getEnclosureType());
        podcastactionactivity.e.startActivity(intent1);
        return;
    }

    static FeedItem b(PodcastActionActivity podcastactionactivity)
    {
        return podcastactionactivity.l;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    protected void onCreate(Bundle bundle)
    {
        e = (ApplicationContext)getApplicationContext();
        super.onCreate(bundle);
        Exception exception1;
        String s;
        Bundle bundle1;
        try
        {
            ar.a(this);
            setContentView(0x7f03005c);
            ((TextView)findViewById(0x7f0a0074)).setText(getString(0x7f080058));
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        bundle1 = getIntent().getExtras();
        if (bundle1 == null) goto _L2; else goto _L1
_L1:
        if (!bundle1.containsKey("POSITION")) goto _L4; else goto _L3
_L3:
        k = bundle1.getInt("POSITION");
_L2:
        l = (FeedItem)e.n.b.get(k);
        j = (TextView)findViewById(0x7f0a00d4);
        j.setText(l.getEnclosureLink());
        f = (Button)findViewById(0x7f0a00d5);
        g = (Button)findViewById(0x7f0a00d6);
        h = (Button)findViewById(0x7f0a00d7);
        i = (Button)findViewById(0x7f0a00d8);
        f.setOnClickListener(a);
        g.setOnClickListener(b);
        h.setOnClickListener(c);
        i.setOnClickListener(d);
        s = e.l.a(l.getTitle(), l.getEnclosureLink(), l.getEnclosureType());
        if (!e.l.c(s))
        {
            break MISSING_BLOCK_LABEL_328;
        }
        h.setVisibility(8);
        i.setVisibility(0);
_L5:
        e.e.a("PodcastAction");
        return;
_L4:
        finish();
          goto _L2
        exception1;
        com.appyet.d.d.a(exception1);
          goto _L2
        h.setVisibility(0);
        i.setVisibility(8);
          goto _L5
    }
}
