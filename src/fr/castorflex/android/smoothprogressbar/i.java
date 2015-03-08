// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.Interpolator;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            j

public final class i extends Drawable
    implements Animatable
{

    private Interpolator a;
    private Rect b;
    private Paint c;
    private int d[];
    private int e;
    private boolean f;
    private float g;
    private int h;
    private int i;
    private float j;
    private boolean k;
    private boolean l;
    private boolean m;
    private float n;
    private final Runnable o;

    private i(Interpolator interpolator, int i1, int j1, int ai[], float f1, float f2, boolean flag, 
            boolean flag1)
    {
        o = new j(this);
        f = false;
        a = interpolator;
        i = i1;
        h = j1;
        j = f2;
        k = flag;
        d = ai;
        e = 0;
        m = flag1;
        n = 1.0F / (float)i;
        c = new Paint();
        c.setStrokeWidth(f1);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setDither(false);
        c.setAntiAlias(false);
    }

    i(Interpolator interpolator, int i1, int j1, int ai[], float f1, float f2, boolean flag, 
            boolean flag1, byte byte0)
    {
        this(interpolator, i1, j1, ai, f1, f2, flag, flag1);
    }

    static float a(i i1)
    {
        return i1.j;
    }

    static float a(i i1, float f1)
    {
        float f2 = f1 + i1.g;
        i1.g = f2;
        return f2;
    }

    static float b(i i1)
    {
        return i1.g;
    }

    static float b(i i1, float f1)
    {
        float f2 = i1.g - f1;
        i1.g = f2;
        return f2;
    }

    static float c(i i1)
    {
        return i1.n;
    }

    static boolean d(i i1)
    {
        i1.l = true;
        return true;
    }

    static Runnable e(i i1)
    {
        return i1.o;
    }

    public final void a(float f1)
    {
        if (f1 < 0.0F)
        {
            throw new IllegalArgumentException("Speed must be >= 0");
        } else
        {
            j = f1;
            invalidateSelf();
            return;
        }
    }

    public final void a(int i1)
    {
        a(new int[] {
            i1
        });
    }

    public final void a(Interpolator interpolator)
    {
        if (interpolator == null)
        {
            throw new IllegalArgumentException("Interpolator cannot be null");
        } else
        {
            a = interpolator;
            invalidateSelf();
            return;
        }
    }

    public final void a(boolean flag)
    {
        if (k == flag)
        {
            return;
        } else
        {
            k = flag;
            invalidateSelf();
            return;
        }
    }

    public final void a(int ai[])
    {
        if (ai == null || ai.length == 0)
        {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        } else
        {
            e = 0;
            d = ai;
            invalidateSelf();
            return;
        }
    }

    public final void b(float f1)
    {
        if (f1 < 0.0F)
        {
            throw new IllegalArgumentException("The strokeWidth must be >= 0");
        } else
        {
            c.setStrokeWidth(f1);
            invalidateSelf();
            return;
        }
    }

    public final void b(int i1)
    {
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        } else
        {
            i = i1;
            n = 1.0F / (float)i;
            g = g % n;
            invalidateSelf();
            return;
        }
    }

    public final void b(boolean flag)
    {
        if (m == flag)
        {
            return;
        } else
        {
            m = flag;
            invalidateSelf();
            return;
        }
    }

    public final void c(int i1)
    {
        if (i1 < 0)
        {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        } else
        {
            h = i1;
            invalidateSelf();
            return;
        }
    }

    public final void draw(Canvas canvas)
    {
        b = getBounds();
        canvas.clipRect(b);
        int i1 = b.width();
        if (k)
        {
            canvas.translate(i1, 0.0F);
            canvas.scale(-1F, 1.0F);
        }
        int j1 = b.width();
        int k1;
        int l1;
        int i2;
        float f1;
        int j2;
        int k2;
        int l2;
        float f2;
        if (m)
        {
            k1 = j1 / 2;
        } else
        {
            k1 = j1;
        }
        l1 = k1 + h + i;
        i2 = b.centerY();
        f1 = 1.0F / (float)i;
        if (l)
        {
            int j3 = -1 + e;
            if (j3 < 0)
            {
                j3 = -1 + d.length;
            }
            e = j3;
            l = false;
        }
        j2 = e;
        k2 = 0;
        l2 = j2;
        f2 = 0.0F;
        do
        {
            while (k2 <= i) 
            {
                float f3 = f1 * (float)k2 + g;
                float f4 = Math.max(0.0F, f3 - f1);
                float f5 = (int)(Math.abs(a.getInterpolation(f4) - a.getInterpolation(Math.min(f3, 1.0F))) * (float)l1);
                float f6;
                float f7;
                float f8;
                if (f5 + f4 < (float)l1)
                {
                    f6 = Math.min(f5, h);
                } else
                {
                    f6 = 0.0F;
                }
                if (f5 > f6)
                {
                    f7 = f5 - f6;
                } else
                {
                    f7 = 0.0F;
                }
                f8 = f2 + f7;
                if (f8 > f2)
                {
                    float f10 = Math.min(k1, f2);
                    float f11 = i2;
                    float f12 = Math.min(k1, f8);
                    float f13 = i2;
                    c.setColor(d[l2]);
                    float f9;
                    int i3;
                    if (!m)
                    {
                        canvas.drawLine(f10, f11, f12, f13, c);
                    } else
                    if (k)
                    {
                        canvas.drawLine(f10 + (float)k1, f11, f12 + (float)k1, f13, c);
                        canvas.drawLine((float)k1 - f10, f11, (float)k1 - f12, f13, c);
                    } else
                    {
                        canvas.drawLine(f10, f11, f12, f13, c);
                        canvas.drawLine((float)(k1 * 2) - f10, f11, (float)(k1 * 2) - f12, f13, c);
                    }
                    canvas.save();
                }
                f9 = f8 + f6;
                i3 = l2 + 1;
                if (i3 >= d.length)
                {
                    i3 = 0;
                }
                k2++;
                l2 = i3;
                f2 = f9;
            }
            return;
        } while (true);
    }

    public final int getOpacity()
    {
        return -2;
    }

    public final boolean isRunning()
    {
        return f;
    }

    public final void scheduleSelf(Runnable runnable, long l1)
    {
        f = true;
        super.scheduleSelf(runnable, l1);
    }

    public final void setAlpha(int i1)
    {
        c.setAlpha(i1);
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        c.setColorFilter(colorfilter);
    }

    public final void start()
    {
        if (isRunning())
        {
            return;
        } else
        {
            scheduleSelf(o, 16L + SystemClock.uptimeMillis());
            invalidateSelf();
            return;
        }
    }

    public final void stop()
    {
        if (!isRunning())
        {
            return;
        } else
        {
            f = false;
            unscheduleSelf(o);
            return;
        }
    }
}
