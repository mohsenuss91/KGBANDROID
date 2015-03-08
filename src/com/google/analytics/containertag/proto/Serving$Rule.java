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

public final class removeMacroRuleName extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public int addMacro[];
    public int addMacroRuleName[];
    public int addTag[];
    public int addTagRuleName[];
    public int negativePredicate[];
    public int positivePredicate[];
    public int removeMacro[];
    public int removeMacroRuleName[];
    public int removeTag[];
    public int removeTagRuleName[];

    public static removeMacroRuleName parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        positivePredicate = k.e;
        negativePredicate = k.e;
        addTag = k.e;
        removeTag = k.e;
        addTagRuleName = k.e;
        removeTagRuleName = k.e;
        addMacro = k.e;
        removeMacro = k.e;
        addMacroRuleName = k.e;
        removeMacroRuleName = k.e;
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
        if (!Arrays.equals(positivePredicate, cachedsize.positivePredicate) || !Arrays.equals(negativePredicate, cachedsize.negativePredicate) || !Arrays.equals(addTag, cachedsize.addTag) || !Arrays.equals(removeTag, cachedsize.removeTag) || !Arrays.equals(addTagRuleName, cachedsize.addTagRuleName) || !Arrays.equals(removeTagRuleName, cachedsize.removeTagRuleName) || !Arrays.equals(addMacro, cachedsize.addMacro) || !Arrays.equals(removeMacro, cachedsize.removeMacro) || !Arrays.equals(addMacroRuleName, cachedsize.addMacroRuleName) || !Arrays.equals(removeMacroRuleName, cachedsize.removeMacroRuleName))
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
        if (positivePredicate != null && positivePredicate.length > 0)
        {
            int ai9[] = positivePredicate;
            int k7 = ai9.length;
            int l7 = 0;
            int i8 = 0;
            for (; l7 < k7; l7++)
            {
                i8 += b.b(ai9[l7]);
            }

            j = i8 + 0 + 1 * positivePredicate.length;
        } else
        {
            j = 0;
        }
        if (negativePredicate != null && negativePredicate.length > 0)
        {
            int ai8[] = negativePredicate;
            int l6 = ai8.length;
            int i7 = 0;
            int j7 = 0;
            for (; i7 < l6; i7++)
            {
                j7 += b.b(ai8[i7]);
            }

            j = j + j7 + 1 * negativePredicate.length;
        }
        if (addTag != null && addTag.length > 0)
        {
            int ai7[] = addTag;
            int i6 = ai7.length;
            int j6 = 0;
            int k6 = 0;
            for (; j6 < i6; j6++)
            {
                k6 += b.b(ai7[j6]);
            }

            j = j + k6 + 1 * addTag.length;
        }
        if (removeTag != null && removeTag.length > 0)
        {
            int ai6[] = removeTag;
            int j5 = ai6.length;
            int k5 = 0;
            int l5 = 0;
            for (; k5 < j5; k5++)
            {
                l5 += b.b(ai6[k5]);
            }

            j = j + l5 + 1 * removeTag.length;
        }
        if (addTagRuleName != null && addTagRuleName.length > 0)
        {
            int ai5[] = addTagRuleName;
            int k4 = ai5.length;
            int l4 = 0;
            int i5 = 0;
            for (; l4 < k4; l4++)
            {
                i5 += b.b(ai5[l4]);
            }

            j = j + i5 + 1 * addTagRuleName.length;
        }
        if (removeTagRuleName != null && removeTagRuleName.length > 0)
        {
            int ai4[] = removeTagRuleName;
            int l3 = ai4.length;
            int i4 = 0;
            int j4 = 0;
            for (; i4 < l3; i4++)
            {
                j4 += b.b(ai4[i4]);
            }

            j = j + j4 + 1 * removeTagRuleName.length;
        }
        if (addMacro != null && addMacro.length > 0)
        {
            int ai3[] = addMacro;
            int i3 = ai3.length;
            int j3 = 0;
            int k3 = 0;
            for (; j3 < i3; j3++)
            {
                k3 += b.b(ai3[j3]);
            }

            j = j + k3 + 1 * addMacro.length;
        }
        if (removeMacro != null && removeMacro.length > 0)
        {
            int ai2[] = removeMacro;
            int j2 = ai2.length;
            int k2 = 0;
            int l2 = 0;
            for (; k2 < j2; k2++)
            {
                l2 += b.b(ai2[k2]);
            }

            j = j + l2 + 1 * removeMacro.length;
        }
        if (addMacroRuleName != null && addMacroRuleName.length > 0)
        {
            int ai1[] = addMacroRuleName;
            int k1 = ai1.length;
            int l1 = 0;
            int i2 = 0;
            for (; l1 < k1; l1++)
            {
                i2 += b.b(ai1[l1]);
            }

            j = j + i2 + 1 * addMacroRuleName.length;
        }
        if (removeMacroRuleName != null && removeMacroRuleName.length > 0)
        {
            int ai[] = removeMacroRuleName;
            int i1 = ai.length;
            int j1 = 0;
            for (; i < i1; i++)
            {
                j1 += b.b(ai[i]);
            }

            j = j + j1 + 1 * removeMacroRuleName.length;
        }
        l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i;
        int i3;
        List list;
        int j3;
        if (positivePredicate == null)
        {
            i = 527;
        } else
        {
            i = 17;
            int j = 0;
            while (j < positivePredicate.length) 
            {
                i = i * 31 + positivePredicate[j];
                j++;
            }
        }
        if (negativePredicate == null)
        {
            i *= 31;
        } else
        {
            int l = 0;
            while (l < negativePredicate.length) 
            {
                i = i * 31 + negativePredicate[l];
                l++;
            }
        }
        if (addTag == null)
        {
            i *= 31;
        } else
        {
            int i1 = 0;
            while (i1 < addTag.length) 
            {
                i = i * 31 + addTag[i1];
                i1++;
            }
        }
        if (removeTag == null)
        {
            i *= 31;
        } else
        {
            int j1 = 0;
            while (j1 < removeTag.length) 
            {
                i = i * 31 + removeTag[j1];
                j1++;
            }
        }
        if (addTagRuleName == null)
        {
            i *= 31;
        } else
        {
            int k1 = 0;
            while (k1 < addTagRuleName.length) 
            {
                i = i * 31 + addTagRuleName[k1];
                k1++;
            }
        }
        if (removeTagRuleName == null)
        {
            i *= 31;
        } else
        {
            int l1 = 0;
            while (l1 < removeTagRuleName.length) 
            {
                i = i * 31 + removeTagRuleName[l1];
                l1++;
            }
        }
        if (addMacro == null)
        {
            i *= 31;
        } else
        {
            int i2 = 0;
            while (i2 < addMacro.length) 
            {
                i = i * 31 + addMacro[i2];
                i2++;
            }
        }
        if (removeMacro == null)
        {
            i *= 31;
        } else
        {
            int j2 = 0;
            while (j2 < removeMacro.length) 
            {
                i = i * 31 + removeMacro[j2];
                j2++;
            }
        }
        if (addMacroRuleName == null)
        {
            i *= 31;
        } else
        {
            int k2 = 0;
            while (k2 < addMacroRuleName.length) 
            {
                i = i * 31 + addMacroRuleName[k2];
                k2++;
            }
        }
        if (removeMacroRuleName == null)
        {
            i *= 31;
        } else
        {
            int l2 = 0;
            while (l2 < removeMacroRuleName.length) 
            {
                i = i * 31 + removeMacroRuleName[l2];
                l2++;
            }
        }
        i3 = i * 31;
        list = unknownFieldData;
        j3 = 0;
        if (list != null)
        {
            j3 = unknownFieldData.hashCode();
        }
        return i3 + j3;
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
                int i5 = k.a(a1, 8);
                int j5 = positivePredicate.length;
                int ai9[] = new int[i5 + j5];
                System.arraycopy(positivePredicate, 0, ai9, 0, j5);
                for (positivePredicate = ai9; j5 < -1 + positivePredicate.length; j5++)
                {
                    positivePredicate[j5] = a1.c();
                    a1.a();
                }

                positivePredicate[j5] = a1.c();
                break;

            case 16: // '\020'
                int k4 = k.a(a1, 16);
                int l4 = negativePredicate.length;
                int ai8[] = new int[k4 + l4];
                System.arraycopy(negativePredicate, 0, ai8, 0, l4);
                for (negativePredicate = ai8; l4 < -1 + negativePredicate.length; l4++)
                {
                    negativePredicate[l4] = a1.c();
                    a1.a();
                }

                negativePredicate[l4] = a1.c();
                break;

            case 24: // '\030'
                int i4 = k.a(a1, 24);
                int j4 = addTag.length;
                int ai7[] = new int[i4 + j4];
                System.arraycopy(addTag, 0, ai7, 0, j4);
                for (addTag = ai7; j4 < -1 + addTag.length; j4++)
                {
                    addTag[j4] = a1.c();
                    a1.a();
                }

                addTag[j4] = a1.c();
                break;

            case 32: // ' '
                int k3 = k.a(a1, 32);
                int l3 = removeTag.length;
                int ai6[] = new int[k3 + l3];
                System.arraycopy(removeTag, 0, ai6, 0, l3);
                for (removeTag = ai6; l3 < -1 + removeTag.length; l3++)
                {
                    removeTag[l3] = a1.c();
                    a1.a();
                }

                removeTag[l3] = a1.c();
                break;

            case 40: // '('
                int i3 = k.a(a1, 40);
                int j3 = addTagRuleName.length;
                int ai5[] = new int[i3 + j3];
                System.arraycopy(addTagRuleName, 0, ai5, 0, j3);
                for (addTagRuleName = ai5; j3 < -1 + addTagRuleName.length; j3++)
                {
                    addTagRuleName[j3] = a1.c();
                    a1.a();
                }

                addTagRuleName[j3] = a1.c();
                break;

            case 48: // '0'
                int k2 = k.a(a1, 48);
                int l2 = removeTagRuleName.length;
                int ai4[] = new int[k2 + l2];
                System.arraycopy(removeTagRuleName, 0, ai4, 0, l2);
                for (removeTagRuleName = ai4; l2 < -1 + removeTagRuleName.length; l2++)
                {
                    removeTagRuleName[l2] = a1.c();
                    a1.a();
                }

                removeTagRuleName[l2] = a1.c();
                break;

            case 56: // '8'
                int i2 = k.a(a1, 56);
                int j2 = addMacro.length;
                int ai3[] = new int[i2 + j2];
                System.arraycopy(addMacro, 0, ai3, 0, j2);
                for (addMacro = ai3; j2 < -1 + addMacro.length; j2++)
                {
                    addMacro[j2] = a1.c();
                    a1.a();
                }

                addMacro[j2] = a1.c();
                break;

            case 64: // '@'
                int k1 = k.a(a1, 64);
                int l1 = removeMacro.length;
                int ai2[] = new int[k1 + l1];
                System.arraycopy(removeMacro, 0, ai2, 0, l1);
                for (removeMacro = ai2; l1 < -1 + removeMacro.length; l1++)
                {
                    removeMacro[l1] = a1.c();
                    a1.a();
                }

                removeMacro[l1] = a1.c();
                break;

            case 72: // 'H'
                int i1 = k.a(a1, 72);
                int j1 = addMacroRuleName.length;
                int ai1[] = new int[i1 + j1];
                System.arraycopy(addMacroRuleName, 0, ai1, 0, j1);
                for (addMacroRuleName = ai1; j1 < -1 + addMacroRuleName.length; j1++)
                {
                    addMacroRuleName[j1] = a1.c();
                    a1.a();
                }

                addMacroRuleName[j1] = a1.c();
                break;

            case 80: // 'P'
                int j = k.a(a1, 80);
                int l = removeMacroRuleName.length;
                int ai[] = new int[j + l];
                System.arraycopy(removeMacroRuleName, 0, ai, 0, l);
                for (removeMacroRuleName = ai; l < -1 + removeMacroRuleName.length; l++)
                {
                    removeMacroRuleName[l] = a1.c();
                    a1.a();
                }

                removeMacroRuleName[l] = a1.c();
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
        if (positivePredicate != null)
        {
            int ai9[] = positivePredicate;
            int l4 = ai9.length;
            for (int i5 = 0; i5 < l4; i5++)
            {
                b1.a(1, ai9[i5]);
            }

        }
        if (negativePredicate != null)
        {
            int ai8[] = negativePredicate;
            int j4 = ai8.length;
            for (int k4 = 0; k4 < j4; k4++)
            {
                b1.a(2, ai8[k4]);
            }

        }
        if (addTag != null)
        {
            int ai7[] = addTag;
            int l3 = ai7.length;
            for (int i4 = 0; i4 < l3; i4++)
            {
                b1.a(3, ai7[i4]);
            }

        }
        if (removeTag != null)
        {
            int ai6[] = removeTag;
            int j3 = ai6.length;
            for (int k3 = 0; k3 < j3; k3++)
            {
                b1.a(4, ai6[k3]);
            }

        }
        if (addTagRuleName != null)
        {
            int ai5[] = addTagRuleName;
            int l2 = ai5.length;
            for (int i3 = 0; i3 < l2; i3++)
            {
                b1.a(5, ai5[i3]);
            }

        }
        if (removeTagRuleName != null)
        {
            int ai4[] = removeTagRuleName;
            int j2 = ai4.length;
            for (int k2 = 0; k2 < j2; k2++)
            {
                b1.a(6, ai4[k2]);
            }

        }
        if (addMacro != null)
        {
            int ai3[] = addMacro;
            int l1 = ai3.length;
            for (int i2 = 0; i2 < l1; i2++)
            {
                b1.a(7, ai3[i2]);
            }

        }
        if (removeMacro != null)
        {
            int ai2[] = removeMacro;
            int j1 = ai2.length;
            for (int k1 = 0; k1 < j1; k1++)
            {
                b1.a(8, ai2[k1]);
            }

        }
        if (addMacroRuleName != null)
        {
            int ai1[] = addMacroRuleName;
            int l = ai1.length;
            for (int i1 = 0; i1 < l; i1++)
            {
                b1.a(9, ai1[i1]);
            }

        }
        if (removeMacroRuleName != null)
        {
            int ai[] = removeMacroRuleName;
            for (int j = ai.length; i < j; i++)
            {
                b1.a(10, ai[i]);
            }

        }
        k.a(unknownFieldData, b1);
    }


    public ()
    {
        positivePredicate = k.e;
        negativePredicate = k.e;
        addTag = k.e;
        removeTag = k.e;
        addTagRuleName = k.e;
        removeTagRuleName = k.e;
        addMacro = k.e;
        removeMacro = k.e;
        addMacroRuleName = k.e;
        removeMacroRuleName = k.e;
    }
}
