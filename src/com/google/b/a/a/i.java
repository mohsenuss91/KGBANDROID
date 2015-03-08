// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

// Referenced classes of package com.google.b.a.a:
//            h

public final class i
{

    public static String a(h h1)
    {
        if (h1 == null)
        {
            return "null";
        }
        StringBuffer stringbuffer = new StringBuffer();
        try
        {
            a(h1.getClass().getSimpleName(), h1.getClass(), h1, new StringBuffer(), stringbuffer);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            return (new StringBuilder("Error printing proto: ")).append(illegalaccessexception.getMessage()).toString();
        }
        return stringbuffer.toString();
    }

    private static String a(String s)
    {
        int j = s.length();
        StringBuilder stringbuilder = new StringBuilder(j);
        int k = 0;
        while (k < j) 
        {
            char c = s.charAt(k);
            if (c >= ' ' && c <= '~' && c != '"' && c != '\'')
            {
                stringbuilder.append(c);
            } else
            {
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(c);
                stringbuilder.append(String.format("\\u%04x", aobj));
            }
            k++;
        }
        return stringbuilder.toString();
    }

    private static void a(String s, Class class1, Object obj, StringBuffer stringbuffer, StringBuffer stringbuffer1)
    {
        if (!com/google/b/a/a/h.isAssignableFrom(class1)) goto _L2; else goto _L1
_L1:
        if (obj != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        stringbuffer1.append(stringbuffer).append(s);
        stringbuffer.append("  ");
        stringbuffer1.append(" <\n");
        Field afield[] = class1.getFields();
        int k = afield.length;
        for (int l = 0; l < k; l++)
        {
            Field field = afield[l];
            int i1 = field.getModifiers();
            String s4 = field.getName();
            if ((i1 & 1) != 1 || (i1 & 8) == 8 || s4.startsWith("_") || s4.endsWith("_"))
            {
                continue;
            }
            Class class2 = field.getType();
            Object obj1 = field.get(obj);
            if (class2.isArray())
            {
                Class class3 = class2.getComponentType();
                if (class3 != Byte.TYPE)
                {
                    int j1;
                    int k1;
                    if (obj1 == null)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = Array.getLength(obj1);
                    }
                    for (k1 = 0; k1 < j1; k1++)
                    {
                        a(s4, class3, Array.get(obj1, k1), stringbuffer, stringbuffer1);
                    }

                    continue;
                }
            }
            a(s4, class2, obj1, stringbuffer, stringbuffer1);
        }

        stringbuffer.delete(-2 + stringbuffer.length(), stringbuffer.length());
        stringbuffer1.append(stringbuffer).append(">\n");
        return;
_L2:
        if (obj != null)
        {
            StringBuffer stringbuffer2 = new StringBuffer();
            int j = 0;
            while (j < s.length()) 
            {
                char c = s.charAt(j);
                if (j == 0)
                {
                    stringbuffer2.append(Character.toLowerCase(c));
                } else
                if (Character.isUpperCase(c))
                {
                    stringbuffer2.append('_').append(Character.toLowerCase(c));
                } else
                {
                    stringbuffer2.append(c);
                }
                j++;
            }
            String s1 = stringbuffer2.toString();
            stringbuffer1.append(stringbuffer).append(s1).append(": ");
            if (obj instanceof String)
            {
                String s2 = (String)obj;
                if (!s2.startsWith("http") && s2.length() > 200)
                {
                    s2 = (new StringBuilder()).append(s2.substring(0, 200)).append("[...]").toString();
                }
                String s3 = a(s2);
                stringbuffer1.append("\"").append(s3).append("\"");
            } else
            {
                stringbuffer1.append(obj);
            }
            stringbuffer1.append("\n");
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }
}
