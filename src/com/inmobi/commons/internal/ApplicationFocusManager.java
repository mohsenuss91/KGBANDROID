// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.HandlerThread;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inmobi.commons.internal:
//            Log

public class ApplicationFocusManager
{

    protected static final int MSG_PAUSED = 1001;
    protected static final int MSG_RESUMED = 1002;
    private static List a = new ArrayList();
    private static Object b;
    private static HandlerThread c = null;
    private static Application d;

    public ApplicationFocusManager()
    {
    }

    static HandlerThread a()
    {
        return c;
    }

    static void a(Boolean boolean1)
    {
        b(boolean1);
    }

    public static void addFocusChangedListener(FocusChangedListener focuschangedlistener)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a.add(focuschangedlistener);
            if (a.size() == 1)
            {
                b();
                return;
            }
        }
    }

    private static void b()
    {
        Class class1;
        int j;
        Class class2;
        Class aclass[];
        int i;
        Object obj;
        try
        {
            HandlerThread handlerthread = new HandlerThread("InMobiAFM");
            c = handlerthread;
            handlerthread.start();
            aclass = android/app/Application.getDeclaredClasses();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Log.internal("[InMobi]-4.4.1", "Cannot register activity lifecycle callbacks", exception);
            return;
        }
        class1 = null;
        i = aclass.length;
        j = 0;
_L2:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        class2 = aclass[j];
        if (class2.getSimpleName().equalsIgnoreCase("ActivityLifecycleCallbacks"))
        {
            new Class[] {
                class2
            };
            break MISSING_BLOCK_LABEL_150;
        }
        break MISSING_BLOCK_LABEL_147;
        obj = Proxy.newProxyInstance(class1.getClassLoader(), new Class[] {
            class1
        }, new a());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        android/app/Application.getMethod("registerActivityLifecycleCallbacks", new Class[] {
            class1
        }).invoke(d, new Object[] {
            obj
        });
        return;
        class2 = class1;
        j++;
        class1 = class2;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void b(Boolean boolean1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((FocusChangedListener)iterator.next()).onFocusChanged(boolean1.booleanValue())) { }
    }

    private static void c()
    {
        try
        {
            if (b != null)
            {
                android/app/Application.getMethod("unregisterActivityLifecycleCallbacks", null).invoke(d, (Object[])(Object[])b);
            }
            c.stop();
            c = null;
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Log.internal("[InMobi]-4.4.1", "Exception unregister app lifecycle callback", exception);
            return;
        }
    }

    public static void init(Context context)
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14 && d == null)
            {
                if (!(context instanceof Activity))
                {
                    break label0;
                }
                d = ((Activity)context).getApplication();
            }
            return;
        }
        d = (Application)context.getApplicationContext();
    }

    public static void removeFocusChangedListener(FocusChangedListener focuschangedlistener)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a.remove(focuschangedlistener);
            if (a.size() == 0)
            {
                c();
                return;
            }
        }
    }


    private class a
        implements InvocationHandler
    {
        private class b extends Handler
        {

            private boolean a;

            public void handleMessage(Message message)
            {
                if (message.what == 1001 && a)
                {
                    a = false;
                    ApplicationFocusManager.a(Boolean.valueOf(a));
                } else
                if (message.what == 1002 && !a)
                {
                    a = true;
                    ApplicationFocusManager.a(Boolean.valueOf(a));
                    return;
                }
            }

            public b(Looper looper)
            {
                super(looper);
                a = true;
            }
        }


        private final Handler a = new b(ApplicationFocusManager.a().getLooper());

        public final void a(Activity activity)
        {
            a.sendEmptyMessageDelayed(1001, 3000L);
        }

        public final void b(Activity activity)
        {
            a.removeMessages(1001);
            a.sendEmptyMessage(1002);
        }

        public final Object invoke(Object obj, Method method, Object aobj[])
        {
            if (aobj == null)
            {
                break MISSING_BLOCK_LABEL_65;
            }
            if (method.getName().equals("onActivityPaused"))
            {
                a((Activity)aobj[0]);
                break MISSING_BLOCK_LABEL_65;
            }
            try
            {
                if (method.getName().equals("onActivityResumed"))
                {
                    b((Activity)aobj[0]);
                }
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.4.1", "Unable to invoke method", exception);
            }
            return null;
        }

        a()
        {
        }
    }


    private class FocusChangedListener
    {

        public abstract void onFocusChanged(boolean flag);
    }

}
