// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.a.a.b.a.e;
import com.a.a.b.a.f;
import com.a.a.b.a.m;
import com.a.a.b.d.d;
import com.a.a.c.b;
import com.a.a.c.c;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.a.a.b.b:
//            d, b, c, e

public final class a
    implements com.a.a.b.b.d
{

    protected final boolean a;

    public a(boolean flag)
    {
        a = flag;
    }

    private static Bitmap a(InputStream inputstream, android.graphics.BitmapFactory.Options options)
    {
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream, null, options);
        c.a(inputstream);
        return bitmap;
        Exception exception;
        exception;
        c.a(inputstream);
        throw exception;
    }

    private static com.a.a.b.b.b a(String s, String s1)
    {
        int i;
        boolean flag;
        i = 0;
        flag = true;
        if (!"image/jpeg".equalsIgnoreCase(s1) || d.a(s) != d.c) goto _L2; else goto _L1
_L1:
        int j = (new ExifInterface(d.c.c(s))).getAttributeInt("Orientation", 1);
        i = 0;
        j;
        JVM INSTR tableswitch 1 8: default 96
    //                   1 96
    //                   2 98
    //                   3 116
    //                   4 118
    //                   5 127
    //                   6 108
    //                   7 110
    //                   8 125;
           goto _L2 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L2:
        flag = false;
_L3:
        return new com.a.a.b.b.b(i, flag);
_L7:
        flag = false;
_L8:
        i = 90;
        continue; /* Loop/switch isn't completed */
_L4:
        flag = false;
_L5:
        i = 180;
        continue; /* Loop/switch isn't completed */
_L9:
        flag = false;
_L6:
        i = 270;
        if (true) goto _L3; else goto _L10
_L10:
        IOException ioexception;
        ioexception;
        Object aobj[] = new Object[flag];
        aobj[0] = s;
        com.a.a.c.d.c("Can't read EXIF tags from file [%s]", aobj);
        if (true) goto _L2; else goto _L11
_L11:
    }

    private static com.a.a.b.b.c a(InputStream inputstream, String s)
    {
        android.graphics.BitmapFactory.Options options;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        c.a(inputstream);
        Exception exception;
        com.a.a.b.b.b b1;
        if (android.os.Build.VERSION.SDK_INT >= 5)
        {
            b1 = a(s, options.outMimeType);
        } else
        {
            b1 = new com.a.a.b.b.b();
        }
        return new com.a.a.b.b.c(new f(options.outWidth, options.outHeight, b1.a), b1);
        exception;
        c.a(inputstream);
        throw exception;
    }

    private static InputStream b(com.a.a.b.b.e e1)
    {
        return e1.f.a(e1.b, e1.g);
    }

    public final Bitmap a(com.a.a.b.b.e e1)
    {
        com.a.a.b.b.c c1;
        f f1;
        e e2;
        f f2;
        int i;
        c1 = a(b(e1), e1.b);
        f1 = c1.a;
        e2 = e1.d;
        f2 = e1.c;
        i = 1;
        if (e2 == e.a) goto _L2; else goto _L1
_L1:
        Bitmap bitmap;
        boolean flag2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        android.graphics.BitmapFactory.Options options;
        Object aobj3[];
        m m2;
        Object aobj4[];
        if (e2 == e.b)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        m2 = e1.e;
        j2 = f1.a;
        k2 = f1.b;
        l2 = f2.a;
        i3 = f2.b;
        j3 = 1;
        k3 = j2 / l2;
        l3 = k2 / i3;
        b.a[m2.ordinal()];
        JVM INSTR tableswitch 1 2: default 132
    //                   1 270
    //                   2 338;
           goto _L3 _L4 _L5
_L3:
        i = j3;
_L7:
        if (i <= 0)
        {
            i = 1;
        }
        if (a)
        {
            aobj4 = new Object[4];
            aobj4[0] = f1;
            aobj4[1] = new f(f1.a / i, f1.b / i);
            aobj4[2] = Integer.valueOf(i);
            aobj4[3] = e1.a;
            com.a.a.c.d.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", aobj4);
        }
_L2:
        options = e1.h;
        options.inSampleSize = i;
        bitmap = a(b(e1), options);
        if (bitmap == null)
        {
            aobj3 = new Object[1];
            aobj3[0] = e1.a;
            com.a.a.c.d.d("Image can't be decoded [%s]", aobj3);
            return bitmap;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (flag2)
        {
            i = j3;
            int i4 = k2;
            int j4 = j2;
            while (j4 / 2 >= l2 || i4 / 2 >= i3) 
            {
                j4 /= 2;
                i4 /= 2;
                i *= 2;
            }
        } else
        {
            i = Math.max(k3, l3);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (flag2)
        {
            while (j2 / 2 >= l2 && k2 / 2 >= i3) 
            {
                j2 /= 2;
                k2 /= 2;
                j3 *= 2;
            }
            continue; /* Loop/switch isn't completed */
        }
        i = Math.min(k3, l3);
        if (true) goto _L7; else goto _L6
_L6:
        int j = c1.b.a;
        boolean flag = c1.b.b;
        Matrix matrix = new Matrix();
        e e3 = e1.d;
        if (e3 == e.d || e3 == e.e)
        {
            f f3 = new f(bitmap.getWidth(), bitmap.getHeight(), j);
            f f4 = e1.c;
            m m1 = e1.e;
            boolean flag1;
            int k;
            int l;
            int i1;
            int j1;
            float f5;
            float f6;
            int k1;
            int l1;
            float f7;
            Bitmap bitmap1;
            Object aobj[];
            Object aobj1[];
            if (e3 == e.e)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            k = f3.a;
            l = f3.b;
            i1 = f4.a;
            j1 = f4.b;
            f5 = (float)k / (float)i1;
            f6 = (float)l / (float)j1;
            if (m1 == m.a && f5 >= f6 || m1 == m.b && f5 < f6)
            {
                int i2 = (int)((float)l / f5);
                k1 = i1;
                l1 = i2;
            } else
            {
                k1 = (int)((float)k / f6);
                l1 = j1;
            }
            if (!flag1 && k1 < k && l1 < l || flag1 && k1 != k && l1 != l)
            {
                f7 = (float)k1 / (float)k;
            } else
            {
                f7 = 1.0F;
            }
            if (Float.compare(f7, 1.0F) != 0)
            {
                matrix.setScale(f7, f7);
                if (a)
                {
                    Object aobj2[] = new Object[4];
                    aobj2[0] = f3;
                    aobj2[1] = new f((int)(f7 * (float)f3.a), (int)(f7 * (float)f3.b));
                    aobj2[2] = Float.valueOf(f7);
                    aobj2[3] = e1.a;
                    com.a.a.c.d.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", aobj2);
                }
            }
        }
        if (flag)
        {
            matrix.postScale(-1F, 1.0F);
            if (a)
            {
                aobj1 = new Object[1];
                aobj1[0] = e1.a;
                com.a.a.c.d.a("Flip image horizontally [%s]", aobj1);
            }
        }
        if (j != 0)
        {
            matrix.postRotate(j);
            if (a)
            {
                aobj = new Object[2];
                aobj[0] = Integer.valueOf(j);
                aobj[1] = e1.a;
                com.a.a.c.d.a("Rotate image on %1$d\260 [%2$s]", aobj);
            }
        }
        bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmap1 != bitmap)
        {
            bitmap.recycle();
        }
        return bitmap1;
        if (true) goto _L3; else goto _L8
_L8:
    }
}
