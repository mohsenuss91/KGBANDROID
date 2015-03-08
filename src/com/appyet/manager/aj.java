// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;


// Referenced classes of package com.appyet.manager:
//            ak

final class aj
{

    static final int a[];

    static 
    {
        a = new int[ak.values().length];
        try
        {
            a[ak.b.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[ak.a.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ak.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2)
        {
            return;
        }
    }
}
