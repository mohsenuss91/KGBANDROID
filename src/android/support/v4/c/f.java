// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.c;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v4.c:
//            h, i, k

abstract class f
{

    h b;
    i c;
    k d;

    f()
    {
    }

    public static boolean a(Set set, Object obj)
    {
        if (set != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof Set))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        Set set1 = (Set)obj;
        boolean flag;
        try
        {
            if (set.size() != set1.size())
            {
                break; /* Loop/switch isn't completed */
            }
            flag = set.containsAll(set1);
        }
        catch (NullPointerException nullpointerexception)
        {
            return false;
        }
        catch (ClassCastException classcastexception)
        {
            return false;
        }
        if (flag) goto _L1; else goto _L3
_L3:
        return false;
        return false;
    }

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int j);

    protected abstract Object a(int i, Object obj);

    protected abstract void a(int i);

    protected abstract void a(Object obj, Object obj1);

    public final Object[] a(Object aobj[], int i)
    {
        int j = a();
        Object aobj1[];
        int k;
        if (aobj.length < j)
        {
            aobj1 = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), j);
        } else
        {
            aobj1 = aobj;
        }
        for (k = 0; k < j; k++)
        {
            aobj1[k] = a(k, i);
        }

        if (aobj1.length > j)
        {
            aobj1[j] = null;
        }
        return aobj1;
    }

    protected abstract int b(Object obj);

    protected abstract Map b();

    public final Object[] b(int i)
    {
        int j = a();
        Object aobj[] = new Object[j];
        for (int k = 0; k < j; k++)
        {
            aobj[k] = a(k, i);
        }

        return aobj;
    }

    protected abstract void c();
}
