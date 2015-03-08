// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.midtier.proto.containertag;

import com.google.b.a.a.a;
import com.google.b.a.a.b;
import com.google.b.a.a.d;
import com.google.b.a.a.h;
import com.google.b.a.a.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class containsReferences extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public boolean boolean_;
    public boolean containsReferences;
    public int escaping[];
    public String functionId;
    public long integer;
    public unknownFieldData listItem[];
    public String macroReference;
    public unknownFieldData mapKey[];
    public unknownFieldData mapValue[];
    public String string;
    public String tagReference;
    public unknownFieldData templateToken[];
    public int type;

    public static containsReferences parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        type = 1;
        string = "";
        listItem = EMPTY_ARRAY;
        mapKey = EMPTY_ARRAY;
        mapValue = EMPTY_ARRAY;
        macroReference = "";
        functionId = "";
        integer = 0L;
        boolean_ = false;
        templateToken = EMPTY_ARRAY;
        tagReference = "";
        escaping = k.e;
        containsReferences = false;
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
            if (type == cachedsize.type && (string != null ? string.equals(cachedsize.string) : cachedsize.string == null) && (Arrays.equals(listItem, cachedsize.listItem) && Arrays.equals(mapKey, cachedsize.mapKey) && Arrays.equals(mapValue, cachedsize.mapValue)) && (macroReference != null ? macroReference.equals(cachedsize.macroReference) : cachedsize.macroReference == null) && (functionId != null ? functionId.equals(cachedsize.functionId) : cachedsize.functionId == null) && (integer == cachedsize.integer && boolean_ == cachedsize.boolean_ && Arrays.equals(templateToken, cachedsize.templateToken)) && (tagReference != null ? tagReference.equals(cachedsize.tagReference) : cachedsize.tagReference == null) && (Arrays.equals(escaping, cachedsize.escaping) && containsReferences == cachedsize.containsReferences))
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
        int j = 0 + b.b(1, type);
        if (!string.equals(""))
        {
            j += b.b(2, string);
        }
        if (listItem != null)
        {
            unknownFieldData aunknownfielddata3[] = listItem;
            int l3 = aunknownfielddata3.length;
            for (int i4 = 0; i4 < l3;)
            {
                int j4 = j + b.b(3, aunknownfielddata3[i4]);
                i4++;
                j = j4;
            }

        }
        if (mapKey != null)
        {
            unknownFieldData aunknownfielddata2[] = mapKey;
            int i3 = aunknownfielddata2.length;
            for (int j3 = 0; j3 < i3;)
            {
                int k3 = j + b.b(4, aunknownfielddata2[j3]);
                j3++;
                j = k3;
            }

        }
        if (mapValue != null)
        {
            unknownFieldData aunknownfielddata1[] = mapValue;
            int j2 = aunknownfielddata1.length;
            for (int k2 = 0; k2 < j2;)
            {
                int l2 = j + b.b(5, aunknownfielddata1[k2]);
                k2++;
                j = l2;
            }

        }
        if (!macroReference.equals(""))
        {
            j += b.b(6, macroReference);
        }
        if (!functionId.equals(""))
        {
            j += b.b(7, functionId);
        }
        if (integer != 0L)
        {
            j += b.b(8, integer);
        }
        if (containsReferences)
        {
            boolean _tmp = containsReferences;
            j += 1 + b.d(9);
        }
        if (escaping != null && escaping.length > 0)
        {
            int ai[] = escaping;
            int k1 = ai.length;
            int l1 = 0;
            int i2 = 0;
            for (; l1 < k1; l1++)
            {
                i2 += b.b(ai[l1]);
            }

            j = j + i2 + 1 * escaping.length;
        }
        if (templateToken != null)
        {
            unknownFieldData aunknownfielddata[] = templateToken;
            for (int i1 = aunknownfielddata.length; i < i1;)
            {
                int j1 = j + b.b(11, aunknownfielddata[i]);
                i++;
                j = j1;
            }

        }
        if (boolean_)
        {
            boolean _tmp1 = boolean_;
            j += 1 + b.d(12);
        }
        if (!tagReference.equals(""))
        {
            j += b.b(13, tagReference);
        }
        int l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i = 1;
        int j = 31 * (527 + type);
        int l;
        int i1;
        int j1;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        int k6;
        int l6;
        int i7;
        int j7;
        int l7;
        int i8;
        List list;
        int j8;
        if (string == null)
        {
            l = 0;
        } else
        {
            l = string.hashCode();
        }
        i1 = l + j;
        if (listItem == null)
        {
            j1 = i1 * 31;
        } else
        {
            j1 = i1;
            int k1 = 0;
            while (k1 < listItem.length) 
            {
                int l1 = j1 * 31;
                int i2;
                if (listItem[k1] == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = listItem[k1].hashCode();
                }
                j1 = i2 + l1;
                k1++;
            }
        }
        if (mapKey == null)
        {
            j1 *= 31;
        } else
        {
            int j2 = 0;
            while (j2 < mapKey.length) 
            {
                int k2 = j1 * 31;
                int l2;
                if (mapKey[j2] == null)
                {
                    l2 = 0;
                } else
                {
                    l2 = mapKey[j2].hashCode();
                }
                j1 = l2 + k2;
                j2++;
            }
        }
        if (mapValue == null)
        {
            j1 *= 31;
        } else
        {
            int i3 = 0;
            while (i3 < mapValue.length) 
            {
                int j3 = j1 * 31;
                int k3;
                if (mapValue[i3] == null)
                {
                    k3 = 0;
                } else
                {
                    k3 = mapValue[i3].hashCode();
                }
                j1 = k3 + j3;
                i3++;
            }
        }
        l3 = j1 * 31;
        if (macroReference == null)
        {
            i4 = 0;
        } else
        {
            i4 = macroReference.hashCode();
        }
        j4 = 31 * (i4 + l3);
        if (functionId == null)
        {
            k4 = 0;
        } else
        {
            k4 = functionId.hashCode();
        }
        l4 = 31 * (31 * (k4 + j4) + (int)(integer ^ integer >>> 32));
        if (boolean_)
        {
            i5 = i;
        } else
        {
            i5 = 2;
        }
        j5 = i5 + l4;
        if (templateToken == null)
        {
            k5 = j5 * 31;
        } else
        {
            k5 = j5;
            int l5 = 0;
            while (l5 < templateToken.length) 
            {
                int i6 = k5 * 31;
                int j6;
                if (templateToken[l5] == null)
                {
                    j6 = 0;
                } else
                {
                    j6 = templateToken[l5].hashCode();
                }
                k5 = j6 + i6;
                l5++;
            }
        }
        k6 = k5 * 31;
        if (tagReference == null)
        {
            l6 = 0;
        } else
        {
            l6 = tagReference.hashCode();
        }
        i7 = l6 + k6;
        if (escaping == null)
        {
            j7 = i7 * 31;
        } else
        {
            j7 = i7;
            int k7 = 0;
            while (k7 < escaping.length) 
            {
                j7 = j7 * 31 + escaping[k7];
                k7++;
            }
        }
        l7 = j7 * 31;
        if (!containsReferences)
        {
            i = 2;
        }
        i8 = 31 * (l7 + i);
        list = unknownFieldData;
        j8 = 0;
        if (list != null)
        {
            j8 = unknownFieldData.hashCode();
        }
        return i8 + j8;
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
                int i3 = a1.c();
                if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6 || i3 == 7 || i3 == 8 || i3 == 9)
                {
                    type = i3;
                } else
                {
                    type = 1;
                }
                break;

            case 18: // '\022'
                string = a1.e();
                break;

            case 26: // '\032'
                int k2 = k.a(a1, 26);
                int l2;
                unknownFieldData aunknownfielddata3[];
                if (listItem == null)
                {
                    l2 = 0;
                } else
                {
                    l2 = listItem.length;
                }
                aunknownfielddata3 = new listItem[k2 + l2];
                if (listItem != null)
                {
                    System.arraycopy(listItem, 0, aunknownfielddata3, 0, l2);
                }
                for (listItem = aunknownfielddata3; l2 < -1 + listItem.length; l2++)
                {
                    listItem[l2] = new <init>();
                    a1.a(listItem[l2]);
                    a1.a();
                }

                listItem[l2] = new <init>();
                a1.a(listItem[l2]);
                break;

            case 34: // '"'
                int i2 = k.a(a1, 34);
                int j2;
                unknownFieldData aunknownfielddata2[];
                if (mapKey == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = mapKey.length;
                }
                aunknownfielddata2 = new mapKey[i2 + j2];
                if (mapKey != null)
                {
                    System.arraycopy(mapKey, 0, aunknownfielddata2, 0, j2);
                }
                for (mapKey = aunknownfielddata2; j2 < -1 + mapKey.length; j2++)
                {
                    mapKey[j2] = new <init>();
                    a1.a(mapKey[j2]);
                    a1.a();
                }

                mapKey[j2] = new <init>();
                a1.a(mapKey[j2]);
                break;

            case 42: // '*'
                int k1 = k.a(a1, 42);
                int l1;
                unknownFieldData aunknownfielddata1[];
                if (mapValue == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = mapValue.length;
                }
                aunknownfielddata1 = new mapValue[k1 + l1];
                if (mapValue != null)
                {
                    System.arraycopy(mapValue, 0, aunknownfielddata1, 0, l1);
                }
                for (mapValue = aunknownfielddata1; l1 < -1 + mapValue.length; l1++)
                {
                    mapValue[l1] = new <init>();
                    a1.a(mapValue[l1]);
                    a1.a();
                }

                mapValue[l1] = new <init>();
                a1.a(mapValue[l1]);
                break;

            case 50: // '2'
                macroReference = a1.e();
                break;

            case 58: // ':'
                functionId = a1.e();
                break;

            case 64: // '@'
                integer = a1.b();
                break;

            case 72: // 'H'
                containsReferences = a1.d();
                break;

            case 80: // 'P'
                int i1 = k.a(a1, 80);
                int j1 = escaping.length;
                int ai[] = new int[i1 + j1];
                System.arraycopy(escaping, 0, ai, 0, j1);
                for (escaping = ai; j1 < -1 + escaping.length; j1++)
                {
                    escaping[j1] = a1.c();
                    a1.a();
                }

                escaping[j1] = a1.c();
                break;

            case 90: // 'Z'
                int j = k.a(a1, 90);
                int l;
                unknownFieldData aunknownfielddata[];
                if (templateToken == null)
                {
                    l = 0;
                } else
                {
                    l = templateToken.length;
                }
                aunknownfielddata = new templateToken[j + l];
                if (templateToken != null)
                {
                    System.arraycopy(templateToken, 0, aunknownfielddata, 0, l);
                }
                for (templateToken = aunknownfielddata; l < -1 + templateToken.length; l++)
                {
                    templateToken[l] = new <init>();
                    a1.a(templateToken[l]);
                    a1.a();
                }

                templateToken[l] = new <init>();
                a1.a(templateToken[l]);
                break;

            case 96: // '`'
                boolean_ = a1.d();
                break;

            case 106: // 'j'
                tagReference = a1.e();
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
        b1.a(1, type);
        if (!string.equals(""))
        {
            b1.a(2, string);
        }
        if (listItem != null)
        {
            mergeFrom amergefrom3[] = listItem;
            int j2 = amergefrom3.length;
            for (int k2 = 0; k2 < j2; k2++)
            {
                b1.a(3, amergefrom3[k2]);
            }

        }
        if (mapKey != null)
        {
            mergeFrom amergefrom2[] = mapKey;
            int l1 = amergefrom2.length;
            for (int i2 = 0; i2 < l1; i2++)
            {
                b1.a(4, amergefrom2[i2]);
            }

        }
        if (mapValue != null)
        {
            mergeFrom amergefrom1[] = mapValue;
            int j1 = amergefrom1.length;
            for (int k1 = 0; k1 < j1; k1++)
            {
                b1.a(5, amergefrom1[k1]);
            }

        }
        if (!macroReference.equals(""))
        {
            b1.a(6, macroReference);
        }
        if (!functionId.equals(""))
        {
            b1.a(7, functionId);
        }
        if (integer != 0L)
        {
            b1.a(8, integer);
        }
        if (containsReferences)
        {
            b1.a(9, containsReferences);
        }
        if (escaping != null && escaping.length > 0)
        {
            int ai[] = escaping;
            int l = ai.length;
            for (int i1 = 0; i1 < l; i1++)
            {
                b1.a(10, ai[i1]);
            }

        }
        if (templateToken != null)
        {
            mergeFrom amergefrom[] = templateToken;
            for (int j = amergefrom.length; i < j; i++)
            {
                b1.a(11, amergefrom[i]);
            }

        }
        if (boolean_)
        {
            b1.a(12, boolean_);
        }
        if (!tagReference.equals(""))
        {
            b1.a(13, tagReference);
        }
        k.a(unknownFieldData, b1);
    }


    public ()
    {
        type = 1;
        string = "";
        listItem = EMPTY_ARRAY;
        mapKey = EMPTY_ARRAY;
        mapValue = EMPTY_ARRAY;
        macroReference = "";
        functionId = "";
        integer = 0L;
        boolean_ = false;
        templateToken = EMPTY_ARRAY;
        tagReference = "";
        escaping = k.e;
        containsReferences = false;
    }
}
