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
    public unknownFieldData event[];

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
        event = PTY_ARRAY;
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
        if (!Arrays.equals(event, cachedsize.event))
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
        unknownFieldData aunknownfielddata[] = event;
        int i = 0;
        if (aunknownfielddata != null)
        {
            unknownFieldData aunknownfielddata1[] = event;
            int l = aunknownfielddata1.length;
            for (int i1 = 0; i1 < l;)
            {
                int j1 = i + b.b(1, aunknownfielddata1[i1]);
                i1++;
                i = j1;
            }

        }
        int j = i + k.a(unknownFieldData);
        cachedSize = j;
        return j;
    }

    public final int hashCode()
    {
        int i;
        int j1;
        List list;
        int k1;
        if (event == null)
        {
            i = 527;
        } else
        {
            i = 17;
            int j = 0;
            while (j < event.length) 
            {
                int l = i * 31;
                int i1;
                if (event[j] == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = event[j].shCode();
                }
                i = i1 + l;
                j++;
            }
        }
        j1 = i * 31;
        list = unknownFieldData;
        k1 = 0;
        if (list != null)
        {
            k1 = unknownFieldData.hashCode();
        }
        return j1 + k1;
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
                if (event == null)
                {
                    l = 0;
                } else
                {
                    l = event.length;
                }
                aunknownfielddata = new event[j + l];
                if (event != null)
                {
                    System.arraycopy(event, 0, aunknownfielddata, 0, l);
                }
                for (event = aunknownfielddata; l < -1 + event.length; l++)
                {
                    event[l] = new nit>();
                    a1.a(event[l]);
                    a1.a();
                }

                event[l] = new nit>();
                a1.a(event[l]);
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
        if (event != null)
        {
            mergeFrom amergefrom[] = event;
            int i = amergefrom.length;
            for (int j = 0; j < i; j++)
            {
                b1.a(1, amergefrom[j]);
            }

        }
        k.a(unknownFieldData, b1);
    }


    public ()
    {
        event = PTY_ARRAY;
    }
}
