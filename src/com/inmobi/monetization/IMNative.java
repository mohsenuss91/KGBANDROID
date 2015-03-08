// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import com.inmobi.androidsdk.carb.CARB;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.monetization.internal.NativeAdRequest;
import com.inmobi.monetization.internal.NativeAdsController;
import com.inmobi.monetization.internal.TrackerView;
import com.inmobi.monetization.internal.abstraction.INativeAdListener;
import com.inmobi.monetization.internal.objects.NativeAd;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            a, IMNativeListener

public class IMNative
{

    TrackerView a;
    private String b;
    private String c;
    private String d;
    private String e;
    private IMNativeListener f;
    private Handler g;
    private NativeAdRequest h;
    private boolean i;
    private a j;
    private INativeAdListener k;

    public IMNative(IMNativeListener imnativelistener)
    {
        b = null;
        c = null;
        d = null;
        a = null;
        e = null;
        f = null;
        h = null;
        i = false;
        j = a.g;
        k = new com.inmobi.monetization.a(this);
        a(InMobi.getAppId(), imnativelistener);
        a(a.a);
    }

    public IMNative(String s, IMNativeListener imnativelistener)
    {
        b = null;
        c = null;
        d = null;
        a = null;
        e = null;
        f = null;
        h = null;
        i = false;
        j = a.g;
        k = new com.inmobi.monetization.a(this);
        if (s == null || "".equals(s.trim()))
        {
            Log.e("[InMobi]-[Monetization]", "Please create an instance of native ad with valid appId");
            return;
        } else
        {
            a(s, imnativelistener);
            a(a.a);
            return;
        }
    }

    public IMNative(String s, String s1, String s2)
    {
        b = null;
        c = null;
        d = null;
        a = null;
        e = null;
        f = null;
        h = null;
        i = false;
        j = a.g;
        k = new com.inmobi.monetization.a(this);
        b = s;
        c = s1;
        d = s2;
    }

    private a a()
    {
        this;
        JVM INSTR monitorenter ;
        a a1 = j;
        this;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    static String a(IMNative imnative)
    {
        return imnative.c;
    }

    static String a(IMNative imnative, String s)
    {
        imnative.b = s;
        return s;
    }

    private void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        j = a1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(IMNative imnative, a a1)
    {
        imnative.a(a1);
    }

    private void a(String s, IMNativeListener imnativelistener)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
            return;
        }
        new NativeAd(null, null, null);
        e = s.trim();
        f = imnativelistener;
        h = new NativeAdRequest(e);
        try
        {
            g = new Handler();
            return;
        }
        catch (Throwable throwable)
        {
            Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
        }
    }

    static boolean a(IMNative imnative, boolean flag)
    {
        imnative.i = flag;
        return flag;
    }

    static String b(IMNative imnative)
    {
        return imnative.d;
    }

    static String b(IMNative imnative, String s)
    {
        imnative.c = s;
        return s;
    }

    static String c(IMNative imnative)
    {
        return imnative.b;
    }

    static String c(IMNative imnative, String s)
    {
        imnative.d = s;
        return s;
    }

    static IMNativeListener d(IMNative imnative)
    {
        return imnative.f;
    }

    static Handler e(IMNative imnative)
    {
        return imnative.g;
    }

    public void attachToView(ViewGroup viewgroup)
    {
        try
        {
            if (!InternalSDKUtil.isInitializedSuccessfully())
            {
                Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
                return;
            }
        }
        catch (Exception exception)
        {
            Log.e("[InMobi]-[Monetization]", "Please pass a valid view to attach");
            return;
        }
        if (!i)
        {
            Log.e("[InMobi]-[Monetization]", "Please load a native ad before attach");
            return;
        }
        if (viewgroup != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        Log.e("[InMobi]-[Monetization]", "Please pass a valid view to attach");
        return;
        if (a() == a.d)
        {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Ad is already attached");
            return;
        }
        if (a() != a.c)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (g == null)
        {
            Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
            return;
        }
        g.post(new b(viewgroup));
        a(a.d);
        return;
        Log.e("[InMobi]-[Monetization]", "Cannot attach an ad which is not ready or detached from view");
        return;
    }

    public void detachFromView()
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
            return;
        }
        if (!i)
        {
            Log.e("[InMobi]-[Monetization]", "Please load a native ad before detach");
            return;
        }
        if (a() == a.d)
        {
            if (g == null)
            {
                Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
                return;
            } else
            {
                g.post(new c());
                i = false;
                a(a.e);
                return;
            }
        } else
        {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please attach the native ad view before calling detach");
            return;
        }
    }

    public String getContent()
    {
        return b;
    }

    public void handleClick(HashMap hashmap)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
            return;
        }
        if (!i)
        {
            Log.e("[InMobi]-[Monetization]", "Cannot handle click, native ad not loaded or detached from view");
            return;
        }
        if (a() == a.d)
        {
            if (g == null)
            {
                Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
                return;
            } else
            {
                g.post(new d(hashmap));
                return;
            }
        } else
        {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Please attach to view before handling any events");
            return;
        }
    }

    public void loadAd()
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            Log.e("[InMobi]-[Monetization]", "Please initialize inmobi before requesting for native ads");
        } else
        if (e != null && !"".equals(e))
        {
            if (g == null)
            {
                Log.e("[InMobi]-[Monetization]", "Please create a native ad instance in the main thread");
                return;
            }
            CARB.getInstance().startCarb();
            InternalSDKUtil.printPublisherTestId();
            if (a() == a.a)
            {
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Loading Native Ad");
                a(a.b);
                NativeAdsController.getInstance().getAd(e, h, k);
                return;
            }
            if (a() == a.b)
            {
                Log.e("[InMobi]-[Monetization]", "Ad is already loading. Please wait");
                return;
            }
            if (a() != a.g)
            {
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Loading native ad");
                if (a() == a.d)
                {
                    detachFromView();
                }
                b = null;
                c = null;
                d = null;
                a(a.b);
                NativeAdsController.getInstance().getAd(e, h, k);
                return;
            }
        }
    }

    public void setKeywords(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Network]-4.4.1", "Keywords cannot be null or blank.");
            return;
        } else
        {
            h.setKeywords(s);
            return;
        }
    }

    public void setRefTagParam(String s, String s1)
    {
        if (s == null || "".equals(s.trim()))
        {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Network]-4.4.1", "Ref tag key cannot be null or blank.");
            return;
        }
        if (s1 == null || "".equals(s1.trim()))
        {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Network]-4.4.1", "RefTag value cannot be null or blank.");
            return;
        } else
        {
            h.setRefTagParam(s, s1);
            return;
        }
    }

    public void setRequestParams(Map map)
    {
        if (map == null || map.isEmpty())
        {
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Network]-4.4.1", "Request params cannot be null or empty.");
            return;
        } else
        {
            h.setRequestParams(map);
            return;
        }
    }

    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        private static final a h[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/inmobi/monetization/IMNative$a, s);
        }

        public static a[] values()
        {
            return (a[])h.clone();
        }

        static 
        {
            a = new a("INIT", 0);
            b = new a("LOADING", 1);
            c = new a("READY", 2);
            d = new a("ATTACHED", 3);
            e = new a("DETACHED", 4);
            f = new a("ERROR", 5);
            g = new a("UNKNOWN", 6);
            a aa[] = new a[7];
            aa[0] = a;
            aa[1] = b;
            aa[2] = c;
            aa[3] = d;
            aa[4] = e;
            aa[5] = f;
            aa[6] = g;
            h = aa;
        }

        private a(String s, int l)
        {
            super(s, l);
        }
    }


    private class b
        implements Runnable
    {

        final ViewGroup a;
        final IMNative b;

        public void run()
        {
            try
            {
                b.a = new TrackerView(a.getContext(), IMNative.a(b), IMNative.b(b));
                a.addView(b.a);
                return;
            }
            catch (Exception exception)
            {
                Log.e("[InMobi]-[Monetization]", "Failed to attach the view");
            }
            IMNative.a(b, a.f);
        }

        b(ViewGroup viewgroup)
        {
            b = IMNative.this;
            a = viewgroup;
            super();
        }
    }


    private class c
        implements Runnable
    {

        final IMNative a;

        public void run()
        {
            if (a.a != null)
            {
                a.a.destroy();
                a.a = null;
                return;
            }
            try
            {
                Log.e("[InMobi]-[Monetization]", "Please attach the native ad view before calling detach");
                IMNative.a(a, a.f);
                return;
            }
            catch (Exception exception)
            {
                IMNative.a(a, a.f);
            }
            com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Failed to detach a view");
            return;
        }

        c()
        {
            a = IMNative.this;
            super();
        }
    }


    private class d
        implements Runnable
    {

        final HashMap a;
        final IMNative b;

        public void run()
        {
            try
            {
                b.a.click(a);
                return;
            }
            catch (Exception exception)
            {
                com.inmobi.commons.internal.Log.debug("[InMobi]-[Monetization]", "Failed to track click");
            }
        }

        d(HashMap hashmap)
        {
            b = IMNative.this;
            a = hashmap;
            super();
        }
    }

}
