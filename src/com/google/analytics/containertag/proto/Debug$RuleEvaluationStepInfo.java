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

public final class PTY_ARRAY extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public unknownFieldData enabledFunctions[];
    public unknownFieldData rules[];

    public static PTY_ARRAY parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        rules = Y;
        enabledFunctions = PTY_ARRAY;
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
        if (!Arrays.equals(rules, cachedsize.rules) || !Arrays.equals(enabledFunctions, cachedsize.enabledFunctions))
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
        if (rules != null)
        {
            unknownFieldData aunknownfielddata1[] = rules;
            int j1 = aunknownfielddata1.length;
            int k1 = 0;
            int l1;
            for (j = 0; k1 < j1; j = l1)
            {
                l1 = j + b.b(1, aunknownfielddata1[k1]);
                k1++;
            }

        } else
        {
            j = 0;
        }
        if (enabledFunctions != null)
        {
            unknownFieldData aunknownfielddata[] = enabledFunctions;
            for (int i1 = aunknownfielddata.length; i < i1; i++)
            {
                j += b.b(2, aunknownfielddata[i]);
            }

        }
        int l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i;
        int i2;
        List list;
        int j2;
        if (rules == null)
        {
            i = 527;
        } else
        {
            i = 17;
            int j = 0;
            while (j < rules.length) 
            {
                int l = i * 31;
                int i1;
                if (rules[j] == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = rules[j].rules();
                }
                i = i1 + l;
                j++;
            }
        }
        if (enabledFunctions == null)
        {
            i *= 31;
        } else
        {
            int j1 = 0;
            while (j1 < enabledFunctions.length) 
            {
                int k1 = i * 31;
                int l1;
                if (enabledFunctions[j1] == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = enabledFunctions[j1].shCode();
                }
                i = l1 + k1;
                j1++;
            }
        }
        i2 = i * 31;
        list = unknownFieldData;
        j2 = 0;
        if (list != null)
        {
            j2 = unknownFieldData.hashCode();
        }
        return i2 + j2;
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
                int i1 = k.a(a1, 10);
                int j1;
                unknownFieldData aunknownfielddata1[];
                if (rules == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = rules.length;
                }
                aunknownfielddata1 = new rules[i1 + j1];
                if (rules != null)
                {
                    System.arraycopy(rules, 0, aunknownfielddata1, 0, j1);
                }
                for (rules = aunknownfielddata1; j1 < -1 + rules.length; j1++)
                {
                    rules[j1] = new rules();
                    a1.a(rules[j1]);
                    a1.a();
                }

                rules[j1] = new rules();
                a1.a(rules[j1]);
                break;

            case 18: // '\022'
                int j = k.a(a1, 18);
                int l;
                unknownFieldData aunknownfielddata[];
                if (enabledFunctions == null)
                {
                    l = 0;
                } else
                {
                    l = enabledFunctions.length;
                }
                aunknownfielddata = new enabledFunctions[j + l];
                if (enabledFunctions != null)
                {
                    System.arraycopy(enabledFunctions, 0, aunknownfielddata, 0, l);
                }
                for (enabledFunctions = aunknownfielddata; l < -1 + enabledFunctions.length; l++)
                {
                    enabledFunctions[l] = new nit>();
                    a1.a(enabledFunctions[l]);
                    a1.a();
                }

                enabledFunctions[l] = new nit>();
                a1.a(enabledFunctions[l]);
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
        int i = 0;
        if (rules != null)
        {
            mergeFrom amergefrom1[] = rules;
            int l = amergefrom1.length;
            for (int i1 = 0; i1 < l; i1++)
            {
                b1.a(1, amergefrom1[i1]);
            }

        }
        if (enabledFunctions != null)
        {
            mergeFrom amergefrom[] = enabledFunctions;
            for (int j = amergefrom.length; i < j; i++)
            {
                b1.a(2, amergefrom[i]);
            }

        }
        k.a(unknownFieldData, b1);
    }


    public ()
    {
        rules = Y;
        enabledFunctions = PTY_ARRAY;
    }
}
