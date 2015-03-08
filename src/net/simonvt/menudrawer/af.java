// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public final class af extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{

    private Drawable a;
    private float b;
    private final Rect c = new Rect();
    private boolean d;

    public af(Drawable drawable)
    {
        a = drawable;
    }

    public final void a(float f)
    {
        b = f;
        invalidateSelf();
    }

    final void a(boolean flag)
    {
        d = flag;
        invalidateSelf();
    }

    public final void clearColorFilter()
    {
        a.clearColorFilter();
    }

    public final void draw(Canvas canvas)
    {
        a.copyBounds(c);
        canvas.save();
        if (d)
        {
            canvas.translate(0.3333333F * (float)c.width() * b, 0.0F);
        } else
        {
            canvas.translate(0.3333333F * (float)c.width() * -b, 0.0F);
        }
        a.draw(canvas);
        canvas.restore();
    }

    public final int getChangingConfigurations()
    {
        return a.getChangingConfigurations();
    }

    public final android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        return super.getConstantState();
    }

    public final Drawable getCurrent()
    {
        return a.getCurrent();
    }

    public final int getIntrinsicHeight()
    {
        return a.getIntrinsicHeight();
    }

    public final int getIntrinsicWidth()
    {
        return a.getIntrinsicWidth();
    }

    public final int getMinimumHeight()
    {
        return a.getMinimumHeight();
    }

    public final int getMinimumWidth()
    {
        return a.getMinimumWidth();
    }

    public final int getOpacity()
    {
        return a.getOpacity();
    }

    public final boolean getPadding(Rect rect)
    {
        return a.getPadding(rect);
    }

    public final int[] getState()
    {
        return a.getState();
    }

    public final Region getTransparentRegion()
    {
        return a.getTransparentRegion();
    }

    public final void invalidateDrawable(Drawable drawable)
    {
        if (drawable == a)
        {
            invalidateSelf();
        }
    }

    public final boolean isStateful()
    {
        return a.isStateful();
    }

    protected final void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        a.setBounds(rect);
    }

    protected final boolean onStateChange(int ai[])
    {
        a.setState(ai);
        return super.onStateChange(ai);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        if (drawable == a)
        {
            scheduleSelf(runnable, l);
        }
    }

    public final void setAlpha(int i)
    {
        a.setAlpha(i);
    }

    public final void setChangingConfigurations(int i)
    {
        a.setChangingConfigurations(i);
    }

    public final void setColorFilter(int i, android.graphics.PorterDuff.Mode mode)
    {
        a.setColorFilter(i, mode);
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        a.setColorFilter(colorfilter);
    }

    public final void setDither(boolean flag)
    {
        a.setDither(flag);
    }

    public final void setFilterBitmap(boolean flag)
    {
        a.setFilterBitmap(flag);
    }

    public final boolean setState(int ai[])
    {
        return a.setState(ai);
    }

    public final boolean setVisible(boolean flag, boolean flag1)
    {
        return super.setVisible(flag, flag1);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        if (drawable == a)
        {
            unscheduleSelf(runnable);
        }
    }
}
