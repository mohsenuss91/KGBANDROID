// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.iq;

final class A extends hr
{

    private static int A(Context context)
    {
        ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
        boolean flag;
        int i;
        if ((0x100000 & context.getApplicationInfo().flags) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && iq.fX())
        {
            i = a(activitymanager);
        } else
        {
            i = activitymanager.getMemoryClass();
        }
        return (int)(0.33F * (float)(i * 0x100000));
    }

    protected final int a(a a1, Bitmap bitmap)
    {
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    protected final void a(boolean flag, a a1, Bitmap bitmap, Bitmap bitmap1)
    {
        super.entryRemoved(flag, a1, bitmap, bitmap1);
    }

    protected final void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
        a(flag, (a)obj, (Bitmap)obj1, (Bitmap)obj2);
    }

    protected final int sizeOf(Object obj, Object obj1)
    {
        return a((a)obj, (Bitmap)obj1);
    }

    public _cls9(Context context)
    {
        super(A(context));
    }
}
