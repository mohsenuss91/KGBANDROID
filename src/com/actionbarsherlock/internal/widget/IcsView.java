// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.widget;

import android.view.View;

final class IcsView
{

    private IcsView()
    {
    }

    public static int getMeasuredStateInt(View view)
    {
        return 0xff000000 & view.getMeasuredWidth() | 0xffffff00 & view.getMeasuredHeight() >> 16;
    }
}
