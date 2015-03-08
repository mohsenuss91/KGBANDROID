// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.view.View;

// Referenced classes of package com.appyet.activity:
//            WhatsNewActivity

final class ap
    implements android.view.View.OnClickListener
{

    final WhatsNewActivity a;

    ap(WhatsNewActivity whatsnewactivity)
    {
        a = whatsnewactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.finish();
    }
}
