// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.b;

import com.a.a.b.a.f;
import com.a.a.b.a.m;
import com.a.a.b.d;
import com.a.a.b.d.c;

public final class e
{

    final String a;
    final String b;
    final f c;
    final com.a.a.b.a.e d;
    final m e;
    final c f;
    final Object g;
    final android.graphics.BitmapFactory.Options h = new android.graphics.BitmapFactory.Options();

    public e(String s, String s1, f f1, m m, c c1, d d1)
    {
        a = s;
        b = s1;
        c = f1;
        d = d1.g;
        e = m;
        f = c1;
        g = d1.j;
        android.graphics.BitmapFactory.Options options = d1.h;
        android.graphics.BitmapFactory.Options options1 = h;
        options1.inDensity = options.inDensity;
        options1.inDither = options.inDither;
        options1.inInputShareable = options.inInputShareable;
        options1.inJustDecodeBounds = options.inJustDecodeBounds;
        options1.inPreferredConfig = options.inPreferredConfig;
        options1.inPurgeable = options.inPurgeable;
        options1.inSampleSize = options.inSampleSize;
        options1.inScaled = options.inScaled;
        options1.inScreenDensity = options.inScreenDensity;
        options1.inTargetDensity = options.inTargetDensity;
        options1.inTempStorage = options.inTempStorage;
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            options1.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            options1.inBitmap = options.inBitmap;
            options1.inMutable = options.inMutable;
        }
    }
}
