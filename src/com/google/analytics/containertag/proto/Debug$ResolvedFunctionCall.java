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

public final class associatedRuleName extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public String associatedRuleName;
    public unknownFieldData properties[];
    public com.google.analytics.midtier.proto.containertag.ieldData result;

    public static associatedRuleName parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        properties = Y_ARRAY;
        result = null;
        associatedRuleName = "";
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
            if (Arrays.equals(properties, cachedsize.properties) && (result != null ? result.es(cachedsize.result) : cachedsize.result == null) && (associatedRuleName != null ? associatedRuleName.equals(cachedsize.associatedRuleName) : cachedsize.associatedRuleName == null))
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
        unknownFieldData aunknownfielddata[] = properties;
        int i = 0;
        if (aunknownfielddata != null)
        {
            unknownFieldData aunknownfielddata1[] = properties;
            int l = aunknownfielddata1.length;
            for (int i1 = 0; i1 < l;)
            {
                int j1 = i + b.b(1, aunknownfielddata1[i1]);
                i1++;
                i = j1;
            }

        }
        if (result != null)
        {
            i += b.b(2, result);
        }
        if (!associatedRuleName.equals(""))
        {
            i += b.b(3, associatedRuleName);
        }
        int j = i + k.a(unknownFieldData);
        cachedSize = j;
        return j;
    }

    public final int hashCode()
    {
        int i;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        List list;
        int k2;
        if (properties == null)
        {
            i = 527;
        } else
        {
            i = 17;
            int j = 0;
            while (j < properties.length) 
            {
                int l = i * 31;
                int i1;
                if (properties[j] == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = properties[j].Code();
                }
                i = i1 + l;
                j++;
            }
        }
        j1 = i * 31;
        if (result == null)
        {
            k1 = 0;
        } else
        {
            k1 = result.es();
        }
        l1 = 31 * (k1 + j1);
        if (associatedRuleName == null)
        {
            i2 = 0;
        } else
        {
            i2 = associatedRuleName.hashCode();
        }
        j2 = 31 * (i2 + l1);
        list = unknownFieldData;
        k2 = 0;
        if (list != null)
        {
            k2 = unknownFieldData.hashCode();
        }
        return j2 + k2;
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
                int j = k.a(a1, 10);
                int l;
                unknownFieldData aunknownfielddata[];
                if (properties == null)
                {
                    l = 0;
                } else
                {
                    l = properties.length;
                }
                aunknownfielddata = new properties[j + l];
                if (properties != null)
                {
                    System.arraycopy(properties, 0, aunknownfielddata, 0, l);
                }
                for (properties = aunknownfielddata; l < -1 + properties.length; l++)
                {
                    properties[l] = new t>();
                    a1.a(properties[l]);
                    a1.a();
                }

                properties[l] = new t>();
                a1.a(properties[l]);
                break;

            case 18: // '\022'
                result = new com.google.analytics.midtier.proto.containertag.es();
                a1.a(result);
                break;

            case 26: // '\032'
                associatedRuleName = a1.e();
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
        if (properties != null)
        {
            mergeFrom amergefrom[] = properties;
            int i = amergefrom.length;
            for (int j = 0; j < i; j++)
            {
                b1.a(1, amergefrom[j]);
            }

        }
        if (result != null)
        {
            b1.a(2, result);
        }
        if (!associatedRuleName.equals(""))
        {
            b1.a(3, associatedRuleName);
        }
        k.a(unknownFieldData, b1);
    }


    public ()
    {
        properties = Y_ARRAY;
        result = null;
        associatedRuleName = "";
    }
}
