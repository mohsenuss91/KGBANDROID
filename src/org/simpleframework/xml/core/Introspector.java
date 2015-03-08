// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Contact, Label, Reflector, PathParser, 
//            EmptyExpression, Expression

class Introspector
{

    private final Contact contact;
    private final Format format;
    private final Label label;
    private final Annotation marker;

    public Introspector(Contact contact1, Label label1, Format format1)
    {
        marker = contact1.getAnnotation();
        contact = contact1;
        format = format1;
        label = label1;
    }

    private String getDefault()
    {
        String s = label.getOverride();
        if (!isEmpty(s))
        {
            return s;
        } else
        {
            return contact.getName();
        }
    }

    private String getName(Class class1)
    {
        String s = getRoot(class1);
        if (s != null)
        {
            return s;
        } else
        {
            return Reflector.getName(class1.getSimpleName());
        }
    }

    private String getRoot(Class class1)
    {
        for (Class class2 = class1; class2 != null; class2 = class2.getSuperclass())
        {
            String s = getRoot(class1, class2);
            if (s != null)
            {
                return s;
            }
        }

        return null;
    }

    private String getRoot(Class class1, Class class2)
    {
        String s = class2.getSimpleName();
        Root root = (Root)class2.getAnnotation(org/simpleframework/xml/Root);
        if (root != null)
        {
            String s1 = root.name();
            if (!isEmpty(s1))
            {
                return s1;
            } else
            {
                return Reflector.getName(s);
            }
        } else
        {
            return null;
        }
    }

    public Contact getContact()
    {
        return contact;
    }

    public Type getDependent()
    {
        return label.getDependent();
    }

    public String getEntry()
    {
        Class class1 = getDependent().getType();
        if (class1.isArray())
        {
            class1 = class1.getComponentType();
        }
        return getName(class1);
    }

    public Expression getExpression()
    {
        String s = getPath();
        if (s != null)
        {
            return new PathParser(s, contact, format);
        } else
        {
            return new EmptyExpression(format);
        }
    }

    public String getName()
    {
        String s = label.getEntry();
        if (!label.isInline())
        {
            s = getDefault();
        }
        return s;
    }

    public String getPath()
    {
        Path path = (Path)contact.getAnnotation(org/simpleframework/xml/Path);
        if (path == null)
        {
            return null;
        } else
        {
            return path.value();
        }
    }

    public boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public String toString()
    {
        Object aobj[] = new Object[2];
        aobj[0] = marker;
        aobj[1] = contact;
        return String.format("%s on %s", aobj);
    }
}
