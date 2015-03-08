// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.os.Handler;
import android.os.IBinder;

// Referenced classes of package com.google.android.youtube.player.internal:
//            r

public final class <init> extends <init>
{

    final r a;

    public final void a(String s, IBinder ibinder)
    {
        a.a.sendMessage(a.a.obtainMessage(1, new <init>(a, s, ibinder)));
    }

    protected (r r1)
    {
        a = r1;
        super();
    }
}
