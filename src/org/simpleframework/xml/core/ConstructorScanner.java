// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            ParameterMap, SignatureScanner, Signature, Detail, 
//            ConstructorException, Support

class ConstructorScanner
{

    private Signature primary;
    private ParameterMap registry;
    private List signatures;
    private Support support;

    public ConstructorScanner(Detail detail, Support support1)
    {
        signatures = new ArrayList();
        registry = new ParameterMap();
        support = support1;
        scan(detail);
    }

    private void scan(Constructor constructor)
    {
        SignatureScanner signaturescanner = new SignatureScanner(constructor, registry, support);
        if (signaturescanner.isValid())
        {
            Signature signature;
            for (Iterator iterator = signaturescanner.getSignatures().iterator(); iterator.hasNext(); signatures.add(signature))
            {
                signature = (Signature)iterator.next();
                if (signature.size() == 0)
                {
                    primary = signature;
                }
            }

        }
    }

    private void scan(Detail detail)
    {
        int i = 0;
        Constructor aconstructor[] = detail.getConstructors();
        if (!detail.isInstantiable())
        {
            throw new ConstructorException("Can not construct inner %s", new Object[] {
                detail
            });
        }
        for (int j = aconstructor.length; i < j; i++)
        {
            Constructor constructor = aconstructor[i];
            if (!detail.isPrimitive())
            {
                scan(constructor);
            }
        }

    }

    public ParameterMap getParameters()
    {
        return registry;
    }

    public Signature getSignature()
    {
        return primary;
    }

    public List getSignatures()
    {
        return new ArrayList(signatures);
    }
}
