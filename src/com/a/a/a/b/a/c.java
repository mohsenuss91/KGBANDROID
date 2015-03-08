// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b.a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public final class c
    implements com.a.a.a.b.c
{

    private final LinkedHashMap a;
    private final int b;
    private int c;

    public c(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        } else
        {
            b = i;
            a = new LinkedHashMap(0, 0.75F, true);
            return;
        }
    }

    private static int a(Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private Bitmap a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap = (Bitmap)a.get(s);
        this;
        JVM INSTR monitorexit ;
        return bitmap;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(int i)
    {
_L1:
        this;
        JVM INSTR monitorenter ;
        if (c < 0 || a.isEmpty() && c != 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getName()).append(".sizeOf() is reporting inconsistent results!").toString());
        }
        break MISSING_BLOCK_LABEL_64;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (c > i && !a.isEmpty())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        java.util.Map.Entry entry = (java.util.Map.Entry)a.entrySet().iterator().next();
        if (entry != null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        String s = (String)entry.getKey();
        Bitmap bitmap = (Bitmap)entry.getValue();
        a.remove(s);
        c = c - a(bitmap);
        this;
        JVM INSTR monitorexit ;
          goto _L1
    }

    private boolean a(String s, Bitmap bitmap)
    {
        if (s == null || bitmap == null)
        {
            throw new NullPointerException("key == null || value == null");
        }
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap1;
        c = c + a(bitmap);
        bitmap1 = (Bitmap)a.put(s, bitmap);
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        c = c - a(bitmap1);
        this;
        JVM INSTR monitorexit ;
        a(b);
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public final volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    public final Collection a()
    {
        this;
        JVM INSTR monitorenter ;
        HashSet hashset = new HashSet(a.keySet());
        this;
        JVM INSTR monitorexit ;
        return hashset;
        Exception exception;
        exception;
        throw exception;
    }

    public final volatile boolean a(Object obj, Object obj1)
    {
        return a((String)obj, (Bitmap)obj1);
    }

    public final void b()
    {
        a(-1);
    }

    public final void b(Object obj)
    {
        String s;
        s = (String)obj;
        if (s == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap = (Bitmap)a.remove(s);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        c = c - a(bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String toString()
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(b);
        s = String.format("LruCache[maxSize=%d]", aobj);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}
