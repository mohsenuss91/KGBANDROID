// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.widget.ImageView;
import com.a.a.b.a.d;
import com.a.a.b.a.f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.a.a.b:
//            d

final class k
{

    final String a;
    final String b;
    final Reference c;
    final f d;
    final com.a.a.b.d e;
    final d f;
    final ReentrantLock g;

    public k(String s, ImageView imageview, f f1, String s1, com.a.a.b.d d1, d d2, ReentrantLock reentrantlock)
    {
        a = s;
        c = new WeakReference(imageview);
        d = f1;
        e = d1;
        f = d2;
        g = reentrantlock;
        b = s1;
    }
}
