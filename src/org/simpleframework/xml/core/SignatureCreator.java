// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Creator, Signature, Parameter, Criteria, 
//            Variable, Support, Contact

class SignatureCreator
    implements Creator
{

    private final List list;
    private final Signature signature;
    private final Class type;

    public SignatureCreator(Signature signature1)
    {
        type = signature1.getType();
        list = signature1.getAll();
        signature = signature1;
    }

    private double getAdjustment(double d)
    {
        double d1 = (double)list.size() / 1000D;
        if (d > 0.0D)
        {
            return d1 + d / (double)list.size();
        } else
        {
            return d / (double)list.size();
        }
    }

    private double getPercentage(Criteria criteria)
    {
        Iterator iterator;
        double d;
        iterator = list.iterator();
        d = 0.0D;
_L2:
        double d1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        Parameter parameter = (Parameter)iterator.next();
        if (criteria.get(parameter.getKey()) == null)
        {
            if (parameter.isRequired())
            {
                return -1D;
            }
            if (parameter.isPrimitive())
            {
                return -1D;
            }
            break MISSING_BLOCK_LABEL_93;
        }
        d1 = d + 1.0D;
_L3:
        d = d1;
        if (true) goto _L2; else goto _L1
_L1:
        return getAdjustment(d);
        d1 = d;
          goto _L3
    }

    private Object getVariable(Criteria criteria, int i)
    {
        Variable variable = criteria.remove(((Parameter)list.get(i)).getKey());
        if (variable != null)
        {
            return variable.getValue();
        } else
        {
            return null;
        }
    }

    public Object getInstance()
    {
        return signature.create();
    }

    public Object getInstance(Criteria criteria)
    {
        Object aobj[] = list.toArray();
        for (int i = 0; i < list.size(); i++)
        {
            aobj[i] = getVariable(criteria, i);
        }

        return signature.create(aobj);
    }

    public double getScore(Criteria criteria)
    {
        Signature signature1 = signature.copy();
        for (Iterator iterator = criteria.iterator(); iterator.hasNext();)
        {
            Object obj = iterator.next();
            Parameter parameter = signature1.get(obj);
            Variable variable = criteria.get(obj);
            Contact contact = variable.getContact();
            if (parameter != null && !Support.isAssignable(variable.getValue().getClass(), parameter.getType()))
            {
                return -1D;
            }
            if (contact.isReadOnly() && parameter == null)
            {
                return -1D;
            }
        }

        return getPercentage(criteria);
    }

    public Signature getSignature()
    {
        return signature;
    }

    public Class getType()
    {
        return type;
    }

    public String toString()
    {
        return signature.toString();
    }
}
