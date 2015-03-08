// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.aa;
import android.support.v4.view.bb;
import android.support.v4.view.w;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.viewpagerindicator:
//            c, m, k, l, 
//            n

public final class TitlePageIndicator extends View
    implements c
{

    private n A;
    private ViewPager a;
    private bb b;
    private int c;
    private float d;
    private int e;
    private final Paint f;
    private boolean g;
    private int h;
    private int i;
    private Path j;
    private final Rect k;
    private final Paint l;
    private l m;
    private m n;
    private final Paint o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private int w;
    private float x;
    private int y;
    private boolean z;

    private void a(Rect rect, float f1, int i1)
    {
        rect.right = (int)((float)i1 - u);
        rect.left = (int)((float)rect.right - f1);
    }

    private void b(Rect rect, float f1, int i1)
    {
        rect.left = (int)((float)i1 + u);
        rect.right = (int)(f1 + u);
    }

    private CharSequence c(int i1)
    {
        Object obj = a.getAdapter().getPageTitle(i1);
        if (obj == null)
        {
            obj = "";
        }
        return ((CharSequence) (obj));
    }

    public final void a(int i1)
    {
        if (e == 0)
        {
            c = i1;
            invalidate();
        }
        if (b != null)
        {
            b.a(i1);
        }
    }

    public final void a(int i1, float f1, int j1)
    {
        c = i1;
        d = f1;
        invalidate();
        if (b != null)
        {
            b.a(i1, f1, j1);
        }
    }

    public final void b(int i1)
    {
        e = i1;
        if (b != null)
        {
            b.b(i1);
        }
    }

    public final float getClipPadding()
    {
        return u;
    }

    public final int getFooterColor()
    {
        return l.getColor();
    }

    public final float getFooterIndicatorHeight()
    {
        return p;
    }

    public final float getFooterIndicatorPadding()
    {
        return r;
    }

    public final l getFooterIndicatorStyle()
    {
        return m;
    }

    public final float getFooterLineHeight()
    {
        return v;
    }

    public final m getLinePosition()
    {
        return n;
    }

    public final int getSelectedColor()
    {
        return i;
    }

    public final int getTextColor()
    {
        return h;
    }

    public final float getTextSize()
    {
        return f.getTextSize();
    }

    public final float getTitlePadding()
    {
        return s;
    }

    public final float getTopPadding()
    {
        return t;
    }

    public final Typeface getTypeface()
    {
        return f.getTypeface();
    }

    protected final void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i1;
        if (a != null)
        {
            if ((i1 = a.getAdapter().getCount()) != 0)
            {
                if (c == -1 && a != null)
                {
                    c = a.getCurrentItem();
                }
                Paint paint = f;
                ArrayList arraylist = new ArrayList();
                int j1 = a.getAdapter().getCount();
                int k1 = getWidth();
                int l1 = k1 / 2;
                for (int i2 = 0; i2 < j1; i2++)
                {
                    Rect rect = new Rect();
                    CharSequence charsequence = c(i2);
                    rect.right = (int)paint.measureText(charsequence, 0, charsequence.length());
                    rect.bottom = (int)(paint.descent() - paint.ascent());
                    int j2 = rect.right - rect.left;
                    int k2 = rect.bottom - rect.top;
                    rect.left = (int)(((float)l1 - (float)j2 / 2.0F) + ((float)(i2 - c) - d) * (float)k1);
                    rect.right = j2 + rect.left;
                    rect.top = 0;
                    rect.bottom = k2;
                    arraylist.add(rect);
                }

                int l2 = arraylist.size();
                if (c >= l2)
                {
                    setCurrentItem(l2 - 1);
                    return;
                }
                int i3 = i1 - 1;
                float f1 = (float)getWidth() / 2.0F;
                int j3 = getLeft();
                float f2 = (float)j3 + u;
                int k3 = getWidth();
                int l3 = getHeight();
                int i4 = j3 + k3;
                float f3 = (float)i4 - u;
                int j4 = c;
                int l4;
                float f5;
                boolean flag;
                boolean flag1;
                float f6;
                Rect rect1;
                float f7;
                if ((double)d <= 0.5D)
                {
                    float f18 = d;
                    l4 = j4;
                    f5 = f18;
                } else
                {
                    int k4 = j4 + 1;
                    float f4 = 1.0F - d;
                    l4 = k4;
                    f5 = f4;
                }
                if (f5 <= 0.25F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (f5 <= 0.05F)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                f6 = (0.25F - f5) / 0.25F;
                rect1 = (Rect)arraylist.get(c);
                f7 = rect1.right - rect1.left;
                if ((float)rect1.left < f2)
                {
                    b(rect1, f7, j3);
                }
                if ((float)rect1.right > f3)
                {
                    a(rect1, f7, i4);
                }
                if (c > 0)
                {
                    for (int k6 = -1 + c; k6 >= 0; k6--)
                    {
                        Rect rect7 = (Rect)arraylist.get(k6);
                        if ((float)rect7.left >= f2)
                        {
                            continue;
                        }
                        int l6 = rect7.right - rect7.left;
                        b(rect7, l6, j3);
                        Rect rect8 = (Rect)arraylist.get(k6 + 1);
                        if ((float)rect7.right + s > (float)rect8.left)
                        {
                            rect7.left = (int)((float)(rect8.left - l6) - s);
                            rect7.right = l6 + rect7.left;
                        }
                    }

                }
                if (c < i3)
                {
                    for (int i6 = 1 + c; i6 < i1; i6++)
                    {
                        Rect rect5 = (Rect)arraylist.get(i6);
                        if ((float)rect5.right <= f3)
                        {
                            continue;
                        }
                        int j6 = rect5.right - rect5.left;
                        a(rect5, j6, i4);
                        Rect rect6 = (Rect)arraylist.get(i6 - 1);
                        if ((float)rect5.left - s < (float)rect6.right)
                        {
                            rect5.left = (int)((float)rect6.right + s);
                            rect5.right = j6 + rect5.left;
                        }
                    }

                }
                int i5 = h >>> 24;
                int j5 = 0;
                while (j5 < i1) 
                {
                    Rect rect3 = (Rect)arraylist.get(j5);
                    if ((rect3.left <= j3 || rect3.left >= i4) && (rect3.right <= j3 || rect3.right >= i4))
                    {
                        continue;
                    }
                    boolean flag2;
                    CharSequence charsequence1;
                    Paint paint1;
                    boolean flag3;
                    if (j5 == l4)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    charsequence1 = c(j5);
                    paint1 = f;
                    if (flag2 && flag1 && g)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    paint1.setFakeBoldText(flag3);
                    f.setColor(h);
                    if (flag2 && flag)
                    {
                        f.setAlpha(i5 - (int)(f6 * (float)i5));
                    }
                    if (j5 < l2 - 1)
                    {
                        Rect rect4 = (Rect)arraylist.get(j5 + 1);
                        if ((float)rect3.right + s > (float)rect4.left)
                        {
                            int l5 = rect3.right - rect3.left;
                            rect3.left = (int)((float)(rect4.left - l5) - s);
                            rect3.right = l5 + rect3.left;
                        }
                    }
                    canvas.drawText(charsequence1, 0, charsequence1.length(), rect3.left, (float)rect3.bottom + t, f);
                    if (flag2 && flag)
                    {
                        f.setColor(i);
                        f.setAlpha((int)(f6 * (float)(i >>> 24)));
                        canvas.drawText(charsequence1, 0, charsequence1.length(), rect3.left, (float)rect3.bottom + t, f);
                    }
                    j5++;
                }
                float f8 = v;
                float f9 = p;
                int k5;
                float f10;
                float f11;
                float f12;
                if (n == m.b)
                {
                    k5 = 0;
                    float f16 = -f8;
                    float f17 = -f9;
                    f11 = f16;
                    f10 = f17;
                } else
                {
                    k5 = l3;
                    f10 = f9;
                    f11 = f8;
                }
                j.reset();
                j.moveTo(0.0F, (float)k5 - f11 / 2.0F);
                j.lineTo(k3, (float)k5 - f11 / 2.0F);
                j.close();
                canvas.drawPath(j, l);
                f12 = (float)k5 - f11;
                switch (k.a[m.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    j.reset();
                    j.moveTo(f1, f12 - f10);
                    j.lineTo(f1 + f10, f12);
                    j.lineTo(f1 - f10, f12);
                    j.close();
                    canvas.drawPath(j, o);
                    return;

                case 2: // '\002'
                    break;
                }
                if (flag && l4 < l2)
                {
                    Rect rect2 = (Rect)arraylist.get(l4);
                    float f13 = (float)rect2.right + q;
                    float f14 = (float)rect2.left - q;
                    float f15 = f12 - f10;
                    j.reset();
                    j.moveTo(f14, f12);
                    j.lineTo(f13, f12);
                    j.lineTo(f13, f15);
                    j.lineTo(f14, f15);
                    j.close();
                    o.setAlpha((int)(255F * f6));
                    canvas.drawPath(j, o);
                    o.setAlpha(255);
                    return;
                }
            }
        }
    }

    protected final void onMeasure(int i1, int j1)
    {
        int k1 = android.view.View.MeasureSpec.getSize(i1);
        if (android.view.View.MeasureSpec.getMode(j1) != 0x40000000) goto _L2; else goto _L1
_L1:
        float f1 = android.view.View.MeasureSpec.getSize(j1);
_L4:
        setMeasuredDimension(k1, (int)f1);
        return;
_L2:
        k.setEmpty();
        k.bottom = (int)(f.descent() - f.ascent());
        f1 = (float)(k.bottom - k.top) + v + r + t;
        if (m != l.a)
        {
            f1 += p;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        c = savedstate.a;
        requestLayout();
    }

    public final Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = c;
        return savedstate;
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!super.onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int i1;
        if (a == null || a.getAdapter().getCount() == 0)
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
    //                   5 384
    //                   6 412;
           goto _L3 _L4 _L5 _L6 _L5 _L3 _L7 _L8
_L3:
        return true;
_L4:
        y = android.support.v4.view.w.b(motionevent, 0);
        x = motionevent.getX();
        return true;
_L6:
        float f6 = android.support.v4.view.w.c(motionevent, android.support.v4.view.w.a(motionevent, y));
        float f7 = f6 - x;
        if (!z && Math.abs(f7) > (float)w)
        {
            z = true;
        }
        if (z)
        {
            x = f6;
            if (a.isFakeDragging() || a.beginFakeDrag())
            {
                a.fakeDragBy(f7);
                return true;
            }
        }
          goto _L1
_L5:
        int i2;
        float f3;
        float f4;
        float f5;
        if (z)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        i2 = a.getAdapter().getCount();
        int j2 = getWidth();
        float f1 = (float)j2 / 2.0F;
        float f2 = (float)j2 / 6F;
        f3 = f1 - f2;
        f4 = f2 + f1;
        f5 = motionevent.getX();
        if (f5 >= f3) goto _L10; else goto _L9
_L9:
        if (c <= 0)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        if (i1 != 3)
        {
            a.setCurrentItem(-1 + c);
            return true;
        }
          goto _L1
_L10:
        if (f5 <= f4) goto _L12; else goto _L11
_L11:
        if (c >= i2 - 1)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        if (i1 != 3)
        {
            a.setCurrentItem(1 + c);
            return true;
        }
          goto _L1
_L12:
        if (A != null && i1 != 3)
        {
            A;
            c;
        }
        z = false;
        y = -1;
        if (a.isFakeDragging())
        {
            a.endFakeDrag();
            return true;
        }
          goto _L1
_L7:
        int l1 = android.support.v4.view.w.b(motionevent);
        x = android.support.v4.view.w.c(motionevent, l1);
        y = android.support.v4.view.w.b(motionevent, l1);
        return true;
_L8:
        int j1 = android.support.v4.view.w.b(motionevent);
        if (android.support.v4.view.w.b(motionevent, j1) == y)
        {
            int k1 = 0;
            if (j1 == 0)
            {
                k1 = 1;
            }
            y = android.support.v4.view.w.b(motionevent, k1);
        }
        x = android.support.v4.view.w.c(motionevent, android.support.v4.view.w.a(motionevent, y));
        return true;
    }

    public final void setClipPadding(float f1)
    {
        u = f1;
        invalidate();
    }

    public final void setCurrentItem(int i1)
    {
        if (a == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        } else
        {
            a.setCurrentItem(i1);
            c = i1;
            invalidate();
            return;
        }
    }

    public final void setFooterColor(int i1)
    {
        l.setColor(i1);
        o.setColor(i1);
        invalidate();
    }

    public final void setFooterIndicatorHeight(float f1)
    {
        p = f1;
        invalidate();
    }

    public final void setFooterIndicatorPadding(float f1)
    {
        r = f1;
        invalidate();
    }

    public final void setFooterIndicatorStyle(l l1)
    {
        m = l1;
        invalidate();
    }

    public final void setFooterLineHeight(float f1)
    {
        v = f1;
        l.setStrokeWidth(v);
        invalidate();
    }

    public final void setLinePosition(m m1)
    {
        n = m1;
        invalidate();
    }

    public final void setOnCenterItemClickListener(n n1)
    {
        A = n1;
    }

    public final void setOnPageChangeListener(bb bb1)
    {
        b = bb1;
    }

    public final void setSelectedBold(boolean flag)
    {
        g = flag;
        invalidate();
    }

    public final void setSelectedColor(int i1)
    {
        i = i1;
        invalidate();
    }

    public final void setTextColor(int i1)
    {
        f.setColor(i1);
        h = i1;
        invalidate();
    }

    public final void setTextSize(float f1)
    {
        f.setTextSize(f1);
        invalidate();
    }

    public final void setTitlePadding(float f1)
    {
        s = f1;
        invalidate();
    }

    public final void setTopPadding(float f1)
    {
        t = f1;
        invalidate();
    }

    public final void setTypeface(Typeface typeface)
    {
        f.setTypeface(typeface);
        invalidate();
    }

    public final void setViewPager(ViewPager viewpager)
    {
        if (a == viewpager)
        {
            return;
        }
        if (a != null)
        {
            a.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            a = viewpager;
            a.setOnPageChangeListener(this);
            invalidate();
            return;
        }
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new o();
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
