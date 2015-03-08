// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.anim;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TranslateAnimation extends Animation
{

    private int a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;

    public TranslateAnimation(float f1, float f2, float f3, float f4)
    {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0.0F;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        e = f1;
        f = f2;
        g = f3;
        h = f4;
        a = 0;
        b = 0;
        c = 0;
        d = 0;
    }

    public TranslateAnimation(int i1, float f1, int j1, float f2, int k1, float f3, int l1, 
            float f4)
    {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0.0F;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        e = f1;
        f = f2;
        g = f3;
        h = f4;
        a = i1;
        b = j1;
        c = k1;
        d = l1;
    }

    protected void applyTransformation(float f1, Transformation transformation)
    {
        float f2 = i;
        float f3 = k;
        if (i != j)
        {
            f2 = i + f1 * (j - i);
        }
        if (k != l)
        {
            f3 = k + f1 * (l - k);
        }
        transformation.getMatrix().setTranslate(f2, f3);
    }

    public void initialize(int i1, int j1, int k1, int l1)
    {
        super.initialize(i1, j1, k1, l1);
        i = resolveSize(a, e, i1, k1);
        j = resolveSize(b, f, i1, k1);
        k = resolveSize(c, g, j1, l1);
        l = resolveSize(d, h, j1, l1);
    }
}
