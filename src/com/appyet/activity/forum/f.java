// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity.forum;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package com.appyet.activity.forum:
//            ForumSignInActivity

final class f
    implements android.view.View.OnClickListener
{

    final ForumSignInActivity a;

    f(ForumSignInActivity forumsigninactivity)
    {
        a = forumsigninactivity;
        super();
    }

    public final void onClick(View view)
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)a.getSystemService("input_method");
        inputmethodmanager.hideSoftInputFromWindow(ForumSignInActivity.a(a).getWindowToken(), 0);
        inputmethodmanager.hideSoftInputFromWindow(ForumSignInActivity.b(a).getWindowToken(), 0);
        ForumSignInActivity.a(a).clearFocus();
        ForumSignInActivity.b(a).clearFocus();
    }
}
