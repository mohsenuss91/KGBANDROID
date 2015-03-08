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

public final class version extends d
{

    public static final unknownFieldData EMPTY_ARRAY[] = new unknownFieldData[0];
    public String containerId;
    public unknownFieldData jsResource;
    public int state;
    public String version;

    public static version parseFrom(a a1)
    {
        return (new <init>()).mergeFrom(a1);
    }

    public static mergeFrom parseFrom(byte abyte0[])
    {
        return (mergeFrom)h.mergeFrom(new <init>(), abyte0);
    }

    public final <init> clear()
    {
        jsResource = null;
        containerId = "";
        state = 1;
        version = "";
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
            if ((jsResource != null ? jsResource.quals(cachedsize.jsResource) : cachedsize.jsResource == null) && (containerId != null ? containerId.equals(cachedsize.containerId) : cachedsize.containerId == null) && state == cachedsize.state && (version != null ? version.equals(cachedsize.version) : cachedsize.version == null))
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
        unknownFieldData unknownfielddata = jsResource;
        int i = 0;
        if (unknownfielddata != null)
        {
            i = 0 + b.b(1, jsResource);
        }
        int j = i + b.b(3, containerId) + b.b(4, state);
        if (!version.equals(""))
        {
            j += b.b(5, version);
        }
        int l = j + k.a(unknownFieldData);
        cachedSize = l;
        return l;
    }

    public final int hashCode()
    {
        int i;
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        List list;
        int l1;
        if (jsResource == null)
        {
            i = 0;
        } else
        {
            i = jsResource.ashCode();
        }
        j = 31 * (i + 527);
        if (containerId == null)
        {
            l = 0;
        } else
        {
            l = containerId.hashCode();
        }
        i1 = 31 * (31 * (l + j) + state);
        if (version == null)
        {
            j1 = 0;
        } else
        {
            j1 = version.hashCode();
        }
        k1 = 31 * (j1 + i1);
        list = unknownFieldData;
        l1 = 0;
        if (list != null)
        {
            l1 = unknownFieldData.hashCode();
        }
        return k1 + l1;
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
                jsResource = new init>();
                a1.a(jsResource);
                break;

            case 26: // '\032'
                containerId = a1.e();
                break;

            case 32: // ' '
                int j = a1.c();
                if (j == 1 || j == 2)
                {
                    state = j;
                } else
                {
                    state = 1;
                }
                break;

            case 42: // '*'
                version = a1.e();
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
        if (jsResource != null)
        {
            b1.a(1, jsResource);
        }
        b1.a(3, containerId);
        b1.a(4, state);
        if (!version.equals(""))
        {
            b1.a(5, version);
        }
        k.a(unknownFieldData, b1);
    }


    public ()
    {
        jsResource = null;
        containerId = "";
        state = 1;
        version = "";
    }
}
