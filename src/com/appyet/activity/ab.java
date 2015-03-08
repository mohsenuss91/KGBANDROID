// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Intent;

// Referenced classes of package com.appyet.activity:
//            SplashActivity, MainActivity

final class ab
    implements Runnable
{

    final SplashActivity a;

    ab(SplashActivity splashactivity)
    {
        a = splashactivity;
        super();
    }

    public final void run()
    {
        a.finish();
        Intent intent = new Intent(a, com/appyet/activity/MainActivity);
        a.startActivity(intent);
    }
}
