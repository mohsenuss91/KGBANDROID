// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;

// Referenced classes of package com.google.android.youtube.player.internal:
//            p

final class <init> extends <init>
{

    final p a;

    public final void a(Bitmap bitmap, String s, boolean flag, boolean flag1)
    {
        class _cls1
            implements Runnable
        {

            final boolean a;
            final boolean b;
            final Bitmap c;
            final String d;
            final p.a e;

            public final void run()
            {
                p.a(e.a, a);
                p.b(e.a, b);
                e.a.a(c, d);
            }

            _cls1(boolean flag, boolean flag1, Bitmap bitmap, String s)
            {
                e = p.a.this;
                a = flag;
                b = flag1;
                c = bitmap;
                d = s;
                super();
            }
        }

        p.a(a).post(new _cls1(flag, flag1, bitmap, s));
    }

    public final void a(String s, boolean flag, boolean flag1)
    {
        class _cls2
            implements Runnable
        {

            final boolean a;
            final boolean b;
            final String c;
            final p.a d;

            public final void run()
            {
                p.a(d.a, a);
                p.b(d.a, b);
                d.a.b(c);
            }

            _cls2(boolean flag, boolean flag1, String s)
            {
                d = p.a.this;
                a = flag;
                b = flag1;
                c = s;
                super();
            }
        }

        p.a(a).post(new _cls2(flag, flag1, s));
    }

    private _cls2(p p1)
    {
        a = p1;
        super();
    }

    <init>(p p1, byte byte0)
    {
        this(p1);
    }
}
