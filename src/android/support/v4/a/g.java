// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.support.v4.c.d;

// Referenced classes of package android.support.v4.a:
//            h

public final class g
{

    public int a;
    public h b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    public final void a(h h)
    {
        if (b == null)
        {
            throw new IllegalStateException("No listener register");
        }
        if (b != h)
        {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else
        {
            b = null;
            return;
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        android.support.v4.c.d.a(this, stringbuilder);
        stringbuilder.append(" id=");
        stringbuilder.append(a);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
