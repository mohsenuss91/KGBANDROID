// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity.forum;

import android.os.Build;
import android.widget.EditText;
import android.widget.Toast;
import com.appyet.context.ApplicationContext;
import com.appyet.f.a;
import com.appyet.manager.an;
import com.appyet.manager.ao;

// Referenced classes of package com.appyet.activity.forum:
//            ForumNewTopicActivity

final class b extends a
{

    final ForumNewTopicActivity a;
    private ao b;

    private b(ForumNewTopicActivity forumnewtopicactivity)
    {
        a = forumnewtopicactivity;
        super();
    }

    b(ForumNewTopicActivity forumnewtopicactivity, byte byte0)
    {
        this(forumnewtopicactivity);
    }

    private transient Void f()
    {
        String s2;
        StringBuilder stringbuilder = (new StringBuilder()).append(com.appyet.activity.forum.ForumNewTopicActivity.a(a).getText().toString()).append("\n\n ");
        String s1 = a.getString(0x7f080113);
        Object aobj[] = new Object[2];
        aobj[0] = Build.MODEL;
        aobj[1] = a.getString(0x7f080116);
        s2 = stringbuilder.append(String.format(s1, aobj)).toString();
        String s = s2;
_L2:
        b = a.a.p.a(a.b, ForumNewTopicActivity.b(a), ForumNewTopicActivity.c(a).getText().toString(), s);
        return null;
        Exception exception;
        exception;
        s = com.appyet.activity.forum.ForumNewTopicActivity.a(a).getText().toString();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final void a()
    {
        ForumNewTopicActivity.e(a);
    }

    protected final void a(Object obj)
    {
        ForumNewTopicActivity.d(a);
        if (b.a)
        {
            a.setResult(1);
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
        return f();
    }

    protected final volatile void c()
    {
    }
}
