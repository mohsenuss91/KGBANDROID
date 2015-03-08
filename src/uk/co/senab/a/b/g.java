// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;

import android.content.Context;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import uk.co.senab.a.b.b.a;
import uk.co.senab.a.b.b.b;
import uk.co.senab.a.b.b.c;
import uk.co.senab.a.b.b.d;

final class g
{

    private static final Class a[] = new Class[0];
    private static final Class b[] = new Class[0];
    private static final HashMap c = new HashMap();

    static Object a(Context context, String s)
    {
        Object obj;
        try
        {
            obj = a(context.getClassLoader().loadClass(s), a, new Object[0]);
        }
        catch (Exception exception)
        {
            Log.w("InstanceCreationUtils", (new StringBuilder("Cannot instantiate class: ")).append(s).toString(), exception);
            return null;
        }
        return obj;
    }

    private static transient Object a(Class class1, Class aclass[], Object aobj[])
    {
        Object obj;
        try
        {
            obj = class1.getConstructor(aclass).newInstance(aobj);
        }
        catch (Exception exception)
        {
            Log.w("InstanceCreationUtils", (new StringBuilder("Cannot instantiate class: ")).append(class1.getName()).toString(), exception);
            return null;
        }
        return obj;
    }

    static c a(View view)
    {
        for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((Class)entry.getKey()).isInstance(view))
            {
                view.getContext();
                return (c)a((Class)entry.getValue(), a, new Object[0]);
            }
        }

        return null;
    }

    private static void a(Class aclass[], Class class1)
    {
        int i = 0;
        for (int j = aclass.length; i < j; i++)
        {
            c.put(aclass[i], class1);
        }

    }

    static 
    {
        a(a.a, uk/co/senab/a/b/b/a);
        a(b.a, uk/co/senab/a/b/b/b);
        a(d.a, uk/co/senab/a/b/b/d);
    }
}
