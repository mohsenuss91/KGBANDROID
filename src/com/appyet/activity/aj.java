// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.view.View;

// Referenced classes of package com.appyet.activity:
//            WebActionActivity

final class aj
    implements android.view.View.OnClickListener
{

    final WebActionActivity a;

    aj(WebActionActivity webactionactivity)
    {
        a = webactionactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.finish();
    }
}
