// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Decorator, NamespaceDecorator, Contact

class Qualifier
    implements Decorator
{

    private NamespaceDecorator decorator;

    public Qualifier(Contact contact)
    {
        decorator = new NamespaceDecorator();
        scan(contact);
    }

    private void namespace(Contact contact)
    {
        Namespace namespace1 = (Namespace)contact.getAnnotation(org/simpleframework/xml/Namespace);
        if (namespace1 != null)
        {
            decorator.set(namespace1);
            decorator.add(namespace1);
        }
    }

    private void scan(Contact contact)
    {
        namespace(contact);
        scope(contact);
    }

    private void scope(Contact contact)
    {
        NamespaceList namespacelist = (NamespaceList)contact.getAnnotation(org/simpleframework/xml/NamespaceList);
        if (namespacelist != null)
        {
            Namespace anamespace[] = namespacelist.value();
            int i = anamespace.length;
            for (int j = 0; j < i; j++)
            {
                Namespace namespace1 = anamespace[j];
                decorator.add(namespace1);
            }

        }
    }

    public void decorate(OutputNode outputnode)
    {
        decorator.decorate(outputnode);
    }

    public void decorate(OutputNode outputnode, Decorator decorator1)
    {
        decorator.decorate(outputnode, decorator1);
    }
}
