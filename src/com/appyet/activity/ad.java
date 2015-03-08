// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.view.View;

// Referenced classes of package com.appyet.activity:
//            TranslateActivity

final class ad
    implements android.view.View.OnClickListener
{

    final TranslateActivity a;

    ad(TranslateActivity translateactivity)
    {
        a = translateactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.setResult(0);
        a.finish();
    }
}
