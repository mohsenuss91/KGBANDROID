// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Decorator

class NamespaceDecorator
    implements Decorator
{

    private Namespace primary;
    private List scope;

    public NamespaceDecorator()
    {
        scope = new ArrayList();
    }

    private void namespace(OutputNode outputnode)
    {
        if (primary != null)
        {
            outputnode.setReference(primary.reference());
        }
    }

    private void scope(OutputNode outputnode)
    {
        NamespaceMap namespacemap = outputnode.getNamespaces();
        Namespace namespace1;
        for (Iterator iterator = scope.iterator(); iterator.hasNext(); namespacemap.setReference(namespace1.reference(), namespace1.prefix()))
        {
            namespace1 = (Namespace)iterator.next();
        }

    }

    public void add(Namespace namespace1)
    {
        scope.add(namespace1);
    }

    public void decorate(OutputNode outputnode)
    {
        decorate(outputnode, null);
    }

    public void decorate(OutputNode outputnode, Decorator decorator)
    {
        if (decorator != null)
        {
            decorator.decorate(outputnode);
        }
        scope(outputnode);
        namespace(outputnode);
    }

    public void set(Namespace namespace1)
    {
        if (namespace1 != null)
        {
            add(namespace1);
        }
        primary = namespace1;
    }
}
