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
//            c, e, p, f, 
//            i, g, j, q

public class UnderlinePageIndicator extends View
    implements c
{

    private final Paint a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private ViewPager g;
    private bb h;
    private int i;
    private int j;
    private float k;
    private int l;
    private float m;
    private int n;
    private boolean o;
    private final Runnable p;

    public UnderlinePageIndicator(Context context)
    {
        this(context, null);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, e.vpiUnderlinePageIndicatorStyle);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = new Paint(1);
        f = 0;
        m = -1F;
        n = -1;
        p = new p(this);
        if (isInEditMode())
        {
            return;
        }
        Resources resources = getResources();
        boolean flag = resources.getBoolean(f.default_underline_indicator_fades);
        int j1 = resources.getInteger(i.default_underline_indicator_fade_delay);
        int k1 = resources.getInteger(i.default_underline_indicator_fade_length);
        int l1 = resources.getColor(g.default_underline_indicator_selected_color);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, j.UnderlinePageIndicator, i1, 0);
        setFades(typedarray.getBoolean(2, flag));
        setSelectedColor(typedarray.getColor(1, l1));
        setFadeDelay(typedarray.getInteger(3, j1));
        setFadeLength(typedarray.getInteger(4, k1));
        android.graphics.drawable.Drawable drawable = typedarray.getDrawable(0);
        if (drawable != null)
        {
            setBackgroundDrawable(drawable);
        }
        typedarray.recycle();
        l = ap.a(ViewConfiguration.get(context));
    }

    static boolean a(UnderlinePageIndicator underlinepageindicator)
    {
        return underlinepageindicator.b;
    }

    static Paint b(UnderlinePageIndicator underlinepageindicator)
    {
        return underlinepageindicator.a;
    }

    static int c(UnderlinePageIndicator underlinepageindicator)
    {
        return underlinepageindicator.e;
    }

    static Runnable d(UnderlinePageIndicator underlinepageindicator)
    {
        return underlinepageindicator.p;
    }

    public final void a(int i1)
    {
        if (i == 0)
        {
            j = i1;
            k = 0.0F;
            invalidate();
            p.run();
        }
        if (h != null)
        {
            h.a(i1);
        }
    }

    public final void a(int i1, float f1, int j1)
    {
        j = i1;
        k = f1;
        if (!b) goto _L2; else goto _L1
_L1:
        if (j1 <= 0) goto _L4; else goto _L3
_L3:
        removeCallbacks(p);
        a.setAlpha(255);
_L2:
        invalidate();
        if (h != null)
        {
            h.a(i1, f1, j1);
        }
        return;
_L4:
        if (i != 1)
        {
            postDelayed(p, c);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final void b(int i1)
    {
        i = i1;
        if (h != null)
        {
            h.b(i1);
        }
    }

    public int getFadeDelay()
    {
        return c;
    }

    public int getFadeLength()
    {
        return d;
    }

    public boolean getFades()
    {
        return b;
    }

    public int getSelectedColor()
    {
        return a.getColor();
    }

    public int getThumbWidth()
    {
        return f;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i1;
        if (g != null)
        {
            if ((i1 = g.getAdapter().getCount()) != 0)
            {
                if (j >= i1)
                {
                    setCurrentItem(i1 - 1);
                    return;
                }
                int j1 = getPaddingLeft();
                float f1 = (float)(getWidth() - j1 - getPaddingRight()) / (1.0F * (float)i1);
                float f2;
                float f3;
                if (f == 0)
                {
                    f2 = (float)j1 + f1 * ((float)j + k);
                } else
                {
                    f2 = ((float)(getWidth() - f) / (float)(i1 - 1)) * (float)j;
                }
                if (f == 0)
                {
                    f3 = f2 + f1;
                } else
                {
                    f3 = f2 + (float)f;
                }
                canvas.drawRect(f2, getPaddingTop(), f3, getHeight() - getPaddingBottom(), a);
                return;
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        j = savedstate.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = j;
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!super.onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int i1;
        if (g == null || g.getAdapter().getCount() == 0)
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
        n = w.b(motionevent, 0);
        m = motionevent.getX();
        return true;
_L6:
        float f3 = w.c(motionevent, w.a(motionevent, n));
        float f4 = f3 - m;
        if (!o && Math.abs(f4) > (float)l)
        {
            o = true;
        }
        if (o)
        {
            m = f3;
            if (g.isFakeDragging() || g.beginFakeDrag())
            {
                g.fakeDragBy(f4);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (o)
        {
            break; /* Loop/switch isn't completed */
        }
        int i2 = g.getAdapter().getCount();
        int j2 = getWidth();
        float f1 = (float)j2 / 2.0F;
        float f2 = (float)j2 / 6F;
        if (j > 0 && motionevent.getX() < f1 - f2)
        {
            if (i1 != 3)
            {
                g.setCurrentItem(-1 + j);
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (j >= i2 - 1 || motionevent.getX() <= f2 + f1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i1 != 3)
        {
            g.setCurrentItem(1 + j);
            return true;
        }
        if (true) goto _L1; else goto _L9
_L9:
        o = false;
        n = -1;
        if (g.isFakeDragging())
        {
            g.endFakeDrag();
            return true;
        }
          goto _L1
_L7:
        int l1 = w.b(motionevent);
        m = w.c(motionevent, l1);
        n = w.b(motionevent, l1);
        return true;
_L8:
        int j1 = w.b(motionevent);
        if (w.b(motionevent, j1) == n)
        {
            int k1 = 0;
            if (j1 == 0)
            {
                k1 = 1;
            }
            n = w.b(motionevent, k1);
        }
        m = w.c(motionevent, w.a(motionevent, n));
        return true;
    }

    public void setCurrentItem(int i1)
    {
        if (g == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        } else
        {
            g.setCurrentItem(i1);
            j = i1;
            invalidate();
            return;
        }
    }

    public void setFadeDelay(int i1)
    {
        c = i1;
    }

    public void setFadeLength(int i1)
    {
        d = i1;
        e = 255 / (d / 30);
    }

    public void setFades(boolean flag)
    {
label0:
        {
            if (flag != b)
            {
                b = flag;
                if (!flag)
                {
                    break label0;
                }
                post(p);
            }
            return;
        }
        removeCallbacks(p);
        a.setAlpha(255);
        invalidate();
    }

    public void setOnPageChangeListener(bb bb1)
    {
        h = bb1;
    }

    public void setSelectedColor(int i1)
    {
        a.setColor(i1);
        invalidate();
    }

    public void setThumbWidth(int i1)
    {
        f = i1;
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (g == viewpager)
        {
            return;
        }
        if (g != null)
        {
            g.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            g = viewpager;
            g.setOnPageChangeListener(this);
            invalidate();
            post(new q(this));
            return;
        }
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new r();
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
