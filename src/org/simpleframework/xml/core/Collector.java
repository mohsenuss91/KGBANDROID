// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package org.simpleframework.xml.core:
//            Criteria, Variable, Contact, Label

class Collector
    implements Criteria
{

    private final Registry alias = new Registry(null);
    private final Registry registry = new Registry(null);

    public Collector()
    {
    }

    public void commit(Object obj)
    {
        Variable variable;
        for (Iterator iterator1 = registry.values().iterator(); iterator1.hasNext(); variable.getContact().set(obj, variable.getValue()))
        {
            variable = (Variable)iterator1.next();
        }

    }

    public Variable get(Object obj)
    {
        return (Variable)registry.get(obj);
    }

    public Variable get(Label label)
    {
        if (label != null)
        {
            Object obj = label.getKey();
            return (Variable)registry.get(obj);
        } else
        {
            return null;
        }
    }

    public Iterator iterator()
    {
        return registry.iterator();
    }

    public Variable remove(Object obj)
    {
        return (Variable)registry.remove(obj);
    }

    public Variable resolve(String s)
    {
        return (Variable)alias.get(s);
    }

    public void set(Label label, Object obj)
    {
        Variable variable = new Variable(label, obj);
        if (label != null)
        {
            String as[] = label.getPaths();
            Object obj1 = label.getKey();
            int i = as.length;
            for (int j = 0; j < i; j++)
            {
                String s = as[j];
                alias.put(s, variable);
            }

            registry.put(obj1, variable);
        }
    }

    private class Registry extends LinkedHashMap
    {

        public Iterator iterator()
        {
            return keySet().iterator();
        }

        private Registry()
        {
        }

        Registry(_cls1 _pcls1)
        {
            this();
        }
    }

}
