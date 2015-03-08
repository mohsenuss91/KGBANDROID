// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.youtube.player.internal.ab;
import com.google.android.youtube.player.internal.ac;
import com.google.android.youtube.player.internal.b;
import com.google.android.youtube.player.internal.n;
import com.google.android.youtube.player.internal.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.youtube.player:
//            YouTubeBaseActivity, YouTubeInitializationResult

public final class YouTubePlayerView extends ViewGroup
    implements YouTubePlayer.Provider
{

    private final a a;
    private final Set b;
    private final b c;
    private com.google.android.youtube.player.internal.b d;
    private s e;
    private View f;
    private n g;
    private YouTubePlayer.Provider h;
    private Bundle i;
    private YouTubePlayer.OnInitializedListener j;
    private boolean k;

    public YouTubePlayerView(Context context)
    {
        this(context, null);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public YouTubePlayerView(Context context, AttributeSet attributeset, int l)
    {
        if (!(context instanceof YouTubeBaseActivity))
        {
            throw new IllegalStateException("A YouTubePlayerView can only be created with an Activity  which extends YouTubeBaseActivity as its context.");
        } else
        {
            this(context, attributeset, l, ((YouTubeBaseActivity)context).a());
            return;
        }
    }

    YouTubePlayerView(Context context, AttributeSet attributeset, int l, b b1)
    {
        super((Context)ac.a(context, "context cannot be null"), attributeset, l);
        c = (b)ac.a(b1, "listener cannot be null");
        if (getBackground() == null)
        {
            setBackgroundColor(0xff000000);
        }
        setClipToPadding(false);
        g = new n(context);
        requestTransparentRegion(g);
        addView(g);
        b = new HashSet();
        a = new a((byte)0);
    }

    static com.google.android.youtube.player.internal.b a(YouTubePlayerView youtubeplayerview)
    {
        return youtubeplayerview.d;
    }

    private void a(View view)
    {
        boolean flag;
        if (view == g || e != null && view == f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new UnsupportedOperationException("No views can be added on top of the player");
        } else
        {
            return;
        }
    }

    private void a(YouTubeInitializationResult youtubeinitializationresult)
    {
        e = null;
        g.c();
        if (j != null)
        {
            j.onInitializationFailure(h, youtubeinitializationresult);
            j = null;
        }
    }

    static void a(YouTubePlayerView youtubeplayerview, Activity activity)
    {
        com.google.android.youtube.player.internal.d d1;
        try
        {
            d1 = ab.a().a(activity, youtubeplayerview.d);
        }
        catch (com.google.android.youtube.player.internal.w.a a1)
        {
            youtubeplayerview.a(YouTubeInitializationResult.INTERNAL_ERROR);
            return;
        }
        youtubeplayerview.e = new s(youtubeplayerview.d, d1);
        youtubeplayerview.f = youtubeplayerview.e.a();
        youtubeplayerview.addView(youtubeplayerview.f);
        youtubeplayerview.removeView(youtubeplayerview.g);
        youtubeplayerview.c.a(youtubeplayerview);
        if (youtubeplayerview.j != null)
        {
            Bundle bundle = youtubeplayerview.i;
            boolean flag = false;
            if (bundle != null)
            {
                flag = youtubeplayerview.e.a(youtubeplayerview.i);
                youtubeplayerview.i = null;
            }
            youtubeplayerview.j.onInitializationSuccess(youtubeplayerview.h, youtubeplayerview.e, flag);
            youtubeplayerview.j = null;
        }
    }

    static void a(YouTubePlayerView youtubeplayerview, YouTubeInitializationResult youtubeinitializationresult)
    {
        youtubeplayerview.a(youtubeinitializationresult);
    }

    static com.google.android.youtube.player.internal.b b(YouTubePlayerView youtubeplayerview)
    {
        youtubeplayerview.d = null;
        return null;
    }

    static boolean c(YouTubePlayerView youtubeplayerview)
    {
        return youtubeplayerview.k;
    }

    static s d(YouTubePlayerView youtubeplayerview)
    {
        return youtubeplayerview.e;
    }

    static n e(YouTubePlayerView youtubeplayerview)
    {
        return youtubeplayerview.g;
    }

    static View f(YouTubePlayerView youtubeplayerview)
    {
        return youtubeplayerview.f;
    }

    static View g(YouTubePlayerView youtubeplayerview)
    {
        youtubeplayerview.f = null;
        return null;
    }

    static s h(YouTubePlayerView youtubeplayerview)
    {
        youtubeplayerview.e = null;
        return null;
    }

    static Set i(YouTubePlayerView youtubeplayerview)
    {
        return youtubeplayerview.b;
    }

    final void a()
    {
        if (e != null)
        {
            e.b();
        }
    }

    final void a(Activity activity, YouTubePlayer.Provider provider, String s1, YouTubePlayer.OnInitializedListener oninitializedlistener, Bundle bundle)
    {
        if (e != null || j != null)
        {
            return;
        } else
        {
            ac.a(activity, "activity cannot be null");
            h = (YouTubePlayer.Provider)ac.a(provider, "provider cannot be null");
            j = (YouTubePlayer.OnInitializedListener)ac.a(oninitializedlistener, "listener cannot be null");
            i = bundle;
            g.b();
            d = ab.a().a(getContext(), s1, new _cls1(activity), new _cls2());
            d.e();
            return;
        }
    }

    final void a(boolean flag)
    {
        if (e != null)
        {
            e.b(flag);
            b(flag);
        }
    }

    public final void addFocusables(ArrayList arraylist, int l)
    {
        ArrayList arraylist1 = new ArrayList();
        super.addFocusables(arraylist1, l);
        arraylist.addAll(arraylist1);
        b.clear();
        b.addAll(arraylist1);
    }

    public final void addFocusables(ArrayList arraylist, int l, int i1)
    {
        ArrayList arraylist1 = new ArrayList();
        super.addFocusables(arraylist1, l, i1);
        arraylist.addAll(arraylist1);
        b.clear();
        b.addAll(arraylist1);
    }

    public final void addView(View view)
    {
        a(view);
        super.addView(view);
    }

    public final void addView(View view, int l)
    {
        a(view);
        super.addView(view, l);
    }

    public final void addView(View view, int l, int i1)
    {
        a(view);
        super.addView(view, l, i1);
    }

    public final void addView(View view, int l, android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(view);
        super.addView(view, l, layoutparams);
    }

    public final void addView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        a(view);
        super.addView(view, layoutparams);
    }

    final void b()
    {
        if (e != null)
        {
            e.c();
        }
    }

    final void b(boolean flag)
    {
        k = true;
        if (e != null)
        {
            e.a(flag);
        }
    }

    final void c()
    {
        if (e != null)
        {
            e.d();
        }
    }

    public final void clearChildFocus(View view)
    {
        if (hasFocusable())
        {
            requestFocus();
            return;
        } else
        {
            super.clearChildFocus(view);
            return;
        }
    }

    final void d()
    {
        if (e != null)
        {
            e.e();
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        if (keyevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        boolean flag1;
label0:
        {
            if (!e.a(keyevent.getKeyCode(), keyevent))
            {
                boolean flag2 = super.dispatchKeyEvent(keyevent);
                flag1 = false;
                if (!flag2)
                {
                    break label0;
                }
            }
            flag1 = true;
        }
_L4:
        return flag1;
_L2:
        boolean flag;
        if (keyevent.getAction() != 1)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        if (e.b(keyevent.getKeyCode(), keyevent))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = super.dispatchKeyEvent(keyevent);
        flag1 = false;
        if (!flag) goto _L4; else goto _L3
_L3:
        return true;
        return super.dispatchKeyEvent(keyevent);
    }

    final Bundle e()
    {
        if (e == null)
        {
            return i;
        } else
        {
            return e.h();
        }
    }

    public final void focusableViewAvailable(View view)
    {
        super.focusableViewAvailable(view);
        b.add(view);
    }

    public final void initialize(String s1, YouTubePlayer.OnInitializedListener oninitializedlistener)
    {
        ac.a(s1, "Developer key cannot be null or empty");
        c.a(this, s1, oninitializedlistener);
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalFocusChangeListener(a);
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (e != null)
        {
            e.a(configuration);
        }
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalFocusChangeListener(a);
    }

    protected final void onLayout(boolean flag, int l, int i1, int j1, int k1)
    {
        if (getChildCount() > 0)
        {
            getChildAt(0).layout(0, 0, j1 - l, k1 - i1);
        }
    }

    protected final void onMeasure(int l, int i1)
    {
        if (getChildCount() > 0)
        {
            View view = getChildAt(0);
            view.measure(l, i1);
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
            return;
        } else
        {
            setMeasuredDimension(0, 0);
            return;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        return true;
    }

    public final void requestChildFocus(View view, View view1)
    {
        super.requestChildFocus(view, view1);
        b.add(view1);
    }

    public final void setClipToPadding(boolean flag)
    {
    }

    public final void setPadding(int l, int i1, int j1, int k1)
    {
    }

    private class b
    {

        public abstract void a(YouTubePlayerView youtubeplayerview);

        public abstract void a(YouTubePlayerView youtubeplayerview, String s1, YouTubePlayer.OnInitializedListener oninitializedlistener);
    }


    private class a
        implements android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    {

        final YouTubePlayerView a;

        public final void onGlobalFocusChanged(View view, View view1)
        {
            if (YouTubePlayerView.d(a) != null && YouTubePlayerView.i(a).contains(view1) && !YouTubePlayerView.i(a).contains(view))
            {
                YouTubePlayerView.d(a).g();
            }
        }

        private a()
        {
            a = YouTubePlayerView.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private class _cls1
        implements com.google.android.youtube.player.internal.t.a
    {

        final Activity a;
        final YouTubePlayerView b;

        public final void a()
        {
            if (YouTubePlayerView.a(b) != null)
            {
                YouTubePlayerView.a(b, a);
            }
            com.google.android.youtube.player.YouTubePlayerView.b(b);
        }

        public final void b()
        {
            if (!YouTubePlayerView.c(b) && YouTubePlayerView.d(b) != null)
            {
                YouTubePlayerView.d(b).f();
            }
            YouTubePlayerView.e(b).a();
            if (b.indexOfChild(YouTubePlayerView.e(b)) < 0)
            {
                b.addView(YouTubePlayerView.e(b));
                b.removeView(YouTubePlayerView.f(b));
            }
            YouTubePlayerView.g(b);
            YouTubePlayerView.h(b);
            com.google.android.youtube.player.YouTubePlayerView.b(b);
        }

        _cls1(Activity activity)
        {
            b = YouTubePlayerView.this;
            a = activity;
            super();
        }
    }


    private class _cls2
        implements com.google.android.youtube.player.internal.t.b
    {

        final YouTubePlayerView a;

        public final void a(YouTubeInitializationResult youtubeinitializationresult)
        {
            YouTubePlayerView.a(a, youtubeinitializationresult);
            com.google.android.youtube.player.YouTubePlayerView.b(a);
        }

        _cls2()
        {
            a = YouTubePlayerView.this;
            super();
        }
    }

}
