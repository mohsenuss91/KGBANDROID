// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.b.a.a.a;
import com.google.b.a.a.b;
import com.google.b.a.a.d;
import com.google.b.a.a.e;
import com.google.b.a.a.h;
import com.google.b.a.a.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class tagReference extends d
{

    public static final _cls1 EMPTY_ARRAY[] = new _cls1[0];
    public static final e ext = e.a(101, new _cls1());
    public int listItem[];
    public int macroNameReference;
    public int macroReference;
    public int mapKey[];
    public int mapValue[];
    public int tagReference;
    public int templateToken[];

    public static tagReference parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        listItem = k.e;
        mapKey = k.e;
        mapValue = k.e;
        macroReference = 0;
        templateToken = k.e;
        macroNameReference = 0;
        tagReference = 0;
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
        if (!Arrays.equals(listItem, cachedsize.listItem) || !Arrays.equals(mapKey, cachedsize.mapKey) || !Arrays.equals(mapValue, cachedsize.mapValue) || macroReference != cachedsize.macroReference || !Arrays.equals(templateToken, cachedsize.templateToken) || macroNameReference != cachedsize.macroNameReference || tagReference != cachedsize.tagReference)
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
        if (listItem != null && listItem.length > 0)
        {
            int ai3[] = listItem;
            int i3 = ai3.length;
            int j3 = 0;
            int k3 = 0;
            for (; j3 < i3; j3++)
            {
                k3 += b.b(ai3[j3]);
            }

            j = k3 + 0 + 1 * listItem.length;
        } else
        {
            j = 0;
        }
        if (mapKey != null && mapKey.length > 0)
        {
            int ai2[] = mapKey;
            int j2 = ai2.length;
            int k2 = 0;
            int l2 = 0;
            for (; k2 < j2; k2++)
            {
                l2 += b.b(ai2[k2]);
            }

            j = j + l2 + 1 * mapKey.length;
        }
        if (mapValue != null && mapValue.length > 0)
        {
            int ai1[] = mapValue;
            int k1 = ai1.length;
            int l1 = 0;
            int i2 = 0;
            for (; l1 < k1; l1++)
            {
                i2 += b.b(ai1[l1]);
            }

            j = j + i2 + 1 * mapValue.length;
        }
        if (macroReference != 0)
        {
            j += b.b(4, macroReference);
        }
        if (templateToken != null && templateToken.length > 0)
        {
            int ai[] = templateToken;
            int i1 = ai.length;
            int j1 = 0;
            for (; i < i1; i++)
            {
                j1 += b.b(ai[i]);
            }

            j = j + j1 + 1 * templateToken.length;
        }
        if (macroNameReference != 0)
        {
            j += b.b(6, macroNameReference);
        }
        if (tagReference != 0)
        {
            j += b.b(7, tagReference);
        }
        l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i;
        int j1;
        int k1;
        int i2;
        List list;
        int j2;
        if (listItem == null)
        {
            i = 527;
        } else
        {
            i = 17;
            int j = 0;
            while (j < listItem.length) 
            {
                i = i * 31 + listItem[j];
                j++;
            }
        }
        if (mapKey == null)
        {
            i *= 31;
        } else
        {
            int l = 0;
            while (l < mapKey.length) 
            {
                i = i * 31 + mapKey[l];
                l++;
            }
        }
        if (mapValue == null)
        {
            i *= 31;
        } else
        {
            int i1 = 0;
            while (i1 < mapValue.length) 
            {
                i = i * 31 + mapValue[i1];
                i1++;
            }
        }
        j1 = i * 31 + macroReference;
        if (templateToken == null)
        {
            k1 = j1 * 31;
        } else
        {
            k1 = j1;
            int l1 = 0;
            while (l1 < templateToken.length) 
            {
                k1 = k1 * 31 + templateToken[l1];
                l1++;
            }
        }
        i2 = 31 * (31 * (k1 * 31 + macroNameReference) + tagReference);
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

            case 8: // '\b'
                int i2 = k.a(a1, 8);
                int j2 = listItem.length;
                int ai3[] = new int[i2 + j2];
                System.arraycopy(listItem, 0, ai3, 0, j2);
                for (listItem = ai3; j2 < -1 + listItem.length; j2++)
                {
                    listItem[j2] = a1.c();
                    a1.a();
                }

                listItem[j2] = a1.c();
                break;

            case 16: // '\020'
                int k1 = k.a(a1, 16);
                int l1 = mapKey.length;
                int ai2[] = new int[k1 + l1];
                System.arraycopy(mapKey, 0, ai2, 0, l1);
                for (mapKey = ai2; l1 < -1 + mapKey.length; l1++)
                {
                    mapKey[l1] = a1.c();
                    a1.a();
                }

                mapKey[l1] = a1.c();
                break;

            case 24: // '\030'
                int i1 = k.a(a1, 24);
                int j1 = mapValue.length;
                int ai1[] = new int[i1 + j1];
                System.arraycopy(mapValue, 0, ai1, 0, j1);
                for (mapValue = ai1; j1 < -1 + mapValue.length; j1++)
                {
                    mapValue[j1] = a1.c();
                    a1.a();
                }

                mapValue[j1] = a1.c();
                break;

            case 32: // ' '
                macroReference = a1.c();
                break;

            case 40: // '('
                int j = k.a(a1, 40);
                int l = templateToken.length;
                int ai[] = new int[j + l];
                System.arraycopy(templateToken, 0, ai, 0, l);
                for (templateToken = ai; l < -1 + templateToken.length; l++)
                {
                    templateToken[l] = a1.c();
                    a1.a();
                }

                templateToken[l] = a1.c();
                break;

            case 48: // '0'
                macroNameReference = a1.c();
                break;

            case 56: // '8'
                tagReference = a1.c();
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
        if (listItem != null)
        {
            int ai3[] = listItem;
            int l1 = ai3.length;
            for (int i2 = 0; i2 < l1; i2++)
            {
                b1.a(1, ai3[i2]);
            }

        }
        if (mapKey != null)
        {
            int ai2[] = mapKey;
            int j1 = ai2.length;
            for (int k1 = 0; k1 < j1; k1++)
            {
                b1.a(2, ai2[k1]);
            }

        }
        if (mapValue != null)
        {
            int ai1[] = mapValue;
            int l = ai1.length;
            for (int i1 = 0; i1 < l; i1++)
            {
                b1.a(3, ai1[i1]);
            }

        }
        if (macroReference != 0)
        {
            b1.a(4, macroReference);
        }
        if (templateToken != null)
        {
            int ai[] = templateToken;
            for (int j = ai.length; i < j; i++)
            {
                b1.a(5, ai[i]);
            }

        }
        if (macroNameReference != 0)
        {
            b1.a(6, macroNameReference);
        }
        if (tagReference != 0)
        {
            b1.a(7, tagReference);
        }
        k.a(unknownFieldData, b1);
    }


    public _cls1()
    {
        listItem = k.e;
        mapKey = k.e;
        mapValue = k.e;
        macroReference = 0;
        templateToken = k.e;
        macroNameReference = 0;
        tagReference = 0;
    }

    class _cls1 extends f
    {

            _cls1()
            {
            }
    }

}
