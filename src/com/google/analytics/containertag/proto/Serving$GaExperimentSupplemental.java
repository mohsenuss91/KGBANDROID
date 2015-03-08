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

public final class ARRAY extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public unknownFieldData experimentRandom[];
    public com.google.analytics.midtier.proto.containertag.ieldData valueToClear[];
    public com.google.analytics.midtier.proto.containertag.ieldData valueToPush[];

    public static ARRAY parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        valueToPush = com.google.analytics.midtier.proto.containertag.ush;
        valueToClear = com.google.analytics.midtier.proto.containertag.lear;
        experimentRandom = ARRAY;
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
        if (!Arrays.equals(valueToPush, cachedsize.valueToPush) || !Arrays.equals(valueToClear, cachedsize.valueToClear) || !Arrays.equals(experimentRandom, cachedsize.experimentRandom))
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
        if (valueToPush != null)
        {
            com.google.analytics.midtier.proto.containertag.ieldData aielddata1[] = valueToPush;
            int i2 = aielddata1.length;
            int j2 = 0;
            int k2;
            for (j = 0; j2 < i2; j = k2)
            {
                k2 = j + b.b(1, aielddata1[j2]);
                j2++;
            }

        } else
        {
            j = 0;
        }
        if (valueToClear != null)
        {
            com.google.analytics.midtier.proto.containertag.ieldData aielddata[] = valueToClear;
            int j1 = aielddata.length;
            for (int k1 = 0; k1 < j1;)
            {
                int l1 = j + b.b(2, aielddata[k1]);
                k1++;
                j = l1;
            }

        }
        if (experimentRandom != null)
        {
            unknownFieldData aunknownfielddata[] = experimentRandom;
            for (int i1 = aunknownfielddata.length; i < i1; i++)
            {
                j += b.b(3, aunknownfielddata[i]);
            }

        }
        int l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i;
        int l2;
        List list;
        int i3;
        if (valueToPush == null)
        {
            i = 527;
        } else
        {
            i = 17;
            int j = 0;
            while (j < valueToPush.length) 
            {
                int l = i * 31;
                int i1;
                if (valueToPush[j] == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = valueToPush[j].ush();
                }
                i = i1 + l;
                j++;
            }
        }
        if (valueToClear == null)
        {
            i *= 31;
        } else
        {
            int j1 = 0;
            while (j1 < valueToClear.length) 
            {
                int k1 = i * 31;
                int l1;
                if (valueToClear[j1] == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = valueToClear[j1].lear();
                }
                i = l1 + k1;
                j1++;
            }
        }
        if (experimentRandom == null)
        {
            i *= 31;
        } else
        {
            int i2 = 0;
            while (i2 < experimentRandom.length) 
            {
                int j2 = i * 31;
                int k2;
                if (experimentRandom[i2] == null)
                {
                    k2 = 0;
                } else
                {
                    k2 = experimentRandom[i2].de();
                }
                i = k2 + j2;
                i2++;
            }
        }
        l2 = i * 31;
        list = unknownFieldData;
        i3 = 0;
        if (list != null)
        {
            i3 = unknownFieldData.hashCode();
        }
        return l2 + i3;
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
                int k1 = k.a(a1, 10);
                int l1;
                com.google.analytics.midtier.proto.containertag.ieldData aielddata1[];
                if (valueToPush == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = valueToPush.length;
                }
                aielddata1 = new com.google.analytics.midtier.proto.containertag.ush[k1 + l1];
                if (valueToPush != null)
                {
                    System.arraycopy(valueToPush, 0, aielddata1, 0, l1);
                }
                for (valueToPush = aielddata1; l1 < -1 + valueToPush.length; l1++)
                {
                    valueToPush[l1] = new com.google.analytics.midtier.proto.containertag.ush();
                    a1.a(valueToPush[l1]);
                    a1.a();
                }

                valueToPush[l1] = new com.google.analytics.midtier.proto.containertag.ush();
                a1.a(valueToPush[l1]);
                break;

            case 18: // '\022'
                int i1 = k.a(a1, 18);
                int j1;
                com.google.analytics.midtier.proto.containertag.ieldData aielddata[];
                if (valueToClear == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = valueToClear.length;
                }
                aielddata = new com.google.analytics.midtier.proto.containertag.lear[i1 + j1];
                if (valueToClear != null)
                {
                    System.arraycopy(valueToClear, 0, aielddata, 0, j1);
                }
                for (valueToClear = aielddata; j1 < -1 + valueToClear.length; j1++)
                {
                    valueToClear[j1] = new com.google.analytics.midtier.proto.containertag.lear();
                    a1.a(valueToClear[j1]);
                    a1.a();
                }

                valueToClear[j1] = new com.google.analytics.midtier.proto.containertag.lear();
                a1.a(valueToClear[j1]);
                break;

            case 26: // '\032'
                int j = k.a(a1, 26);
                int l;
                unknownFieldData aunknownfielddata[];
                if (experimentRandom == null)
                {
                    l = 0;
                } else
                {
                    l = experimentRandom.length;
                }
                aunknownfielddata = new experimentRandom[j + l];
                if (experimentRandom != null)
                {
                    System.arraycopy(experimentRandom, 0, aunknownfielddata, 0, l);
                }
                for (experimentRandom = aunknownfielddata; l < -1 + experimentRandom.length; l++)
                {
                    experimentRandom[l] = new ();
                    a1.a(experimentRandom[l]);
                    a1.a();
                }

                experimentRandom[l] = new ();
                a1.a(experimentRandom[l]);
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
        if (valueToPush != null)
        {
            com.google.analytics.midtier.proto.containertag.m am1[] = valueToPush;
            int j1 = am1.length;
            for (int k1 = 0; k1 < j1; k1++)
            {
                b1.a(1, am1[k1]);
            }

        }
        if (valueToClear != null)
        {
            com.google.analytics.midtier.proto.containertag.m am[] = valueToClear;
            int l = am.length;
            for (int i1 = 0; i1 < l; i1++)
            {
                b1.a(2, am[i1]);
            }

        }
        if (experimentRandom != null)
        {
            mergeFrom amergefrom[] = experimentRandom;
            for (int j = amergefrom.length; i < j; i++)
            {
                b1.a(3, amergefrom[i]);
            }

        }
        k.a(unknownFieldData, b1);
    }


    public ()
    {
        valueToPush = com.google.analytics.midtier.proto.containertag.ush;
        valueToClear = com.google.analytics.midtier.proto.containertag.lear;
        experimentRandom = ARRAY;
    }
}
