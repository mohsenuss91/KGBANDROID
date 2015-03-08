// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

// Referenced classes of package net.simonvt.menudrawer:
//            e

final class d extends Drawable
{

    private e a;
    private final Paint b;

    public d()
    {
        this(((e) (null)));
    }

    public d(byte byte0)
    {
        this(((e) (null)));
        if (a.a != 0xff000000 || a.b != 0xff000000)
        {
            invalidateSelf();
            e e1 = a;
            a.b = 0xff000000;
            e1.a = 0xff000000;
        }
    }

    private d(e e1)
    {
        b = new Paint();
        a = new e(e1);
    }

    d(e e1, byte byte0)
    {
        this(e1);
    }

    public final void draw(Canvas canvas)
    {
        if (a.b >>> 24 != 0)
        {
            b.setColor(a.b);
            canvas.drawRect(getBounds(), b);
        }
    }

    public final int getChangingConfigurations()
    {
        return super.getChangingConfigurations() | a.c;
    }

    public final android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        a.c = getChangingConfigurations();
        return a;
    }

    public final int getOpacity()
    {
        switch (a.b >>> 24)
        {
        default:
            return -3;

        case 255: 
            return -1;

        case 0: // '\0'
            return -2;
        }
    }

    public final void setAlpha(int i)
    {
        int j = (i + (i >> 7)) * (a.a >>> 24) >> 8;
        int k = a.b;
        a.b = (a.a << 8) >>> 8 | j << 24;
        if (k != a.b)
        {
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
    }
}
