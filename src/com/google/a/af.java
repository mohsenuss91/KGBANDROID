// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;


// Referenced classes of package com.google.a:
//            ag, ah

public abstract class af extends Enum
{

    public static final af a;
    public static final af b;
    private static final af c[];

    private af(String s, int i)
    {
        super(s, i);
    }

    af(String s, int i, byte byte0)
    {
        this(s, i);
    }

    public static af valueOf(String s)
    {
        return (af)Enum.valueOf(com/google/a/af, s);
    }

    public static af[] values()
    {
        return (af[])c.clone();
    }

    static 
    {
        a = new ag("DEFAULT");
        b = new ah("STRING");
        af aaf[] = new af[2];
        aaf[0] = a;
        aaf[1] = b;
        c = aaf;
    }
}
