// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.view.View;

public final class a
{

    public static void a(View view, Runnable runnable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            view.postOnAnimation(runnable);
            return;
        } else
        {
            view.postDelayed(runnable, 16L);
            return;
        }
    }
}
