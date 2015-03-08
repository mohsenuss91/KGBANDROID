// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import fr.castorflex.android.smoothprogressbar.k;

// Referenced classes of package uk.co.senab.a.b:
//            f, q, w, t, 
//            v, r, s, d

public class c extends f
{

    private ViewGroup a;
    public View b;
    private TextView c;
    private SmoothProgressBar d;
    private CharSequence e;
    private CharSequence f;
    private CharSequence g;
    private int h;
    private long i;
    private int j;
    private int k;
    private final Interpolator l = new AccelerateInterpolator();

    public c()
    {
        k = -2;
        int i1 = d();
        if (android.os.Build.VERSION.SDK_INT < i1)
        {
            throw new IllegalStateException((new StringBuilder("This HeaderTransformer is designed to run on SDK ")).append(i1).append("+. If using ActionBarSherlock or ActionBarCompat you should use the appropriate provided extra.").toString());
        } else
        {
            return;
        }
    }

    protected static TypedArray a(Context context, int i1, int ai[])
    {
        TypedValue typedvalue = new TypedValue();
        context.getTheme().resolveAttribute(i1, typedvalue, true);
        return context.obtainStyledAttributes(typedvalue.resourceId, ai);
    }

    private void b(Activity activity, View view)
    {
        TypedArray typedarray = a(activity, q.ptrHeaderStyle, w.PullToRefreshHeader);
        if (a != null)
        {
            int j1 = typedarray.getDimensionPixelSize(1, b(((Context) (activity))));
            a.getLayoutParams().height = j1;
            a.requestLayout();
        }
        Drawable drawable;
        Context context;
        int i1;
        if (typedarray.hasValue(0))
        {
            drawable = typedarray.getDrawable(0);
        } else
        {
            drawable = a(activity);
        }
        if (drawable != null)
        {
            c.setBackgroundDrawable(drawable);
            if (a != null && drawable.getOpacity() == -1)
            {
                a.setBackgroundResource(0);
            }
        }
        context = view.getContext();
        i1 = typedarray.getResourceId(2, c(context));
        if (i1 != 0)
        {
            c.setTextAppearance(context, i1);
        }
        if (typedarray.hasValue(3))
        {
            h = typedarray.getColor(3, h);
        }
        j = typedarray.getInt(4, 1);
        if (typedarray.hasValue(5))
        {
            k = typedarray.getDimensionPixelSize(5, k);
        }
        if (typedarray.hasValue(6))
        {
            e = typedarray.getString(6);
        }
        if (typedarray.hasValue(7))
        {
            f = typedarray.getString(7);
        }
        if (typedarray.hasValue(8))
        {
            g = typedarray.getString(8);
        }
        typedarray.recycle();
    }

    public Drawable a(Context context)
    {
        TypedArray typedarray = a(context, 0x10102ce, new int[] {
            0x10100d4
        });
        Drawable drawable = typedarray.getDrawable(0);
        typedarray.recycle();
        return drawable;
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    public final void a(float f1)
    {
        if (d != null)
        {
            d.setVisibility(0);
            float f2 = l.getInterpolation(f1);
            d.setProgress(Math.round(f2 * (float)d.getMax()));
        }
    }

    public final void a(Activity activity)
    {
        b(activity, b);
    }

    public void a(Activity activity, View view)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams;
        b = view;
        d = (SmoothProgressBar)view.findViewById(t.ptr_progress);
        c = (TextView)view.findViewById(t.ptr_text);
        a = (ViewGroup)view.findViewById(t.ptr_content);
        e = activity.getString(v.pull_to_refresh_pull_label);
        f = activity.getString(v.pull_to_refresh_refreshing_label);
        g = activity.getString(v.pull_to_refresh_release_label);
        i = activity.getResources().getInteger(0x10e0000);
        h = activity.getResources().getColor(r.default_progress_bar_color);
        b(activity, view);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, k);
        j;
        JVM INSTR tableswitch 0 1: default 156
    //                   0 284
    //                   1 296;
           goto _L1 _L2 _L3
_L1:
        d.setLayoutParams(layoutparams);
        if (d != null)
        {
            int i1 = d.getResources().getDimensionPixelSize(s.ptr_progress_bar_stroke_width);
            d.setIndeterminateDrawable((new k(d.getContext())).a(h).a(i1).a());
            ShapeDrawable shapedrawable = new ShapeDrawable();
            shapedrawable.setShape(new RectShape());
            shapedrawable.getPaint().setColor(h);
            ClipDrawable clipdrawable = new ClipDrawable(shapedrawable, 17, 1);
            d.setProgressDrawable(clipdrawable);
        }
        e();
        return;
_L2:
        layoutparams.addRule(8, t.ptr_content);
        continue; /* Loop/switch isn't completed */
_L3:
        layoutparams.addRule(3, t.ptr_content);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean a()
    {
        boolean flag;
        if (b.getVisibility() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b.setVisibility(0);
            AnimatorSet animatorset = new AnimatorSet();
            ViewGroup viewgroup = a;
            float af[] = new float[2];
            af[0] = -a.getHeight();
            af[1] = 0.0F;
            animatorset.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(viewgroup, "translationY", af), ObjectAnimator.ofFloat(b, "alpha", new float[] {
                    0.0F, 1.0F
                })
            });
            animatorset.setDuration(i);
            animatorset.start();
        }
        return flag;
    }

    public int b(Context context)
    {
        TypedArray typedarray;
        int ai[] = {
            0x10102eb
        };
        typedarray = context.getTheme().obtainStyledAttributes(ai);
        int i1 = typedarray.getDimensionPixelSize(0, 0);
        typedarray.recycle();
        return i1;
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    public boolean b()
    {
        boolean flag;
        if (b.getVisibility() != 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Object obj;
            if (a.getAlpha() >= 0.5F)
            {
                obj = new AnimatorSet();
                ViewGroup viewgroup = a;
                float af[] = new float[2];
                af[0] = 0.0F;
                af[1] = -a.getHeight();
                ObjectAnimator objectanimator = ObjectAnimator.ofFloat(viewgroup, "translationY", af);
                ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(b, "alpha", new float[] {
                    1.0F, 0.0F
                });
                ((AnimatorSet)obj).playTogether(new Animator[] {
                    objectanimator, objectanimator1
                });
            } else
            {
                obj = ObjectAnimator.ofFloat(b, "alpha", new float[] {
                    1.0F, 0.0F
                });
            }
            ((Animator) (obj)).setDuration(i);
            ((Animator) (obj)).addListener(new d(this));
            ((Animator) (obj)).start();
        }
        return flag;
    }

    public int c(Context context)
    {
        TypedArray typedarray = a(context, 0x10102ce, new int[] {
            0x10102f8
        });
        int i1 = typedarray.getResourceId(0, 0);
        typedarray.recycle();
        return i1;
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    public void c()
    {
        if (a != null)
        {
            ObjectAnimator.ofFloat(a, "alpha", new float[] {
                1.0F, 0.0F
            }).start();
        }
    }

    public int d()
    {
        return 14;
    }

    public final void e()
    {
        if (d != null)
        {
            d.setVisibility(0);
            d.setProgress(0);
            d.setIndeterminate(false);
        }
        if (c != null)
        {
            c.setVisibility(0);
            c.setText(e);
        }
        if (a != null)
        {
            a.setVisibility(0);
            ViewGroup viewgroup = a;
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                viewgroup.setAlpha(1.0F);
            }
        }
    }

    public final void f()
    {
        if (c != null)
        {
            c.setText(f);
        }
        if (d != null)
        {
            d.setVisibility(0);
            d.setIndeterminate(true);
        }
    }

    public final void g()
    {
        if (c != null)
        {
            c.setText(g);
        }
        if (d != null)
        {
            d.setProgress(d.getMax());
        }
    }
}
