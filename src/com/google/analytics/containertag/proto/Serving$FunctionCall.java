// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.b.a.a.a;
import com.google.b.a.a.b;
import com.google.b.a.a.d;
import com.google.b.a.a.h;
import com.google.b.a.a.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class serverSide extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public int function;
    public boolean liveOnly;
    public int name;
    public int property[];
    public boolean serverSide;

    public static serverSide parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        property = k.e;
        function = 0;
        name = 0;
        liveOnly = false;
        serverSide = false;
        unknownFieldData = null;
        cachedSize = -1;
        return this;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        cachedSize cachedsize;
        if (!(obj instanceof cachedSize))
        {
            return false;
        }
        cachedsize = (cachedSize)obj;
        if (!Arrays.equals(property, cachedsize.property) || function != cachedsize.function || name != cachedsize.name || liveOnly != cachedsize.liveOnly || serverSide != cachedsize.serverSide)
        {
            break; /* Loop/switch isn't completed */
        }
        if (unknownFieldData != null) goto _L4; else goto _L3
_L3:
        if (cachedsize.unknownFieldData == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (unknownFieldData.equals(cachedsize.unknownFieldData))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int getSerializedSize()
    {
        int i = 0;
        int j;
        int l;
        int i1;
        if (serverSide)
        {
            boolean _tmp = serverSide;
            j = 0 + (1 + b.d(1));
        } else
        {
            j = 0;
        }
        l = j + b.b(2, function);
        if (property != null && property.length > 0)
        {
            int ai[] = property;
            int j1 = ai.length;
            int k1 = 0;
            for (; i < j1; i++)
            {
                k1 += b.b(ai[i]);
            }

            l = l + k1 + 1 * property.length;
        }
        if (name != 0)
        {
            l += b.b(4, name);
        }
        if (liveOnly)
        {
            boolean _tmp1 = liveOnly;
            l += 1 + b.d(6);
        }
        i1 = l + k.a(unknownFieldData);
        cachedSize = i1;
        return i1;
    }

    public final int hashCode()
    {
        int i = 1;
        int j;
        int i1;
        int j1;
        int k1;
        int l1;
        List list;
        int i2;
        if (property == null)
        {
            j = 527;
        } else
        {
            j = 17;
            int l = 0;
            while (l < property.length) 
            {
                j = j * 31 + property[l];
                l++;
            }
        }
        i1 = 31 * (31 * (j * 31 + function) + name);
        if (liveOnly)
        {
            j1 = i;
        } else
        {
            j1 = 2;
        }
        k1 = 31 * (j1 + i1);
        if (!serverSide)
        {
            i = 2;
        }
        l1 = 31 * (k1 + i);
        list = unknownFieldData;
        i2 = 0;
        if (list != null)
        {
            i2 = unknownFieldData.hashCode();
        }
        return l1 + i2;
    }

    public final unknownFieldData mergeFrom(a a1)
    {
        do
        {
            int i = a1.a();
            switch (i)
            {
            default:
                if (unknownFieldData == null)
                {
                    unknownFieldData = new ArrayList();
                }
                if (k.a(unknownFieldData, a1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                serverSide = a1.d();
                break;

            case 16: // '\020'
                function = a1.c();
                break;

            case 24: // '\030'
                int j = k.a(a1, 24);
                int l = property.length;
                int ai[] = new int[j + l];
                System.arraycopy(property, 0, ai, 0, l);
                for (property = ai; l < -1 + property.length; l++)
                {
                    property[l] = a1.c();
                    a1.a();
                }

                property[l] = a1.c();
                break;

            case 32: // ' '
                name = a1.c();
                break;

            case 48: // '0'
                liveOnly = a1.d();
                break;
            }
        } while (true);
    }

    public final volatile h mergeFrom(a a1)
    {
        return mergeFrom(a1);
    }

    public final void writeTo(b b1)
    {
        if (serverSide)
        {
            b1.a(1, serverSide);
        }
        b1.a(2, function);
        if (property != null)
        {
            int ai[] = property;
            int i = ai.length;
            for (int j = 0; j < i; j++)
            {
                b1.a(3, ai[j]);
            }

        }
        if (name != 0)
        {
            b1.a(4, name);
        }
        if (liveOnly)
        {
            b1.a(6, liveOnly);
        }
        k.a(unknownFieldData, b1);
    }


    public ()
    {
        property = k.e;
        function = 0;
        name = 0;
        liveOnly = false;
        serverSide = false;
    }
}
