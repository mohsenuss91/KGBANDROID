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

public final class dataLayerEventResult extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public String containerId;
    public String containerVersion;
    public ventEvaluationInfo dataLayerEventResult;
    public int eventType;
    public String key;
    public ationInfo macroResult;

    public static dataLayerEventResult parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        eventType = 1;
        containerVersion = "";
        containerId = "";
        key = "";
        macroResult = null;
        dataLayerEventResult = null;
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
            if (eventType == cachedsize.eventType && (containerVersion != null ? containerVersion.equals(cachedsize.containerVersion) : cachedsize.containerVersion == null) && (containerId != null ? containerId.equals(cachedsize.containerId) : cachedsize.containerId == null) && (key != null ? key.equals(cachedsize.key) : cachedsize.key == null) && (macroResult != null ? macroResult.equals(cachedsize.macroResult) : cachedsize.macroResult == null) && (dataLayerEventResult != null ? dataLayerEventResult.equals(cachedsize.dataLayerEventResult) : cachedsize.dataLayerEventResult == null))
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
        int i = eventType;
        int j = 0;
        if (i != 1)
        {
            j = 0 + b.b(1, eventType);
        }
        if (!containerVersion.equals(""))
        {
            j += b.b(2, containerVersion);
        }
        if (!containerId.equals(""))
        {
            j += b.b(3, containerId);
        }
        if (!key.equals(""))
        {
            j += b.b(4, key);
        }
        if (macroResult != null)
        {
            j += b.b(6, macroResult);
        }
        if (dataLayerEventResult != null)
        {
            j += b.b(7, dataLayerEventResult);
        }
        int l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i = 31 * (527 + eventType);
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        List list;
        int i3;
        if (containerVersion == null)
        {
            j = 0;
        } else
        {
            j = containerVersion.hashCode();
        }
        l = 31 * (j + i);
        if (containerId == null)
        {
            i1 = 0;
        } else
        {
            i1 = containerId.hashCode();
        }
        j1 = 31 * (i1 + l);
        if (key == null)
        {
            k1 = 0;
        } else
        {
            k1 = key.hashCode();
        }
        l1 = 31 * (k1 + j1);
        if (macroResult == null)
        {
            i2 = 0;
        } else
        {
            i2 = macroResult.hashCode();
        }
        j2 = 31 * (i2 + l1);
        if (dataLayerEventResult == null)
        {
            k2 = 0;
        } else
        {
            k2 = dataLayerEventResult.hashCode();
        }
        l2 = 31 * (k2 + j2);
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

            case 8: // '\b'
                int j = a1.c();
                if (j == 1 || j == 2)
                {
                    eventType = j;
                } else
                {
                    eventType = 1;
                }
                break;

            case 18: // '\022'
                containerVersion = a1.e();
                break;

            case 26: // '\032'
                containerId = a1.e();
                break;

            case 34: // '"'
                key = a1.e();
                break;

            case 50: // '2'
                macroResult = new ationInfo();
                a1.a(macroResult);
                break;

            case 58: // ':'
                dataLayerEventResult = new ventEvaluationInfo();
                a1.a(dataLayerEventResult);
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
        if (eventType != 1)
        {
            b1.a(1, eventType);
        }
        if (!containerVersion.equals(""))
        {
            b1.a(2, containerVersion);
        }
        if (!containerId.equals(""))
        {
            b1.a(3, containerId);
        }
        if (!key.equals(""))
        {
            b1.a(4, key);
        }
        if (macroResult != null)
        {
            b1.a(6, macroResult);
        }
        if (dataLayerEventResult != null)
        {
            b1.a(7, dataLayerEventResult);
        }
        k.a(unknownFieldData, b1);
    }


    public ationInfo()
    {
        eventType = 1;
        containerVersion = "";
        containerId = "";
        key = "";
        macroResult = null;
        dataLayerEventResult = null;
    }
}
