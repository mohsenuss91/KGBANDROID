// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.reflect.Method;
import net.simonvt.menudrawer.a.a;
import net.simonvt.menudrawer.a.c;
import net.simonvt.menudrawer.a.d;

// Referenced classes of package net.simonvt.menudrawer:
//            ai, z, l, m, 
//            r, aj, aa, t, 
//            x, ag, a, k, 
//            n, ac, ab, s, 
//            d, al, af, o, 
//            p

public abstract class MenuDrawer extends ViewGroup
{

    static final boolean q;
    protected static final Interpolator r = new ai();
    protected static final Interpolator s = new AccelerateInterpolator();
    protected int A;
    protected final Rect B;
    protected net.simonvt.menudrawer.a C;
    protected net.simonvt.menudrawer.a D;
    protected int E;
    protected boolean F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    protected boolean K;
    protected int L;
    protected float M;
    protected boolean N;
    protected Bundle O;
    protected int P;
    protected p Q;
    protected af R;
    protected Drawable S;
    protected boolean T;
    protected boolean U;
    protected final Rect V;
    protected float W;
    protected boolean Z;
    private boolean a;
    private android.view.ViewTreeObserver.OnScrollChangedListener aa;
    private boolean b;
    private final Rect c;
    private View d;
    private int e;
    private o f;
    private Activity g;
    private k h;
    private Runnable i;
    private a j;
    private int k;
    private int l;
    private int m;
    private x n;
    private x o;
    private final Rect p;
    protected Drawable t;
    protected boolean u;
    protected int v;
    protected Drawable w;
    protected int x;
    protected Bitmap y;
    protected View z;

    MenuDrawer(Activity activity, int i1)
    {
        this(((Context) (activity)));
        g = activity;
        e = i1;
    }

    public MenuDrawer(Context context)
    {
        this(context, (byte)0);
    }

    private MenuDrawer(Context context, byte byte0)
    {
        this(context, z.menuDrawerStyle);
    }

    private MenuDrawer(Context context, int i1)
    {
        super(context, null, i1);
        B = new Rect();
        c = new Rect();
        e = 0;
        G = 0;
        J = 1;
        K = true;
        i = new l(this);
        P = 600;
        p = new Rect();
        V = new Rect();
        aa = new m(this);
        a(context, null, i1);
    }

    public static MenuDrawer a(Activity activity, r r1, x x1, int i1)
    {
        Object obj;
        if (r1 == r.b)
        {
            obj = new aj(activity);
        } else
        if (r1 == net.simonvt.menudrawer.r.c)
        {
            t t1 = new t(activity, i1);
            ViewGroup viewgroup;
            ViewGroup viewgroup1;
            ViewGroup viewgroup2;
            ag ag1;
            if (x1 == net.simonvt.menudrawer.x.a || x1 == x.e)
            {
                t1.setupUpIndicator(activity);
                obj = t1;
            } else
            {
                obj = t1;
            }
        } else
        {
            ag1 = new ag(activity, i1);
            if (x1 == net.simonvt.menudrawer.x.a || x1 == x.e)
            {
                ag1.setupUpIndicator(activity);
            }
            obj = ag1;
        }
        obj.e = i1;
        ((MenuDrawer) (obj)).setPosition(x1);
        ((MenuDrawer) (obj)).setId(aa.md__drawer);
        switch (i1)
        {
        default:
            throw new RuntimeException((new StringBuilder("Unknown menu mode: ")).append(i1).toString());

        case 0: // '\0'
            viewgroup2 = (ViewGroup)activity.findViewById(0x1020002);
            viewgroup2.removeAllViews();
            viewgroup2.addView(((View) (obj)), -1, -1);
            return ((MenuDrawer) (obj));

        case 1: // '\001'
            viewgroup = (ViewGroup)activity.getWindow().getDecorView();
            break;
        }
        viewgroup1 = (ViewGroup)viewgroup.getChildAt(0);
        viewgroup.removeAllViews();
        viewgroup.addView(((View) (obj)), -1, -1);
        ((MenuDrawer) (obj)).D.addView(viewgroup1, viewgroup1.getLayoutParams());
        return ((MenuDrawer) (obj));
    }

    static void a(MenuDrawer menudrawer)
    {
        menudrawer.c();
    }

    static Rect b(MenuDrawer menudrawer)
    {
        return menudrawer.c;
    }

    private void c()
    {
        boolean flag = true;
        k k1 = h;
        if (k1.h)
        {
            flag = false;
        } else
        {
            int i1 = (int)(AnimationUtils.currentAnimationTimeMillis() - k1.d);
            if (i1 < k1.e)
            {
                float f1 = (float)i1 * k1.f;
                float f2 = k1.i.getInterpolation(f1);
                k1.c = k1.a + f2 * k1.g;
            } else
            {
                k1.c = k1.b;
                k1.h = flag;
            }
        }
        if (flag)
        {
            M = h.c;
            invalidate();
            if (!h.h)
            {
                postOnAnimation(i);
                return;
            }
        }
        d();
    }

    private void d()
    {
        M = 1.0F;
        N = false;
        invalidate();
    }

    private int getIndicatorStartPos()
    {
        switch (net.simonvt.menudrawer.n.a[getPosition().ordinal()])
        {
        default:
            return p.top;

        case 2: // '\002'
            return p.left;

        case 3: // '\003'
            return p.top;

        case 4: // '\004'
            return p.left;
        }
    }

    private void setPosition(x x1)
    {
        n = x1;
        o = getPosition();
    }

    protected final int a(int i1)
    {
        return (int)(0.5F + getResources().getDisplayMetrics().density * (float)i1);
    }

    public abstract void a();

    protected void a(Context context, AttributeSet attributeset, int i1)
    {
        setWillNotDraw(false);
        setFocusable(false);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, ac.MenuDrawer, z.menuDrawerStyle, ab.Widget_MenuDrawer);
        Drawable drawable = typedarray.getDrawable(0);
        Drawable drawable1 = typedarray.getDrawable(1);
        E = typedarray.getDimensionPixelSize(2, a(240));
        int j1 = typedarray.getResourceId(3, 0);
        if (j1 != 0)
        {
            y = BitmapFactory.decodeResource(getResources(), j1);
        }
        u = typedarray.getBoolean(4, true);
        w = typedarray.getDrawable(7);
        int k1;
        if (w == null)
        {
            v = typedarray.getColor(6, 0xff000000);
        } else
        {
            a = true;
        }
        x = typedarray.getDimensionPixelSize(5, a(6));
        H = typedarray.getDimensionPixelSize(8, a(24));
        b = typedarray.getBoolean(9, false);
        P = typedarray.getInt(10, 600);
        k1 = typedarray.getResourceId(11, -1);
        if (k1 != -1)
        {
            setSlideDrawable(k1);
        }
        l = typedarray.getResourceId(12, 0);
        m = typedarray.getResourceId(13, 0);
        Z = typedarray.getBoolean(14, true);
        setPosition(net.simonvt.menudrawer.x.a(typedarray.getInt(15, 0)));
        typedarray.recycle();
        C = new s(context);
        C.setId(aa.md__menu);
        C.setBackgroundDrawable(drawable1);
        D = new s(context);
        D.setId(aa.md__content);
        D.setBackgroundDrawable(drawable);
        t = new net.simonvt.menudrawer.d((byte)0);
        h = new k(r);
    }

    protected abstract void a(Canvas canvas);

    void a(Bundle bundle)
    {
    }

    public void a(Parcelable parcelable)
    {
        O = (Bundle)parcelable;
    }

    public abstract void a(boolean flag);

    protected final boolean a(View view)
    {
        for (ViewParent viewparent = view.getParent(); viewparent != null; viewparent = viewparent.getParent())
        {
            if (viewparent == this)
            {
                return true;
            }
        }

        return false;
    }

    protected abstract void b(int i1);

    public abstract boolean b();

    protected void dispatchDraw(Canvas canvas)
    {
        int i1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        i1 = 0;
        super.dispatchDraw(canvas);
        int j1 = (int)W;
        if (Z && j1 != 0)
        {
            a(canvas);
        }
        if (u && (j1 != 0 || U))
        {
            if (w == null)
            {
                setDropShadowColor(v);
            }
            l();
            w.setBounds(V);
            w.draw(canvas);
        }
        boolean flag;
        float f2;
        if (z != null && y != null && a(z))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag || j1 == 0 && !U) goto _L2; else goto _L1
_L1:
        Integer integer = (Integer)z.getTag(aa.mdActiveViewPosition);
        int k1;
        if (integer == null)
        {
            k1 = 0;
        } else
        {
            k1 = integer.intValue();
        }
        if (k1 != A) goto _L2; else goto _L3
_L3:
        z.getDrawingRect(B);
        offsetDescendantRectToMyCoords(z, B);
        float f1;
        if (U)
        {
            f1 = 1.0F;
        } else
        {
            f1 = Math.abs(W) / (float)E;
        }
        f2 = 1.0F - s.getInterpolation(1.0F - f1);
        l1 = y.getWidth();
        i2 = y.getHeight();
        j2 = (int)(f2 * (float)l1);
        k2 = (int)(f2 * (float)i2);
        l2 = L;
        net.simonvt.menudrawer.n.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 292
    //                   1 492
    //                   2 563
    //                   3 492
    //                   4 563;
           goto _L4 _L5 _L6 _L5 _L6
_L4:
        l3 = 0;
        j3 = 0;
        i4 = 0;
        k3 = 0;
_L16:
        net.simonvt.menudrawer.n.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 344
    //                   1 630
    //                   2 649
    //                   3 668
    //                   4 687;
           goto _L7 _L8 _L9 _L10 _L11
_L7:
        p.left = k3;
        p.top = i4;
        p.right = j3;
        p.bottom = l3;
        canvas.save();
        canvas.clipRect(p);
        net.simonvt.menudrawer.n.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 436
    //                   1 706
    //                   2 706
    //                   3 726
    //                   4 754;
           goto _L12 _L13 _L13 _L14 _L15
_L12:
        j4 = 0;
_L17:
        canvas.drawBitmap(y, j4, i1, null);
        canvas.restore();
_L2:
        return;
_L5:
        int k4 = B.top + (B.height() - i2) / 2;
        if (N)
        {
            k4 = (int)((float)l2 + (float)(k4 - l2) * M);
        }
        int l4 = k4 + i2;
        i4 = k4;
        l3 = l4;
        j3 = 0;
        k3 = 0;
          goto _L16
_L6:
        int i3 = B.left + (B.width() - l1) / 2;
        if (N)
        {
            i3 = (int)((float)l2 + (float)(i3 - l2) * M);
        }
        j3 = l1 + i3;
        k3 = i3;
        l3 = 0;
        i4 = 0;
          goto _L16
_L8:
        j3 = net.simonvt.menudrawer.al.a(D);
        k3 = j3 - j2;
          goto _L7
_L9:
        l3 = al.b(D);
        i4 = l3 - k2;
          goto _L7
_L10:
        k3 = net.simonvt.menudrawer.al.c(D);
        j3 = k3 + j2;
          goto _L7
_L11:
        i4 = net.simonvt.menudrawer.al.d(D);
        l3 = i4 + k2;
          goto _L7
_L13:
        j4 = p.left;
        i1 = p.top;
          goto _L17
_L14:
        j4 = p.right - y.getWidth();
        i1 = p.top;
          goto _L17
_L15:
        j4 = p.left;
        i1 = p.bottom - y.getHeight();
          goto _L17
    }

    protected boolean fitSystemWindows(Rect rect)
    {
        if (e == 1 && n != net.simonvt.menudrawer.x.d)
        {
            C.setPadding(0, rect.top, 0, 0);
        }
        return super.fitSystemWindows(rect);
    }

    public boolean getAllowIndicatorAnimation()
    {
        return b;
    }

    public ViewGroup getContentContainer()
    {
        if (e == 0)
        {
            return D;
        } else
        {
            return (ViewGroup)findViewById(0x1020002);
        }
    }

    public boolean getDrawOverlay()
    {
        return Z;
    }

    public int getDrawerState()
    {
        return G;
    }

    public Drawable getDropShadow()
    {
        return w;
    }

    protected android.graphics.drawable.GradientDrawable.Orientation getDropShadowOrientation()
    {
        switch (net.simonvt.menudrawer.n.a[getPosition().ordinal()])
        {
        default:
            return android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT;

        case 2: // '\002'
            return android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP;

        case 3: // '\003'
            return android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT;

        case 4: // '\004'
            return android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM;
        }
    }

    public ViewGroup getMenuContainer()
    {
        return C;
    }

    public int getMenuSize()
    {
        return E;
    }

    public View getMenuView()
    {
        return d;
    }

    public abstract boolean getOffsetMenuEnabled();

    protected x getPosition()
    {
        int i1 = al.e(this);
        switch (net.simonvt.menudrawer.n.a[n.ordinal()])
        {
        default:
            return n;

        case 5: // '\005'
            if (i1 == 1)
            {
                return net.simonvt.menudrawer.x.c;
            } else
            {
                return net.simonvt.menudrawer.x.a;
            }

        case 6: // '\006'
            break;
        }
        if (i1 == 1)
        {
            return net.simonvt.menudrawer.x.a;
        } else
        {
            return net.simonvt.menudrawer.x.c;
        }
    }

    public abstract int getTouchBezelSize();

    public abstract int getTouchMode();

    protected void l()
    {
        switch (net.simonvt.menudrawer.n.a[getPosition().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            V.top = 0;
            V.bottom = getHeight();
            V.right = net.simonvt.menudrawer.al.a(D);
            V.left = V.right - x;
            return;

        case 2: // '\002'
            V.left = 0;
            V.right = getWidth();
            V.bottom = al.b(D);
            V.top = V.bottom - x;
            return;

        case 3: // '\003'
            V.top = 0;
            V.bottom = getHeight();
            V.left = net.simonvt.menudrawer.al.c(D);
            V.right = V.left + x;
            return;

        case 4: // '\004'
            V.left = 0;
            break;
        }
        V.right = getWidth();
        V.top = net.simonvt.menudrawer.al.d(D);
        V.bottom = V.top + x;
    }

    public final void m()
    {
        a();
    }

    public final void n()
    {
        a(true);
    }

    public final void o()
    {
        p();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(aa);
    }

    protected void onDetachedFromWindow()
    {
        getViewTreeObserver().removeOnScrollChangedListener(aa);
        super.onDetachedFromWindow();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        View view = findViewById(aa.mdMenu);
        if (view != null)
        {
            removeView(view);
            setMenuView(view);
        }
        View view1 = findViewById(aa.mdContent);
        if (view1 != null)
        {
            removeView(view1);
            setContentView(view1);
        }
        if (getChildCount() > 2)
        {
            throw new IllegalStateException("Menu and content view added in xml must have id's @id/mdMenu and @id/mdContent");
        } else
        {
            return;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        a(savedstate.a);
    }

    public void onRtlPropertiesChanged(int i1)
    {
        boolean flag = true;
        super.onRtlPropertiesChanged(i1);
        if (!a)
        {
            setDropShadowColor(v);
        }
        if (getPosition() != o)
        {
            o = getPosition();
            setOffsetPixels(-1F * W);
        }
        if (R != null)
        {
            af af1 = R;
            if (i1 != flag)
            {
                flag = false;
            }
            af1.a(flag);
        }
        requestLayout();
        invalidate();
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (O == null)
        {
            O = new Bundle();
        }
        a(O);
        savedstate.a = O;
        return savedstate;
    }

    public abstract void p();

    public void postOnAnimation(Runnable runnable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            super.postOnAnimation(runnable);
            return;
        } else
        {
            postDelayed(runnable, 16L);
            return;
        }
    }

    protected final void q()
    {
        if (J == 1)
        {
            I = H;
            return;
        }
        if (J == 2)
        {
            I = getMeasuredWidth();
            return;
        } else
        {
            I = 0;
            return;
        }
    }

    public void setActiveView(View view)
    {
        View view1 = z;
        z = view;
        A = 0;
        if (b && view1 != null)
        {
            L = getIndicatorStartPos();
            N = true;
            k k1 = h;
            k1.h = false;
            k1.e = 800;
            k1.d = AnimationUtils.currentAnimationTimeMillis();
            k1.a = 0.0F;
            k1.b = 1.0F;
            k1.g = 1.0F;
            k1.f = 1.0F / (float)k1.e;
            c();
        }
        invalidate();
    }

    public void setAllowIndicatorAnimation(boolean flag)
    {
        if (flag != b)
        {
            b = flag;
            d();
        }
    }

    public void setContentView(int i1)
    {
        switch (e)
        {
        default:
            return;

        case 0: // '\0'
            D.removeAllViews();
            LayoutInflater.from(getContext()).inflate(i1, D, true);
            return;

        case 1: // '\001'
            g.setContentView(i1);
            break;
        }
    }

    public void setContentView(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        switch (e)
        {
        default:
            return;

        case 0: // '\0'
            D.removeAllViews();
            D.addView(view, layoutparams);
            return;

        case 1: // '\001'
            g.setContentView(view, layoutparams);
            break;
        }
    }

    public void setDrawOverlay(boolean flag)
    {
        Z = flag;
    }

    public void setDrawerIndicatorEnabled(boolean flag)
    {
        if (j == null)
        {
            throw new IllegalStateException("setupUpIndicator(Activity) has not been called");
        }
        T = flag;
        if (flag)
        {
            a a1 = j;
            af af1 = R;
            int i1;
            if (b())
            {
                i1 = l;
            } else
            {
                i1 = m;
            }
            a1.a(af1, i1);
            return;
        } else
        {
            j.a(S, 0);
            return;
        }
    }

    protected void setDrawerState(int i1)
    {
        if (i1 != G)
        {
            int _tmp = G;
            G = i1;
            if (f != null)
            {
                f.a(i1);
            }
        }
    }

    public void setDropShadow(int i1)
    {
        setDropShadow(getResources().getDrawable(i1));
    }

    public void setDropShadow(Drawable drawable)
    {
        w = drawable;
        boolean flag;
        if (drawable != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        invalidate();
    }

    public void setDropShadowColor(int i1)
    {
        w = new GradientDrawable(getDropShadowOrientation(), new int[] {
            i1, 0xffffff & i1
        });
        invalidate();
    }

    public void setDropShadowEnabled(boolean flag)
    {
        u = flag;
        invalidate();
    }

    public void setDropShadowSize(int i1)
    {
        x = i1;
        invalidate();
    }

    public abstract void setHardwareLayerEnabled(boolean flag);

    public void setMaxAnimationDuration(int i1)
    {
        P = i1;
    }

    public abstract void setMenuSize(int i1);

    public void setMenuView(int i1)
    {
        C.removeAllViews();
        d = LayoutInflater.from(getContext()).inflate(i1, C, false);
        C.addView(d);
    }

    public void setMenuView(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        d = view;
        C.removeAllViews();
        C.addView(view, layoutparams);
    }

    public abstract void setOffsetMenuEnabled(boolean flag);

    protected void setOffsetPixels(float f1)
    {
        int i1 = (int)W;
        int j1 = (int)f1;
        W = f1;
        if (R != null)
        {
            float f2 = Math.abs(W) / (float)E;
            R.a(f2);
            int k1;
            if (b())
            {
                k1 = l;
            } else
            {
                k1 = m;
            }
            if (T && j != null && k1 != k)
            {
                k = k1;
                a a1 = j;
                if (a1.c && android.os.Build.VERSION.SDK_INT < 14)
                {
                    Object obj = a1.b;
                    Activity activity = a1.a;
                    c c1 = (c)obj;
                    if (c1.a != null)
                    {
                        Object obj1;
                        if (k1 == 0)
                        {
                            obj1 = null;
                        } else
                        {
                            obj1 = activity.getString(k1);
                        }
                        c1.a.setContentDescription(((CharSequence) (obj1)));
                    }
                } else
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    net.simonvt.menudrawer.a.d.a(a1.b, a1.a, k1);
                }
            }
        }
        if (j1 != i1)
        {
            b(j1);
            boolean flag;
            if (j1 != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            F = flag;
            Math.abs(j1);
            int _tmp = E;
            if (f != null)
            {
                o _tmp1 = f;
            }
        }
    }

    public void setOnDrawerStateChangeListener(o o1)
    {
        f = o1;
    }

    public void setOnInterceptMoveEventListener(p p1)
    {
        Q = p1;
    }

    public void setSlideDrawable(int i1)
    {
        setSlideDrawable(getResources().getDrawable(i1));
    }

    public void setSlideDrawable(Drawable drawable)
    {
        boolean flag = true;
        R = new af(drawable);
        af af1 = R;
        if (al.e(this) != flag)
        {
            flag = false;
        }
        af1.a(flag);
        if (j != null)
        {
            a a1 = j;
            if (a1.c && android.os.Build.VERSION.SDK_INT < 14)
            {
                c c1 = (c)a1.b;
                a a2;
                af af2;
                int i1;
                if (c1.c != null)
                {
                    try
                    {
                        Method method = c1.c;
                        Object obj = c1.b;
                        Object aobj[] = new Object[1];
                        aobj[0] = Boolean.valueOf(true);
                        method.invoke(obj, aobj);
                    }
                    catch (Throwable throwable) { }
                }
            } else
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                net.simonvt.menudrawer.a.d.c(a1.a);
            }
            if (T)
            {
                a2 = j;
                af2 = R;
                if (b())
                {
                    i1 = l;
                } else
                {
                    i1 = m;
                }
                a2.a(af2, i1);
            }
        }
    }

    public abstract void setTouchBezelSize(int i1);

    public abstract void setTouchMode(int i1);

    public void setupUpIndicator(Activity activity)
    {
        if (j == null)
        {
            j = new a(activity);
            a a1 = j;
            Drawable drawable;
            if (a1.c && android.os.Build.VERSION.SDK_INT < 14)
            {
                c c1 = (c)a1.b;
                a a2;
                af af1;
                if (c1.a != null)
                {
                    drawable = c1.a.getDrawable();
                } else
                {
                    drawable = null;
                }
            } else
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                Object _tmp = a1.b;
                drawable = net.simonvt.menudrawer.a.d.a(a1.a);
            } else
            {
                drawable = null;
            }
            S = drawable;
            if (T)
            {
                a2 = j;
                af1 = R;
                int i1;
                if (b())
                {
                    i1 = l;
                } else
                {
                    i1 = m;
                }
                a2.a(af1, i1);
            }
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        q = flag;
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new q();
        Bundle a;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeBundle(a);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readBundle();
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
