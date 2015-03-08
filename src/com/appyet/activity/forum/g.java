// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity.forum;

import android.widget.EditText;
import android.widget.Toast;
import com.appyet.context.ApplicationContext;
import com.appyet.f.a;
import com.appyet.manager.an;
import com.appyet.manager.ao;
import com.appyet.manager.bp;

// Referenced classes of package com.appyet.activity.forum:
//            ForumSignInActivity

final class g extends a
{

    final ForumSignInActivity a;
    private ao b;

    private g(ForumSignInActivity forumsigninactivity)
    {
        a = forumsigninactivity;
        super();
    }

    g(ForumSignInActivity forumsigninactivity, byte byte0)
    {
        this(forumsigninactivity);
    }

    protected final void a()
    {
        ForumSignInActivity.e(a);
    }

    protected final void a(Object obj)
    {
        ForumSignInActivity.c(a);
        if (b.a)
        {
            a.a.d.a(ForumSignInActivity.d(a), com.appyet.activity.forum.ForumSignInActivity.a(a).getText().toString());
            a.a.d.b(ForumSignInActivity.d(a), ForumSignInActivity.b(a).getText().toString());
            a.finish();
            return;
        }
        String s = a.getString(0x7f080046);
        if (b.b != null && b.b.length() > 0)
        {
            s = (new StringBuilder()).append(s).append(" ").append(b.b).toString();
        }
        Toast.makeText(a, s, 1).show();
    }

    protected final Object b()
    {
        b = a.a.p.a(a.b, com.appyet.activity.forum.ForumSignInActivity.a(a).getText().toString(), ForumSignInActivity.b(a).getText().toString());
        return null;
    }

    protected final volatile void c()
    {
    }
}
