// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;

// Referenced classes of package com.google.android.youtube.player.internal:
//            y, ac

public final class aa extends y
{

    private static final Class a[] = {
        android/content/Context, android/util/AttributeSet
    };
    private final Resources b;
    private final LayoutInflater c;
    private final android.content.res.Resources.Theme d;

    public aa(Activity activity, Resources resources, ClassLoader classloader, int i)
    {
        super(activity);
        b = (Resources)ac.a(resources, "resources cannot be null");
        LayoutInflater layoutinflater = ((LayoutInflater)super.getSystemService("layout_inflater")).cloneInContext(this);
        layoutinflater.setFactory(new a(classloader));
        c = layoutinflater;
        d = resources.newTheme();
        d.applyStyle(i, false);
    }

    static Class[] a()
    {
        return a;
    }

    public final Context getApplicationContext()
    {
        return super.getApplicationContext();
    }

    public final Context getBaseContext()
    {
        return super.getBaseContext();
    }

    public final Resources getResources()
    {
        return b;
    }

    public final Object getSystemService(String s)
    {
        if ("layout_inflater".equals(s))
        {
            return c;
        } else
        {
            return super.getSystemService(s);
        }
    }

    public final android.content.res.Resources.Theme getTheme()
    {
        return d;
    }


    private class a
        implements android.view.LayoutInflater.Factory
    {

        private final ClassLoader a;

        public final View onCreateView(String s, Context context, AttributeSet attributeset)
        {
            View view;
            try
            {
                view = (View)a.loadClass(s).asSubclass(android/view/View).getConstructor(aa.a()).newInstance(new Object[] {
                    context, attributeset
                });
            }
            catch (NoClassDefFoundError noclassdeffounderror)
            {
                return null;
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                return null;
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                return null;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                return null;
            }
            catch (InstantiationException instantiationexception)
            {
                return null;
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                return null;
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                return null;
            }
            return view;
        }

        public a(ClassLoader classloader)
        {
            a = (ClassLoader)ac.a(classloader, "remoteClassLoader cannot be null");
        }
    }

}
