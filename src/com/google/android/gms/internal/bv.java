// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.d;

// Referenced classes of package com.google.android.gms.internal:
//            aj, bw, am

public interface bv
    extends IInterface
{

    public abstract void a(d d, aj aj, String s, bw bw);

    public abstract void a(d d, aj aj, String s, String s1, bw bw);

    public abstract void a(d d, am am, aj aj, String s, bw bw);

    public abstract void a(d d, am am, aj aj, String s, String s1, bw bw);

    public abstract void destroy();

    public abstract d getView();

    public abstract void pause();

    public abstract void resume();

    public abstract void showInterstitial();
}
