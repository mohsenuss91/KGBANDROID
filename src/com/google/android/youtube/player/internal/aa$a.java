// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.google.android.youtube.player.internal:
//            ac, aa

final class a
    implements android.view.tInflater.Factory
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

    public (ClassLoader classloader)
    {
        a = (ClassLoader)ac.a(classloader, "remoteClassLoader cannot be null");
    }
}
