// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.a.a.a.a.b;
import com.a.a.b.a.f;
import com.a.a.b.a.g;
import com.a.a.b.a.m;
import com.a.a.b.b.d;
import com.a.a.b.b.e;
import com.a.a.b.d.c;
import com.a.a.b.e.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.Reference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.a.a.b:
//            i, g, k, d, 
//            m, e, n, c

final class l
    implements Runnable
{

    final String a;
    final Reference b;
    final com.a.a.b.d c;
    final com.a.a.b.a.d d;
    private final i e;
    private final k f;
    private final Handler g;
    private final com.a.a.b.g h;
    private final c i;
    private final c j;
    private final c k;
    private final d l;
    private final boolean m;
    private final String n;
    private final f o;
    private g p;
    private boolean q;

    public l(i i1, k k1, Handler handler)
    {
        p = g.a;
        q = false;
        e = i1;
        f = k1;
        g = handler;
        h = i1.a;
        i = h.r;
        j = h.w;
        k = h.x;
        l = h.s;
        m = h.u;
        a = k1.a;
        n = k1.b;
        b = k1.c;
        o = k1.d;
        c = k1.e;
        d = k1.f;
    }

    private Bitmap a(String s)
    {
        ImageView imageview = d();
        if (imageview == null)
        {
            return null;
        } else
        {
            m m1 = com.a.a.b.a.m.a(imageview);
            e e1 = new e(n, s, o, m1, h(), c);
            return l.a(e1);
        }
    }

    private String a(File file)
    {
        b("Cache image on disc [%s]");
        int i1;
        int j1;
        i1 = h.d;
        j1 = h.e;
        boolean flag;
        if (i1 <= 0)
        {
            flag = false;
            if (j1 <= 0)
            {
                break MISSING_BLOCK_LABEL_45;
            }
        }
        flag = a(file, i1, j1);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        java.io.InputStream inputstream = h().a(a, c.j);
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file), 32768);
        com.a.a.c.c.a(inputstream, bufferedoutputstream);
        com.a.a.c.c.a(bufferedoutputstream);
        com.a.a.c.c.a(inputstream);
        String s;
        b b1 = h.q;
        a;
        b1.a(file);
        s = com.a.a.b.d.d.c.b(file.getAbsolutePath());
        return s;
        Exception exception;
        exception;
        com.a.a.c.c.a(bufferedoutputstream);
        throw exception;
        Exception exception1;
        exception1;
        try
        {
            com.a.a.c.c.a(inputstream);
            throw exception1;
        }
        catch (IOException ioexception)
        {
            com.a.a.c.d.a(ioexception);
        }
        return a;
    }

    private void a(com.a.a.b.a.b b1, Throwable throwable)
    {
        if (!Thread.interrupted())
        {
            g.post(new com.a.a.b.m(this, b1, throwable));
        }
    }

    private boolean a()
    {
        AtomicBoolean atomicboolean = e.f;
        atomicboolean;
        JVM INSTR monitorenter ;
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_33;
        }
        b("ImageLoader is paused. Waiting...  [%s]");
        atomicboolean.wait();
        b(".. Resume loading [%s]");
        return c();
        InterruptedException interruptedexception;
        interruptedexception;
        Object aobj[] = new Object[1];
        aobj[0] = n;
        com.a.a.c.d.d("Task was interrupted [%s]", aobj);
        atomicboolean;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean a(File file, int i1, int j1)
    {
        Bitmap bitmap;
        BufferedOutputStream bufferedoutputstream;
        f f1 = new f(i1, j1);
        com.a.a.b.e e1 = new com.a.a.b.e();
        com.a.a.b.d d1 = c;
        e1. = d1.a;
        e1.b = d1.b;
        e1.c = d1.;
        e1.d = d1.d;
        e1.e = d1.e;
        e1.f = d1.f;
        e1.g = d1.g;
        e1.h = d1.h;
        e1.i = d1.i;
        e1.j = d1.j;
        e1.k = d1.k;
        e1.l = d1.l;
        e1.m = d1.m;
        e1.n = d1.n;
        e1.g = com.a.a.b.a.e.c;
        com.a.a.b.d d2 = e1.f();
        e e2 = new e(n, a, f1, m.a, h(), d2);
        bitmap = l.a(e2);
        if (bitmap == null)
        {
            return false;
        }
        if (h.h != null)
        {
            b("Process image before cache on disc [%s]");
            bitmap = h.h.a();
            if (bitmap == null)
            {
                Object aobj[] = new Object[1];
                aobj[0] = n;
                com.a.a.c.d.d("Bitmap processor for disc cache returned null [%s]", aobj);
                return false;
            }
        }
        bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file), 32768);
        boolean flag = bitmap.compress(h.f, h.g, bufferedoutputstream);
        com.a.a.c.c.a(bufferedoutputstream);
        bitmap.recycle();
        return flag;
        Exception exception;
        exception;
        com.a.a.c.c.a(bufferedoutputstream);
        throw exception;
    }

    private void b(String s)
    {
        if (m)
        {
            Object aobj[] = new Object[1];
            aobj[0] = n;
            com.a.a.c.d.a(s, aobj);
        }
    }

    private boolean b()
    {
        boolean flag;
        if (c.i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(c.i);
            aobj[1] = n;
            if (m)
            {
                com.a.a.c.d.a("Delay %d ms before loading...  [%s]", aobj);
            }
            try
            {
                Thread.sleep(c.i);
            }
            catch (InterruptedException interruptedexception)
            {
                Object aobj1[] = new Object[1];
                aobj1[0] = n;
                com.a.a.c.d.d("Task was interrupted [%s]", aobj1);
                return true;
            }
            return c();
        } else
        {
            return false;
        }
    }

    private boolean c()
    {
label0:
        {
            ImageView imageview = d();
            if (imageview != null)
            {
                String s = e.a(imageview);
                boolean flag;
                boolean flag1;
                if (!n.equals(s))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    b("ImageView is reused for another image. Task is cancelled. [%s]");
                    g();
                }
                flag = false;
                if (!flag1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private ImageView d()
    {
        ImageView imageview = (ImageView)b.get();
        if (imageview == null)
        {
            q = true;
            b("ImageView was collected by GC. Task is cancelled. [%s]");
            g();
        }
        return imageview;
    }

    private boolean e()
    {
        boolean flag = Thread.interrupted();
        if (flag)
        {
            b("Task was interrupted [%s]");
        }
        return flag;
    }

    private Bitmap f()
    {
        File file;
        file = h.q.a(a);
        File file1 = file.getParentFile();
        if (file1 == null || !file1.exists() && !file1.mkdirs())
        {
            file = h.v.a(a);
            File file2 = file.getParentFile();
            if (file2 != null && !file2.exists())
            {
                file2.mkdirs();
            }
        }
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        Bitmap bitmap4;
        b("Load image from disc cache [%s]");
        p = g.b;
        bitmap4 = a(com.a.a.b.d.d.c.b(file.getAbsolutePath()));
        Bitmap bitmap2 = bitmap4;
        if (q)
        {
            return null;
        }
_L12:
        if (bitmap2 == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (bitmap2.getWidth() > 0 && bitmap2.getHeight() > 0)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        String s;
        b("Load image from network [%s]");
        p = g.a;
        if (!c.f)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        s = a(file);
_L3:
        if (c())
        {
            break MISSING_BLOCK_LABEL_242;
        }
        bitmap2 = a(s);
        if (q)
        {
            return null;
        }
        break MISSING_BLOCK_LABEL_213;
        s = a;
          goto _L3
        if (bitmap2 == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        if (bitmap2.getWidth() > 0 && bitmap2.getHeight() > 0)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        a(com.a.a.b.a.b.b, null);
        return bitmap2;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Bitmap bitmap3 = null;
_L10:
        a(com.a.a.b.a.b.c, null);
        return bitmap3;
        IOException ioexception;
        ioexception;
        IOException ioexception1;
        bitmap2 = null;
        ioexception1 = ioexception;
_L9:
        com.a.a.c.d.a(ioexception1);
        a(com.a.a.b.a.b.a, ioexception1);
        if (file.exists())
        {
            file.delete();
        }
        return bitmap2;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        OutOfMemoryError outofmemoryerror1;
        Bitmap bitmap1;
        outofmemoryerror1 = outofmemoryerror;
        bitmap1 = null;
_L7:
        com.a.a.c.d.a(outofmemoryerror1);
        a(com.a.a.b.a.b.d, outofmemoryerror1);
        return bitmap1;
        Throwable throwable;
        throwable;
        Throwable throwable1;
        Bitmap bitmap;
        throwable1 = throwable;
        bitmap = null;
_L5:
        com.a.a.c.d.a(throwable1);
        a(com.a.a.b.a.b.e, throwable1);
        return bitmap;
        Throwable throwable2;
        throwable2;
        bitmap = bitmap2;
        throwable1 = throwable2;
        if (true) goto _L5; else goto _L4
_L4:
        OutOfMemoryError outofmemoryerror2;
        outofmemoryerror2;
        bitmap1 = bitmap2;
        outofmemoryerror1 = outofmemoryerror2;
        if (true) goto _L7; else goto _L6
_L6:
        ioexception1;
        if (true) goto _L9; else goto _L8
_L8:
        IllegalStateException illegalstateexception1;
        illegalstateexception1;
        bitmap3 = bitmap2;
        if (true) goto _L10; else goto _L2
_L2:
        bitmap2 = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void g()
    {
        if (!Thread.interrupted())
        {
            g.post(new n(this));
        }
    }

    private c h()
    {
        if (e.g.get())
        {
            return j;
        }
        if (e.h.get())
        {
            return k;
        } else
        {
            return i;
        }
    }

    public final void run()
    {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
_L2:
        ReentrantLock reentrantlock;
        do
        {
            return;
        } while (a() || b());
        reentrantlock = f.g;
        b("Start display image task [%s]");
        if (reentrantlock.isLocked())
        {
            b("Image already is loading. Waiting... [%s]");
        }
        reentrantlock.lock();
        boolean flag1 = c();
        if (flag1)
        {
            reentrantlock.unlock();
            return;
        }
        Bitmap bitmap = (Bitmap)h.p.a(n);
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        boolean flag2;
        bitmap = f();
        flag2 = q;
        if (flag2)
        {
            reentrantlock.unlock();
            return;
        }
        if (bitmap == null)
        {
            reentrantlock.unlock();
            return;
        }
        boolean flag3;
        if (c())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        flag3 = e();
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        reentrantlock.unlock();
        return;
        com.a.a.b.c c1;
        Object aobj[];
        if (c.k == null)
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        b("PreProcess image before caching in memory [%s]");
        bitmap = c.k.a();
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        com.a.a.c.d.d("Pre-processor returned null [%s]", new Object[0]);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        if (c.e)
        {
            b("Cache image in memory [%s]");
            h.p.a(n, bitmap);
        }
_L3:
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        if (!c.a())
        {
            break MISSING_BLOCK_LABEL_301;
        }
        b("PostProcess image before displaying [%s]");
        bitmap = c.l.a();
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        aobj = new Object[1];
        aobj[0] = n;
        com.a.a.c.d.d("Pre-processor returned null [%s]", aobj);
        reentrantlock.unlock();
        if (c() || e()) goto _L2; else goto _L1
_L1:
        c1 = new com.a.a.b.c(bitmap, f, e, p);
        c1.a = m;
        g.post(c1);
        return;
        p = g.c;
        b("...Get cached bitmap from memory after waiting. [%s]");
          goto _L3
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }
}
