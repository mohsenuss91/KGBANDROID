// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.a.a.a.g;
import org.a.a.a.j;
import org.a.a.a.k;
import org.a.a.a.l;
import org.a.a.c;
import org.a.a.d;

// Referenced classes of package com.appyet.d:
//            d

public final class b
{

    public static String a(byte abyte0[])
    {
        int i = 0;
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        c c1;
        int i1;
        c1 = new c();
        i1 = abyte0.length;
        if (c1.b) goto _L4; else goto _L3
_L3:
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        c1.d = true;
        if (!c1.c) goto _L6; else goto _L5
_L5:
        c1.c = false;
        if (i1 <= 3) goto _L6; else goto _L7
_L7:
        int j1;
        int k1;
        int l1;
        int i2;
        String s;
        float f;
        int j2;
        float f1;
        int k2;
        int l2;
        int i3;
        int j3;
        try
        {
            k2 = 0xff & abyte0[0];
            l2 = 0xff & abyte0[1];
            i3 = 0xff & abyte0[2];
            j3 = 0xff & abyte0[3];
        }
        catch (Exception exception)
        {
            return null;
        }
        k2;
        JVM INSTR lookupswitch 4: default 132
    //                   0: 265
    //                   239: 193
    //                   254: 219
    //                   255: 327;
           goto _L8 _L9 _L10 _L11 _L12
_L8:
        if (c1.f == null) goto _L6; else goto _L13
_L13:
        c1.b = true;
_L4:
        if (!c1.d) goto _L15; else goto _L14
_L14:
        if (c1.f == null) goto _L17; else goto _L16
_L16:
        c1.b = true;
        if (c1.i != null)
        {
            c1.i;
            c1.f;
        }
_L15:
        s = c1.f;
        c1.a();
        return s;
_L10:
        if (l2 != 187 || i3 != 191) goto _L8; else goto _L18
_L18:
        c1.f = org.a.a.b.u;
          goto _L8
_L11:
        if (l2 != 255 || i3 != 0 || j3 != 0) goto _L20; else goto _L19
_L19:
        c1.f = org.a.a.b.A;
          goto _L8
_L20:
        if (l2 != 255) goto _L8; else goto _L21
_L21:
        c1.f = org.a.a.b.v;
          goto _L8
_L9:
        if (l2 != 0 || i3 != 254 || j3 != 255) goto _L23; else goto _L22
_L22:
        c1.f = org.a.a.b.x;
          goto _L8
_L23:
        if (l2 != 0 || i3 != 255 || j3 != 254) goto _L8; else goto _L24
_L24:
        c1.f = org.a.a.b.B;
          goto _L8
_L12:
        if (l2 != 254 || i3 != 0 || j3 != 0) goto _L26; else goto _L25
_L25:
        c1.f = org.a.a.b.y;
          goto _L8
_L26:
        if (l2 != 254) goto _L8; else goto _L27
_L27:
        c1.f = org.a.a.b.w;
          goto _L8
_L47:
        if (k1 >= j1) goto _L29; else goto _L28
_L28:
        l1 = 0xff & abyte0[k1];
        if ((l1 & 0x80) == 0 || l1 == 160) goto _L31; else goto _L30
_L30:
        if (c1.a != d.c)
        {
            c1.a = d.c;
            if (c1.h != null)
            {
                c1.h = null;
            }
            if (c1.g[0] == null)
            {
                c1.g[0] = new k();
            }
            if (c1.g[1] == null)
            {
                c1.g[1] = new l();
            }
            if (c1.g[2] == null)
            {
                c1.g[2] = new j();
            }
        }
          goto _L32
_L31:
        if (c1.a != d.a)
        {
            break MISSING_BLOCK_LABEL_545;
        }
        if (l1 == 27) goto _L34; else goto _L33
_L33:
        if (l1 != 123)
        {
            break MISSING_BLOCK_LABEL_545;
        }
        if (c1.e != 126)
        {
            break MISSING_BLOCK_LABEL_545;
        }
_L34:
        c1.a = d.b;
        c1.e = abyte0[k1];
          goto _L32
_L29:
        if (c1.a != d.b) goto _L36; else goto _L35
_L35:
        if (c1.h == null)
        {
            c1.h = new g();
        }
        if (c1.h.a(abyte0, i1) == org.a.a.a.c.b)
        {
            c1.b = true;
            c1.f = c1.h.a();
        }
          goto _L4
_L36:
        if (c1.a != d.c) goto _L4; else goto _L37
_L37:
        i2 = 0;
_L48:
        if (i2 >= c1.g.length) goto _L4; else goto _L38
_L38:
        if (c1.g[i2].a(abyte0, i1) != org.a.a.a.c.b) goto _L40; else goto _L39
_L39:
        c1.b = true;
        c1.f = c1.g[i2].a();
          goto _L4
_L17:
        if (c1.a != d.c) goto _L42; else goto _L41
_L41:
        f = 0.0F;
        j2 = 0;
_L49:
        if (i >= c1.g.length) goto _L44; else goto _L43
_L43:
        f1 = c1.g[i].b();
          goto _L45
_L44:
        if (f <= 0.2F) goto _L15; else goto _L46
_L46:
        c1.f = c1.g[j2].a();
        if (c1.i != null)
        {
            c1.i;
            c1.f;
        }
          goto _L15
_L42:
        c1.a;
        d.b;
          goto _L15
_L2:
        return null;
_L6:
        j1 = i1 + 0;
        k1 = 0;
          goto _L47
_L32:
        k1++;
          goto _L47
_L40:
        i2++;
          goto _L48
_L45:
        if (f1 > f)
        {
            j2 = i;
        } else
        {
            f1 = f;
        }
        i++;
        f = f1;
          goto _L49
    }

    public static String a(byte abyte0[], String s)
    {
        if (abyte0 != null && s != null)
        {
            String s1;
            try
            {
                s1 = new String(abyte0, s);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                d.a(unsupportedencodingexception);
                return null;
            }
            return s1;
        } else
        {
            return null;
        }
    }

    public static byte[] a(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[16384];
_L1:
        int i = inputstream.read(abyte0, 0, abyte0.length);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L1
        Exception exception1;
        exception1;
        d.a(exception1);
        bytearrayoutputstream.close();
        Exception exception;
        IOException ioexception;
        byte abyte1[];
        byte abyte2[];
        IOException ioexception2;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception1)
            {
                d.a(ioexception1);
            }
        }
        abyte1 = null;
        return abyte1;
        bytearrayoutputstream.flush();
        abyte2 = bytearrayoutputstream.toByteArray();
        abyte1 = abyte2;
        try
        {
            bytearrayoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception2)
        {
            d.a(ioexception2);
            return abyte1;
        }
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        inputstream.close();
        return abyte1;
        exception;
        bytearrayoutputstream.close();
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                d.a(ioexception);
            }
        }
        throw exception;
    }
}
