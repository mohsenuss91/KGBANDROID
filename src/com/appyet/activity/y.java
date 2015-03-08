// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.view.View;

// Referenced classes of package com.appyet.activity:
//            PodcastActionActivity

final class y
    implements android.view.View.OnClickListener
{

    final PodcastActionActivity a;

    y(PodcastActionActivity podcastactionactivity)
    {
        a = podcastactionactivity;
        super();
    }

    public final void onClick(View view)
    {
        PodcastActionActivity.a(a, false);
        a.finish();
    }
}
