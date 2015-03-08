// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            eg, ey, ag, ab, 
//            am, af, ev, ae, 
//            bc, aa, ew

public final class ad
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener, android.view.ViewTreeObserver.OnScrollChangedListener
{

    private static final long lE;
    private final WindowManager lA;
    private final PowerManager lB;
    private final KeyguardManager lC;
    private ae lD;
    private boolean lF;
    private long lG;
    private boolean lH;
    private BroadcastReceiver lI;
    private HashSet lJ;
    private boolean lh;
    private final Object lq;
    private final WeakReference lt;
    private WeakReference lu;
    private final WeakReference lv;
    private final ab lw;
    private final Context lx;
    private final af ly;
    private boolean lz;

    public ad(am am1, eg eg1)
    {
        this(am1, eg1, eg1.ow.bY(), ((View) (eg1.ow)), ((af) (new ag(eg1.ow.getContext(), eg1.ow.bY()))));
    }

    public ad(am am1, eg eg1, ew ew, View view, af af1)
    {
        lq = new Object();
        lh = false;
        lF = false;
        lG = 0x8000000000000000L;
        lJ = new HashSet();
        lt = new WeakReference(eg1);
        lv = new WeakReference(view);
        lu = new WeakReference(null);
        lH = true;
        lw = new ab(Integer.toString(eg1.hashCode()), ew, am1.mc, eg1.rv);
        ly = af1;
        lA = (WindowManager)view.getContext().getSystemService("window");
        lB = (PowerManager)view.getContext().getApplicationContext().getSystemService("power");
        lC = (KeyguardManager)view.getContext().getSystemService("keyguard");
        lx = view.getContext().getApplicationContext();
        a(af1);
        ly.a(new _cls1());
        b(ly);
        ev.B((new StringBuilder("Tracking ad unit: ")).append(lw.ap()).toString());
    }

    static af b(ad ad1)
    {
        return ad1.ly;
    }

    static boolean b(ad ad1, boolean flag)
    {
        ad1.lz = flag;
        return flag;
    }

    static ab c(ad ad1)
    {
        return ad1.lw;
    }

    protected final int a(int i, DisplayMetrics displaymetrics)
    {
        float f = displaymetrics.density;
        return (int)((float)i / f);
    }

    public final void a(aa aa1)
    {
        lJ.add(aa1);
    }

    public final void a(ae ae1)
    {
        synchronized (lq)
        {
            lD = ae1;
        }
    }

    protected final void a(af af1)
    {
        af1.d("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    protected final void a(ey ey1, Map map)
    {
        e(false);
    }

    protected final void a(JSONObject jsonobject)
    {
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonobject1 = new JSONObject();
        jsonarray.put(jsonobject);
        jsonobject1.put("units", jsonarray);
        ly.a("AFMA_updateActiveView", jsonobject1);
    }

    protected final boolean a(View view, boolean flag)
    {
        return view.getVisibility() == 0 && flag && view.isShown() && lB.isScreenOn() && !lC.inKeyguardRestrictedInputMode();
    }

    protected final void aq()
    {
label0:
        {
            IntentFilter intentfilter;
            synchronized (lq)
            {
                if (lI == null)
                {
                    break label0;
                }
            }
            return;
        }
        intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.SCREEN_ON");
        intentfilter.addAction("android.intent.action.SCREEN_OFF");
        lI = new _cls2();
        lx.registerReceiver(lI, intentfilter);
        obj;
        JVM INSTR monitorexit ;
    }

    protected final void ar()
    {
        synchronized (lq)
        {
            if (lI != null)
            {
                lx.unregisterReceiver(lI);
                lI = null;
            }
        }
    }

    public final void as()
    {
        Object obj = lq;
        obj;
        JVM INSTR monitorenter ;
        if (!lH) goto _L2; else goto _L1
_L1:
        aw();
        ar();
        a(ay());
_L3:
        lH = false;
        at();
        ev.B((new StringBuilder("Untracked ad unit: ")).append(lw.ap()).toString());
_L2:
        return;
        JSONException jsonexception;
        jsonexception;
        ev.b("JSON Failure while processing active view data.", jsonexception);
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    protected final void at()
    {
        if (lD != null)
        {
            lD.a(this);
        }
    }

    public final boolean au()
    {
        boolean flag;
        synchronized (lq)
        {
            flag = lH;
        }
        return flag;
    }

    protected final void av()
    {
        View view = (View)lv.get();
        if (view != null)
        {
            ViewTreeObserver viewtreeobserver = (ViewTreeObserver)lu.get();
            ViewTreeObserver viewtreeobserver1 = view.getViewTreeObserver();
            if (viewtreeobserver1 != viewtreeobserver)
            {
                lu = new WeakReference(viewtreeobserver1);
                viewtreeobserver1.addOnScrollChangedListener(this);
                viewtreeobserver1.addOnGlobalLayoutListener(this);
                return;
            }
        }
    }

    protected final void aw()
    {
        ViewTreeObserver viewtreeobserver = (ViewTreeObserver)lu.get();
        if (viewtreeobserver == null || !viewtreeobserver.isAlive())
        {
            return;
        } else
        {
            viewtreeobserver.removeOnScrollChangedListener(this);
            viewtreeobserver.removeGlobalOnLayoutListener(this);
            return;
        }
    }

    protected final JSONObject ax()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("afmaVersion", lw.an()).put("activeViewJSON", lw.ao()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", lw.am()).put("hashCode", lw.ap());
        return jsonobject;
    }

    protected final JSONObject ay()
    {
        JSONObject jsonobject = ax();
        jsonobject.put("doneReasonCode", "u");
        return jsonobject;
    }

    protected final void b(af af1)
    {
        af1.a("/updateActiveView", new _cls3());
        af1.a("/activeViewPingSent", new _cls4());
        af1.a("/visibilityChanged", new _cls5());
        af1.a("/viewabilityChanged", bc.mR);
    }

    protected final JSONObject c(View view)
    {
        int ai[] = new int[2];
        int ai1[] = new int[2];
        view.getLocationOnScreen(ai);
        view.getLocationInWindow(ai1);
        JSONObject jsonobject = ax();
        DisplayMetrics displaymetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = ai[0];
        rect.top = ai[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect1 = new Rect();
        rect1.right = lA.getDefaultDisplay().getWidth();
        rect1.bottom = lA.getDefaultDisplay().getHeight();
        Rect rect2 = new Rect();
        boolean flag = view.getGlobalVisibleRect(rect2, null);
        Rect rect3 = new Rect();
        view.getLocalVisibleRect(rect3);
        jsonobject.put("viewBox", (new JSONObject()).put("top", a(rect1.top, displaymetrics)).put("bottom", a(rect1.bottom, displaymetrics)).put("left", a(rect1.left, displaymetrics)).put("right", a(rect1.right, displaymetrics))).put("adBox", (new JSONObject()).put("top", a(rect.top, displaymetrics)).put("bottom", a(rect.bottom, displaymetrics)).put("left", a(rect.left, displaymetrics)).put("right", a(rect.right, displaymetrics))).put("globalVisibleBox", (new JSONObject()).put("top", a(rect2.top, displaymetrics)).put("bottom", a(rect2.bottom, displaymetrics)).put("left", a(rect2.left, displaymetrics)).put("right", a(rect2.right, displaymetrics))).put("localVisibleBox", (new JSONObject()).put("top", a(rect3.top, displaymetrics)).put("bottom", a(rect3.bottom, displaymetrics)).put("left", a(rect3.left, displaymetrics)).put("right", a(rect3.right, displaymetrics))).put("screenDensity", displaymetrics.density).put("isVisible", a(view, flag)).put("isStopped", lF).put("isPaused", lh);
        return jsonobject;
    }

    protected final void c(af af1)
    {
        af1.e("/viewabilityChanged");
        af1.e("/visibilityChanged");
        af1.e("/activeViewPingSent");
        af1.e("/updateActiveView");
    }

    protected final void d(boolean flag)
    {
        for (Iterator iterator = lJ.iterator(); iterator.hasNext(); ((aa)iterator.next()).a(this, flag)) { }
    }

    protected final void e(boolean flag)
    {
        long l;
label0:
        {
            synchronized (lq)
            {
                if (lz && lH)
                {
                    break label0;
                }
            }
            return;
        }
        l = System.nanoTime();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (lG + lE <= l)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        eg eg1;
        View view;
        lG = l;
        eg1 = (eg)lt.get();
        view = (View)lv.get();
        boolean flag1;
        JSONException jsonexception;
        if (view != null && eg1 != null)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        as();
        obj;
        JVM INSTR monitorexit ;
        return;
        a(c(view));
_L1:
        av();
        at();
        obj;
        JVM INSTR monitorexit ;
        return;
        jsonexception;
        ev.b("Active view update failed.", jsonexception);
          goto _L1
    }

    public final void onGlobalLayout()
    {
        e(false);
    }

    public final void onScrollChanged()
    {
        e(true);
    }

    public final void pause()
    {
        synchronized (lq)
        {
            lh = true;
            e(false);
            ly.pause();
        }
    }

    public final void resume()
    {
        synchronized (lq)
        {
            ly.resume();
            lh = false;
            e(false);
        }
    }

    public final void stop()
    {
        synchronized (lq)
        {
            lF = true;
            e(false);
            ly.pause();
        }
    }

    static 
    {
        lE = TimeUnit.MILLISECONDS.toNanos(100L);
    }

    private class _cls1
        implements af.a
    {

        final ad lK;

        public void az()
        {
            ad.b(lK, true);
            lK.e(false);
            lK.aq();
        }

        _cls1()
        {
            lK = ad.this;
            super();
        }
    }


    private class _cls2 extends BroadcastReceiver
    {

        final ad lK;

        public void onReceive(Context context, Intent intent)
        {
            lK.e(false);
        }

        _cls2()
        {
            lK = ad.this;
            super();
        }
    }


    private class _cls3
        implements bd
    {

        final ad lK;

        public void b(ey ey1, Map map)
        {
            lK.a(ey1, map);
        }

        _cls3()
        {
            lK = ad.this;
            super();
        }
    }


    private class _cls4
        implements bd
    {

        final ad lK;

        public void b(ey ey1, Map map)
        {
            if (map.containsKey("pingType") && "unloadPing".equals(map.get("pingType")))
            {
                lK.c(ad.b(lK));
                ev.B((new StringBuilder("Unregistered GMSG handlers for: ")).append(ad.c(lK).ap()).toString());
            }
        }

        _cls4()
        {
            lK = ad.this;
            super();
        }
    }


    private class _cls5
        implements bd
    {

        final ad lK;

        public void b(ey ey1, Map map)
        {
            if (!map.containsKey("isVisible"))
            {
                return;
            }
            boolean flag;
            Boolean boolean1;
            if ("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean1 = Boolean.valueOf(flag);
            lK.d(boolean1.booleanValue());
        }

        _cls5()
        {
            lK = ad.this;
            super();
        }
    }

}
