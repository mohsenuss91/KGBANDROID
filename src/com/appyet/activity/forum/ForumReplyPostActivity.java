// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity.forum;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.appyet.a.a.a;
import com.appyet.a.a.f;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.Module;
import com.appyet.manager.an;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.activity.forum:
//            c, ForumSignInActivity, d

public class ForumReplyPostActivity extends SherlockActivity
{

    protected ApplicationContext a;
    protected long b;
    private EditText c;
    private Module d;
    private String e;
    private String f;
    private com.appyet.a.a.d g;
    private a h;
    private ProgressDialog i;

    public ForumReplyPostActivity()
    {
        h = null;
    }

    static EditText a(ForumReplyPostActivity forumreplypostactivity)
    {
        return forumreplypostactivity.c;
    }

    static String b(ForumReplyPostActivity forumreplypostactivity)
    {
        return forumreplypostactivity.e;
    }

    static String c(ForumReplyPostActivity forumreplypostactivity)
    {
        return forumreplypostactivity.f;
    }

    static void d(ForumReplyPostActivity forumreplypostactivity)
    {
        try
        {
            if (forumreplypostactivity.i != null)
            {
                forumreplypostactivity.i.dismiss();
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    static void e(ForumReplyPostActivity forumreplypostactivity)
    {
        try
        {
            forumreplypostactivity.i = new ProgressDialog(forumreplypostactivity);
            forumreplypostactivity.i.setProgressStyle(0);
            forumreplypostactivity.i.setCancelable(true);
            forumreplypostactivity.i.setIndeterminate(true);
            forumreplypostactivity.i.setCanceledOnTouchOutside(false);
            forumreplypostactivity.i.setMessage(forumreplypostactivity.getString(0x7f080085));
            forumreplypostactivity.i.show();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public void onBackPressed()
    {
        if (c.getText().length() > 0)
        {
            (new android.app.AlertDialog.Builder(this)).setIcon(0x1080027).setTitle(getString(0x7f08005f)).setMessage(getString(0x7f080060)).setPositiveButton(getString(0x7f080061), new c(this)).setNegativeButton(getString(0x7f080062), null).show();
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030047);
        a = (ApplicationContext)getApplicationContext();
        try
        {
            Bundle bundle1 = getIntent().getExtras();
            b = bundle1.getLong("ARG_MODULE_ID");
            d = a.h.g(b);
            e = bundle1.getString("ARG_FORUM_ID");
            f = bundle1.getString("ARG_TOPIC_ID");
            g = a.p.a(b);
            Iterator iterator = g.b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                a a1 = (a)iterator.next();
                if (a1.a.equals(e))
                {
                    h = a1;
                }
            } while (true);
            break MISSING_BLOCK_LABEL_162;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
_L1:
        return;
        c = (EditText)findViewById(0x7f0a009a);
        setTitle(0x7f0800f4);
        if ((g.e == null || !g.e.a) && g.d != null)
        {
            Intent intent = new Intent(a, com/appyet/activity/forum/ForumSignInActivity);
            intent.putExtra("ARG_MODULE_ID", b);
            a.startActivity(intent);
            return;
        }
          goto _L1
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0006, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131362060 2131362060: default 24
    //                   2131362060 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(c.getWindowToken(), 0);
        c.clearFocus();
        (new com.appyet.activity.forum.d(this, (byte)0)).a(new Void[0]);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu);
    }
}
