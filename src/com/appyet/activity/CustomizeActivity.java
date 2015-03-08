// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.data.Module;
import com.appyet.manager.ap;
import com.appyet.manager.ar;
import com.appyet.manager.d;
import com.mobeta.android.dslv.DragSortListView;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.appyet.activity:
//            a, b, d, MainActivity

public class CustomizeActivity extends SherlockActivity
{

    ApplicationContext a;
    MainActivity b;
    List c;
    b d;
    List e;
    Module f;
    DragSortListView g;
    TextView h;
    ProgressBar i;
    private boolean j;
    private android.widget.AdapterView.OnItemClickListener k;

    public CustomizeActivity()
    {
        e = null;
        f = null;
        j = false;
        k = new a(this);
    }

    static boolean a(CustomizeActivity customizeactivity)
    {
        return customizeactivity.j;
    }

    static boolean b(CustomizeActivity customizeactivity)
    {
        customizeactivity.j = true;
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        String s;
        InputStream inputstream;
        super.onCreate(bundle);
        ar.a(this);
        setContentView(0x7f030034);
        a = (ApplicationContext)getApplicationContext();
        f = a.h.i();
        if (f == null)
        {
            finish();
            return;
        }
        setTitle(0x7f0800e1);
        s = "customize.png";
        if (f != null && f.getIcon() != null)
        {
            s = f.getIcon();
        }
        inputstream = null;
        InputStream inputstream2 = getResources().getAssets().open((new StringBuilder("module/")).append(s).toString());
        InputStream inputstream1 = inputstream2;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream1);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int l = bitmap.getWidth();
        int i1 = bitmap.getHeight();
        float f1 = displaymetrics.scaledDensity;
        float f2 = displaymetrics.scaledDensity;
        Matrix matrix = new Matrix();
        matrix.postScale(f1, f2);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, l, i1, matrix, true);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), bitmap1);
        getSupportActionBar().setIcon(bitmapdrawable);
        if (inputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        inputstream1.close();
_L2:
        h = (TextView)findViewById(0x7f0a0070);
        g = (DragSortListView)findViewById(0x7f0a0071);
        i = (ProgressBar)findViewById(0x7f0a0073);
        ActionBar actionbar1 = getSupportActionBar();
        actionbar1.setDisplayHomeAsUpEnabled(true);
        actionbar1.setHomeButtonEnabled(true);
        g.setCacheColorHint(0);
        d = new b(this, this);
        g.setDividerHeight(0);
        g.setOnItemClickListener(k);
        (new com.appyet.activity.d(this)).a(new Void[0]);
        a.e.a("Customize");
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
}
