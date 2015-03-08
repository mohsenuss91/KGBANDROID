// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.appyet.context.ApplicationContext;
import com.appyet.context.b;
import com.appyet.d.d;
import com.appyet.manager.bp;
import java.net.URLEncoder;

// Referenced classes of package com.appyet.activity:
//            TranslateActivity

final class ac
    implements android.view.View.OnClickListener
{

    final TranslateActivity a;

    ac(TranslateActivity translateactivity)
    {
        a = translateactivity;
        super();
    }

    public final void onClick(View view)
    {
        String s1;
        if (TranslateActivity.a(a).d.z() != b.b)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        s1 = (new StringBuilder("http://www.google.com/gwt/x?u=")).append(URLEncoder.encode(com.appyet.activity.TranslateActivity.b(a), "UTF-8")).toString();
_L1:
        String s2 = (new StringBuilder("http://translate.google.com/translate?sl=auto&tl=")).append(TranslateActivity.c(a)).append("&u=").append(URLEncoder.encode(s1, "UTF-8")).toString();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s2));
        a.startActivity(intent);
        a.setResult(1);
        a.finish();
        return;
        String s;
        try
        {
            s = (new StringBuilder("http://www.instapaper.com/m?u=")).append(URLEncoder.encode(com.appyet.activity.TranslateActivity.b(a), "UTF-8")).toString();
        }
        catch (Exception exception)
        {
            d.a(exception);
            Toast.makeText(TranslateActivity.a(a), 0x7f080046, 1).show();
            return;
        }
        s1 = s;
          goto _L1
    }
}
