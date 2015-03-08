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

public final class experimentSupplemental extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public upplemental experimentSupplemental;
    public String name;
    public com.google.analytics.midtier.proto.containertag.tal value;

    public static experimentSupplemental parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        name = "";
        value = null;
        experimentSupplemental = null;
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
            if ((name != null ? name.equals(cachedsize.name) : cachedsize.name == null) && (value != null ? value.ls(cachedsize.value) : cachedsize.value == null) && (experimentSupplemental != null ? experimentSupplemental.equals(cachedsize.experimentSupplemental) : cachedsize.experimentSupplemental == null))
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
        boolean flag = name.equals("");
        int i = 0;
        if (!flag)
        {
            i = 0 + b.b(1, name);
        }
        if (value != null)
        {
            i += b.b(2, value);
        }
        if (experimentSupplemental != null)
        {
            i += b.b(3, experimentSupplemental);
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
        int j1;
        int k1;
        List list;
        int l1;
        if (name == null)
        {
            i = 0;
        } else
        {
            i = name.hashCode();
        }
        j = 31 * (i + 527);
        if (value == null)
        {
            l = 0;
        } else
        {
            l = value.Code();
        }
        i1 = 31 * (l + j);
        if (experimentSupplemental == null)
        {
            j1 = 0;
        } else
        {
            j1 = experimentSupplemental.hashCode();
        }
        k1 = 31 * (j1 + i1);
        list = unknownFieldData;
        l1 = 0;
        if (list != null)
        {
            l1 = unknownFieldData.hashCode();
        }
        return k1 + l1;
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
                name = a1.e();
                break;

            case 18: // '\022'
                value = new com.google.analytics.midtier.proto.containertag.t>();
                a1.a(value);
                break;

            case 26: // '\032'
                experimentSupplemental = new upplemental();
                a1.a(experimentSupplemental);
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
        if (!name.equals(""))
        {
            b1.a(1, name);
        }
        if (value != null)
        {
            b1.a(2, value);
        }
        if (experimentSupplemental != null)
        {
            b1.a(3, experimentSupplemental);
        }
        k.a(unknownFieldData, b1);
    }


    public lue()
    {
        name = "";
        value = null;
        experimentSupplemental = null;
    }
}
