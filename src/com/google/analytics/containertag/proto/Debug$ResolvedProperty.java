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
import java.util.List;

public final class value extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public String key;
    public com.google.analytics.midtier.proto.containertag.ieldData value;

    public static value parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        key = "";
        value = null;
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
label0:
        {
            if (!(obj instanceof cachedSize))
            {
                return false;
            }
            cachedsize = (cachedSize)obj;
            if ((key != null ? key.equals(cachedsize.key) : cachedsize.key == null) && (value != null ? value.(cachedsize.value) : cachedsize.value == null))
            {
                break label0;
            } else
            {
                break; /* Loop/switch isn't completed */
            }
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
        boolean flag = key.equals("");
        int i = 0;
        if (!flag)
        {
            i = 0 + b.b(1, key);
        }
        if (value != null)
        {
            i += b.b(2, value);
        }
        int j = i + k.a(unknownFieldData);
        cachedSize = j;
        return j;
    }

    public final int hashCode()
    {
        int i;
        int j;
        int l;
        int i1;
        List list;
        int j1;
        if (key == null)
        {
            i = 0;
        } else
        {
            i = key.hashCode();
        }
        j = 31 * (i + 527);
        if (value == null)
        {
            l = 0;
        } else
        {
            l = value.de();
        }
        i1 = 31 * (l + j);
        list = unknownFieldData;
        j1 = 0;
        if (list != null)
        {
            j1 = unknownFieldData.hashCode();
        }
        return i1 + j1;
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

            case 10: // '\n'
                key = a1.e();
                break;

            case 18: // '\022'
                value = new com.google.analytics.midtier.proto.containertag.();
                a1.a(value);
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
        if (!key.equals(""))
        {
            b1.a(1, key);
        }
        if (value != null)
        {
            b1.a(2, value);
        }
        k.a(unknownFieldData, b1);
    }


    public e()
    {
        key = "";
        value = null;
    }
}
