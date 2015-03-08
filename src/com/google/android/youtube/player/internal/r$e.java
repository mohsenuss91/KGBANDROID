// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package com.google.android.youtube.player.internal:
//            r

final class a
    implements ServiceConnection
{

    final r a;

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        a.b(ibinder);
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        r.a(a, null);
        a.h();
    }

    (r r1)
    {
        a = r1;
        super();
    }
}
