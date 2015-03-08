// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;


// Referenced classes of package com.appyet.f:
//            h

final class e
{

    static final int a[];

    static 
    {
        a = new int[h.values().length];
        try
        {
            a[h.b.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[h.c.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1)
        {
            return;
        }
    }
}
