// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Parameter

class ParameterMap extends LinkedHashMap
    implements Iterable
{

    public ParameterMap()
    {
    }

    public Parameter get(int i)
    {
        return (Parameter)getAll().get(i);
    }

    public List getAll()
    {
        Collection collection = values();
        if (!collection.isEmpty())
        {
            return new ArrayList(collection);
        } else
        {
            return Collections.emptyList();
        }
    }

    public Iterator iterator()
    {
        return values().iterator();
    }
}
