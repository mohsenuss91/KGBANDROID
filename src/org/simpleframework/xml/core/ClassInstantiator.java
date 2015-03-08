// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Instantiator, Creator, PersistenceException, ParameterMap, 
//            Parameter, Detail, Criteria

class ClassInstantiator
    implements Instantiator
{

    private final List creators;
    private final Detail detail;
    private final Creator primary;
    private final ParameterMap registry;

    public ClassInstantiator(List list, Creator creator, ParameterMap parametermap, Detail detail1)
    {
        creators = list;
        registry = parametermap;
        primary = creator;
        detail = detail1;
    }

    private Creator getCreator(Criteria criteria)
    {
        Creator creator = primary;
        Iterator iterator = creators.iterator();
        Creator creator1 = creator;
        double d = 0.0D;
        while (iterator.hasNext()) 
        {
            Creator creator2 = (Creator)iterator.next();
            double d1 = creator2.getScore(criteria);
            double d2;
            Creator creator3;
            if (d1 > d)
            {
                creator3 = creator2;
                d2 = d1;
            } else
            {
                d2 = d;
                creator3 = creator1;
            }
            creator1 = creator3;
            d = d2;
        }
        return creator1;
    }

    public List getCreators()
    {
        return new ArrayList(creators);
    }

    public Object getInstance()
    {
        return primary.getInstance();
    }

    public Object getInstance(Criteria criteria)
    {
        Creator creator = getCreator(criteria);
        if (creator == null)
        {
            Object aobj[] = new Object[1];
            aobj[0] = detail;
            throw new PersistenceException("Constructor not matched for %s", aobj);
        } else
        {
            return creator.getInstance(criteria);
        }
    }

    public Parameter getParameter(String s)
    {
        return (Parameter)registry.get(s);
    }

    public List getParameters()
    {
        return registry.getAll();
    }

    public boolean isDefault()
    {
        if (creators.size() <= 1)
        {
            return primary != null;
        } else
        {
            return false;
        }
    }

    public String toString()
    {
        Object aobj[] = new Object[1];
        aobj[0] = detail;
        return String.format("creator for %s", aobj);
    }
}
