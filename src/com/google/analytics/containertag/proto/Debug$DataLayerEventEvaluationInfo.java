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

public final class RAY extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public unknownFieldData results[];
    public unknownFieldData rulesEvaluation;

    public static RAY parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        rulesEvaluation = null;
        results = RAY;
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
            if ((rulesEvaluation != null ? rulesEvaluation.(cachedsize.rulesEvaluation) : cachedsize.rulesEvaluation == null) && Arrays.equals(results, cachedsize.results))
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
        int i = 0;
        int j;
        int l;
        if (rulesEvaluation != null)
        {
            j = 0 + b.b(1, rulesEvaluation);
        } else
        {
            j = 0;
        }
        if (results != null)
        {
            unknownFieldData aunknownfielddata[] = results;
            for (int i1 = aunknownfielddata.length; i < i1; i++)
            {
                j += b.b(2, aunknownfielddata[i]);
            }

        }
        l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i;
        int j;
        int l;
        int l1;
        List list;
        int i2;
        if (rulesEvaluation == null)
        {
            i = 0;
        } else
        {
            i = rulesEvaluation.de();
        }
        j = i + 527;
        if (results == null)
        {
            l = j * 31;
        } else
        {
            l = j;
            int i1 = 0;
            while (i1 < results.length) 
            {
                int j1 = l * 31;
                int k1;
                if (results[i1] == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = results[i1].();
                }
                l = k1 + j1;
                i1++;
            }
        }
        l1 = l * 31;
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

            case 10: // '\n'
                rulesEvaluation = new ();
                a1.a(rulesEvaluation);
                break;

            case 18: // '\022'
                int j = k.a(a1, 18);
                int l;
                unknownFieldData aunknownfielddata[];
                if (results == null)
                {
                    l = 0;
                } else
                {
                    l = results.length;
                }
                aunknownfielddata = new results[j + l];
                if (results != null)
                {
                    System.arraycopy(results, 0, aunknownfielddata, 0, l);
                }
                for (results = aunknownfielddata; l < -1 + results.length; l++)
                {
                    results[l] = new results();
                    a1.a(results[l]);
                    a1.a();
                }

                results[l] = new results();
                a1.a(results[l]);
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
        if (rulesEvaluation != null)
        {
            b1.a(1, rulesEvaluation);
        }
        if (results != null)
        {
            mergeFrom amergefrom[] = results;
            int i = amergefrom.length;
            for (int j = 0; j < i; j++)
            {
                b1.a(2, amergefrom[j]);
            }

        }
        k.a(unknownFieldData, b1);
    }


    public ()
    {
        rulesEvaluation = null;
        results = RAY;
    }
}
