// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.b.a.a;
import com.google.a.b.a.c;
import com.google.a.b.a.e;
import com.google.a.b.a.m;
import com.google.a.b.a.p;
import com.google.a.b.a.t;
import com.google.a.b.a.v;
import com.google.a.b.a.y;
import com.google.a.b.af;
import com.google.a.b.f;
import com.google.a.b.s;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.a:
//            d, af, l, m, 
//            p, n, o, ak, 
//            ae, al, q, x, 
//            u, ac, j

public final class k
{

    final u a;
    final ac b;
    private final ThreadLocal c;
    private final Map d;
    private final List e;
    private final f f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    public k()
    {
        this(s.a, ((j) (com.google.a.d.a)), Collections.emptyMap(), false, false, false, true, false, false, com.google.a.af.a, Collections.emptyList());
    }

    k(s s1, j j1, Map map, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, com.google.a.af af1, List list)
    {
        c = new ThreadLocal();
        d = Collections.synchronizedMap(new HashMap());
        a = new l(this);
        b = new com.google.a.m(this);
        f = new f(map);
        g = flag;
        i = flag2;
        h = flag3;
        j = flag4;
        ArrayList arraylist = new ArrayList();
        arraylist.add(y.Q);
        arraylist.add(m.a);
        arraylist.add(s1);
        arraylist.addAll(list);
        arraylist.add(y.x);
        arraylist.add(y.m);
        arraylist.add(y.g);
        arraylist.add(y.i);
        arraylist.add(y.k);
        Class class1 = Long.TYPE;
        Object obj;
        Class class2;
        Object obj1;
        Class class3;
        Object obj2;
        if (af1 == com.google.a.af.a)
        {
            obj = y.n;
        } else
        {
            obj = new com.google.a.p(this);
        }
        arraylist.add(y.a(class1, java/lang/Long, ((ak) (obj))));
        class2 = Double.TYPE;
        if (flag5)
        {
            obj1 = y.p;
        } else
        {
            obj1 = new n(this);
        }
        arraylist.add(y.a(class2, java/lang/Double, ((ak) (obj1))));
        class3 = Float.TYPE;
        if (flag5)
        {
            obj2 = y.o;
        } else
        {
            obj2 = new o(this);
        }
        arraylist.add(y.a(class3, java/lang/Float, ((ak) (obj2))));
        arraylist.add(y.r);
        arraylist.add(y.t);
        arraylist.add(y.z);
        arraylist.add(y.B);
        arraylist.add(y.a(java/math/BigDecimal, y.v));
        arraylist.add(y.a(java/math/BigInteger, y.w));
        arraylist.add(y.D);
        arraylist.add(y.F);
        arraylist.add(y.J);
        arraylist.add(y.O);
        arraylist.add(y.H);
        arraylist.add(y.d);
        arraylist.add(e.a);
        arraylist.add(y.M);
        arraylist.add(v.a);
        arraylist.add(t.a);
        arraylist.add(y.K);
        arraylist.add(a.a);
        arraylist.add(y.R);
        arraylist.add(y.b);
        arraylist.add(new c(f));
        arraylist.add(new com.google.a.b.a.k(f, flag1));
        arraylist.add(new p(f, j1, s1));
        e = Collections.unmodifiableList(arraylist);
    }

    private Object a(com.google.a.d.a a1, Type type)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = a1.p();
        a1.a(flag);
        a1.f();
        flag = false;
        Object obj = a(com.google.a.c.a.a(type)).a(a1);
        a1.a(flag1);
        return obj;
        EOFException eofexception;
        eofexception;
        if (flag)
        {
            a1.a(flag1);
            return null;
        }
        throw new ae(eofexception);
        Exception exception;
        exception;
        a1.a(flag1);
        throw exception;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        throw new ae(illegalstateexception);
        IOException ioexception;
        ioexception;
        throw new ae(ioexception);
    }

    static void a(double d1)
    {
        if (Double.isNaN(d1) || Double.isInfinite(d1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(d1).append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        } else
        {
            return;
        }
    }

    public final ak a(al al1, com.google.a.c.a a1)
    {
        Iterator iterator = e.iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            al al2 = (al)iterator.next();
            if (!flag)
            {
                if (al2 == al1)
                {
                    flag = true;
                }
            } else
            {
                ak ak1 = al2.a(this, a1);
                if (ak1 != null)
                {
                    return ak1;
                }
            }
        }
        throw new IllegalArgumentException((new StringBuilder("GSON cannot serialize ")).append(a1).toString());
    }

    public final ak a(com.google.a.c.a a1)
    {
        Object obj = (ak)d.get(a1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        return ((ak) (obj));
_L2:
        Map map = (Map)c.get();
        Object obj1;
        boolean flag;
        q q1;
        Exception exception;
        Iterator iterator;
        if (map == null)
        {
            HashMap hashmap = new HashMap();
            c.set(hashmap);
            obj1 = hashmap;
            flag = true;
        } else
        {
            obj1 = map;
            flag = false;
        }
        obj = (q)((Map) (obj1)).get(a1);
        if (obj != null) goto _L1; else goto _L3
_L3:
        q1 = new q();
        ((Map) (obj1)).put(a1, q1);
        iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_222;
            }
            obj = ((al)iterator.next()).a(this, a1);
        } while (obj == null);
        if (q1.a != null)
        {
            throw new AssertionError();
        }
        break MISSING_BLOCK_LABEL_181;
        exception;
        ((Map) (obj1)).remove(a1);
        if (flag)
        {
            c.remove();
        }
        throw exception;
        q1.a = ((ak) (obj));
        d.put(a1, obj);
        ((Map) (obj1)).remove(a1);
        if (!flag) goto _L1; else goto _L4
_L4:
        c.remove();
        return ((ak) (obj));
        throw new IllegalArgumentException((new StringBuilder("GSON cannot handle ")).append(a1).toString());
    }

    public final ak a(Class class1)
    {
        return a(com.google.a.c.a.a(class1));
    }

    public final Object a(String s1, Class class1)
    {
        if (s1 != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return af.a(class1).cast(obj);
_L2:
        com.google.a.d.a a1;
        a1 = new com.google.a.d.a(new StringReader(s1));
        obj = a(a1, ((Type) (class1)));
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (a1.f() == com.google.a.d.c.j) goto _L4; else goto _L5
_L5:
        throw new x("JSON document was not fully consumed.");
        com.google.a.d.e e1;
        e1;
        throw new ae(e1);
        IOException ioexception;
        ioexception;
        throw new x(ioexception);
    }

    public final String toString()
    {
        return (new StringBuilder("{serializeNulls:")).append(g).append("factories:").append(e).append(",instanceCreators:").append(f).append("}").toString();
    }
}
