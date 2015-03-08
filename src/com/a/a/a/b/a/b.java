// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b.a;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class b extends com.a.a.a.b.b
{

    private final Map a = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));

    public b(int i)
    {
        super(i);
    }

    private Bitmap d()
    {
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator;
        boolean flag;
        iterator = a.entrySet().iterator();
        flag = iterator.hasNext();
        Bitmap bitmap;
        bitmap = null;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        bitmap = (Bitmap)((java.util.Map.Entry)iterator.next()).getValue();
        iterator.remove();
        map;
        JVM INSTR monitorexit ;
        return bitmap;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object a(Object obj)
    {
        String s = (String)obj;
        a.get(s);
        return (Bitmap)super.a(s);
    }

    public final boolean a(Object obj, Object obj1)
    {
        String s = (String)obj;
        Bitmap bitmap = (Bitmap)obj1;
        if (super.a(s, bitmap))
        {
            a.put(s, bitmap);
            return true;
        } else
        {
            return false;
        }
    }

    public final void b()
    {
        a.clear();
        super.b();
    }

    public final void b(Object obj)
    {
        String s = (String)obj;
        a.remove(s);
        super.b(s);
    }

    protected final Object c()
    {
        return d();
    }

    protected final Reference c(Object obj)
    {
        return new WeakReference((Bitmap)obj);
    }

    protected final int d(Object obj)
    {
        Bitmap bitmap = (Bitmap)obj;
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}
