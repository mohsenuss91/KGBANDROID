// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.a.a;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.b.a.a:
//            h, k, e

public abstract class d extends h
{

    protected List unknownFieldData;

    public d()
    {
    }

    public Object getExtension(e e)
    {
        return k.a(e, unknownFieldData);
    }

    public int getSerializedSize()
    {
        int i = k.a(unknownFieldData);
        cachedSize = i;
        return i;
    }

    public void setExtension(e e, Object obj)
    {
        if (unknownFieldData == null)
        {
            unknownFieldData = new ArrayList();
        }
        k.a(e, obj, unknownFieldData);
    }
}
