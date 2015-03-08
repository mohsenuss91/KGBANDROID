// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.ae;
import com.google.a.ak;
import com.google.a.b.a.y;
import com.google.a.d.a;
import com.google.a.d.d;
import com.google.a.d.e;
import com.google.a.w;
import com.google.a.x;
import java.io.EOFException;
import java.io.IOException;

public final class ag
{

    public static w a(a a1)
    {
        boolean flag = true;
        w w1;
        try
        {
            a1.f();
        }
        catch (EOFException eofexception)
        {
            if (flag)
            {
                return com.google.a.y.a;
            } else
            {
                throw new ae(eofexception);
            }
        }
        catch (e e1)
        {
            throw new ae(e1);
        }
        catch (IOException ioexception)
        {
            throw new x(ioexception);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new ae(numberformatexception);
        }
        flag = false;
        w1 = (w)y.P.a(a1);
        return w1;
    }

    public static void a(w w1, d d)
    {
        y.P.a(d, w1);
    }
}
