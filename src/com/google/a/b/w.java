// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

// Referenced classes of package com.google.a.b:
//            x, ad, y, aa

public final class w extends AbstractMap
    implements Serializable
{

    static final boolean f;
    private static final Comparator g = new x();
    Comparator a;
    ad b;
    int c;
    int d;
    final ad e;
    private y h;
    private aa i;

    public w()
    {
        this(g);
    }

    private w(Comparator comparator)
    {
        c = 0;
        d = 0;
        e = new ad();
        if (comparator == null)
        {
            comparator = g;
        }
        a = comparator;
    }

    private ad a(Object obj, boolean flag)
    {
        Comparator comparator;
        ad ad1;
        ad ad3;
        int k;
        comparator = a;
        ad1 = b;
        if (ad1 == null)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        Comparable comparable;
        if (comparator == g)
        {
            comparable = (Comparable)obj;
        } else
        {
            comparable = null;
        }
_L3:
        if (comparable != null)
        {
            k = comparable.compareTo(ad1.f);
        } else
        {
            k = comparator.compare(obj, ad1.f);
        }
        if (k != 0) goto _L2; else goto _L1
_L1:
        ad3 = ad1;
_L5:
        return ad3;
_L2:
label0:
        {
            ad ad6;
            if (k < 0)
            {
                ad6 = ad1.b;
            } else
            {
                ad6 = ad1.c;
            }
            if (ad6 == null)
            {
                break label0;
            }
            ad1 = ad6;
        }
          goto _L3
        ad ad2;
        int j;
        int l = k;
        ad2 = ad1;
        j = l;
_L6:
        ad3 = null;
        if (!flag) goto _L5; else goto _L4
_L4:
        ad ad4 = e;
        ad ad5;
        if (ad2 == null)
        {
            if (comparator == g && !(obj instanceof Comparable))
            {
                throw new ClassCastException((new StringBuilder()).append(obj.getClass().getName()).append(" is not Comparable").toString());
            }
            ad5 = new ad(ad2, obj, ad4, ad4.e);
            b = ad5;
        } else
        {
            ad5 = new ad(ad2, obj, ad4, ad4.e);
            if (j < 0)
            {
                ad2.b = ad5;
            } else
            {
                ad2.c = ad5;
            }
            b(ad2, true);
        }
        c = 1 + c;
        d = 1 + d;
        return ad5;
        ad2 = ad1;
        j = 0;
          goto _L6
    }

    private void a(ad ad1)
    {
        ad ad2 = ad1.b;
        ad ad3 = ad1.c;
        ad ad4 = ad3.b;
        ad ad5 = ad3.c;
        ad1.c = ad4;
        if (ad4 != null)
        {
            ad4.a = ad1;
        }
        a(ad1, ad3);
        ad3.b = ad1;
        ad1.a = ad3;
        int j;
        int k;
        int l;
        int i1;
        if (ad2 != null)
        {
            j = ad2.h;
        } else
        {
            j = 0;
        }
        if (ad4 != null)
        {
            k = ad4.h;
        } else
        {
            k = 0;
        }
        ad1.h = 1 + Math.max(j, k);
        l = ad1.h;
        i1 = 0;
        if (ad5 != null)
        {
            i1 = ad5.h;
        }
        ad3.h = 1 + Math.max(l, i1);
    }

    private void a(ad ad1, ad ad2)
    {
        ad ad3 = ad1.a;
        ad1.a = null;
        if (ad2 != null)
        {
            ad2.a = ad3;
        }
        if (ad3 != null)
        {
            if (ad3.b == ad1)
            {
                ad3.b = ad2;
                return;
            }
            if (!f && ad3.c != ad1)
            {
                throw new AssertionError();
            } else
            {
                ad3.c = ad2;
                return;
            }
        } else
        {
            b = ad2;
            return;
        }
    }

    private ad b(Object obj)
    {
        ad ad1 = null;
        if (obj != null)
        {
            ad ad2;
            try
            {
                ad2 = a(obj, false);
            }
            catch (ClassCastException classcastexception)
            {
                return null;
            }
            ad1 = ad2;
        }
        return ad1;
    }

    private void b(ad ad1)
    {
        ad ad2 = ad1.b;
        ad ad3 = ad1.c;
        ad ad4 = ad2.b;
        ad ad5 = ad2.c;
        ad1.b = ad5;
        if (ad5 != null)
        {
            ad5.a = ad1;
        }
        a(ad1, ad2);
        ad2.c = ad1;
        ad1.a = ad2;
        int j;
        int k;
        int l;
        int i1;
        if (ad3 != null)
        {
            j = ad3.h;
        } else
        {
            j = 0;
        }
        if (ad5 != null)
        {
            k = ad5.h;
        } else
        {
            k = 0;
        }
        ad1.h = 1 + Math.max(j, k);
        l = ad1.h;
        i1 = 0;
        if (ad4 != null)
        {
            i1 = ad4.h;
        }
        ad2.h = 1 + Math.max(l, i1);
    }

    private void b(ad ad1, boolean flag)
    {
_L6:
        if (ad1 == null) goto _L2; else goto _L1
_L1:
        ad ad2;
        ad ad3;
        int j;
        int k;
        int l;
        ad2 = ad1.b;
        ad3 = ad1.c;
        ad ad6;
        ad ad7;
        if (ad2 != null)
        {
            j = ad2.h;
        } else
        {
            j = 0;
        }
        if (ad3 != null)
        {
            k = ad3.h;
        } else
        {
            k = 0;
        }
        l = j - k;
        if (l != -2) goto _L4; else goto _L3
_L3:
        ad6 = ad3.b;
        ad7 = ad3.c;
        int l1;
        int i2;
        int j2;
        if (ad7 != null)
        {
            l1 = ad7.h;
        } else
        {
            l1 = 0;
        }
        if (ad6 != null)
        {
            i2 = ad6.h;
        } else
        {
            i2 = 0;
        }
        j2 = i2 - l1;
        if (j2 == -1 || j2 == 0 && !flag)
        {
            a(ad1);
        } else
        {
            if (!f && j2 != 1)
            {
                throw new AssertionError();
            }
            b(ad3);
            a(ad1);
        }
        if (flag) goto _L2; else goto _L5
_L5:
        ad1 = ad1.a;
          goto _L6
_L4:
        if (l != 2) goto _L8; else goto _L7
_L7:
        ad ad4 = ad2.b;
        ad ad5 = ad2.c;
        int i1;
        int j1;
        int k1;
        if (ad5 != null)
        {
            i1 = ad5.h;
        } else
        {
            i1 = 0;
        }
        if (ad4 != null)
        {
            j1 = ad4.h;
        } else
        {
            j1 = 0;
        }
        k1 = j1 - i1;
        if (k1 == 1 || k1 == 0 && !flag)
        {
            b(ad1);
        } else
        {
            if (!f && k1 != -1)
            {
                throw new AssertionError();
            }
            a(ad2);
            b(ad1);
        }
        if (!flag) goto _L5; else goto _L2
_L2:
        return;
_L8:
        if (l == 0)
        {
            ad1.h = j + 1;
            if (flag)
            {
                return;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
        }
        if (!f && l != -1 && l != 1)
        {
            throw new AssertionError();
        }
        ad1.h = 1 + Math.max(j, k);
        if (!flag) goto _L2; else goto _L5
    }

    final ad a(Object obj)
    {
        ad ad1 = b(obj);
        if (ad1 != null)
        {
            a(ad1, true);
        }
        return ad1;
    }

    final ad a(java.util.Map.Entry entry)
    {
        boolean flag;
        flag = true;
        ad ad1 = b(entry.getKey());
        if (ad1 == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        Object obj = ad1.g;
        Object obj1 = entry.getValue();
        boolean flag1;
        if (obj == obj1 || obj != null && obj.equals(obj1))
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_73;
        }
_L1:
        if (flag)
        {
            return ad1;
        } else
        {
            return null;
        }
        flag = false;
          goto _L1
    }

    final void a(ad ad1, boolean flag)
    {
        if (flag)
        {
            ad1.e.d = ad1.d;
            ad1.d.e = ad1.e;
        }
        ad ad2 = ad1.b;
        ad ad3 = ad1.c;
        ad ad4 = ad1.a;
        if (ad2 != null && ad3 != null)
        {
            ad ad5;
            ad ad6;
            int j;
            ad ad7;
            int k;
            if (ad2.h > ad3.h)
            {
                ad5 = ad2.b();
            } else
            {
                ad5 = ad3.a();
            }
            a(ad5, false);
            ad6 = ad1.b;
            if (ad6 != null)
            {
                j = ad6.h;
                ad5.b = ad6;
                ad6.a = ad5;
                ad1.b = null;
            } else
            {
                j = 0;
            }
            ad7 = ad1.c;
            k = 0;
            if (ad7 != null)
            {
                k = ad7.h;
                ad5.c = ad7;
                ad7.a = ad5;
                ad1.c = null;
            }
            ad5.h = 1 + Math.max(j, k);
            a(ad1, ad5);
            return;
        }
        if (ad2 != null)
        {
            a(ad1, ad2);
            ad1.b = null;
        } else
        if (ad3 != null)
        {
            a(ad1, ad3);
            ad1.c = null;
        } else
        {
            a(ad1, ((ad) (null)));
        }
        b(ad4, false);
        c = -1 + c;
        d = 1 + d;
    }

    public final void clear()
    {
        b = null;
        c = 0;
        d = 1 + d;
        ad ad1 = e;
        ad1.e = ad1;
        ad1.d = ad1;
    }

    public final boolean containsKey(Object obj)
    {
        return b(obj) != null;
    }

    public final Set entrySet()
    {
        y y1 = h;
        if (y1 != null)
        {
            return y1;
        } else
        {
            y y2 = new y(this);
            h = y2;
            return y2;
        }
    }

    public final Object get(Object obj)
    {
        ad ad1 = b(obj);
        if (ad1 != null)
        {
            return ad1.g;
        } else
        {
            return null;
        }
    }

    public final Set keySet()
    {
        aa aa1 = i;
        if (aa1 != null)
        {
            return aa1;
        } else
        {
            aa aa2 = new aa(this);
            i = aa2;
            return aa2;
        }
    }

    public final Object put(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        } else
        {
            ad ad1 = a(obj, true);
            Object obj2 = ad1.g;
            ad1.g = obj1;
            return obj2;
        }
    }

    public final Object remove(Object obj)
    {
        ad ad1 = a(obj);
        if (ad1 != null)
        {
            return ad1.g;
        } else
        {
            return null;
        }
    }

    public final int size()
    {
        return c;
    }

    static 
    {
        boolean flag;
        if (!com/google/a/b/w.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
    }
}
