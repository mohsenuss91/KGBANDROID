// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.core:
//            Scanner, Support, PrimitiveScanner, ObjectScanner, 
//            DefaultScanner

class ScannerFactory
{

    private final Cache cache = new ConcurrentCache();
    private final Support support;

    public ScannerFactory(Support support1)
    {
        support = support1;
    }

    public Scanner getInstance(Class class1)
    {
        Object obj = (Scanner)cache.fetch(class1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        Detail detail = support.getDetail(class1);
        if (!support.isPrimitive(class1)) goto _L4; else goto _L3
_L3:
        obj = new PrimitiveScanner(detail);
_L6:
        cache.cache(class1, obj);
_L2:
        return ((Scanner) (obj));
_L4:
        obj = new ObjectScanner(detail, support);
        if (((Scanner) (obj)).isPrimitive() && !support.isContainer(class1))
        {
            obj = new DefaultScanner(detail, support);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
