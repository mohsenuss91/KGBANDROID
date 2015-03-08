// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

// Referenced classes of package org.simpleframework.xml.core:
//            Contact

class LabelKey
{

    private final Class label;
    private final String name;
    private final Class owner;
    private final Class type;

    public LabelKey(Contact contact, Annotation annotation)
    {
        owner = contact.getDeclaringClass();
        label = annotation.annotationType();
        name = contact.getName();
        type = contact.getType();
    }

    private boolean equals(LabelKey labelkey)
    {
        boolean flag;
        if (labelkey == this)
        {
            flag = true;
        } else
        {
            Class class1 = labelkey.label;
            Class class2 = label;
            flag = false;
            if (class1 == class2)
            {
                Class class3 = labelkey.owner;
                Class class4 = owner;
                flag = false;
                if (class3 == class4)
                {
                    Class class5 = labelkey.type;
                    Class class6 = type;
                    flag = false;
                    if (class5 == class6)
                    {
                        return labelkey.name.equals(name);
                    }
                }
            }
        }
        return flag;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof LabelKey)
        {
            return equals((LabelKey)obj);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return name.hashCode() ^ owner.hashCode();
    }

    public String toString()
    {
        Object aobj[] = new Object[2];
        aobj[0] = name;
        aobj[1] = owner;
        return String.format("key '%s' for %s", aobj);
    }
}
