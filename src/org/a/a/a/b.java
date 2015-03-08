// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;


// Referenced classes of package org.a.a.a:
//            c

public abstract class b
{

    public b()
    {
    }

    static boolean a(byte byte0)
    {
        return (byte0 & 0x80) == 0;
    }

    static boolean b(byte byte0)
    {
        int i = byte0 & 0xff;
        return i < 65 || i > 90 && i < 97 || i > 122;
    }

    public abstract String a();

    public abstract c a(byte abyte0[], int i);

    public abstract float b();

    public abstract c c();

    public abstract void d();
}
