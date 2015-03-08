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

public final class result extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public ionCall addMacros[];
    public ionCall addTags[];
    public ionCall negativePredicates[];
    public ionCall positivePredicates[];
    public ionCall removeMacros[];
    public ionCall removeTags[];
    public com.google.analytics.midtier.proto.containertag.ieldData result;

    public static result parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        positivePredicates = ionCall.EMPTY_ARRAY;
        negativePredicates = ionCall.EMPTY_ARRAY;
        addTags = ionCall.EMPTY_ARRAY;
        removeTags = ionCall.EMPTY_ARRAY;
        addMacros = ionCall.EMPTY_ARRAY;
        removeMacros = ionCall.EMPTY_ARRAY;
        result = null;
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
            if (Arrays.equals(positivePredicates, cachedsize.positivePredicates) && Arrays.equals(negativePredicates, cachedsize.negativePredicates) && Arrays.equals(addTags, cachedsize.addTags) && Arrays.equals(removeTags, cachedsize.removeTags) && Arrays.equals(addMacros, cachedsize.addMacros) && Arrays.equals(removeMacros, cachedsize.removeMacros) && (result != null ? result.uals(cachedsize.result) : cachedsize.result == null))
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
        if (positivePredicates != null)
        {
            ionCall aioncall5[] = positivePredicates;
            int j4 = aioncall5.length;
            int k4 = 0;
            int l4;
            for (j = 0; k4 < j4; j = l4)
            {
                l4 = j + b.b(1, aioncall5[k4]);
                k4++;
            }

        } else
        {
            j = 0;
        }
        if (negativePredicates != null)
        {
            ionCall aioncall4[] = negativePredicates;
            int k3 = aioncall4.length;
            for (int l3 = 0; l3 < k3;)
            {
                int i4 = j + b.b(2, aioncall4[l3]);
                l3++;
                j = i4;
            }

        }
        if (addTags != null)
        {
            ionCall aioncall3[] = addTags;
            int l2 = aioncall3.length;
            for (int i3 = 0; i3 < l2;)
            {
                int j3 = j + b.b(3, aioncall3[i3]);
                i3++;
                j = j3;
            }

        }
        if (removeTags != null)
        {
            ionCall aioncall2[] = removeTags;
            int i2 = aioncall2.length;
            for (int j2 = 0; j2 < i2;)
            {
                int k2 = j + b.b(4, aioncall2[j2]);
                j2++;
                j = k2;
            }

        }
        if (addMacros != null)
        {
            ionCall aioncall1[] = addMacros;
            int j1 = aioncall1.length;
            for (int k1 = 0; k1 < j1;)
            {
                int l1 = j + b.b(5, aioncall1[k1]);
                k1++;
                j = l1;
            }

        }
        if (removeMacros != null)
        {
            ionCall aioncall[] = removeMacros;
            for (int i1 = aioncall.length; i < i1; i++)
            {
                j += b.b(6, aioncall[i]);
            }

        }
        if (result != null)
        {
            j += b.b(7, result);
        }
        int l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i;
        int i5;
        int j5;
        int k5;
        List list;
        int l5;
        if (positivePredicates == null)
        {
            i = 527;
        } else
        {
            i = 17;
            int j = 0;
            while (j < positivePredicates.length) 
            {
                int l = i * 31;
                int i1;
                if (positivePredicates[j] == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = positivePredicates[j].hashCode();
                }
                i = i1 + l;
                j++;
            }
        }
        if (negativePredicates == null)
        {
            i *= 31;
        } else
        {
            int j1 = 0;
            while (j1 < negativePredicates.length) 
            {
                int k1 = i * 31;
                int l1;
                if (negativePredicates[j1] == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = negativePredicates[j1].hashCode();
                }
                i = l1 + k1;
                j1++;
            }
        }
        if (addTags == null)
        {
            i *= 31;
        } else
        {
            int i2 = 0;
            while (i2 < addTags.length) 
            {
                int j2 = i * 31;
                int k2;
                if (addTags[i2] == null)
                {
                    k2 = 0;
                } else
                {
                    k2 = addTags[i2].hashCode();
                }
                i = k2 + j2;
                i2++;
            }
        }
        if (removeTags == null)
        {
            i *= 31;
        } else
        {
            int l2 = 0;
            while (l2 < removeTags.length) 
            {
                int i3 = i * 31;
                int j3;
                if (removeTags[l2] == null)
                {
                    j3 = 0;
                } else
                {
                    j3 = removeTags[l2].hashCode();
                }
                i = j3 + i3;
                l2++;
            }
        }
        if (addMacros == null)
        {
            i *= 31;
        } else
        {
            int k3 = 0;
            while (k3 < addMacros.length) 
            {
                int l3 = i * 31;
                int i4;
                if (addMacros[k3] == null)
                {
                    i4 = 0;
                } else
                {
                    i4 = addMacros[k3].hashCode();
                }
                i = i4 + l3;
                k3++;
            }
        }
        if (removeMacros == null)
        {
            i *= 31;
        } else
        {
            int j4 = 0;
            while (j4 < removeMacros.length) 
            {
                int k4 = i * 31;
                int l4;
                if (removeMacros[j4] == null)
                {
                    l4 = 0;
                } else
                {
                    l4 = removeMacros[j4].hashCode();
                }
                i = l4 + k4;
                j4++;
            }
        }
        i5 = i * 31;
        if (result == null)
        {
            j5 = 0;
        } else
        {
            j5 = result.shCode();
        }
        k5 = 31 * (j5 + i5);
        list = unknownFieldData;
        l5 = 0;
        if (list != null)
        {
            l5 = unknownFieldData.hashCode();
        }
        return k5 + l5;
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
                int i3 = k.a(a1, 10);
                int j3;
                ionCall aioncall5[];
                if (positivePredicates == null)
                {
                    j3 = 0;
                } else
                {
                    j3 = positivePredicates.length;
                }
                aioncall5 = new ionCall[i3 + j3];
                if (positivePredicates != null)
                {
                    System.arraycopy(positivePredicates, 0, aioncall5, 0, j3);
                }
                for (positivePredicates = aioncall5; j3 < -1 + positivePredicates.length; j3++)
                {
                    positivePredicates[j3] = new ionCall();
                    a1.a(positivePredicates[j3]);
                    a1.a();
                }

                positivePredicates[j3] = new ionCall();
                a1.a(positivePredicates[j3]);
                break;

            case 18: // '\022'
                int k2 = k.a(a1, 18);
                int l2;
                ionCall aioncall4[];
                if (negativePredicates == null)
                {
                    l2 = 0;
                } else
                {
                    l2 = negativePredicates.length;
                }
                aioncall4 = new ionCall[k2 + l2];
                if (negativePredicates != null)
                {
                    System.arraycopy(negativePredicates, 0, aioncall4, 0, l2);
                }
                for (negativePredicates = aioncall4; l2 < -1 + negativePredicates.length; l2++)
                {
                    negativePredicates[l2] = new ionCall();
                    a1.a(negativePredicates[l2]);
                    a1.a();
                }

                negativePredicates[l2] = new ionCall();
                a1.a(negativePredicates[l2]);
                break;

            case 26: // '\032'
                int i2 = k.a(a1, 26);
                int j2;
                ionCall aioncall3[];
                if (addTags == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = addTags.length;
                }
                aioncall3 = new ionCall[i2 + j2];
                if (addTags != null)
                {
                    System.arraycopy(addTags, 0, aioncall3, 0, j2);
                }
                for (addTags = aioncall3; j2 < -1 + addTags.length; j2++)
                {
                    addTags[j2] = new ionCall();
                    a1.a(addTags[j2]);
                    a1.a();
                }

                addTags[j2] = new ionCall();
                a1.a(addTags[j2]);
                break;

            case 34: // '"'
                int k1 = k.a(a1, 34);
                int l1;
                ionCall aioncall2[];
                if (removeTags == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = removeTags.length;
                }
                aioncall2 = new ionCall[k1 + l1];
                if (removeTags != null)
                {
                    System.arraycopy(removeTags, 0, aioncall2, 0, l1);
                }
                for (removeTags = aioncall2; l1 < -1 + removeTags.length; l1++)
                {
                    removeTags[l1] = new ionCall();
                    a1.a(removeTags[l1]);
                    a1.a();
                }

                removeTags[l1] = new ionCall();
                a1.a(removeTags[l1]);
                break;

            case 42: // '*'
                int i1 = k.a(a1, 42);
                int j1;
                ionCall aioncall1[];
                if (addMacros == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = addMacros.length;
                }
                aioncall1 = new ionCall[i1 + j1];
                if (addMacros != null)
                {
                    System.arraycopy(addMacros, 0, aioncall1, 0, j1);
                }
                for (addMacros = aioncall1; j1 < -1 + addMacros.length; j1++)
                {
                    addMacros[j1] = new ionCall();
                    a1.a(addMacros[j1]);
                    a1.a();
                }

                addMacros[j1] = new ionCall();
                a1.a(addMacros[j1]);
                break;

            case 50: // '2'
                int j = k.a(a1, 50);
                int l;
                ionCall aioncall[];
                if (removeMacros == null)
                {
                    l = 0;
                } else
                {
                    l = removeMacros.length;
                }
                aioncall = new ionCall[j + l];
                if (removeMacros != null)
                {
                    System.arraycopy(removeMacros, 0, aioncall, 0, l);
                }
                for (removeMacros = aioncall; l < -1 + removeMacros.length; l++)
                {
                    removeMacros[l] = new ionCall();
                    a1.a(removeMacros[l]);
                    a1.a();
                }

                removeMacros[l] = new ionCall();
                a1.a(removeMacros[l]);
                break;

            case 58: // ':'
                result = new com.google.analytics.midtier.proto.containertag.nit>();
                a1.a(result);
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
        if (positivePredicates != null)
        {
            ionCall aioncall5[] = positivePredicates;
            int l2 = aioncall5.length;
            for (int i3 = 0; i3 < l2; i3++)
            {
                b1.a(1, aioncall5[i3]);
            }

        }
        if (negativePredicates != null)
        {
            ionCall aioncall4[] = negativePredicates;
            int j2 = aioncall4.length;
            for (int k2 = 0; k2 < j2; k2++)
            {
                b1.a(2, aioncall4[k2]);
            }

        }
        if (addTags != null)
        {
            ionCall aioncall3[] = addTags;
            int l1 = aioncall3.length;
            for (int i2 = 0; i2 < l1; i2++)
            {
                b1.a(3, aioncall3[i2]);
            }

        }
        if (removeTags != null)
        {
            ionCall aioncall2[] = removeTags;
            int j1 = aioncall2.length;
            for (int k1 = 0; k1 < j1; k1++)
            {
                b1.a(4, aioncall2[k1]);
            }

        }
        if (addMacros != null)
        {
            ionCall aioncall1[] = addMacros;
            int l = aioncall1.length;
            for (int i1 = 0; i1 < l; i1++)
            {
                b1.a(5, aioncall1[i1]);
            }

        }
        if (removeMacros != null)
        {
            ionCall aioncall[] = removeMacros;
            for (int j = aioncall.length; i < j; i++)
            {
                b1.a(6, aioncall[i]);
            }

        }
        if (result != null)
        {
            b1.a(7, result);
        }
        k.a(unknownFieldData, b1);
    }


    public Value()
    {
        positivePredicates = ionCall.EMPTY_ARRAY;
        negativePredicates = ionCall.EMPTY_ARRAY;
        addTags = ionCall.EMPTY_ARRAY;
        removeTags = ionCall.EMPTY_ARRAY;
        addMacros = ionCall.EMPTY_ARRAY;
        removeMacros = ionCall.EMPTY_ARRAY;
        result = null;
    }
}
