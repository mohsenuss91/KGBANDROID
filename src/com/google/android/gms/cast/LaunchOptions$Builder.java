// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.internal.gj;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.cast:
//            LaunchOptions

public final class Ap
{

    private LaunchOptions Ap;

    public final LaunchOptions build()
    {
        return Ap;
    }

    public final Ap setLocale(Locale locale)
    {
        Ap.setLanguage(gj.b(locale));
        return this;
    }

    public final age setRelaunchIfRunning(boolean flag)
    {
        Ap.setRelaunchIfRunning(flag);
        return this;
    }

    public ()
    {
        Ap = new LaunchOptions();
    }
}
