// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            gi

class Ca
    implements Runnable
{

    final int Ca;
    final Ca Cb;

    public void run()
    {
        if (gi.d(Cb.) != null)
        {
            gi.d(Cb.).onApplicationDisconnected(Ca);
        }
    }

    er(er er, int i)
    {
        Cb = er;
        Ca = i;
        super();
    }
}
