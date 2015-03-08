// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

// Referenced classes of package uk.co.senab.photoview:
//            r, n, m, c, 
//            o, p, d, PhotoView, 
//            e, f, i, g, 
//            h

public final class b
    implements android.view.GestureDetector.OnDoubleTapListener, android.view.View.OnTouchListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, r
{

    static final boolean a = Log.isLoggable("PhotoViewAttacher", 3);
    private float b;
    private float c;
    private float d;
    private boolean e;
    private WeakReference f;
    private ViewTreeObserver g;
    private GestureDetector h;
    private m i;
    private final Matrix j = new Matrix();
    private final Matrix k = new Matrix();
    private final Matrix l = new Matrix();
    private final RectF m = new RectF();
    private final float n[] = new float[9];
    private g o;
    private h p;
    private i q;
    private android.view.View.OnLongClickListener r;
    private int s;
    private int t;
    private int u;
    private int v;
    private f w;
    private int x;
    private boolean y;
    private android.widget.ImageView.ScaleType z;

    public b(ImageView imageview)
    {
        b = 1.0F;
        c = 1.75F;
        d = 3F;
        e = true;
        x = 2;
        z = android.widget.ImageView.ScaleType.FIT_CENTER;
        f = new WeakReference(imageview);
        imageview.setOnTouchListener(this);
        g = imageview.getViewTreeObserver();
        g.addOnGlobalLayoutListener(this);
        b(imageview);
        if (!imageview.isInEditMode())
        {
            android.content.Context context = imageview.getContext();
            int i1 = android.os.Build.VERSION.SDK_INT;
            Object obj;
            if (i1 < 5)
            {
                obj = new n(context);
            } else
            if (i1 < 8)
            {
                obj = new o(context);
            } else
            {
                obj = new p(context);
            }
            obj.a = this;
            i = ((m) (obj));
            h = new GestureDetector(imageview.getContext(), new c(this));
            h.setOnDoubleTapListener(this);
            b(true);
        }
    }

    private RectF a(Matrix matrix)
    {
        ImageView imageview = c();
        if (imageview != null)
        {
            Drawable drawable = imageview.getDrawable();
            if (drawable != null)
            {
                m.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                matrix.mapRect(m);
                return m;
            }
        }
        return null;
    }

    static android.view.View.OnLongClickListener a(b b1)
    {
        return b1.r;
    }

    private void a(Drawable drawable)
    {
        float f1;
        float f2;
        int i1;
        int j1;
        float f3;
        float f4;
        ImageView imageview = c();
        if (imageview == null || drawable == null)
        {
            return;
        }
        f1 = imageview.getWidth();
        f2 = imageview.getHeight();
        i1 = drawable.getIntrinsicWidth();
        j1 = drawable.getIntrinsicHeight();
        j.reset();
        f3 = f1 / (float)i1;
        f4 = f2 / (float)j1;
        if (z != android.widget.ImageView.ScaleType.CENTER) goto _L2; else goto _L1
_L1:
        j.postTranslate((f1 - (float)i1) / 2.0F, (f2 - (float)j1) / 2.0F);
_L4:
        m();
        return;
_L2:
        if (z == android.widget.ImageView.ScaleType.CENTER_CROP)
        {
            float f6 = Math.max(f3, f4);
            j.postScale(f6, f6);
            j.postTranslate((f1 - f6 * (float)i1) / 2.0F, (f2 - f6 * (float)j1) / 2.0F);
            continue; /* Loop/switch isn't completed */
        }
        if (z != android.widget.ImageView.ScaleType.CENTER_INSIDE)
        {
            break; /* Loop/switch isn't completed */
        }
        float f5 = Math.min(1.0F, Math.min(f3, f4));
        j.postScale(f5, f5);
        j.postTranslate((f1 - f5 * (float)i1) / 2.0F, (f2 - f5 * (float)j1) / 2.0F);
        if (true) goto _L4; else goto _L3
_L3:
        RectF rectf = new RectF(0.0F, 0.0F, i1, j1);
        RectF rectf1 = new RectF(0.0F, 0.0F, f1, f2);
        switch (d.a[z.ordinal()])
        {
        case 2: // '\002'
            j.setRectToRect(rectf, rectf1, android.graphics.Matrix.ScaleToFit.START);
            break;

        case 4: // '\004'
            j.setRectToRect(rectf, rectf1, android.graphics.Matrix.ScaleToFit.CENTER);
            break;

        case 3: // '\003'
            j.setRectToRect(rectf, rectf1, android.graphics.Matrix.ScaleToFit.END);
            break;

        case 5: // '\005'
            j.setRectToRect(rectf, rectf1, android.graphics.Matrix.ScaleToFit.FILL);
            break;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    static void a(b b1, Matrix matrix)
    {
        b1.b(matrix);
    }

    private static boolean a(ImageView imageview)
    {
        return imageview != null && imageview.getDrawable() != null;
    }

    static WeakReference b(b b1)
    {
        return b1.f;
    }

    private static void b(float f1, float f2, float f3)
    {
        if (f1 >= f2)
        {
            throw new IllegalArgumentException("MinZoom should be less than MidZoom");
        }
        if (f2 >= f3)
        {
            throw new IllegalArgumentException("MidZoom should be less than MaxZoom");
        } else
        {
            return;
        }
    }

    private void b(Matrix matrix)
    {
        ImageView imageview = c();
        if (imageview != null)
        {
            ImageView imageview1 = c();
            if (imageview1 != null && !(imageview1 instanceof PhotoView) && imageview1.getScaleType() != android.widget.ImageView.ScaleType.MATRIX)
            {
                throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
            }
            imageview.setImageMatrix(matrix);
            if (o != null && a(matrix) != null)
            {
                g _tmp = o;
            }
        }
    }

    private static void b(ImageView imageview)
    {
        if (imageview != null && !(imageview instanceof PhotoView))
        {
            imageview.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        }
    }

    static Matrix c(b b1)
    {
        return b1.l;
    }

    private void c(float f1, float f2, float f3)
    {
        ImageView imageview = c();
        if (imageview != null)
        {
            imageview.post(new e(this, g(), f1, f2, f3));
        }
    }

    static void d(b b1)
    {
        b1.k();
    }

    private void k()
    {
        l();
        b(j());
    }

    private void l()
    {
        ImageView imageview = c();
        if (imageview != null) goto _L2; else goto _L1
_L1:
        RectF rectf;
        return;
_L2:
        if ((rectf = a(j())) == null) goto _L1; else goto _L3
_L3:
        float f1;
        float f2;
        int i1;
        f1 = rectf.height();
        f2 = rectf.width();
        i1 = imageview.getHeight();
        if (f1 > (float)i1) goto _L5; else goto _L4
_L4:
        d.a[z.ordinal()];
        JVM INSTR tableswitch 2 3: default 80
    //                   2 177
    //                   3 187;
           goto _L6 _L7 _L8
_L6:
        float f3 = ((float)i1 - f1) / 2.0F - rectf.top;
_L12:
        int j1;
        j1 = imageview.getWidth();
        if (f2 > (float)j1)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        d.a[z.ordinal()];
        JVM INSTR tableswitch 2 3: default 144
    //                   2 245
    //                   3 255;
           goto _L9 _L10 _L11
_L9:
        float f4 = ((float)j1 - f2) / 2.0F - rectf.left;
_L13:
        x = 2;
_L14:
        l.postTranslate(f4, f3);
        return;
_L7:
        f3 = -rectf.top;
          goto _L12
_L8:
        f3 = (float)i1 - f1 - rectf.top;
          goto _L12
_L5:
        if (rectf.top > 0.0F)
        {
            f3 = -rectf.top;
        } else
        if (rectf.bottom < (float)i1)
        {
            f3 = (float)i1 - rectf.bottom;
        } else
        {
            f3 = 0.0F;
        }
          goto _L12
_L10:
        f4 = -rectf.left;
          goto _L13
_L11:
        f4 = (float)j1 - f2 - rectf.left;
          goto _L13
        if (rectf.left > 0.0F)
        {
            x = 0;
            f4 = -rectf.left;
        } else
        if (rectf.right < (float)j1)
        {
            f4 = (float)j1 - rectf.right;
            x = 1;
        } else
        {
            x = -1;
            f4 = 0.0F;
        }
          goto _L14
    }

    private void m()
    {
        l.reset();
        b(j());
        l();
    }

    public final void a()
    {
        if (g != null && g.isAlive())
        {
            g.removeGlobalOnLayoutListener(this);
        }
        g = null;
        o = null;
        p = null;
        q = null;
        f = null;
    }

    public final void a(float f1)
    {
        b(f1, c, d);
        b = f1;
    }

    public final void a(float f1, float f2)
    {
        if (a)
        {
            Object aobj[] = new Object[2];
            aobj[0] = Float.valueOf(f1);
            aobj[1] = Float.valueOf(f2);
            Log.d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", aobj));
        }
        ImageView imageview = c();
        if (imageview != null && a(imageview))
        {
            l.postTranslate(f1, f2);
            k();
            if (e && !i.a() && (x == 2 || x == 0 && f1 >= 1.0F || x == 1 && f1 <= -1F))
            {
                imageview.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    public final void a(float f1, float f2, float f3)
    {
        if (a)
        {
            Object aobj[] = new Object[3];
            aobj[0] = Float.valueOf(f1);
            aobj[1] = Float.valueOf(f2);
            aobj[2] = Float.valueOf(f3);
            Log.d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", aobj));
        }
        if (a(c()) && (g() < d || f1 < 1.0F))
        {
            l.postScale(f1, f1, f2, f3);
            k();
        }
    }

    public final void a(float f1, float f2, float f3, float f4)
    {
        if (a)
        {
            Log.d("PhotoViewAttacher", (new StringBuilder("onFling. sX: ")).append(f1).append(" sY: ").append(f2).append(" Vx: ").append(f3).append(" Vy: ").append(f4).toString());
        }
        ImageView imageview = c();
        if (a(imageview))
        {
            w = new f(this, imageview.getContext());
            w.a(imageview.getWidth(), imageview.getHeight(), (int)f3, (int)f4);
            imageview.post(w);
        }
    }

    public final void a(android.view.View.OnLongClickListener onlongclicklistener)
    {
        r = onlongclicklistener;
    }

    public final void a(android.widget.ImageView.ScaleType scaletype)
    {
        if (scaletype != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        if (flag && scaletype != z)
        {
            z = scaletype;
            i();
        }
        return;
_L2:
        switch (d.a[scaletype.ordinal()])
        {
        default:
            flag = true;
            break;

        case 1: // '\001'
            throw new IllegalArgumentException((new StringBuilder()).append(scaletype.name()).append(" is not supported in PhotoView").toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(g g1)
    {
        o = g1;
    }

    public final void a(h h1)
    {
        p = h1;
    }

    public final void a(i i1)
    {
        q = i1;
    }

    public final void a(boolean flag)
    {
        e = flag;
    }

    public final RectF b()
    {
        l();
        return a(j());
    }

    public final void b(float f1)
    {
        b(b, f1, d);
        c = f1;
    }

    public final void b(boolean flag)
    {
        y = flag;
        i();
    }

    public final ImageView c()
    {
        WeakReference weakreference = f;
        ImageView imageview = null;
        if (weakreference != null)
        {
            imageview = (ImageView)f.get();
        }
        if (imageview == null)
        {
            a();
        }
        return imageview;
    }

    public final void c(float f1)
    {
        b(b, c, f1);
        d = f1;
    }

    public final float d()
    {
        return b;
    }

    public final float e()
    {
        return c;
    }

    public final float f()
    {
        return d;
    }

    public final float g()
    {
        l.getValues(n);
        return n[0];
    }

    public final android.widget.ImageView.ScaleType h()
    {
        return z;
    }

    public final void i()
    {
label0:
        {
            ImageView imageview = c();
            if (imageview != null)
            {
                if (!y)
                {
                    break label0;
                }
                b(imageview);
                a(imageview.getDrawable());
            }
            return;
        }
        m();
    }

    protected final Matrix j()
    {
        k.set(j);
        k.postConcat(l);
        return k;
    }

    public final boolean onDoubleTap(MotionEvent motionevent)
    {
        float f1;
        float f2;
        float f3;
        f1 = g();
        f2 = motionevent.getX();
        f3 = motionevent.getY();
        if (f1 < c)
        {
            c(c, f2, f3);
            break MISSING_BLOCK_LABEL_86;
        }
        if (f1 >= c && f1 < d)
        {
            c(d, f2, f3);
            break MISSING_BLOCK_LABEL_86;
        }
        try
        {
            c(b, f2, f3);
        }
        catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) { }
        return true;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionevent)
    {
        return false;
    }

    public final void onGlobalLayout()
    {
        ImageView imageview = c();
        if (imageview != null && y)
        {
            int i1 = imageview.getTop();
            int j1 = imageview.getRight();
            int k1 = imageview.getBottom();
            int l1 = imageview.getLeft();
            if (i1 != s || k1 != u || l1 != v || j1 != t)
            {
                a(imageview.getDrawable());
                s = i1;
                t = j1;
                u = k1;
                v = l1;
            }
        }
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (c() != null)
        {
            if (p != null)
            {
                RectF rectf = b();
                if (rectf != null && rectf.contains(motionevent.getX(), motionevent.getY()))
                {
                    float _tmp = rectf.left;
                    rectf.width();
                    float _tmp1 = rectf.top;
                    rectf.height();
                    h _tmp2 = p;
                    return true;
                }
            }
            if (q != null)
            {
                i i1 = q;
                motionevent.getX();
                motionevent.getY();
                i1.a();
            }
        }
        return false;
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag;
        boolean flag1;
        flag = y;
        flag1 = false;
        if (!flag) goto _L2; else goto _L1
_L1:
        int i1;
        i1 = motionevent.getAction();
        flag1 = false;
        i1;
        JVM INSTR tableswitch 0 3: default 52
    //                   0 97
    //                   1 139
    //                   2 52
    //                   3 139;
           goto _L3 _L4 _L5 _L3 _L5
_L3:
        if (h != null && h.onTouchEvent(motionevent))
        {
            flag1 = true;
        }
        if (i != null && i.a(motionevent))
        {
            flag1 = true;
        }
_L2:
        return flag1;
_L4:
        view.getParent().requestDisallowInterceptTouchEvent(true);
        f f1 = w;
        flag1 = false;
        if (f1 != null)
        {
            w.a();
            w = null;
            flag1 = false;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        int j1 = g() != b;
        flag1 = false;
        if (j1 < 0)
        {
            RectF rectf = b();
            flag1 = false;
            if (rectf != null)
            {
                view.post(new e(this, g(), b, rectf.centerX(), rectf.centerY()));
                flag1 = true;
            }
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

}
