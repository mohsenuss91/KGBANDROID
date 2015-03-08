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
//            a, ForumSignInActivity, b

public class ForumNewTopicActivity extends SherlockActivity
{

    protected ApplicationContext a;
    protected long b;
    private EditText c;
    private EditText d;
    private Module e;
    private String f;
    private com.appyet.a.a.d g;
    private a h;
    private ProgressDialog i;

    public ForumNewTopicActivity()
    {
        h = null;
    }

    static EditText a(ForumNewTopicActivity forumnewtopicactivity)
    {
        return forumnewtopicactivity.d;
    }

    static String b(ForumNewTopicActivity forumnewtopicactivity)
    {
        return forumnewtopicactivity.f;
    }

    static EditText c(ForumNewTopicActivity forumnewtopicactivity)
    {
        return forumnewtopicactivity.c;
    }

    static void d(ForumNewTopicActivity forumnewtopicactivity)
    {
        try
        {
            if (forumnewtopicactivity.i != null)
            {
                forumnewtopicactivity.i.dismiss();
            }
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    static void e(ForumNewTopicActivity forumnewtopicactivity)
    {
        try
        {
            forumnewtopicactivity.i = new ProgressDialog(forumnewtopicactivity);
            forumnewtopicactivity.i.setProgressStyle(0);
            forumnewtopicactivity.i.setCancelable(true);
            forumnewtopicactivity.i.setIndeterminate(true);
            forumnewtopicactivity.i.setCanceledOnTouchOutside(false);
            forumnewtopicactivity.i.setMessage(forumnewtopicactivity.getString(0x7f080085));
            forumnewtopicactivity.i.show();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public void onBackPressed()
    {
        if (d.getText().length() > 0 || c.getText().length() > 0)
        {
            (new android.app.AlertDialog.Builder(this)).setIcon(0x1080027).setTitle(getString(0x7f08005f)).setMessage(getString(0x7f080060)).setPositiveButton(getString(0x7f080061), new com.appyet.activity.forum.a(this)).setNegativeButton(getString(0x7f080062), null).show();
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
        setContentView(0x7f03004d);
        a = (ApplicationContext)getApplicationContext();
        try
        {
            Bundle bundle1 = getIntent().getExtras();
            b = bundle1.getLong("ARG_MODULE_ID");
            e = a.h.g(b);
            f = bundle1.getString("ARG_FORUM_ID");
            g = a.p.a(b);
            Iterator iterator = g.b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                a a1 = (a)iterator.next();
                if (a1.a.equals(f))
                {
                    h = a1;
                }
            } while (true);
            break MISSING_BLOCK_LABEL_152;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
_L1:
        return;
        c = (EditText)findViewById(0x7f0a00bd);
        d = (EditText)findViewById(0x7f0a009a);
        setTitle(0x7f0800e8);
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
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        inputmethodmanager.hideSoftInputFromWindow(c.getWindowToken(), 0);
        inputmethodmanager.hideSoftInputFromWindow(d.getWindowToken(), 0);
        c.clearFocus();
        d.clearFocus();
        (new b(this, (byte)0)).a(new Void[0]);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return super.onPrepareOptionsMenu(menu);
    }
}
