// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.b.a;
import com.google.a.b.v;
import java.math.BigInteger;

// Referenced classes of package com.google.a:
//            w

public final class ab extends w
{

    private static final Class a[];
    private Object b;

    public ab(Boolean boolean1)
    {
        a(boolean1);
    }

    public ab(Number number)
    {
        a(number);
    }

    public ab(String s)
    {
        a(s);
    }

    private void a(Object obj)
    {
        if (obj instanceof Character)
        {
            b = String.valueOf(((Character)obj).charValue());
            return;
        }
        if (obj instanceof Number) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof String)) goto _L4; else goto _L3
_L3:
        boolean flag1 = true;
_L7:
        boolean flag = false;
        if (!flag1) goto _L5; else goto _L2
_L2:
        flag = true;
_L5:
        com.google.a.b.a.a(flag);
        b = obj;
        return;
_L4:
        Class class1 = obj.getClass();
        Class aclass[] = a;
        int i = aclass.length;
        int j = 0;
        do
        {
            if (j >= i)
            {
                break;
            }
            if (aclass[j].isAssignableFrom(class1))
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while (true);
        flag1 = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static boolean a(ab ab1)
    {
        if (ab1.b instanceof Number)
        {
            Number number = (Number)ab1.b;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        } else
        {
            return false;
        }
    }

    public final Number a()
    {
        if (b instanceof String)
        {
            return new v((String)b);
        } else
        {
            return (Number)b;
        }
    }

    public final String b()
    {
        if (b instanceof Number)
        {
            return a().toString();
        }
        if (b instanceof Boolean)
        {
            return ((Boolean)b).toString();
        } else
        {
            return (String)b;
        }
    }

    public final double c()
    {
        if (b instanceof Number)
        {
            return a().doubleValue();
        } else
        {
            return Double.parseDouble(b());
        }
    }

    public final long d()
    {
        if (b instanceof Number)
        {
            return a().longValue();
        } else
        {
            return Long.parseLong(b());
        }
    }

    public final int e()
    {
        if (b instanceof Number)
        {
            return a().intValue();
        } else
        {
            return Integer.parseInt(b());
        }
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        ab ab1;
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        ab1 = (ab)obj;
        if (b != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (ab1.b != null)
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!a(this) || !a(ab1))
        {
            break; /* Loop/switch isn't completed */
        }
        if (a().longValue() != ab1.a().longValue())
        {
            return false;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if ((b instanceof Number) && (ab1.b instanceof Number))
        {
            double d1 = a().doubleValue();
            double d2 = ab1.a().doubleValue();
            if (d1 != d2 && (!Double.isNaN(d1) || !Double.isNaN(d2)))
            {
                return false;
            }
        } else
        {
            return b.equals(ab1.b);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public final boolean f()
    {
        if (b instanceof Boolean)
        {
            return ((Boolean)b).booleanValue();
        } else
        {
            return Boolean.parseBoolean(b());
        }
    }

    public final int hashCode()
    {
        if (b == null)
        {
            return 31;
        }
        if (a(this))
        {
            long l1 = a().longValue();
            return (int)(l1 ^ l1 >>> 32);
        }
        if (b instanceof Number)
        {
            long l = Double.doubleToLongBits(a().doubleValue());
            return (int)(l ^ l >>> 32);
        } else
        {
            return b.hashCode();
        }
    }

    public final boolean n()
    {
        return b instanceof Boolean;
    }

    public final boolean o()
    {
        return b instanceof Number;
    }

    public final boolean p()
    {
        return b instanceof String;
    }

    static 
    {
        Class aclass[] = new Class[16];
        aclass[0] = Integer.TYPE;
        aclass[1] = Long.TYPE;
        aclass[2] = Short.TYPE;
        aclass[3] = Float.TYPE;
        aclass[4] = Double.TYPE;
        aclass[5] = Byte.TYPE;
        aclass[6] = Boolean.TYPE;
        aclass[7] = Character.TYPE;
        aclass[8] = java/lang/Integer;
        aclass[9] = java/lang/Long;
        aclass[10] = java/lang/Short;
        aclass[11] = java/lang/Float;
        aclass[12] = java/lang/Double;
        aclass[13] = java/lang/Byte;
        aclass[14] = java/lang/Boolean;
        aclass[15] = java/lang/Character;
        a = aclass;
    }
}
