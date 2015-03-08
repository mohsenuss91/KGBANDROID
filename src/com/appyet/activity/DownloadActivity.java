// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.Display;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.Module;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.bp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.appyet.activity:
//            i, l, j, m, 
//            k

public class DownloadActivity extends SherlockActivity
{

    protected ApplicationContext a;
    android.widget.AdapterView.OnItemClickListener b;
    private l c;
    private TextView d;
    private ListView e;
    private ProgressBar f;
    private Module g;

    public DownloadActivity()
    {
        b = new i(this);
    }

    static l a(DownloadActivity downloadactivity)
    {
        return downloadactivity.c;
    }

    static l a(DownloadActivity downloadactivity, l l1)
    {
        downloadactivity.c = l1;
        return l1;
    }

    static ProgressBar b(DownloadActivity downloadactivity)
    {
        return downloadactivity.f;
    }

    static ListView c(DownloadActivity downloadactivity)
    {
        return downloadactivity.e;
    }

    static TextView d(DownloadActivity downloadactivity)
    {
        return downloadactivity.d;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        android.widget.AdapterView.AdapterContextMenuInfo adaptercontextmenuinfo = (android.widget.AdapterView.AdapterContextMenuInfo)menuitem.getMenuInfo();
        int k1;
        if (menuitem.getItemId() != 0x7f0a00f3)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        k1 = adaptercontextmenuinfo.position;
        Intent intent = new Intent("android.intent.action.SEND");
        File file = (File)c.getItem(k1);
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        intent.putExtra("android.intent.extra.SUBJECT", file.getName());
        startActivity(Intent.createChooser(intent, getString(0x7f08008d)));
_L2:
        return true;
        Exception exception2;
        exception2;
        try
        {
            com.appyet.d.d.a(exception2);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return super.onContextItemSelected(menuitem);
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (menuitem.getItemId() != 0x7f0a00f4) goto _L4; else goto _L3
_L3:
        int i1 = adaptercontextmenuinfo.position;
        j j1 = new j(this, i1);
        (new android.app.AlertDialog.Builder(this)).setMessage(0x7f080060).setIcon(0x7f0200b4).setTitle(0x7f08005f).setPositiveButton(getString(0x7f080061), j1).setNegativeButton(getString(0x7f080062), j1).show();
_L5:
        return true;
        Exception exception1;
        exception1;
        com.appyet.d.d.a(exception1);
        if (true) goto _L5; else goto _L4
_L4:
        return super.onContextItemSelected(menuitem);
    }

    protected void onCreate(Bundle bundle)
    {
        String s;
        InputStream inputstream;
        super.onCreate(bundle);
        ar.a(this);
        setContentView(0x7f030039);
        a = (ApplicationContext)getApplicationContext();
        g = a.h.h();
        if (g == null)
        {
            finish();
            return;
        }
        setTitle(0x7f0800bb);
        s = "download.png";
        if (g != null && g.getIcon() != null)
        {
            s = g.getIcon();
        }
        inputstream = null;
        InputStream inputstream2 = getResources().getAssets().open((new StringBuilder("module/")).append(s).toString());
        InputStream inputstream1 = inputstream2;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream1);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i1 = bitmap.getWidth();
        int j1 = bitmap.getHeight();
        float f1 = displaymetrics.scaledDensity;
        float f2 = displaymetrics.scaledDensity;
        Matrix matrix = new Matrix();
        matrix.postScale(f1, f2);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, i1, j1, matrix, true);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), bitmap1);
        getSupportActionBar().setIcon(bitmapdrawable);
        if (inputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        inputstream1.close();
_L2:
        d = (TextView)findViewById(0x7f0a0070);
        e = (ListView)findViewById(0x7f0a0071);
        f = (ProgressBar)findViewById(0x7f0a0073);
        ActionBar actionbar1 = getSupportActionBar();
        actionbar1.setDisplayHomeAsUpEnabled(true);
        actionbar1.setHomeButtonEnabled(true);
        e.setOnItemClickListener(b);
        (new m(this)).a(new Void[0]);
        registerForContextMenu(e);
        a.e.a("Download");
        return;
        IOException ioexception1;
        ioexception1;
_L5:
        com.appyet.d.d.a(ioexception1);
        getSupportActionBar().setIcon(0x7f020078);
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        inputstream.close();
          goto _L2
        IOException ioexception2;
        ioexception2;
        ActionBar actionbar;
        com.appyet.d.d.a(ioexception2);
        actionbar = getSupportActionBar();
_L3:
        actionbar.setIcon(0x7f020078);
          goto _L2
        Exception exception;
        exception;
        inputstream1 = null;
_L4:
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            catch (IOException ioexception)
            {
                com.appyet.d.d.a(ioexception);
                getSupportActionBar().setIcon(0x7f020078);
            }
        }
        throw exception;
        IOException ioexception3;
        ioexception3;
        com.appyet.d.d.a(ioexception3);
        actionbar = getSupportActionBar();
          goto _L3
        exception;
          goto _L4
        exception;
        inputstream1 = inputstream;
          goto _L4
        ioexception1;
        inputstream = inputstream1;
          goto _L5
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        try
        {
            getMenuInflater().inflate(0x7f0f0000, contextmenu);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0001, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 3: default 40
    //                   16908332: 46
    //                   2131362037: 53
    //                   2131362038: 72;
           goto _L1 _L2 _L3 _L4
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        finish();
        continue; /* Loop/switch isn't completed */
_L3:
        (new m(this)).a(new Void[0]);
        continue; /* Loop/switch isn't completed */
_L4:
        try
        {
            CharSequence acharsequence[] = getResources().getTextArray(0x7f0e0006);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle(getString(0x7f08008c));
            builder.setSingleChoiceItems(acharsequence, a.d.R(), new k(this));
            builder.create().show();
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu);
    }
}
