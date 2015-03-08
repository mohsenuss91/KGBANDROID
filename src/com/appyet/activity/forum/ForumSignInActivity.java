// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity.forum;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.Module;
import com.appyet.manager.an;

// Referenced classes of package com.appyet.activity.forum:
//            e, f

public class ForumSignInActivity extends SherlockActivity
{

    protected ApplicationContext a;
    protected long b;
    private EditText c;
    private EditText d;
    private Button e;
    private Button f;
    private Module g;
    private com.appyet.a.a.d h;
    private ProgressDialog i;

    public ForumSignInActivity()
    {
    }

    static EditText a(ForumSignInActivity forumsigninactivity)
    {
        return forumsigninactivity.c;
    }

    static EditText b(ForumSignInActivity forumsigninactivity)
    {
        return forumsigninactivity.d;
    }

    static void c(ForumSignInActivity forumsigninactivity)
    {
        try
        {
            if (forumsigninactivity.i != null)
            {
                forumsigninactivity.i.dismiss();
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    static com.appyet.a.a.d d(ForumSignInActivity forumsigninactivity)
    {
        return forumsigninactivity.h;
    }

    static void e(ForumSignInActivity forumsigninactivity)
    {
        try
        {
            forumsigninactivity.i = new ProgressDialog(forumsigninactivity);
            forumsigninactivity.i.setProgressStyle(0);
            forumsigninactivity.i.setCancelable(true);
            forumsigninactivity.i.setIndeterminate(true);
            forumsigninactivity.i.setCanceledOnTouchOutside(false);
            forumsigninactivity.i.setMessage(forumsigninactivity.getString(0x7f080085));
            forumsigninactivity.i.show();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030048);
        a = (ApplicationContext)getApplicationContext();
        try
        {
            b = getIntent().getExtras().getLong("ARG_MODULE_ID");
            g = a.h.g(b);
            h = a.p.a(b);
            c = (EditText)findViewById(0x7f0a00a2);
            d = (EditText)findViewById(0x7f0a00a3);
            f = (Button)findViewById(0x7f0a00a5);
            e = (Button)findViewById(0x7f0a00a4);
            f.setOnClickListener(new e(this));
            e.setOnClickListener(new f(this));
            setTitle(0x7f08010f);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0007, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        return super.onOptionsItemSelected(menuitem);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu);
    }
}
