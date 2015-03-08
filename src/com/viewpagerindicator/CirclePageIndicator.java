// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.aa;
import android.support.v4.view.ap;
import android.support.v4.view.bb;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package com.viewpagerindicator:
//            c, e, g, i, 
//            h, f, j

public class CirclePageIndicator extends View
    implements c
{

    private float a;
    private float b;
    private final Paint c;
    private final Paint d;
    private final Paint e;
    private ViewPager f;
    private bb g;
    private int h;
    private int i;
    private float j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private int o;
    private float p;
    private int q;
    private boolean r;

    public CirclePageIndicator(Context context)
    {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, e.vpiCirclePageIndicatorStyle);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        c = new Paint(1);
        d = new Paint(1);
        e = new Paint(1);
        p = -1F;
        q = -1;
        if (isInEditMode())
        {
            return;
        }
        Resources resources = getResources();
        int j1 = resources.getColor(g.default_circle_indicator_page_color);
        int k1 = resources.getColor(g.default_circle_indicator_fill_color);
        int l1 = resources.getInteger(i.default_circle_indicator_orientation);
        int i2 = resources.getColor(g.default_circle_indicator_stroke_color);
        float f1 = resources.getDimension(h.default_circle_indicator_stroke_width);
        float f2 = resources.getDimension(h.default_circle_indicator_radius);
        float f3 = resources.getDimension(h.default_circle_indicator_gap);
        boolean flag = resources.getBoolean(f.default_circle_indicator_centered);
        boolean flag1 = resources.getBoolean(f.default_circle_indicator_snap);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, j.CirclePageIndicator, i1, 0);
        m = typedarray.getBoolean(2, flag);
        l = typedarray.getInt(0, l1);
        c.setStyle(android.graphics.Paint.Style.FILL);
        c.setColor(typedarray.getColor(5, j1));
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setColor(typedarray.getColor(9, i2));
        d.setStrokeWidth(typedarray.getDimension(3, f1));
        e.setStyle(android.graphics.Paint.Style.FILL);
        e.setColor(typedarray.getColor(4, k1));
        a = typedarray.getDimension(6, f2);
        b = typedarray.getDimension(7, f3);
        n = typedarray.getBoolean(8, flag1);
        android.graphics.drawable.Drawable drawable = typedarray.getDrawable(1);
        if (drawable != null)
        {
            setBackgroundDrawable(drawable);
        }
        typedarray.recycle();
        o = ap.a(ViewConfiguration.get(context));
    }

    private int c(int i1)
    {
        int j1 = android.view.View.MeasureSpec.getMode(i1);
        int k1 = android.view.View.MeasureSpec.getSize(i1);
        int l1;
        if (j1 == 0x40000000 || f == null)
        {
            l1 = k1;
        } else
        {
            int i2 = f.getAdapter().getCount();
            l1 = (int)(1.0F + ((float)(getPaddingLeft() + getPaddingRight()) + (float)(i2 * 2) * a + (float)(i2 - 1) * a));
            if (j1 == 0x80000000)
            {
                return Math.min(l1, k1);
            }
        }
        return l1;
    }

    private int d(int i1)
    {
        int j1 = android.view.View.MeasureSpec.getMode(i1);
        int k1 = android.view.View.MeasureSpec.getSize(i1);
        if (j1 == 0x40000000)
        {
            return k1;
        }
        int l1 = (int)(1.0F + (2.0F * a + (float)getPaddingTop() + (float)getPaddingBottom()));
        if (j1 == 0x80000000)
        {
            return Math.min(l1, k1);
        } else
        {
            return l1;
        }
    }

    public final void a(int i1)
    {
        if (n || k == 0)
        {
            h = i1;
            i = i1;
            invalidate();
        }
        if (g != null)
        {
            g.a(i1);
        }
    }

    public final void a(int i1, float f1, int j1)
    {
        h = i1;
        j = f1;
        invalidate();
        if (g != null)
        {
            g.a(i1, f1, j1);
        }
    }

    public final void b(int i1)
    {
        k = i1;
        if (g != null)
        {
            g.b(i1);
        }
    }

    public int getFillColor()
    {
        return e.getColor();
    }

    public float getGapSize()
    {
        return b;
    }

    public int getOrientation()
    {
        return l;
    }

    public int getPageColor()
    {
        return c.getColor();
    }

    public float getRadius()
    {
        return a;
    }

    public int getStrokeColor()
    {
        return d.getColor();
    }

    public float getStrokeWidth()
    {
        return d.getStrokeWidth();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i1;
        if (f != null)
        {
            if ((i1 = f.getAdapter().getCount()) != 0)
            {
                if (h >= i1)
                {
                    setCurrentItem(i1 - 1);
                    return;
                }
                int j1;
                int k1;
                int l1;
                int i2;
                float f1;
                float f2;
                float f3;
                float f4;
                int j2;
                if (l == 0)
                {
                    j1 = getWidth();
                    k1 = getPaddingLeft();
                    l1 = getPaddingRight();
                    i2 = getPaddingTop();
                } else
                {
                    j1 = getHeight();
                    k1 = getPaddingTop();
                    l1 = getPaddingBottom();
                    i2 = getPaddingLeft();
                }
                f1 = 3F * a + b;
                f2 = (float)i2 + a;
                f3 = (float)k1 + a + b;
                if (m)
                {
                    f3 += (float)(j1 - k1 - l1) / 2.0F - (f1 * (float)i1) / 2.0F;
                }
                f4 = a;
                if (d.getStrokeWidth() > 0.0F)
                {
                    f4 -= d.getStrokeWidth() / 2.0F;
                }
                j2 = 0;
                while (j2 < i1) 
                {
                    float f8 = f3 + f1 * (float)j2;
                    float f9;
                    if (l == 0)
                    {
                        f9 = f8;
                        f8 = f2;
                    } else
                    {
                        f9 = f2;
                    }
                    if (c.getAlpha() > 0)
                    {
                        canvas.drawCircle(f9, f8, f4, c);
                    }
                    if (f4 != a)
                    {
                        canvas.drawCircle(f9, f8, a, d);
                    }
                    j2++;
                }
                int k2;
                float f5;
                float f7;
                if (n)
                {
                    k2 = i;
                } else
                {
                    k2 = h;
                }
                f5 = f1 * (float)k2;
                if (!n)
                {
                    f5 += f1 * j;
                }
                if (l == 0)
                {
                    f7 = f3 + f5;
                } else
                {
                    float f6 = f3 + f5;
                    f7 = f2;
                    f2 = f6;
                }
                canvas.drawCircle(f7, f2, a, e);
                return;
            }
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        if (l == 0)
        {
            setMeasuredDimension(c(i1), d(j1));
            return;
        } else
        {
            setMeasuredDimension(d(i1), c(j1));
            return;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        h = savedstate.a;
        i = savedstate.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = h;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!super.onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int i1;
        if (f == null || f.getAdapter().getCount() == 0)
        {
            return false;
        }
        i1 = 0xff & motionevent.getAction();
        i1;
        JVM INSTR tableswitch 0 6: default 84
    //                   0 86
    //                   1 198
    //                   2 105
    //                   3 198
    //                   4 84
    //                   5 352
    //                   6 380;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L7 _L8
_L3:
        return true;
_L4:
        q = w.b(motionevent, 0);
        p = motionevent.getX();
        return true;
_L6:
        float f3 = w.c(motionevent, w.a(motionevent, q));
        float f4 = f3 - p;
        if (!r && Math.abs(f4) > (float)o)
        {
            r = true;
        }
        if (r)
        {
            p = f3;
            if (f.isFakeDragging() || f.beginFakeDrag())
            {
                f.fakeDragBy(f4);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (r)
        {
            break; /* Loop/switch isn't completed */
        }
        int i2 = f.getAdapter().getCount();
        int j2 = getWidth();
        float f1 = (float)j2 / 2.0F;
        float f2 = (float)j2 / 6F;
        if (h > 0 && motionevent.getX() < f1 - f2)
        {
            if (i1 != 3)
            {
                f.setCurrentItem(-1 + h);
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (h >= i2 - 1 || motionevent.getX() <= f2 + f1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i1 != 3)
        {
            f.setCurrentItem(1 + h);
            return true;
        }
        if (true) goto _L1; else goto _L9
_L9:
        r = false;
        q = -1;
        if (f.isFakeDragging())
        {
            f.endFakeDrag();
            return true;
        }
          goto _L1
_L7:
        int l1 = w.b(motionevent);
        p = w.c(motionevent, l1);
        q = w.b(motionevent, l1);
        return true;
_L8:
        int j1 = w.b(motionevent);
        if (w.b(motionevent, j1) == q)
        {
            int k1 = 0;
            if (j1 == 0)
            {
                k1 = 1;
            }
            q = w.b(motionevent, k1);
        }
        p = w.c(motionevent, w.a(motionevent, q));
        return true;
    }

    public void setCentered(boolean flag)
    {
        m = flag;
        invalidate();
    }

    public void setCurrentItem(int i1)
    {
        if (f == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        } else
        {
            f.setCurrentItem(i1);
            h = i1;
            invalidate();
            return;
        }
    }

    public void setFillColor(int i1)
    {
        e.setColor(i1);
        invalidate();
    }

    public void setGap(float f1)
    {
        b = f1;
        invalidate();
    }

    public void setOnPageChangeListener(bb bb1)
    {
        g = bb1;
    }

    public void setOrientation(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");

        case 0: // '\0'
        case 1: // '\001'
            l = i1;
            break;
        }
        requestLayout();
    }

    public void setPageColor(int i1)
    {
        c.setColor(i1);
        invalidate();
    }

    public void setRadius(float f1)
    {
        a = f1;
        invalidate();
    }

    public void setSnap(boolean flag)
    {
        n = flag;
        invalidate();
    }

    public void setStrokeColor(int i1)
    {
        d.setColor(i1);
        invalidate();
    }

    public void setStrokeWidth(float f1)
    {
        d.setStrokeWidth(f1);
        invalidate();
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (f == viewpager)
        {
            return;
        }
        if (f != null)
        {
            f.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            f = viewpager;
            f.setOnPageChangeListener(this);
            invalidate();
            return;
        }
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new a();
        int a;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readInt();
        }

        SavedState(Parcel parcel, byte byte0)
        {
            this(parcel);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
