// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.a.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.b.a.a:
//            a, j, b, h, 
//            e

public final class k
{

    static final int a = 11;
    static final int b = 12;
    static final int c = 16;
    static final int d = 26;
    public static final int e[] = new int[0];
    public static final long f[] = new long[0];
    public static final float g[] = new float[0];
    public static final double h[] = new double[0];
    public static final boolean i[] = new boolean[0];
    public static final String j[] = new String[0];
    public static final byte k[][] = new byte[0][];
    public static final byte l[] = new byte[0];
    public static final Integer m[] = new Integer[0];
    public static final Long n[] = new Long[0];
    public static final Float o[] = new Float[0];
    public static final Double p[] = new Double[0];
    public static final Boolean q[] = new Boolean[0];

    static int a(int i1)
    {
        return i1 & 7;
    }

    static int a(int i1, int j1)
    {
        return j1 | i1 << 3;
    }

    public static final int a(a a1, int i1)
    {
        int j1 = 1;
        int k1 = a1.i();
        a1.b(i1);
        do
        {
            int i2;
            if (a1.e == 0x7fffffff)
            {
                i2 = -1;
            } else
            {
                int l1 = a1.d;
                i2 = a1.e - l1;
            }
            if (i2 > 0 && a1.a() == i1)
            {
                a1.b(i1);
                j1++;
            } else
            {
                if (k1 > a1.d - a1.b)
                {
                    throw new IllegalArgumentException((new StringBuilder("Position ")).append(k1).append(" is beyond current ").append(a1.d - a1.b).toString());
                }
                if (k1 < 0)
                {
                    throw new IllegalArgumentException((new StringBuilder("Bad position ")).append(k1).toString());
                } else
                {
                    a1.d = k1 + a1.b;
                    return j1;
                }
            }
        } while (true);
    }

    public static int a(List list)
    {
        if (list == null)
        {
            return 0;
        }
        Iterator iterator = list.iterator();
        int i1;
        j j1;
        for (i1 = 0; iterator.hasNext(); i1 = i1 + com.google.b.a.a.b.f(j1.a) + j1.b.length)
        {
            j1 = (j)iterator.next();
        }

        return i1;
    }

    private static j a(int i1, Object obj)
    {
label0:
        {
            {
                Class class1 = obj.getClass();
                if (class1 != java/lang/String)
                {
                    break label0;
                }
                byte abyte0[];
                int j1;
                Integer integer;
                Long long1;
                Boolean boolean1;
                Float float1;
                Double double1;
                b b1;
                long l1;
                byte abyte1[];
                b b2;
                h h1;
                int k1;
                b b3;
                try
                {
                    String s = (String)obj;
                    abyte0 = new byte[com.google.b.a.a.b.b(s)];
                    com.google.b.a.a.b.a(abyte0, 0, abyte0.length).a(s);
                }
                catch (IOException ioexception)
                {
                    throw new IllegalArgumentException(ioexception);
                }
                j1 = 2 | i1 << 3;
            }
            return new j(j1, abyte0);
        }
        if (class1 != java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        integer = (Integer)obj;
        abyte0 = new byte[com.google.b.a.a.b.b(integer.intValue())];
        com.google.b.a.a.b.a(abyte0, 0, abyte0.length).a(integer.intValue());
        j1 = 0 | i1 << 3;
        continue; /* Loop/switch isn't completed */
        if (class1 != java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        long1 = (Long)obj;
        abyte0 = new byte[com.google.b.a.a.b.a(long1.longValue())];
        com.google.b.a.a.b.a(abyte0, 0, abyte0.length).b(long1.longValue());
        j1 = 0 | i1 << 3;
        continue; /* Loop/switch isn't completed */
        if (class1 != java/lang/Boolean)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        boolean1 = (Boolean)obj;
        boolean1.booleanValue();
        abyte0 = new byte[1];
        com.google.b.a.a.b.a(abyte0, 0, abyte0.length).a(boolean1.booleanValue());
        j1 = 0 | i1 << 3;
        continue; /* Loop/switch isn't completed */
        if (class1 != java/lang/Float)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        float1 = (Float)obj;
        float1.floatValue();
        abyte0 = new byte[4];
        com.google.b.a.a.b.a(abyte0, 0, abyte0.length).a(float1.floatValue());
        j1 = 5 | i1 << 3;
        continue; /* Loop/switch isn't completed */
        if (class1 != java/lang/Double)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        double1 = (Double)obj;
        double1.doubleValue();
        abyte0 = new byte[8];
        b1 = com.google.b.a.a.b.a(abyte0, 0, abyte0.length);
        l1 = Double.doubleToLongBits(double1.doubleValue());
        b1.c(0xff & (int)l1);
        b1.c(0xff & (int)(l1 >> 8));
        b1.c(0xff & (int)(l1 >> 16));
        b1.c(0xff & (int)(l1 >> 24));
        b1.c(0xff & (int)(l1 >> 32));
        b1.c(0xff & (int)(l1 >> 40));
        b1.c(0xff & (int)(l1 >> 48));
        b1.c(0xff & (int)(l1 >> 56));
        j1 = 1 | i1 << 3;
        continue; /* Loop/switch isn't completed */
        if (class1 != [B)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        abyte1 = (byte[])(byte[])obj;
        abyte0 = new byte[com.google.b.a.a.b.f(abyte1.length) + abyte1.length];
        b2 = com.google.b.a.a.b.a(abyte0, 0, abyte0.length);
        b2.e(abyte1.length);
        b2.a(abyte1);
        j1 = 2 | i1 << 3;
        continue; /* Loop/switch isn't completed */
        if (!com/google/b/a/a/h.isAssignableFrom(class1))
        {
            break; /* Loop/switch isn't completed */
        }
        h1 = (h)obj;
        k1 = h1.getSerializedSize();
        abyte0 = new byte[k1 + com.google.b.a.a.b.f(k1)];
        b3 = com.google.b.a.a.b.a(abyte0, 0, abyte0.length);
        b3.e(k1);
        b3.a(com.google.b.a.a.h.toByteArray(h1));
        j1 = 2 | i1 << 3;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_47;
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unhandled extension field type: ")).append(class1).toString());
    }

    public static Object a(e e1, List list)
    {
        if (list == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            j j3 = (j)iterator.next();
            if (j3.a >>> 3 == e1.a)
            {
                arraylist.add(j3);
            }
        } while (true);
        if (arraylist.isEmpty())
        {
            return null;
        }
        if (e1.b)
        {
            ArrayList arraylist1 = new ArrayList(arraylist.size());
            j j1;
            for (Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); arraylist1.add(a(e1.c, j1.b)))
            {
                j1 = (j)iterator1.next();
            }

            return e1.d.cast(arraylist1);
        } else
        {
            j j2 = (j)arraylist.get(-1 + arraylist.size());
            return a(e1.c, j2.b);
        }
    }

    private static Object a(Class class1, byte abyte0[])
    {
        if (abyte0.length == 0)
        {
            return null;
        }
        a a1 = com.google.b.a.a.a.a(abyte0, 0, abyte0.length);
        int i1;
        byte abyte1[];
        boolean flag;
        IllegalAccessException illegalaccessexception;
        h h1;
        Object obj;
        if (class1 == java/lang/String)
        {
            try
            {
                return class1.cast(a1.e());
            }
            catch (IOException ioexception)
            {
                throw new IllegalArgumentException("Error reading extension field", ioexception);
            }
        }
        if (class1 != java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        return class1.cast(Integer.valueOf(a1.f()));
        if (class1 != java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        return class1.cast(Long.valueOf(a1.b()));
        if (class1 != java/lang/Boolean)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        return class1.cast(Boolean.valueOf(a1.d()));
        if (class1 != java/lang/Float)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        return class1.cast(Float.valueOf(Float.intBitsToFloat(a1.g())));
        if (class1 != java/lang/Double)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        return class1.cast(Double.valueOf(Double.longBitsToDouble(a1.h())));
        if (class1 != [B) goto _L2; else goto _L1
_L1:
        i1 = a1.f();
        if (i1 > a1.c - a1.d || i1 <= 0) goto _L4; else goto _L3
_L3:
        abyte1 = new byte[i1];
        System.arraycopy(a1.a, a1.d, abyte1, 0, i1);
        a1.d = i1 + a1.d;
_L5:
        return class1.cast(abyte1);
_L4:
        abyte1 = a1.c(i1);
        if (true) goto _L5; else goto _L2
_L2:
        flag = com/google/b/a/a/h.isAssignableFrom(class1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        h1 = (h)class1.newInstance();
        a1.a(h1);
        obj = class1.cast(h1);
        return obj;
        illegalaccessexception;
        throw new IllegalArgumentException((new StringBuilder("Error creating instance of class ")).append(class1).toString(), illegalaccessexception);
        InstantiationException instantiationexception;
        instantiationexception;
        throw new IllegalArgumentException((new StringBuilder("Error creating instance of class ")).append(class1).toString(), instantiationexception);
        throw new IllegalArgumentException((new StringBuilder("Unhandled extension field type: ")).append(class1).toString());
    }

    public static void a(e e1, Object obj, List list)
    {
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            j j1 = (j)iterator.next();
            if (e1.a == j1.a >>> 3)
            {
                iterator.remove();
            }
        } while (true);
        if (obj != null)
        {
            if (obj instanceof List)
            {
                Iterator iterator1 = ((List)obj).iterator();
                while (iterator1.hasNext()) 
                {
                    Object obj1 = iterator1.next();
                    list.add(a(e1.a, obj1));
                }
            } else
            {
                list.add(a(e1.a, obj));
                return;
            }
        }
    }

    public static void a(List list, b b1)
    {
        if (list != null)
        {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                j j1 = (j)iterator.next();
                b1.c(j1.a >>> 3, 7 & j1.a);
                b1.a(j1.b);
            }
        }
    }

    public static boolean a(List list, a a1, int i1)
    {
        int j1 = a1.i();
        boolean flag = a1.b(i1);
        int k1 = a1.i() - j1;
        byte abyte0[];
        if (k1 == 0)
        {
            abyte0 = l;
        } else
        {
            abyte0 = new byte[k1];
            int l1 = j1 + a1.b;
            System.arraycopy(a1.a, l1, abyte0, 0, k1);
        }
        list.add(new j(i1, abyte0));
        return flag;
    }

    public static int b(int i1)
    {
        return i1 >>> 3;
    }

}
