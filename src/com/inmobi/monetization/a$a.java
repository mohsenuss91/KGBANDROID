// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


// Referenced classes of package com.inmobi.monetization:
//            a, IMNative, IMNativeListener, IMErrorCode

class a
    implements Runnable
{

    final IMErrorCode a;
    final a b;

    public void run()
    {
        if (IMNative.d(b.a) != null)
        {
            IMNative.d(b.a).onNativeRequestFailed(a);
        }
    }

    rorCode(a a1, IMErrorCode imerrorcode)
    {
        b = a1;
        a = imerrorcode;
        super();
    }
}
