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

public final class gcacheExpirationSeconds extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public int expirationSeconds;
    public int gcacheExpirationSeconds;
    public int level;

    public static gcacheExpirationSeconds parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        level = 1;
        expirationSeconds = 0;
        gcacheExpirationSeconds = 0;
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
        if (level != cachedsize.level || expirationSeconds != cachedsize.expirationSeconds || gcacheExpirationSeconds != cachedsize.gcacheExpirationSeconds)
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
        int i = level;
        int j = 0;
        if (i != 1)
        {
            j = 0 + b.b(1, level);
        }
        if (expirationSeconds != 0)
        {
            j += b.b(2, expirationSeconds);
        }
        if (gcacheExpirationSeconds != 0)
        {
            j += b.b(3, gcacheExpirationSeconds);
        }
        int l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i = 31 * (31 * (31 * (527 + level) + expirationSeconds) + gcacheExpirationSeconds);
        int j;
        if (unknownFieldData == null)
        {
            j = 0;
        } else
        {
            j = unknownFieldData.hashCode();
        }
        return j + i;
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
                if (j == 1 || j == 2 || j == 3)
                {
                    level = j;
                } else
                {
                    level = 1;
                }
                break;

            case 16: // '\020'
                expirationSeconds = a1.c();
                break;

            case 24: // '\030'
                gcacheExpirationSeconds = a1.c();
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
        if (level != 1)
        {
            b1.a(1, level);
        }
        if (expirationSeconds != 0)
        {
            b1.a(2, expirationSeconds);
        }
        if (gcacheExpirationSeconds != 0)
        {
            b1.a(3, gcacheExpirationSeconds);
        }
        k.a(unknownFieldData, b1);
    }


    public A()
    {
        level = 1;
        expirationSeconds = 0;
        gcacheExpirationSeconds = 0;
    }
}
