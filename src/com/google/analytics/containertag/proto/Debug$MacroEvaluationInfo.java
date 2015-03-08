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
import java.util.List;

public final class result extends d
{

    public static final _cls1 EMPTY_ARRAY[] = new _cls1[0];
    public static final e macro = e.a(0x2d4c0bd, new _cls1());
    public  result;
    public fo rulesEvaluation;

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
        rulesEvaluation = null;
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
            if ((rulesEvaluation != null ? rulesEvaluation.equals(cachedsize.rulesEvaluation) : cachedsize.rulesEvaluation == null) && (result != null ? result.equals(cachedsize.result) : cachedsize.result == null))
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
        fo fo = rulesEvaluation;
        int i = 0;
        if (fo != null)
        {
            i = 0 + b.b(1, rulesEvaluation);
        }
        if (result != null)
        {
            i += b.b(3, result);
        }
        int j = i + k.a(unknownFieldData);
        cachedSize = j;
        return j;
    }

    public final int hashCode()
    {
        int i;
        int j;
        int l;
        int i1;
        List list;
        int j1;
        if (rulesEvaluation == null)
        {
            i = 0;
        } else
        {
            i = rulesEvaluation.hashCode();
        }
        j = 31 * (i + 527);
        if (result == null)
        {
            l = 0;
        } else
        {
            l = result.hashCode();
        }
        i1 = 31 * (l + j);
        list = unknownFieldData;
        j1 = 0;
        if (list != null)
        {
            j1 = unknownFieldData.hashCode();
        }
        return i1 + j1;
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
                rulesEvaluation = new fo();
                a1.a(rulesEvaluation);
                break;

            case 26: // '\032'
                result = new ();
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
        if (rulesEvaluation != null)
        {
            b1.a(1, rulesEvaluation);
        }
        if (result != null)
        {
            b1.a(3, result);
        }
        k.a(unknownFieldData, b1);
    }


    public fo()
    {
        rulesEvaluation = null;
        result = null;
    }

    class _cls1 extends f
    {

            _cls1()
            {
            }
    }

}
