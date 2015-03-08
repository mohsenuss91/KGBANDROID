// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;

public final class hl
{

    public static a e(Object obj)
    {
        return new a(obj, null);
    }

    public static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static transient int hashCode(Object aobj[])
    {
        return Arrays.hashCode(aobj);
    }

    private class a
    {

        private final List GG;
        private final Object GH;

        public final a a(String s, Object obj)
        {
            GG.add((new StringBuilder()).append((String)hn.f(s)).append("=").append(String.valueOf(obj)).toString());
            return this;
        }

        public final String toString()
        {
            StringBuilder stringbuilder = (new StringBuilder(100)).append(GH.getClass().getSimpleName()).append('{');
            int i = GG.size();
            for (int j = 0; j < i; j++)
            {
                stringbuilder.append((String)GG.get(j));
                if (j < i - 1)
                {
                    stringbuilder.append(", ");
                }
            }

            return stringbuilder.append('}').toString();
        }

        private a(Object obj)
        {
            GH = hn.f(obj);
            GG = new ArrayList();
        }

        a(Object obj, _cls1 _pcls1)
        {
            this(obj);
        }
    }

}
